/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.vista;

import java.rmi.RemoteException;
import servidor.controladores.ControladorGestionPedidoInt;
import cliente.utilidades.UtilidadesConsola;

/**
 *
 * @author valer
 */
public class Menu {

    private final ControladorGestionPedidoInt objRemoto;
    private String usuario;///CAMBIAR
    private String contrasenia;

    public Menu(ControladorGestionPedidoInt objRemoto) {
        this.objRemoto = objRemoto;
    }

    public void ejecutarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("======= Menu Cocinero =========");
            System.out.println("1. Iniciar sesion ");
            System.out.println("2. Salir");

            System.out.println("Digite opcion: ");
            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    opcion1();
                    break;
                case 2:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opción invalida");
            }
        } while (opcion != 2);
    }
    private void opcion1() {
        try {
            int result;
            do {
                solicitarDatos();
                result = objRemoto.iniciarSesion(usuario, contrasenia);
                if (result == 0) {
                    System.out.println("Usuario o contraseña incorrectos. Intente de nuevo");
                }
            }while(result ==0 );
            System.out.println("Inicio de sesion exitoso... ");
            actualizarEstado();
        }
        catch(RemoteException e){
            System.out.println("La operación no se pudo completar, intente nuevamente...");
        }
    }
    private void solicitarDatos() { ///CAMBIAR
        boolean validacionDatos;
        do {
            System.out.println("Ingrese Usuario: ");
            usuario = UtilidadesConsola.leerCadena();
            System.out.println("Ingrese Contrasenia: ");
            contrasenia = UtilidadesConsola.leerCadena();
            validacionDatos = validarLongitud(usuario, 8, 15) && validarLongitud(contrasenia, 7, 15);
            if (!validacionDatos) {
                System.out.println("Error. El usuario y contraseña debe tener entre 8 y 15 caracteres!");
            }
        } while (!validacionDatos);
    }

    private void actualizarEstado() {
        try {
            int opcion = -1;
            do {
                System.out.println("========= Actualizacion del Cocinero=========");
                System.out.println("1. Cocinero Disponible");
                System.out.println("2. Cocinero No Disponible");
                System.out.println("3. Resolver dudas a clientes");
                System.out.println("4. Salir");
                opcion = UtilidadesConsola.leerEntero();
                switch (opcion) {
                    case 1:
                        System.out.println("Cambiando estado a disponible para: " + usuario);
                        objRemoto.cambiarEstadoLibre(usuario);
                        break;
                    case 2:
                        objRemoto.cambiarEstadoOcupado(usuario);
                        break;
                    case 3:
                        chatClientes();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            } while (opcion != 3);

        } 
        catch (RemoteException e) {
            System.out.println("Error al ejecutar operacion: " + e.getMessage());
        }
    }

    private void chatClientes() {
        try {
            GUIConexion objGUIConexion = new GUIConexion();
            objGUIConexion.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error al abrir el chat de clientes: " + e.getMessage());
        }
    }
    private boolean validarLongitud(String texto, int min, int max) {
        return texto.length() >= min && texto.length() <= max;
    }

}
