/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cliente.controladores;

import java.rmi.RemoteException;

/**
 *
 * @author valer
 */
public interface ControladorCallBackInt {
       public void notificarAsignacionTurno(String mensaje) throws RemoteException;   
}
