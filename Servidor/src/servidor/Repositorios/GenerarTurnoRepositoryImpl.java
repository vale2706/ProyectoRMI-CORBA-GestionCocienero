package servidor.Repositorios;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.DTO.CocineroDTO;
import servidor.DTO.HamburguesaDTO;
import servidor.DTO.NotificacionDTO;
import servidor.controladores.ControladorDisplayInt;

public class GenerarTurnoRepositoryImpl implements GenerarTurnoRepositoryInt {

    private int numeroTurno;
    private int cantidadPedidosFila = 0;
    private final CocineroDTO vectorCocineros[];
    private final HamburguesaDTO pedidosFilaVirtual[];
    private final ControladorDisplayInt objRemotoDisplay;

    public GenerarTurnoRepositoryImpl(ControladorDisplayInt objRemotoDisplay) {
        System.out.println("Configurando cocineros");
        this.vectorCocineros = new CocineroDTO[3];
        this.pedidosFilaVirtual = new HamburguesaDTO[10];
        this.numeroTurno = 1;
        for (int i = 0; i < 3; i++) {
            int j = i + 1;
            this.vectorCocineros[i] = new CocineroDTO();
            this.vectorCocineros[i].setNoCocinero(i + 1);
            this.vectorCocineros[i].setOcupado(true);
            this.vectorCocineros[i].setUsuario("cocinero" + j);
            this.vectorCocineros[i].setContrasenia("123456780");
        }
        this.objRemotoDisplay = objRemotoDisplay;
    }

    private int consultarNumeroCocineroDiponible() {
        int posicion = -1;
        for (int i = 0; i < 3; i++) {
            if (this.vectorCocineros[i].isOcupado() == false) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    @Override
    public int generarTurno(HamburguesaDTO objHamburguesa) {
        int posicion = this.consultarNumeroCocineroDiponible();
        imprimirHamburguesa(objHamburguesa);
        if (posicion == -1) {
            System.out.println("Los cocineros se encuentran ocupados");
            this.pedidosFilaVirtual[this.cantidadPedidosFila] = objHamburguesa;
            this.cantidadPedidosFila++;
            System.out.println("El pedido se agregó a la fila virtual");
        } else {
            System.out.println("El cocinero en la posición " + posicion + " esta libre y se "
                    + "asignara al pedido " + objHamburguesa.getNombre());
            this.vectorCocineros[posicion].setOcupado(true);
            this.vectorCocineros[posicion].setObjHamburguesa(objHamburguesa);
            this.vectorCocineros[posicion].setNoCocinero(posicion + 1);
        }
        this.numeroTurno++;
        enviarNotificacion();
        return this.cantidadPedidosFila;
    }

    private void imprimirHamburguesa(HamburguesaDTO objHamburguesa) {
        System.out.println("No Mesa:" + objHamburguesa.getNoMesa() + "\n"
                + "Hamburguesa:" + objHamburguesa.getNombre() + "\n"
                + "Cantidad de ingredientes extra: " + objHamburguesa.getCantidadIngredientesExtra()
                + "\n" + "Tipo de hamburguesa: " + objHamburguesa.getTipoHamburguesa());
    }

    @Override
    public int iniciarSesion(String usuario, String contrasenia) {
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

    @Override
    public void cambiarEstadoOcupado(String usuario) {
        System.out.println("Invocando a cambiarEstadoOcupado");
        CocineroDTO objCocinero = null;

        // Busca el cocinero por usuario y lo cambia a ocupado solo si no está ocupado ya
        for (int i = 0; i < this.vectorCocineros.length; i++) {
            if (this.vectorCocineros[i].getUsuario().equals(usuario)) {
                objCocinero = this.vectorCocineros[i];
                if (!objCocinero.isOcupado()) { // Solo cambia a ocupado si está libre
                    objCocinero.setOcupado(true);
                    System.out.println("El cocinero " + usuario + " ahora está ocupado.");
                } else {
                    System.out.println("El cocinero " + usuario + " ya está ocupado.");
                }
                break;
            }
        }
        enviarNotificacion();
    }

    @Override
    public void cambiarEstadoLibre(String usuario) {
        System.out.println("Invocando a cambiarEstadoLibre");
        CocineroDTO objCocinero = null;

        // Busca el cocinero por usuario y lo cambia a libre solo si está ocupado
        for (int i = 0; i < this.vectorCocineros.length; i++) {
            if (this.vectorCocineros[i].getUsuario().equals(usuario)) {
                objCocinero = this.vectorCocineros[i];
                if (objCocinero.isOcupado()) {
                    objCocinero.setOcupado(false);
                    objCocinero.setObjHamburguesa(null);
                    System.out.println("El cocinero " + usuario + " ahora está libre.");
                } else {
                    System.out.println("El cocinero " + usuario + " ya está libre.");
                }
                break;
            }
        }
        // Si hay pedidos en la fila virtual, asigna el primer pedido al siguiente cocinero disponible
        if (pedidosFilaVirtual[0] != null) {
            objCocinero.setObjHamburguesa(pedidosFilaVirtual[0]);
            objCocinero.setOcupado(true);
            System.out.println("El cocinero " + usuario + " ahora tiene un nuevo pedido asignado.");

            for (int i = 0; i < pedidosFilaVirtual.length - 1; i++) {
                pedidosFilaVirtual[i] = pedidosFilaVirtual[i + 1];
            }
            cantidadPedidosFila--;
        }
        enviarNotificacion();
    }

    private void enviarNotificacion() {
        NotificacionDTO objNotificacion = new NotificacionDTO();
        objNotificacion.setVectorCocineros(vectorCocineros);
        objNotificacion.setCantidadPedidosFilaVirtual(cantidadPedidosFila);
        try {
            this.objRemotoDisplay.mostrarNotificacion(objNotificacion);
            System.out.println("Notificando al servidor display");
        } catch (Exception e) {
            System.out.println("No fue posible notificar al servidor display");
        }
    }
}
