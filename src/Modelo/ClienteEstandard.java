/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jacob
 */
public class ClienteEstandard extends Cliente {

    //constructor corto
    public ClienteEstandard(){
        super();
    }


    //constructor largo
    public ClienteEstandard(String nombre, String domicilio, String nif, String email){
        super(nombre,domicilio, nif, email);
    }


    public String tipoCliente(){
        return "Estandard";
    }

    public float calcAnual(){
        //al ser cliente estándard no paga cuota anual
        return 0.0f;
    }

    public float descuentoEnv(){
        //sin descuento por ser estándar
        return 0.0f;

    }


    
}
