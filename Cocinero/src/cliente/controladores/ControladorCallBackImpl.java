/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author valer
 */
public class ControladorCallBackImpl extends UnicastRemoteObject implements ControladorCallBackInt{
    
    public ControladorCallBackImpl() throws RemoteException
    {
        super();
    }
    @Override
    public void notificarAsignacionTurno(String mensaje) throws RemoteException {
        System.out.println(mensaje);
    }
    
}
