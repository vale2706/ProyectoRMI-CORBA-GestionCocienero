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
public class CocineroDTO implements Serializable {

    private int noCocinero;
    private String usuario;
    private String contrasenia;
    private boolean ocupado;
    private HamburguesaDTO objHamburguesa;

    public CocineroDTO() {
    }
    
    public CocineroDTO (String usuario, String contrasenia,int noCocinero, boolean ocupado, HamburguesaDTO objHamburguesa)
    {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.noCocinero = noCocinero;
        this.ocupado = ocupado;
        this.objHamburguesa = objHamburguesa;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setNoCocinero(int noCocinero) {
        this.noCocinero = noCocinero;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado= ocupado;
    }

    public void setObjHamburguesa(HamburguesaDTO objHamburguesa) {
        this.objHamburguesa= objHamburguesa;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public int getNoCocinero() {
        return noCocinero;
    }

    public HamburguesaDTO getObjHamburguesa() {
        return objHamburguesa;
    }

}
