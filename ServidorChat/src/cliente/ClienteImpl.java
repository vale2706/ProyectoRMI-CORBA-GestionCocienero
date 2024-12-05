
package cliente;

import sop_corba.ClienteIntPOA;


public class ClienteImpl extends ClienteIntPOA {
    
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
