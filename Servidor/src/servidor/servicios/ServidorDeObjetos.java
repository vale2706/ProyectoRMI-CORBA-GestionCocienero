/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.servicios;

import servidor.utilidades.UtilidadesRegistroS;
import servidor.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidor.Repositorios.GenerarTurnoRepositoryImpl;
import servidor.controladores.ControladorDisplayInt;
import servidor.controladores.ControladorGeneradorTurnoImpl;
import servidor.utilidades.UtilidadesRegistroC;
import servidor.controladores.ControladorGestionPedidoInt;
import servidor.controladores.ControladorGestionPedidoImpl;
import servidor.controladores.ControladorRegistroReferenciaCocineroImpl;


public class ServidorDeObjetos {

    public static void main(String args[]) throws RemoteException {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        int numPuertoRMIRegistryDisplay = 0;
        String direccionIpRMIRegistryDisplay = "";
        int numPuertoRMIRegistryCocinero = 0;
        String direccionIpRMIRegistryCocinero = "";

        System.out.println("Cual es el la direccion ip donde se encuentra  el rmiRegistry de asignacion de cocineros ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiRegistry  de asignacion de cocineros");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero();
        System.out.println("Cual es la direccion ip donde se encuentra el rmiRegistry del servidor display");
        direccionIpRMIRegistryDisplay = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiRegistry del servidor display");
        numPuertoRMIRegistryDisplay = UtilidadesConsola.leerEntero();
        System.out.println("Cual es la direccion ip donde se encuentra el rmiRegistry del servidor cocineros");
        direccionIpRMIRegistryCocinero = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiRegistry del servidor cocineros");
        numPuertoRMIRegistryCocinero = UtilidadesConsola.leerEntero();

        ControladorDisplayInt objRemotoDisplay = (ControladorDisplayInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistryDisplay, numPuertoRMIRegistryDisplay, "controladorDisplay");
        ControladorRegistroReferenciaCocineroImpl objRepositorio1 = new ControladorRegistroReferenciaCocineroImpl();
                
        GenerarTurnoRepositoryImpl objRepositorio = new GenerarTurnoRepositoryImpl(objRemotoDisplay);
        ControladorGeneradorTurnoImpl objRemoto = new ControladorGeneradorTurnoImpl(objRepositorio);//se leasigna el puerto de escucha del objeto remoto
        ControladorGestionPedidoInt objRemotoCocinero = new ControladorGestionPedidoImpl(objRepositorio);
        try {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto,
                    direccionIpRMIRegistry, numPuertoRMIRegistry,
                    "controladorGeneradorTurno");

            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistryCocinero);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoCocinero,
                    direccionIpRMIRegistryCocinero,
                    numPuertoRMIRegistryCocinero,
                    "controladorGestionPedido");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }

    }
}
