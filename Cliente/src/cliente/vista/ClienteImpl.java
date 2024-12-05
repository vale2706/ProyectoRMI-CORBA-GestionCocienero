/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.vista;

import sop_corba.ClienteIntPOA;

/**
 *
 * @author yicel
 */
class ClienteImpl extends ClienteIntPOA {

    private GUIClienteChat GUIC;    

    ClienteImpl(GUIClienteChat GUIC) {
        this.GUIC = GUIC;
    }

    @Override
    public void recibirMensaje(String usuario, String mensaje) {
        GUIC.fijarTexto(usuario, mensaje);
    }

    @Override
    public String obtenerUsuario() {
        return GUIC.obtenerNombre();
    }
}
