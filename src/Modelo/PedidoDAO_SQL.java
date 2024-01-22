/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import Controlador.FXMLController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kazlo
 */
public class PedidoDAO_SQL {
    
    private final static String SQL_CREATE_PEDIDO = "INSERT INTO pedidos (numPedido, articulo, unidades, cliente, fechaPedido) VALUES (?,?,?,?,?)";
    private final static String SQL_GET_PEDIDO = "SELECT * FROM pedidos WHERE codigo=?";
    private final static String SQL_GET_LISTA_PEDIDOS = "SELECT * FROM pedidos";
    private final static String SQL_DELETE_PEDIDO = "DELETE FROM pedidos WHERE numPedido = ?";
    
    private final ClienteDAO_SQL clientePedido = new ClienteDAO_SQL();
    private final ArticuloDAO_SQL articuloPedido = new ArticuloDAO_SQL();
    
    List <Articulo> la=new ArrayList<>();
    List <Cliente> lc=new ArrayList<>();
    
    FXMLController contr = new FXMLController();
    
    public PedidoDAO_SQL() {
    }

    private final Connection connection = ConexionSQL.gConnection();

    public boolean nuevoPedido(Pedido p) throws SQLException
    {
        // id es serial, por eso lo ponemos así
        //long id=0;
        String nuevoCodigo=Integer.toString(totalPedidos()+1);
        final String sql =SQL_CREATE_PEDIDO;
        //try ( PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS))+

        String art = p.getArticulo().getCodigo();
        String cli = p.getCliente().getEmail();
        Timestamp fecha = p.getFecha();

        try ( PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1, nuevoCodigo);
            ps.setString(2, art);
            ps.setDouble(3, p.getUnidades());
            ps.setString(4, cli);
            ps.setTimestamp(5, fecha);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                        //id = rs.getLong(1);
                    }
        return true;
        } catch (SQLException e) {
            printSQLException(e);
        return false;
        }
    }
    
    public boolean eliminarPedido(Integer n){

        final String sql =SQL_DELETE_PEDIDO;   
        try ( PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1, n);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
    }
    
    public List<Pedido> mostrarPedidos() throws SQLException {

        List<Pedido> pedidos = new ArrayList();
        final String sql =SQL_GET_LISTA_PEDIDOS;  
        try (Statement s = connection.createStatement()) {
            try (ResultSet resultSet = s.executeQuery(sql)) {
                while ( resultSet.next() == true ) {
                    
                    Pedido ped = new Pedido();

                    String codArt = resultSet.getString(2);
                    String emailCli = resultSet.getString(4);

                    Articulo art = contr.obtenerArticulo(codArt);
                    Cliente cli = contr.obtenerCliente(emailCli);
                    
                    ped.setNumero(resultSet.getInt(1) );
                    ped.setArticulo(art);
                    ped.setUnidades( resultSet.getInt(3) );
                    ped.setCliente(cli);
                    ped.setFecha(resultSet.getTimestamp(5) );
                    pedidos.add(ped);
                }
            }
        }
        return pedidos;
    }
    
    public List<Pedido> mostrarPedidosEnviados() throws SQLException {

        List<Pedido> pedidos = new ArrayList();
        final String sql =SQL_GET_LISTA_PEDIDOS;  
        try (Statement s = connection.createStatement()) {
            try (ResultSet resultSet = s.executeQuery(sql)) {
                while ( resultSet.next() == true ) {
                    
                    Pedido ped = new Pedido();

                    String codArt = resultSet.getString(2);
                    String emailCli = resultSet.getString(4);

                    Articulo art = contr.obtenerArticulo(codArt);
                    Cliente cli = contr.obtenerCliente(emailCli);
                    
                    ped.setNumero(resultSet.getInt(1) );
                    ped.setArticulo(art);
                    ped.setUnidades( resultSet.getInt(3) );
                    ped.setCliente(cli);
                    ped.setFecha(resultSet.getTimestamp(5) );
                    
                    // Comprobar si esta enviado
                    Timestamp fecha = new Timestamp(System.currentTimeMillis());
                    Integer tiempoPrep = art.getTiempoDePreparacion();
                    Timestamp fechaPrep = resultSet.getTimestamp(5);
                    
                    long fin = fecha.getTime() - fechaPrep.getTime();
                    int sec = (int)fin / 1000;
                    int min = sec / 60;
                    
                    if (min > tiempoPrep){
                        pedidos.add(ped);
                    }
                }
            }
        }
        return pedidos;
    }
    
    public List<Pedido> mostrarPedidosPendientes() throws SQLException {
        List<Pedido> pedidos = new ArrayList();
        final String sql =SQL_GET_LISTA_PEDIDOS;  
        try (Statement s = connection.createStatement()) {
            try (ResultSet resultSet = s.executeQuery(sql)) {
                while ( resultSet.next() == true ) {
                    
                    Pedido ped = new Pedido();

                    String codArt = resultSet.getString(2);
                    String emailCli = resultSet.getString(4);

                    Articulo art = contr.obtenerArticulo(codArt);
                    Cliente cli = contr.obtenerCliente(emailCli);
                    
                    ped.setNumero(resultSet.getInt(1) );
                    ped.setArticulo(art);
                    ped.setUnidades( resultSet.getInt(3) );
                    ped.setCliente(cli);
                    ped.setFecha(resultSet.getTimestamp(5) );
                    
                    // Comprobar si esta enviado
                    Timestamp fecha = new Timestamp(System.currentTimeMillis());
                    Integer tiempoPrep = art.getTiempoDePreparacion();
                    Timestamp fechaPrep = resultSet.getTimestamp(5);
                    
                    long fin = fecha.getTime() - fechaPrep.getTime();
                    int sec = (int)fin / 1000;
                    int min = sec / 60;
                    
                    if (min < tiempoPrep){
                        pedidos.add(ped);
                    }
                }
            }
        }
        return pedidos;
    }

    public int totalPedidos() throws SQLException {
        final String sql =   "SELECT count(*) FROM pedidos";
        try ( PreparedStatement ps = connection.prepareStatement(sql))
        {
            try ( ResultSet resultSet = ps.executeQuery())
            {
                resultSet.next();
                int count = resultSet.getInt(1);
                return count;
            }
        } catch (SQLException e){
            printSQLException(e);
            return 0;
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
