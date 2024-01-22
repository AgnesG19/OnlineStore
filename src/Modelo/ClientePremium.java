/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jacob
 */
public class ClientePremium extends Cliente {



    //constructor corto
    public ClientePremium(){
        super();
    }


    //constructor largo
    public ClientePremium(String nombre, String domicilio, String nif, String email){
        super(nombre,domicilio, nif, email);
    }

    public String tipoCliente() {
        return "Premium";
    }

    public float calcAnual() {
        // 30eu anuales
        return 30.0f;
    }

    public float descuentoEnv() {
        // 20% en gastos de envío
        return 0.2f;

    }

}
