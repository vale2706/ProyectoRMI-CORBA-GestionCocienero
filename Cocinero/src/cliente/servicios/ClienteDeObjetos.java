/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.servicios;

import cliente.controladores.ControladorCallBackImpl;
import servidor.controladores.ControladorRegistroReferenciaCocineroInt;
import cliente.utilidades.UtilidadesRegistroC;
import cliente.utilidades.UtilidadesConsola;
import servidor.controladores.ControladorGestionPedidoInt;
import cliente.vista.Menu;
import java.rmi.RemoteException;

/**
 *
 * @author valer
 */
public class ClienteDeObjetos {

    private static ControladorGestionPedidoInt objRemoto;
    private static ControladorRegistroReferenciaCocineroInt objRemoto2;

    public static void main(String[] args) {
        int numPuertoRMIRegistry = 0;
        int noCocinero;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry del servidor de cocineros ");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry del servidor de  cocineros");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();
        System.out.println("Cual es el numero de cocinero asignado");
        noCocinero = cliente.utilidades.UtilidadesConsola.leerEntero();
        objRemoto2 = (ControladorRegistroReferenciaCocineroInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, noCocinero, "controladorRegistroReferenciaCocinero");

        ControladorCallBackImpl objRemotoCliente;
        try {
            objRemotoCliente = new ControladorCallBackImpl();
            objRemoto2.registrarReferenciaCocinero(objRemotoCliente, noCocinero);
            System.out.println("Esperando Notificaciones: ");
        } catch (RemoteException ex) {
            System.out.println("Error al registrar el cocinero en el servidor");
        }

        objRemoto = (ControladorGestionPedidoInt) UtilidadesRegistroC.obtenerObjRemoto(
                direccionIpRMIRegistry,
                numPuertoRMIRegistry,
                "controladorGestionPedido");

        Menu objMenu = new Menu(objRemoto,noCocinero);
        objMenu.ejecutarMenuPrincipal();

    }

}
