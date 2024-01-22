package Controlador;

import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;//time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Modelo.*; // importa todo el paquete
import java.sql.Timestamp;

public class Controlador {

    private Datos datos;

    List <Articulo> la=new ArrayList<>();
    List <Cliente> lc=new ArrayList<>();
    List <Pedido> lp=new ArrayList<>();

    Scanner teclado = new Scanner(System.in);

    public Controlador() {
    }
    
    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }
    // Funcional
    public void nuevoArticulo() throws SQLException{//lectura de datos de nuevo artículo y devuelve el objeto Articulo creado
        ArticuloDAO_SQL articuloDAO = new ArticuloDAO_SQL();
        // variables para Artículo nuevo:
        String codigo, descripcion;
        int tiempoDePreparacion;
        float pvp, gastosEnvio;

        System.out.println("\nCódigo autogenerado\n");
        codigo = "-";
        System.out.println("Descripción: ");
        descripcion = pedirDato();
        System.out.println("Precio: ");
        pvp = Float.parseFloat(pedirDato());
        System.out.println("Gastos de envío: ");
        gastosEnvio = Float.parseFloat(pedirDato());
        System.out.println("Tiempo de preparación (minutos): ");
        //tiempoDePreparacion = Integer.parseInt(pedirDato());
        tiempoDePreparacion = Integer.parseInt(pedirDato());
        //Time t=new Time(tiempoDePreparacion);
        //la.add(new Articulo(codigo, descripcion, precio, gastosEnvio, t));
        articuloDAO.nuevoArticulo(new Articulo(codigo, descripcion, gastosEnvio, pvp, tiempoDePreparacion));
        System.out.println("Artículo guardado OK.");
        System.out.println();
        
    }
    // Funcional
    public void mostrarArticulos() throws SQLException{
        
        datos = new Datos();
        ArticuloDAO_SQL daoArticulos = new ArticuloDAO_SQL();
        la=daoArticulos.getListaArticulos();
                                    
        System.out.println("Listado de artículos:");
        System.out.println("=====================");
        for (int i = 0; i < la.size(); i++) {
            System.out.println(la.get(i));
        }
        if (la.size() == 0) {
            System.out.println("No hay artículos.");
        }
        System.out.println();
    }
    
        public void mostrarIdArticulos() throws SQLException{
        
        datos = new Datos();
        ArticuloDAO_SQL daoArticulos = new ArticuloDAO_SQL();
        la=daoArticulos.getListaArticulos();
                                    
        System.out.println("Seleccione un Id de articulo de la siguiente lista \n");
        for (int i = 0; i < la.size(); i++) {
            System.out.println(la.get(i).getCodigo() + " - " + la.get(i).getDescripcion());
        }
        if (la.size() == 0) {
            System.out.println("No hay artículos.");
        }
        System.out.println();
    }
        
    // Funcional
    public void nuevoCliente(){
        ClienteDAO_SQL clienteDAO = new ClienteDAO_SQL();
        // variables para Cliente
        char tipoCliente;// 'e' / 'p'
        String nombre, domicilio, nif, email;

        System.out.println("\nNuevo cliente:");
        System.out.println("Nombre:");
        nombre = teclado.nextLine();
        System.out.println("Domicilio:");
        domicilio = teclado.nextLine();
        System.out.println("Nif:");
        nif = teclado.nextLine();
        System.out.println("Email:");
        email = teclado.nextLine();
        System.out.println("Tipo: 'e' para estándar, 'p' para premium:");
        tipoCliente = teclado.nextLine().toLowerCase().charAt(0);
        switch (tipoCliente) {
            case 'e':
                clienteDAO.nuevoClienteE(new ClienteEstandard(nombre, domicilio, nif, email));
                System.out.println("Se ha añadido el cliente Estandard" + nombre);
                System.out.println();
                break;
            case 'p':
                clienteDAO.nuevoClienteP(new ClientePremium(nombre, domicilio, nif, email));
                System.out.println("Se ha añadido el cliente Premium" + nombre);
                System.out.println();
                break;
            default:
                System.out.println("Opción no disponible.");
                return;//salgo de la función
        }
    }
    // Funcional
    public void mostrarClientes () throws SQLException{

        datos = new Datos();
        ClienteDAO_SQL daoCliente = new ClienteDAO_SQL();
        lc=daoCliente.getListaClientesE();
 
        if (lc.size() == 0) {
            System.out.println("Nada que mostrar");
        } else {
            
            System.out.println("Listado de clientes totales:");
            System.out.println("=====================");
        
            System.out.println();
            for (int i = 0; i < lc.size(); i++) {
                System.out.println(lc.get(i));
            }
        }
        lc=daoCliente.getListaClientesP();
 
        if (lc.size() == 0) {
        } else {
            for (int i = 0; i < lc.size(); i++) {
                System.out.println(lc.get(i));
            }
            System.out.println();
        }
    }
    // Funcional
    public void mostrarClientesEstaandar() throws SQLException{
        
        datos = new Datos();
        ClienteDAO_SQL daoCliente = new ClienteDAO_SQL();
        lc=daoCliente.getListaClientesE();
        
        if (lc.size() == 0) {
            System.out.println("Nada que mostrar");
        } else {
            System.out.println("Listado de clientes Estandard:");
            System.out.println("=====================");
            System.out.println();
            for (int i = 0; i < lc.size(); i++) {
                System.out.println(lc.get(i));
            }
            System.out.println();
        }
    }
    // Funcional
    public void mostraCientesPremium() throws SQLException{

        datos = new Datos();
        ClienteDAO_SQL daoCliente = new ClienteDAO_SQL();
        lc=daoCliente.getListaClientesP();
        
        if (lc.size() == 0) {
            System.out.println("Nada que mostrar");
        } else {
            System.out.println("Listado de clientes Premium:");
            System.out.println("=====================");
            System.out.println();
            for (int i = 0; i < lc.size(); i++) {
                System.out.println(lc.get(i));
            }
            System.out.println();
        }
    }
    public void mostrarEmailClientes() throws SQLException{

        ClienteDAO_SQL daoCliente = new ClienteDAO_SQL();
        lc=daoCliente.getListaClientesE();
        
        if (lc.size() == 0) {
            System.out.println("Nada que mostrar");
        } else {
            
            System.out.println("Listado de emails:");
        
            System.out.println();
            for (int i = 0; i < lc.size(); i++) {
                System.out.println(lc.get(i).getEmail());
            }
        }
        lc=daoCliente.getListaClientesP();
 
        if (lc.size() == 0) {
        } else {
            for (int i = 0; i < lc.size(); i++) {
                System.out.println(lc.get(i).getEmail());
            }
            System.out.println();
        }
    }

    public void nuevoPedido() throws SQLException{
        
        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();
        lp=daoPedidos.mostrarPedidosEnviados();
        
        //variables
        int numero;
        String idArt;//id del artículo
        Articulo art;
        String emailCliente;//id del cliente
        Cliente cli;
        int unidades;
//        int anno, mes, dia, hora, minutos;//para fecha del pedido
        //LocalDateTime fecha;//fecha del pedido
        //Date fecha;//fecha del pedido

        System.out.println("\nNuevo Pedido:");
        System.out.println("Número de pedido: ");
        numero = Integer.parseInt(teclado.nextLine());
        mostrarIdArticulos();
        System.out.println("Identificador del artículo:");
        idArt=teclado.nextLine();
        art=obtenerArticulo(idArt);
        if (art == null){
            System.out.println("No existe ese artículo.");
        }else{
            mostrarEmailClientes();
            System.out.println("Email del cliente:");
            emailCliente=teclado.nextLine();
            cli=obtenerCliente(emailCliente);
            if (cli ==null){
                System.out.println("No existe el cliente.");
                return;//salir
            }else{
                System.out.println("Unidades: ");
                unidades=Integer.parseInt(teclado.nextLine());

                Timestamp fecha = new Timestamp(System.currentTimeMillis());

                daoPedidos.nuevoPedido(new Pedido(numero, art, cli, unidades, fecha));
                
                System.out.println("Pedido agregado ok.");                
            }
        }
    }//end nuevoPedido


    public void eliminarPedido() throws SQLException{//elimina el pedido a partir de su número
        
        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();

        Integer n;//número de pedido a eliminar
        boolean Confirm = false;
        System.out.println("Introducir el número de pedido a eliminar: ");
        n = Integer.parseInt(teclado.nextLine());
        Confirm = daoPedidos.eliminarPedido(n);
        if (Confirm == true){
            System.out.println("Pedido eliminado");
        }
        else {
            System.out.println("Error al eliminar el pedido");
        }
    }
    
    public void mostrarPedidosPendientes() throws SQLException{
        
        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();
        lp=daoPedidos.mostrarPedidosEnviados();
        
        System.out.println("\nListado de pedidos pendientes:");
        System.out.println("-------------------------------");
        Pedido ped;
        for (int i=0;i<lp.size();i++){
            ped=lp.get(i);
            if (!ped.pedidoEnviado()){ //no se ha enviado, luego es pendiente
                System.out.println(ped);
            }
        }
        System.out.println();
        System.out.println("-------  fin de listado --------");
        System.out.println();

    }
    public void mostrarPedidosEnviados(){

        System.out.println("\nListado de pedidos enviados:");
        System.out.println("-------------------------------");
        Pedido ped;
        for (int i=0;i<lp.size();i++){
            ped=lp.get(i);
            if (ped.pedidoEnviado()){//se ha enviado
                System.out.println(ped);
            }
        }
        System.out.println();
        System.out.println("-------  fin de listado --------");
        System.out.println();

    }
    
    public void obtenerIdPedidos() throws SQLException{
        
        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();
        lp=daoPedidos.mostrarPedidos();
        
        System.out.println("\nElija un Id de pedido:\n");
        
        if (lp.size() == 0) {
        } else {
            for (int i = 0; i < lp.size(); i++) {
                System.out.println(lp.get(i).getNumero());
            }
            System.out.println();
        }
    }


    public Articulo obtenerArticulo(String idArt) throws SQLException{
        //devuelve el artículo de la lista, si existe
        //si no existe, devuelve null
       
        Articulo art = null;
        ArticuloDAO_SQL daoArticulos = new ArticuloDAO_SQL();
        la=daoArticulos.getListaArticulos();

        for (int i=0;i<la.size();i++){
            if (idArt.toLowerCase().equals(la.get(i).getCodigo().toLowerCase())){
                if (la.get(i) != null){
                    art = la.get(i);
                }
            }
        }
        return art;

    }

    public Cliente obtenerCliente(String emailCliente) throws SQLException{
        //si existe en la lista, lo devuelve
        //si no, null
        ClienteDAO_SQL daoCliente = new ClienteDAO_SQL();
        lc=daoCliente.getListaClientesE();
        Cliente cli;
        for (int i=0;i<lc.size();i++){
            cli=lc.get(i);
            if (cli.getEmail().toLowerCase().equals(emailCliente.toLowerCase())){
                return cli;
            }
        }
        lc=daoCliente.getListaClientesP();
        for (int i=0;i<lc.size();i++){
            cli=lc.get(i);
            if (cli.getEmail().toLowerCase().equals(emailCliente.toLowerCase())){
                return cli;
            }
        }
        return null;//no such Cliente
    }


    String pedirDato() {
        String resp;
        resp = teclado.nextLine();
        return resp;
    }

} 