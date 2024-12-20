/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.servicios;

import cliente.utilidades.UtilidadesRegistroC;
import cliente.utilidades.UtilidadesConsola;
import servidor.controladores.ControladorGestionPedidoInt;
import cliente.vista.Menu;

/**
 *
 * @author valer
 */

public class ClienteDeObjetos {

    private static ControladorGestionPedidoInt objRemoto;

    public static void main(String[] args) {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la direccion ip donde se encuentra  el rmiregistry del servidor de cocineros ");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiregistry del servidor de  cocineros");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();

        objRemoto = (ControladorGestionPedidoInt) UtilidadesRegistroC.obtenerObjRemoto(
                direccionIpRMIRegistry,
                numPuertoRMIRegistry,
                "controladorGestionPedido");
        Menu objMenu = new Menu(objRemoto);
        objMenu.ejecutarMenuPrincipal();

    }

}
