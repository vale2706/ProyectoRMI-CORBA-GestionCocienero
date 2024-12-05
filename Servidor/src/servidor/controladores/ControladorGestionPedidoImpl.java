/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.controladores;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import servidor.Repositorios.GenerarTurnoRepositoryInt;
import servidor.controladores.ControladorGestionPedidoInt;

/**
 
 * @author valer
 */
public class ControladorGestionPedidoImpl extends UnicastRemoteObject implements ControladorGestionPedidoInt {
    private final GenerarTurnoRepositoryInt objRemoto;
    
    
    public ControladorGestionPedidoImpl(GenerarTurnoRepositoryInt objRemoto) throws RemoteException{
         super();
         this.objRemoto= objRemoto;
    }  
    @Override
    public int iniciarSesion(String usuario, String contrasenia) throws RemoteException {
        return objRemoto.iniciarSesion(usuario, contrasenia);      
    }

    @Override
    public void cambiarEstadoOcupado(String usuario) throws RemoteException {
        objRemoto.cambiarEstadoOcupado(usuario);
    }

    @Override
    public void cambiarEstadoLibre(String usuario) throws RemoteException {
        objRemoto.cambiarEstadoLibre(usuario);
    }
      
}
