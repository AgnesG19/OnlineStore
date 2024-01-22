package Modelo;

import static Modelo.PedidoDAO_SQL.printSQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteDAO_SQL extends ConexionSQL implements ClienteDAO {
    private final static String SQL_CREATE_CLIENTE = "INSERT INTO clientes (nombre, domicilio, nif, email) VALUES (?,?,?,?)";
    private final static String SQL_CREATE_CLIENTE_E = "INSERT INTO clienteestandar (cuota, descuento, nombre) VALUES (0,0,?)";
    private final static String SQL_CREATE_CLIENTE_P = "INSERT INTO clientevip (cuota, descuento, nombre) VALUES (30.0,0.2,?)";
    private final static String SQL_GET_LISTA_CLIENTES_E = "SELECT * FROM clienteestandar";
    private final static String SQL_GET_LISTA_CLIENTES_P = "SELECT * FROM clientevip";
    private final static String SQL_GET_LISTA_CLIENTES_FROM_NOMBRE = "SELECT * FROM clientes WHERE nombre=?";
    private final static String SQL_GET_LISTA_CLIENTES_FROM_EMAIL = "SELECT * FROM clientes WHERE email=?";
    private final static String SQL_DELETE_CLIENTE = "DELETE FROM clientes WHERE nombre = ?";
    private final static String SQL_DELETE_CLIENTE_E = "DELETE FROM clienteestandar WHERE nombre = ?";
    private final static String SQL_DELETE_CLIENTE_P = "DELETE FROM clientevip WHERE nombre = ?";
    
    
    public ClienteDAO_SQL() {
    }
    
    private final Connection connection = ConexionSQL.gConnection();
    
    @Override
    public List<Cliente> getListaClientesE() throws SQLException {
    List<Cliente> cliente = new ArrayList();
    final String sql =SQL_GET_LISTA_CLIENTES_E;
    
        try (Statement s = connection.createStatement()) {
            try (ResultSet resultSet = s.executeQuery(sql)) {
                while ( resultSet.next() == true ) {
                    ClienteEstandard c = new ClienteEstandard();
                    c.setNombre( resultSet.getString(3) );
                    String nombreAux = resultSet.getString(3);
                    try{
                        PreparedStatement pstmt = connection.prepareStatement(SQL_GET_LISTA_CLIENTES_FROM_NOMBRE);
                        pstmt.setString(1, nombreAux);
                        ResultSet resultSetAux = pstmt.executeQuery();
                        while ( resultSetAux.next() == true ) {
                        c.setDomicilio( resultSetAux.getString(2) );
                        c.setNif( resultSetAux.getString(3) );
                        c.setEmail( resultSetAux.getString(4) );
                        }
                    } catch (SQLException e) {
                    printSQLException(e);
                    }
        
                    cliente.add(c);
                }
            }
        }
        return cliente;
    }
    
    @Override
    public List<Cliente> getListaClientesP() throws SQLException {
    List<Cliente> cliente = new ArrayList();
    final String sql =SQL_GET_LISTA_CLIENTES_P;
    
        try (Statement s = connection.createStatement()) {
            try (ResultSet resultSet = s.executeQuery(sql)) {
                while ( resultSet.next() == true ) {
                    ClientePremium c = new ClientePremium();
                    c.setNombre( resultSet.getString(3) );
                    String nombreAux = resultSet.getString(3);
                    try{
                        PreparedStatement pstmt = connection.prepareStatement(SQL_GET_LISTA_CLIENTES_FROM_NOMBRE);
                        pstmt.setString(1, nombreAux);
                        ResultSet resultSetAux = pstmt.executeQuery();
                        while ( resultSetAux.next() == true ) {
                        c.setDomicilio( resultSetAux.getString(2) );
                        c.setNif( resultSetAux.getString(3) );
                        c.setEmail( resultSetAux.getString(4) );
                        }
                    } catch (SQLException e) {
                    printSQLException(e);
                    }
        
                    cliente.add(c);
                }
            }
        }
        return cliente;
    }
    public List<Articulo> clientePorEmail(String email) throws SQLException {
        List<Articulo> articulos = new ArrayList<>();
        final String sql =SQL_GET_LISTA_CLIENTES_FROM_EMAIL;
        try ( PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1,email);
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
    
    @Override
    public boolean nuevoClienteE(Cliente cliente){
        try {
            PreparedStatement pstmt1 = connection.prepareStatement(SQL_CREATE_CLIENTE);

            pstmt1.setString(1, cliente.getNombre());
            pstmt1.setString(2, cliente.getDomicilio());
            pstmt1.setString(3, cliente.getNif());
            pstmt1.setString(4, cliente.getEmail());

            pstmt1.executeUpdate();
            
            PreparedStatement pstmt2 = connection.prepareStatement(SQL_CREATE_CLIENTE_E);

            pstmt2.setString(1, cliente.getNombre());

            pstmt2.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
    }
    
    @Override
    public boolean nuevoClienteP(Cliente cliente){
        try {
            PreparedStatement pstmt1 = connection.prepareStatement(SQL_CREATE_CLIENTE);

            pstmt1.setString(1, cliente.getNombre());
            pstmt1.setString(2, cliente.getDomicilio());
            pstmt1.setString(3, cliente.getNif());
            pstmt1.setString(4, cliente.getEmail());

            pstmt1.executeUpdate();
            
            PreparedStatement pstmt2 = connection.prepareStatement(SQL_CREATE_CLIENTE_P);

            pstmt2.setString(1, cliente.getNombre());

            pstmt2.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
    }
    
    @Override
    public boolean eliminarClienteE(String cli){

        try { 
            PreparedStatement pstmt1 = connection.prepareStatement(SQL_DELETE_CLIENTE_E);
            pstmt1.setString(1, cli);
            pstmt1.executeUpdate(); 
            
            PreparedStatement pstmt2 = connection.prepareStatement(SQL_DELETE_CLIENTE);
            pstmt2.setString(1, cli);
            pstmt2.executeUpdate(); 
            return true;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
    }
    @Override
    public boolean eliminarClienteP(String cli){

        try { 
            PreparedStatement pstmt1 = connection.prepareStatement(SQL_DELETE_CLIENTE_P);
            pstmt1.setString(1, cli);
            pstmt1.executeUpdate(); 
            
            PreparedStatement pstmt2 = connection.prepareStatement(SQL_DELETE_CLIENTE);
            pstmt2.setString(1, cli);
            pstmt2.executeUpdate(); 
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
