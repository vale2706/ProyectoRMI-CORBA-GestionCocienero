/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidor.controladores;

import cliente.controladores.ControladorCallBackInt;
import java.rmi.RemoteException;

/**
 *
 * @author valer
 */
public interface ControladorRegistroReferenciaCocineroInt {
      public void registrarReferenciaCocinero(ControladorCallBackInt referenciaCocinero, int noCocinero) throws RemoteException;  

}
