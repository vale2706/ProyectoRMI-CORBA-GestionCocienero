package cliente.servicios;

import cliente.utilidades.UtilidadesRegistroC;
import cliente.vista.Menu;
import servidor.controladores.ControladorGeneradorTurnoInt;
public class ClienteDeObjetos{
	private static ControladorGeneradorTurnoInt objRemoto;
        
	public static void main(String[] args)
	{
            int numPuertoRMIRegistry = 0;
            String direccionIpRMIRegistry = "";        
               
            System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry del servidor de asignacion de  cocineros ");
            direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
            System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry  del servidor de asignacion de cocineros");
            numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero(); 
            
            objRemoto = (ControladorGeneradorTurnoInt) UtilidadesRegistroC.obtenerObjRemoto(
                    direccionIpRMIRegistry,
                    numPuertoRMIRegistry, 
                    "controladorGeneradorTurno");
            Menu objMenu= new Menu(objRemoto);
            objMenu.ejecutarMenuPrincipal();
		
	}
	
	
	
}

