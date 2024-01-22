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
public interface ClienteDAO{
    
    public boolean nuevoClienteE(Cliente cliente);
    
    public boolean nuevoClienteP(Cliente cliente);
    
    public boolean eliminarClienteE(String cli) throws SQLException;  
    
    public boolean eliminarClienteP(String cli) throws SQLException;    
    
    public List getListaClientesE() throws SQLException;
    
    public List getListaClientesP() throws SQLException;
    
}
