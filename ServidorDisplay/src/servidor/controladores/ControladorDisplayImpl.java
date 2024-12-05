/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import servidor.DTO.NotificacionDTO;
import servidor.DTO.CocineroDTO;

/**
 *
 * @author valer
 */
public class ControladorDisplayImpl extends UnicastRemoteObject implements ControladorDisplayInt {
    
    public ControladorDisplayImpl() throws RemoteException {
        super();
    }
    
    @Override
    public void mostrarNotificacion(NotificacionDTO objNotificacion) throws RemoteException {
        CocineroDTO vectorCocineros[] = objNotificacion.getVectorCocineros();
        System.out.println("=========== Turnos y cocineros asignados ===========");
        System.out.printf(
            "%-10s %-12s %-22s %-25s %-10s%n",
            "No mesa", "No cocinero", "Cant. ingredientes", "Nombre Hamburguesa", "Tipo"
        );
        
        for (int i = 0; i < 3; i++) {
            if (vectorCocineros[i].isOcupado()) {
                System.out.printf(
                    "%-10d %-12d %-22d %-25s %-10s%n",
                    vectorCocineros[i].getObjHamburguesa().getNoMesa(),
                    vectorCocineros[i].getNoCocinero(),
                    vectorCocineros[i].getObjHamburguesa().getCantidadIngredientesExtra(),
                    vectorCocineros[i].getObjHamburguesa().getNombre(),
                    vectorCocineros[i].getObjHamburguesa().getTipoHamburguesa()
                );
            }
        }
        System.out.println("Cantidad pedidos en la fila virtual: " + objNotificacion.getCantidadPedidosFilaVirtual());
    }
}