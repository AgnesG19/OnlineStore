/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kazlo
 */
public interface PedidoDAO {
    
    public boolean nuevoPedido(Pedido pedido) throws SQLException ;
    
    public boolean eliminarPedido(String n) throws SQLException;
    
    public void mostrarPedidos() throws SQLException;

    public List mostrarPedidosPendientes() throws SQLException;

    public List mostrarPedidosEnviados() throws SQLException;
     
}