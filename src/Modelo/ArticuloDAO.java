/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.util.List;

public interface ArticuloDAO {
    public boolean nuevoArticulo(Articulo articulo) throws SQLException;
    
    public boolean eliminarArticulo(String n) throws SQLException;

    public List getListaArticulos() throws SQLException;
  
}