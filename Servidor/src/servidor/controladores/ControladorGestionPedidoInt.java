/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidor.controladores;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author valer
 */
public interface ControladorGestionPedidoInt extends Remote {
    public int iniciarSesion(String usuario,String contrasenia) throws RemoteException;
    public void cambiarEstadoOcupado(String usuario)throws RemoteException;
    public void cambiarEstadoLibre(String usuario) throws RemoteException;
}
