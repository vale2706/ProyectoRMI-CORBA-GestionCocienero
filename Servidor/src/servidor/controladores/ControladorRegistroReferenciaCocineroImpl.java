/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.controladores;

import cliente.controladores.ControladorCallBackInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
/**
 *
 * @author valer
 */
public class ControladorRegistroReferenciaCocineroImpl extends UnicastRemoteObject implements ControladorRegistroReferenciaCocineroInt{
   private final HashMap<Integer, ControladorCallBackInt> referencias;
    
    public ControladorRegistroReferenciaCocineroImpl() throws RemoteException
    {
        super();
        this.referencias = new HashMap();
    }
    
    public void notificarCocinero(String mensaje, int noCocinero)
    {
        var referencia = this.referencias.get(noCocinero);
        try{
            referencia.notificarAsignacionTurno(mensaje);
        } catch (RemoteException ex){
            System.out.println("Error al notificar al Cocinero");
        }
    } 

    @Override
    public void registrarReferenciaCocinero(ControladorCallBackInt referenciaCocinero, int noCocinero) throws RemoteException {
        this.referencias.put(noCocinero, referenciaCocinero);
    }
}
