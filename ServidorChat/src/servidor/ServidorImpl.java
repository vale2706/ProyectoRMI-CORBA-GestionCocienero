/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.util.ArrayList;
import java.util.List;
import sop_corba.ClienteInt;
import sop_corba.ServidorIntPOA;
import sop_corba.ServidorIntPackage.DatosCliente;

/**
 *
 * @author Usuario
 */
public class ServidorImpl extends ServidorIntPOA {
    
    private List<ClienteInt> clientes;
    private final List<Float> calificaciones;
    
    public ServidorImpl() {
       clientes = new ArrayList<>();
       calificaciones = new ArrayList<>();
    }
    
    @Override
    public boolean registrarCliente(ClienteInt objcllbck, String usuario) {
        System.out.println("Registrar");
        boolean registro = false;
        if(!clientes.contains(objcllbck)){
            registro = clientes.add(objcllbck);
        }
        if(registro){
            System.out.println("El cliente con el numero de turno "+ usuario+ "se ha registrado");
        }
        return registro;
    }

    @Override
    public void enviarMensaje(String usuario, String mensaje) {
       for(ClienteInt cliente: clientes)
           cliente.recibirMensaje(usuario,mensaje);
    }

    @Override
    public boolean desconectarCliente(ClienteInt objcllbck, String usuario) {
        boolean bandera = clientes.remove(objcllbck);
        return bandera;
    }

    @Override
    public DatosCliente[] obtenerUsuariosConectados() {
        return (DatosCliente[]) this.clientes.toArray();
    }

    @Override
    public void calificarAtencion(String usuario, float calificacion) {
        if (calificacion >= 0 && calificacion <= 5) {
        calificaciones.add(calificacion);
        System.out.println("El cliente " + usuario + " calificó con: " + calificacion);
        } else {
        System.err.println("Calificación inválida: " + calificacion);
        }
    }

    @Override
    public float obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) {
        return 0;
        }
        float suma = 0;
        for (float calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.size();
    }

    @Override
    public String obtenerApreciacion() {
        float promedio = obtenerPromedioCalificaciones();
        if (promedio <= 2.9) return "Mala";
        else if (promedio <= 3.9) return "Aceptable";
        else if (promedio <= 4.5) return "Buena";
        else return "Excelente";
    }
    
}
