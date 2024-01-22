package Modelo;

import static Modelo.PedidoDAO_SQL.printSQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticuloDAO_SQL extends ConexionSQL implements ArticuloDAO {
    private final static String SQL_CREATE_ARTICULO = "INSERT INTO articulos (codigo, descripcion, gastosEnvio, pvp, tiempoPreparacion) VALUES (?,?,?,?,?)";
    private final static String SQL_GET_ARTICULO = "SELECT * FROM articulos WHERE codigo=?";
    private final static String SQL_GET_LISTA_ARTICULOS = "SELECT * FROM articulos";
    private final static String SQL_GET_COUNT_ARTICULOS = "SELECT count(*) FROM articulos";
    private final static String SQL_DELETE_ARTICULO = "DELETE FROM articulos WHERE codigo = ?";

    public ArticuloDAO_SQL() {
    }

    private final Connection connection = ConexionSQL.gConnection();

    public int totalArticulos()throws SQLException  {
        final String sql =SQL_GET_COUNT_ARTICULOS;
        try ( PreparedStatement ps = connection.prepareStatement(sql))
        {
            try ( ResultSet resultSet = ps.executeQuery())
            {
                resultSet.next();
                int count = resultSet.getInt(1);
                return count;
            }
        } catch (SQLException e) {
            printSQLException(e);
            return 0;
        }
    }
    
    @Override
    public List<Articulo> getListaArticulos() throws SQLException {
        List<Articulo> articulos = new ArrayList();
        final String sql =SQL_GET_LISTA_ARTICULOS;
        try (Statement s = connection.createStatement()) {
            try (ResultSet resultSet = s.executeQuery(sql)) {
                while ( resultSet.next() == true ) {
                    Articulo a = new Articulo();
                    a.setCodigo(resultSet.getString(1) );
                    a.setDescripcion(resultSet.getString(2) );
                    a.setPvp( resultSet.getFloat(3) );
                    a.setGastosEnvio( resultSet.getFloat(4) );
                    a.setTiempoDePreparacion(resultSet.getInt(5) );
                    articulos.add(a);
                }
            }
        }
        return articulos;
    }
    
    @Override
    public boolean nuevoArticulo(Articulo articulo) throws SQLException{
        
        String nuevoCodigo=Integer.toString(totalArticulos()+1);
        
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL_CREATE_ARTICULO);

            pstmt.setString(1, nuevoCodigo);
            pstmt.setString(2, articulo.getDescripcion());
            pstmt.setFloat(3, articulo.getPvp());
            pstmt.setFloat(4, articulo.getGastosEnvio());
            pstmt.setInt(5, articulo.getTiempoDePreparacion());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
    }
    
    public List<Articulo> articuloPorId(String codigo) throws SQLException {
        List<Articulo> articulos = new ArrayList<>();
        final String sql =SQL_GET_ARTICULO;
        try ( PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1,codigo);
            try ( ResultSet resultSet = ps.executeQuery())
            {
                while ( resultSet.next() == true )
                {
                    Articulo a = new Articulo();
                    a.setCodigo(resultSet.getString(1) );
                    a.setDescripcion(resultSet.getString(2) );
                    a.setPvp(resultSet.getFloat(3) );
                    a.setGastosEnvio(resultSet.getFloat(4) );
                    a.setTiempoDePreparacion(resultSet.getInt(5) );
                    articulos.add(a);
                }
            }
        }
        return articulos;
    }
    public boolean eliminarArticulo(String n){

        final String sql =SQL_DELETE_ARTICULO;   
        try ( PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1, n);
            ps.executeUpdate(); 
            return true;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
    }
    
    public static void printSQLException(SQLException ex) {
    for (Throwable e: ex) {
        if (e instanceof SQLException) {
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }
    }
}
   
