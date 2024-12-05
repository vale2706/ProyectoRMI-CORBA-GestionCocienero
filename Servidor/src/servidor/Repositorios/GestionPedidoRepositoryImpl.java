/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.Repositorios;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.DTO.CocineroDTO;
import servidor.DTO.HamburguesaDTO;
import servidor.DTO.NotificacionDTO;
import servidor.controladores.ControladorDisplayInt;

/**
 *
 * @author valer
 */
public class GestionPedidoRepositoryImpl implements GestionPedidoRepositoryInt {

    private int numeroTurno;
    private int cantidadPedidosFila = 0;
    private final CocineroDTO vectorCocineros[];
    private final HamburguesaDTO pedidosFilaVirtual[];
    private final ControladorDisplayInt objRemotoDisplay;
    public GestionPedidoRepositoryImpl(ControladorDisplayInt objRemotoDisplay)
    {        
        System.out.println("Configurando cocineros");
        this.vectorCocineros = new CocineroDTO[3];
        this.pedidosFilaVirtual = new HamburguesaDTO[10];
        this.numeroTurno=1;
        for(int i =0; i <3;i++){
            int j=i+1;
            this.vectorCocineros[i] = new CocineroDTO();
            this.vectorCocineros[i].setNoCocinero(i+1);
            this.vectorCocineros[i].setOcupado(true);
            this.vectorCocineros[i].setUsuario("cocinero"+j);
            this.vectorCocineros[i].setContrasenia("123456780");
        }
        this.objRemotoDisplay= objRemotoDisplay;
    }   
    

        @Override
        public int iniciarSesion
        (String usuario, String contrasenia
        
            ){
        System.out.println("Invocando a iniciar sesion...");
            for (int i = 0; i < this.vectorCocineros.length; i++) {
                if (this.vectorCocineros[i].getUsuario().equals(usuario)) {
                    if (this.vectorCocineros[i].getContrasenia().equals(contrasenia)) {
                        return 1;
                    }
                }
            }
            return 0;
        }

}
