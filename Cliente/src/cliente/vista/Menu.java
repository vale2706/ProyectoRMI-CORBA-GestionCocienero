package cliente.vista;

import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import servidor.DTO.HamburguesaDTO;
import servidor.controladores.ControladorGeneradorTurnoInt;
import sop_corba.ClienteInt;
import sop_corba.ClienteIntHelper;
import sop_corba.ServidorInt;
import sop_corba.ServidorIntHelper;

public class Menu {

    private final ControladorGeneradorTurnoInt objRemoto;

    public Menu(ControladorGeneradorTurnoInt objRemoto) {
        this.objRemoto = objRemoto;
    }

    public void ejecutarMenuPrincipal() {
        int opcion = 0;
        do {
            System.out.println("==Menu==");
            System.out.println("1. Generar turno");
            System.out.println("2. Chat con el Cocinero");
            System.out.println("3. Salir");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    Opcion1();
                    break;
                case 2:
                    Opcion2();
                    break;
                case 3:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 4);
    }

    private void Opcion1() {
        try {
            System.out.println("==Generar Turno==");
            System.out.println("Digite el numero de mesa ");
            int noMesa = UtilidadesConsola.leerEntero();
            System.out.println("Digite el nombre de la hamburguesa ");
            String nombre = UtilidadesConsola.leerCadena();
            System.out.println("Digite el tipo de Hamburguesa [1.Pequena,2.Mediana,3.Grande]");
            int tipoHamburguesa = UtilidadesConsola.leerEntero();
            System.out.println("Digite la cantidad de ingredientes extra ");
            int cantidadIngredientesExtra = UtilidadesConsola.leerEntero();

            HamburguesaDTO objHamburguesa = new HamburguesaDTO(nombre, noMesa, cantidadIngredientesExtra, tipoHamburguesa);

            int valor = objRemoto.generarTurno(objHamburguesa);
            if (valor != -1) {
                System.out.println("Pedido realizado satisfactoriamente...");
                System.out.println("cantidad de pedidos en la fila virtual: " + valor);
            } else {
                System.out.println("no se pudo realizar el registro...");
            }
        } catch (RemoteException e) {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }
    }

    private void Opcion2() {
        try {
            GUIConexion vtnConexion = new GUIConexion();
            vtnConexion.setVisible(true);
        } catch (Exception e) {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
            System.out.println("Excepcion generada: " + e.getMessage());
        }
    }
}
