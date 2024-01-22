package Controlador;

import Modelo.Articulo;
import Modelo.ArticuloDAO_SQL;
import Modelo.Cliente;
import Modelo.ClienteDAO_SQL;
import Modelo.ClienteEstandard;
import Modelo.ClientePremium;
import Modelo.Datos;
import Modelo.Pedido;
import Modelo.PedidoDAO_SQL;
import Vista.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLController implements Initializable{
    
    private Scene scene;
    private Stage stage;
    private Parent root;
    
    private Datos datos;

    List <Articulo> la=new ArrayList<>();
    List <Cliente> lc=new ArrayList<>();
    List <Pedido> lp=new ArrayList<>();
    
    @FXML
    MenuButton menuArt , menuCli , menuPed;
    
    @FXML
    TextField txtNombre , txtDescripcion , txtGastosEnvio , txtPVP , txtTiempo ,
           txtDomicilio , txtNIF , txtEmail , txtTipo , txtCuota , txtDescuento
            , txtNumero , txtArticulo , txtCliente , txtUnidades , txtFecha , 
            txtCodigo;
    
    @FXML
    Button btnGuardarArt , btnGuardarCli , btnGuardarPed , 
            btnMostrarArt , btnMostrarCli , btnMostrarPed ,
            btnMostrarPedE , btnMostrarPedP , btnEliminarArt , 
            btnEliminarCliE , btnEliminarCliP , btnEliminarPed , 
            btnModificarCliE , btnModificarCliP;
    
    @FXML
    TableView<Articulo> tabArticulos;
    @FXML
    TableView<Cliente> tabClientes , tabClientesE , tabClientesP;
    @FXML
    TableView<Pedido> tabPedidos , tabPedidosE , tabPedidosP;
    
    @FXML
    TableColumn<Articulo, String> colCodigo;
    @FXML
    TableColumn<Articulo, String> colDescripcion;
    @FXML
    TableColumn<Articulo, Float> colGastosEnvio;
    @FXML
    TableColumn<Articulo, Float> colPVP;
    @FXML
    TableColumn<Articulo, Integer> colTiempo;
    @FXML
    TableColumn<Cliente, String> colNombre;
    @FXML
    TableColumn<Cliente, String> colDomicilio;
    @FXML
    TableColumn<Cliente, String> colNIF;
    @FXML
    TableColumn<Cliente, String> colEmail;
    @FXML
    TableColumn<Cliente, String> colTipo;
    @FXML
    TableColumn<Cliente, Float> colCuota;
    @FXML
    TableColumn<Cliente, Float> colDescuento;
    @FXML
    TableColumn<Pedido, Integer> colNumero;
    @FXML
    TableColumn<Pedido, Cliente> colCliente;
    @FXML
    TableColumn<Pedido, Articulo> colArticulo;
    @FXML
    TableColumn<Pedido, Integer> colCantidad;
    @FXML
    TableColumn<Pedido, Timestamp> colFecha;
    @FXML
    TableColumn<Pedido, Timestamp> colEnviado;
   
    @FXML
    Label label , lblEstado , lblTitulo , lblCuota , lblDescuento;
    
    public FXMLController() {
    }
    
    public Datos getDatos() {
        return datos;
    }
    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){


    }
    
    
    
    @FXML
    public void agregarArticulos(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLAgregarArticulos.fxml"));        
        stage = (Stage)menuArt.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void mostrarArticulos(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLMostrarArticulos.fxml"));        
        stage = (Stage)menuArt.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }     
    @FXML
    public void agregarClientes(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLAgregarClientes.fxml"));        
        stage = (Stage)menuCli.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }     
    @FXML
    public void mostrarClientes(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLMostrarClientes.fxml"));        
        stage = (Stage)menuCli.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }    
    @FXML
    public void mostrarEstandar(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLMostrarEstandar.fxml"));        
        stage = (Stage)menuCli.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }    
    @FXML
    public void mostrarPremium(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLMostrarPremium.fxml"));        
        stage = (Stage)menuCli.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void agregarPedidos(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLAgregarPedidos.fxml"));        
        stage = (Stage)menuPed.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } 
    @FXML
    public void eliminarPedidos(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLEliminarPedidos.fxml"));        
        stage = (Stage)menuPed.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }  
    @FXML
    public void mostrarPedidos(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLMostrarPedidos.fxml"));        
        stage = (Stage)menuPed.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }    
    @FXML
    public void mostrarPendientes(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLMostrarPendientes.fxml"));        
        stage = (Stage)menuPed.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void mostrarEnviados(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getClassLoader().getResource("Vista/FXMLMostrarEnviados.fxml"));        
        stage = (Stage)menuPed.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }    
    @FXML
    public void salir(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        
    }
// FIN MENU
    @FXML
    public void guardarArt(ActionEvent event) throws SQLException{
        
        
        ArticuloDAO_SQL articuloDAO = new ArticuloDAO_SQL();
        // variables para Artículo nuevo:
        String codigo, descripcion;
        int tiempoDePreparacion;
        float pvp, gastosEnvio;

        codigo = "-";
        descripcion = txtDescripcion.getText();
        pvp = Float.parseFloat(txtPVP.getText());
        gastosEnvio = Float.parseFloat(txtGastosEnvio.getText());
        tiempoDePreparacion = Integer.parseInt(txtTiempo.getText());
        
        //System.out.print(codigo + descripcion + pvp + gastosEnvio + tiempoDePreparacion);
        
        articuloDAO.nuevoArticulo(new Articulo(codigo, descripcion, gastosEnvio, pvp, tiempoDePreparacion));
        lblEstado.setText("Se ha agregado correctamente");

    }
    @FXML
    public void guardarCli(ActionEvent event){
        ClienteDAO_SQL clienteDAO = new ClienteDAO_SQL();
        // variables para Cliente
        char tipoCliente;// 'e' / 'p'
        String nombre, domicilio, nif, email;

        nombre = txtNombre.getText();
        domicilio = txtDomicilio.getText();
        nif = txtNIF.getText();
        email = txtEmail.getText();
        tipoCliente = txtTipo.getText().toLowerCase().charAt(0);
        
        switch (tipoCliente) {
            case 'e':
                clienteDAO.nuevoClienteE(new ClienteEstandard(nombre, domicilio, nif, email));
                lblEstado.setText("Se ha agregado correctamente el cliente Estandar");
                break;
            case 'p':
                clienteDAO.nuevoClienteP(new ClientePremium(nombre, domicilio, nif, email));
                lblEstado.setText("Se ha agregado correctamente el cliente Premium");
                break;
            default:
                return;//salgo de la función
        }
    }
    @FXML
    public void guardarPed(ActionEvent event) throws SQLException{
        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();
        lp=daoPedidos.mostrarPedidosEnviados();
       
        String idArt;
        Articulo art;
        String emailCliente;
        Cliente cli;
        int unidades;

        idArt = txtArticulo.getText();
        art = obtenerArticulo(idArt);
        if (art == null){
            lblEstado.setText("No existe ese artículo.");
        }else{

            emailCliente = txtCliente.getText();   
            cli=obtenerCliente(emailCliente);          
            if (cli ==null){
                lblEstado.setText("No existe el cliente.");
                return;//salir
            }else{
                unidades=Integer.parseInt(txtUnidades.getText());

                Timestamp fecha = new Timestamp(System.currentTimeMillis());

                daoPedidos.nuevoPedido(new Pedido(0, art, cli, unidades, fecha));
                lblEstado.setText("Se ha agregado correctamente el pedido");
            }
        }
    }
    @FXML
    public void mostrarArt(ActionEvent event) throws SQLException{
        datos = new Datos();
        ArticuloDAO_SQL daoArticulos = new ArticuloDAO_SQL();
        la = daoArticulos.getListaArticulos();
      
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colPVP.setCellValueFactory(new PropertyValueFactory<>("pvp"));
        colGastosEnvio.setCellValueFactory(new PropertyValueFactory<>("gastosEnvio"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempoDePreparacion"));
        ObservableList<Articulo> observableListArt= FXCollections.observableArrayList(la);
        tabArticulos.setItems(observableListArt);
    }
    @FXML
    public void mostrarCli(ActionEvent event) throws SQLException{
        datos = new Datos();
        ClienteDAO_SQL daoCliente = new ClienteDAO_SQL();
        lc = daoCliente.getListaClientesE();
        lc.addAll(daoCliente.getListaClientesP());
        
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        colNIF.setCellValueFactory(new PropertyValueFactory<>("nif"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        ObservableList<Cliente> observableListCli= FXCollections.observableArrayList(lc);
        tabClientes.setItems(observableListCli);
    }
    @FXML
    public void mostrarCliE(ActionEvent event) throws SQLException{
        datos = new Datos();
        ClienteDAO_SQL daoCliente = new ClienteDAO_SQL();
        lc = daoCliente.getListaClientesE();
        
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        colNIF.setCellValueFactory(new PropertyValueFactory<>("nif"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        ObservableList<Cliente> observableListCliE= FXCollections.observableArrayList(lc);
        tabClientesE.setItems(observableListCliE);
        
        lblTitulo.setText("Los siguientes clientes tendrán:");
        lblCuota.setText("Cuota: 0.0 Euros");
        lblDescuento.setText("Descuento: 0% en Gastos de Envio");
    }
    @FXML
    public void mostrarCliP(ActionEvent event) throws SQLException{
        datos = new Datos();
        ClienteDAO_SQL daoCliente = new ClienteDAO_SQL();

        lc = daoCliente.getListaClientesP();
        
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        colNIF.setCellValueFactory(new PropertyValueFactory<>("nif"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        ObservableList<Cliente> observableListCliP= FXCollections.observableArrayList(lc);
        tabClientesP.setItems(observableListCliP);
        
        lblTitulo.setText("Los siguientes clientes tendrán:");
        lblCuota.setText("Cuota: 30 Euros");
        lblDescuento.setText("Descuento: 20% en Gastos de Envio");
    }
    @FXML
    public void mostrarPed(ActionEvent event) throws SQLException{
        datos = new Datos();
        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();
        lp = daoPedidos.mostrarPedidos();
      
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colArticulo.setCellValueFactory(new PropertyValueFactory<>("articulo"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        ObservableList<Pedido> observableListPed= FXCollections.observableArrayList(lp);
        tabPedidos.setItems(observableListPed);
    }
    @FXML
    public void mostrarPedE(ActionEvent event) throws SQLException{
        datos = new Datos();
        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();
        lp = daoPedidos.mostrarPedidosEnviados();
      
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colArticulo.setCellValueFactory(new PropertyValueFactory<>("articulo"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        ObservableList<Pedido> observableListPed= FXCollections.observableArrayList(lp);
        tabPedidosE.setItems(observableListPed);
    }
    @FXML
    public void mostrarPedP(ActionEvent event) throws SQLException{
        datos = new Datos();
        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();
        lp = daoPedidos.mostrarPedidosPendientes();
      
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colArticulo.setCellValueFactory(new PropertyValueFactory<>("articulo"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        ObservableList<Pedido> observableListPed= FXCollections.observableArrayList(lp);
        tabPedidosP.setItems(observableListPed);
    }
    @FXML
    public void eliminarArt(ActionEvent event) throws SQLException{
        ArticuloDAO_SQL daoArticulos = new ArticuloDAO_SQL();       
        boolean Confirm = false;
        int selectedId = tabArticulos.getSelectionModel().getSelectedIndex();
        Confirm = daoArticulos.eliminarArticulo(String.valueOf(selectedId + 1));
        if (Confirm == true){
            lblEstado.setText("Articulo eliminado");
        }
        else {
            lblEstado.setText("Error al eliminar el articulo");
        }
        mostrarArt(event);
    }
    @FXML
    public void eliminarCliE(ActionEvent event) throws SQLException{
        ClienteDAO_SQL daoClientes = new ClienteDAO_SQL();       
        boolean Confirm = false;       
        int selectedId = tabClientesE.getSelectionModel().getSelectedIndex();
        String nombre = colNombre.getCellData(selectedId);
        Confirm = daoClientes.eliminarClienteE(nombre);
        
        if (Confirm == true){
            lblEstado.setText("Cliente eliminado");
        }
        else {
            lblEstado.setText("Error al eliminar el cliente");
        }
        mostrarCliE(event);
    }
    @FXML
    public void eliminarCliP(ActionEvent event) throws SQLException{
        ClienteDAO_SQL daoClientes = new ClienteDAO_SQL();        
        boolean Confirm = false;       
        int selectedId = tabClientesP.getSelectionModel().getSelectedIndex();        
        String nombre = colNombre.getCellData(selectedId);
        
        Confirm = daoClientes.eliminarClienteP(nombre);
        
        if (Confirm == true){
            lblEstado.setText("Cliente eliminado");
        }
        else {
            lblEstado.setText("Error al eliminar el cliente");
        }
        mostrarCliP(event);
    }
    @FXML
    public void eliminarPed(ActionEvent event) throws SQLException{

        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();       
        boolean Confirm = false;       
        int selectedId = tabPedidos.getSelectionModel().getSelectedIndex();
        int Id = colNumero.getCellData(selectedId);
        Confirm = daoPedidos.eliminarPedido(Id);
        
        if (Confirm == true){
            lblEstado.setText("Pedido eliminado");
        }
        else {
            lblEstado.setText("Error al eliminar el pedido");
        }
        mostrarPed(event);
    }
    @FXML
    public void eliminarPedE(ActionEvent event) throws SQLException{

        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();       
        boolean Confirm = false;       
        int selectedId = tabPedidosE.getSelectionModel().getSelectedIndex();
        int Id = colNumero.getCellData(selectedId);
        Confirm = daoPedidos.eliminarPedido(Id);
        
        if (Confirm == true){
            lblEstado.setText("Pedido eliminado");
        }
        else {
            lblEstado.setText("Error al eliminar el pedido");
        }
        mostrarPedE(event);
    }
    @FXML
    public void eliminarPedP(ActionEvent event) throws SQLException{

        PedidoDAO_SQL daoPedidos = new PedidoDAO_SQL();       
        boolean Confirm = false;       
        int selectedId = tabPedidosP.getSelectionModel().getSelectedIndex();
        int Id = colNumero.getCellData(selectedId);
        Confirm = daoPedidos.eliminarPedido(Id);
        
        if (Confirm == true){
            lblEstado.setText("Pedido eliminado");
        }
        else {
            lblEstado.setText("Error al eliminar el pedido");
        }
        mostrarPedP(event);
    }

    //Metodos auxiliares
    public Articulo obtenerArticulo(String idArt) throws SQLException{
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
        return null;
    }
    //FIN metodos auxiliares 
// FIN    
}
