package Vista;



import Controlador.Controlador;

import java.sql.SQLException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jacob
 */
public class GestionOS {
    
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);

    public GestionOS() throws SQLException {// constructor
        controlador = new Controlador();

    }

    public void inicio() throws SQLException {
        boolean salir = false;
        char opcio, opcio2;

        do {
            System.out.println("1. Gestión Artículos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1': // gestión de artículos OK
                    // todo: añadir y mostrar artículos OK
                    System.out.println("1. Añadir artículo");
                    System.out.println("2. Mostrar artículos");
                    System.out.println("opción: ");
                    opcio2 = teclado.nextLine().charAt(0);
                    switch (opcio2) {
                        case '1':// crear nuevo artículo OK
                            controlador.nuevoArticulo();
                            break;

                        case '2'://mostrar artículos OK
                            controlador.mostrarArticulos();
                            break;
                    }
                    break;
                case '2':// gestión de clientes OK
                    System.out.println();
                    System.out.println("Gestión de clientes:");
                    System.out.println("--------------------");
                    System.out.println("1. Añadir clientes");
                    System.out.println("2. Mostrar clientes");
                    System.out.println("3. Mostrar clientes estándar");
                    System.out.println("4. Mostrar clientes premium");
                    System.out.println("opción: ");
                    opcio2 = teclado.nextLine().charAt(0);
                    switch (opcio2) {
                        case '1':// añadir clientes OK
                            controlador.nuevoCliente();
                            break;

                        case '2':// mostrar clientes OK
                            controlador.mostrarClientes();
                            break;

                        case '3':// mostrar clientes estándar OK
                            controlador.mostrarClientesEstaandar();
                            break;

                        case '4':// mostrar clientes premium OK
                            controlador.mostraCientesPremium();
                            break;
                    }

                break;
                case '3': // gestión de pedidos PTE
                System.out.println();
                System.out.println("Gestión de pedidos:");
                System.out.println("--------------------");
                System.out.println("1. Añadir pedido");
                System.out.println("2. Eliminar pedido");
                System.out.println("3. Mostrar pedidos pendientes");
                System.out.println("4. Mostrar pedidos enviados");

                System.out.println("opción: ");
                opcio2 = teclado.nextLine().charAt(0);
                switch (opcio2) {
                    case '1':// añadir pedido OK
                        controlador.nuevoPedido();
                        break;
                    case '2':// eliminar pedido OK
                        controlador.eliminarPedido();
                        break;
                    case '3':// mostrar pedidos pendientes PTE
                        controlador.mostrarPedidosPendientes();
                        break;
                    case '4':// mostrar pedidos enviados PTE
                        controlador.mostrarPedidosEnviados();
                        break;

                }
                break;                 
                case '0':
                    salir = true;
            }
        } while (!salir);
    }

    char pedirOpcion() {
        String resp;// respuesta
        System.out.println("Elige una opción (1,2,3 o 0):");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    String pedirDato() {
        String resp;
        resp = teclado.nextLine();
        return resp;
    }
}