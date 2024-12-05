package cliente.vista;

import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidor.DTO.HamburguesaDTO;
import servidor.controladores.ControladorGeneradorTurnoInt;

public class Menu {
    
    private final ControladorGeneradorTurnoInt objRemoto;
    
    public Menu(ControladorGeneradorTurnoInt objRemoto)
    {
        this.objRemoto=objRemoto;
    }
    
    public void ejecutarMenuPrincipal()
    {
        int opcion = 0;
        do
        {
            System.out.println("==Menu==");
            System.out.println("1. Generar turno");
            System.out.println("2. Salir");

            opcion = UtilidadesConsola.leerEntero();

            switch(opcion)
            {
                case 1:
                        Opcion1();
                        break;
                case 2:
                        System.out.println("Salir...");
                        break;
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcion != 4);
    }

    private void Opcion1() 
    {
        try
        {
                System.out.println("==Generar Turno==");
                System.out.println("Digite el numero de mesa ");
                int noMesa = UtilidadesConsola.leerEntero();
                System.out.println("Digite el nombre de la hamburguesa ");
                String nombre = UtilidadesConsola.leerCadena();
                System.out.println("Digite el tipo de Hamburguesa ");
                int tipoHamburguesa = UtilidadesConsola.leerEntero();
                System.out.println("Digite la cantidad de ingredientes extra ");
                int cantidadIngredientesExtra = UtilidadesConsola.leerEntero();
                
                HamburguesaDTO objHamburguesa= new HamburguesaDTO(nombre, noMesa, cantidadIngredientesExtra, tipoHamburguesa);

                int valor = objRemoto.generarTurno(objHamburguesa);
                if(valor != -1){
                        System.out.println("Pedido realizado satisfactoriamente...");
                        System.out.println("cantidad de pedidos en la fila virtual: "+ valor);
                }else
                        System.out.println("no se pudo realizar el registro...");
        }
        catch(RemoteException e)
        {
                System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }
    }
}
