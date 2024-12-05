/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.utilidades;

import servidor.controladores.ControladorDisplayInt;
import java.rmi.Naming;
import java.rmi.Remote;
/**
 *
 * @author valer
 */
public class UtilidadesRegistroC {
    public static Remote obtenerObjRemoto(String ip, int puerto, String nombreObjeto) {
    String URLRegistro;
    URLRegistro  = "rmi://" +ip + ":" + puerto + "/"+nombreObjeto;
    try
    {
        return Naming.lookup(URLRegistro);
    } catch (Exception e) {
        System.out.println("Error obteniendo el objeto remoto: " + e.getMessage());
        return null;  // En caso de error, retorna null o maneja de otra forma
    }
}
    
}
