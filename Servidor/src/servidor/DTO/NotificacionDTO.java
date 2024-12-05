/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.DTO;
import java.io.Serializable;
/**
 *
 * @author valer
 */
public class NotificacionDTO  implements Serializable {

    private CocineroDTO vectorCocineros[];
    private int cantidadPedidosFilaVirtual;
    
    public NotificacionDTO(){
        
    }

    public CocineroDTO[] getVectorCocineros() {
        return vectorCocineros;
    }

    public void setVectorCocineros(CocineroDTO[] vectorCocineros) {
        this.vectorCocineros = vectorCocineros;
    }

    public int getCantidadPedidosFilaVirtual() {
        return cantidadPedidosFilaVirtual;
    }

    public void setCantidadPedidosFilaVirtual(int cantidadPedidosFilaVirtual) {
        this.cantidadPedidosFilaVirtual = cantidadPedidosFilaVirtual;
    }
    
    
}