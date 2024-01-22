/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

//import java.time.DateTime;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author jacob
 */
public class Pedido {

    int numero;
    Articulo articulo;
    Cliente cliente;
    int unidades;
    Timestamp fecha; // fecha y hora

    public Pedido(){
        numero = 0;
        articulo = null;
        cliente = null;
        unidades = 0;
        fecha = null;
    }
    // constructor
    public Pedido(int numero, Articulo articulo, Cliente cliente, int unidades, Timestamp fecha) {
        setNumero(numero);
        setArticulo(articulo);
        setCliente(cliente);
        setUnidades(unidades);
        setFecha(fecha);
    }

    // getters and setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    //public DateTime getFecha() {        return fecha;    }
    public Timestamp getFecha() {
        return fecha;
    }

    //public void setFecha(DateTime fecha) {        this.fecha = fecha;    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    // end of getters and setters

    public boolean pedidoEnviado() {
        // Si fecha del pedido + minutos de preparación < fecha actual (?), se considera
        // que se ha enviado

        // DateTime fechaEnvio=this.fecha.plusMinutes(this.articulo.getTiempoDePreparacion());
        //DateTime fechaEnvio=this.fecha.plusMinutes(this.articulo.getTiempoDePreparacion().getTime());
        Date fechaEnvio=this.fecha;//.plusDays(1);
        //return fechaEnvio.isBefore(DateTime.now());
        //return fechaEnvio.isBefore(Date.now());

        return fechaEnvio.before(new Date());


    }

//    public float precioEnvio() {
//        float precio;
//        float gastosEnviio;
//        precio = getUnidades() * getArticulo().getPvp();// precio sin gastos de envío
//        gastosEnviio = getArticulo().getGastosEnvio() * getUnidades();// gastos de envío sin descuento
//
//        precio += gastosEnviio * (1 - cliente.descuentoEnv());
//        // redondeo a 2 decimales:
//        precio =(float) (Math.round(precio * 100.0) / 100.0);
//        return precio;
//    }

    @Override
    public String toString() {
        String str = "Pedido num " + getNumero();
        str += "\nArtículo: " + getArticulo();
        str += "\nCliente: " + getCliente();
        str += "\nUnidades: " + getUnidades();
        str += "\nFecha: " + getFecha();
        str += "\n";

        return str;
    }

}