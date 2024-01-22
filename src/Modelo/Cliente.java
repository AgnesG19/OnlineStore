/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jacob
 */
public abstract class Cliente {

    String nombre;
    String domicilio;
    String nif;
    String email;//identificador

    //constructor corto
    public Cliente(){
        nombre="-";
        domicilio="-";
        nif="-";
        email="-";
    }
    //constructor largo:
    public Cliente(String nombre, String domicilio, String nif, String email){
        setNombre(nombre);
        setDomicilio(domicilio);
        setNif(nif);
        setEmail(email);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //end getters and setters

    public abstract String tipoCliente();
    public abstract float calcAnual();
    public abstract float descuentoEnv();

    public String toString(){
        String str="Cliente: "+getNombre();
        str+=" * "+getDomicilio();
        str+=" * "+getNif();
        str+=" * "+getEmail();

        str+=" * tipo de cliente: " + tipoCliente();

        return str;

    }

}