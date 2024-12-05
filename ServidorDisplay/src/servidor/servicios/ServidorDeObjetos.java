/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.servicios;


import servidor.utilidades.UtilidadesRegistroS;
import servidor.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidor.controladores.ControladorDisplayImpl;

public class ServidorDeObjetos 
{
    public static void main(String args[]) throws RemoteException {
        int numPuertoRMIRegistryServidorDisplay = 0;
        String direccionIpRMIRegistryServidorDisplay = "";
        
        System.out.println("Cual es el la dirección ip donde se encuentra el rmiRegistry del servidor display");
        direccionIpRMIRegistryServidorDisplay = UtilidadesConsola.leerCadena();
        
        System.out.println("Cual es el número de puerto por el cual escucha el rmiRegistry del servidor display");
        numPuertoRMIRegistryServidorDisplay = UtilidadesConsola.leerEntero();
        
        ControladorDisplayImpl objRemoto= new ControladorDisplayImpl();
        
        try
        {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistryServidorDisplay);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistryServidorDisplay, 
                    numPuertoRMIRegistryServidorDisplay, 
                    "controladorDisplay");
        }catch (Exception e){
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}
