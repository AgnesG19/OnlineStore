/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jacob
 */
public class ListaArticulos extends Lista<Articulo> {
    // TO-BE-DONE
    private ArticuloDAO daoArticulos=null;
    List<Articulo> articulos=new ArrayList<Articulo>();

    public List<Articulo> ListaArticulos() throws SQLException {// constructor
        return daoArticulos.getListaArticulos();
        //this.articulos.lista = new ArrayList();
    }

    //DONE

}
