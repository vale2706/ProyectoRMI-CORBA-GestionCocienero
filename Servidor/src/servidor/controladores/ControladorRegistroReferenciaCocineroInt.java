/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidor.controladores;

import cliente.controladores.ControladorCallBackInt;
import java.rmi.RemoteException;
import java.rmi.Remote;
/**
 *
 * @author valer
 */
public interface ControladorRegistroReferenciaCocineroInt extends Remote {
   public void registrarReferenciaCocinero(ControladorCallBackInt referenciaCocinero, int noCocinero) throws RemoteException;  
}
