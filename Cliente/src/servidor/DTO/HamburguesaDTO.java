package servidor.DTO;

import java.io.Serializable;

public class HamburguesaDTO implements Serializable
{	
    private String nombre;
    private int noMesa;
    private int cantidadIngredientesExtra;
    private int tipoHamburguesa;

    public HamburguesaDTO(String nombre, int noMesa, int cantidadIngredientesExtra, int tipoHamburguesa) {
        this.nombre = nombre;
        this.noMesa = noMesa;
        this.cantidadIngredientesExtra = cantidadIngredientesExtra;
        this.tipoHamburguesa = tipoHamburguesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNoMesa() {
        return noMesa;
    }

    public void setNoMesa(int noMesa) {
        this.noMesa = noMesa;
    }

    public int getCantidadIngredientesExtra() {
        return cantidadIngredientesExtra;
    }

    public void setCantidadIngredientesExtra(int cantidadIngredientesExtra) {
        this.cantidadIngredientesExtra = cantidadIngredientesExtra;
    }

    public int getTipoHamburguesa() {
        return tipoHamburguesa;
    }

    public void setTipoHamburguesa(int tipoHamburguesa) {
        this.tipoHamburguesa = tipoHamburguesa;
    }

    
    

}
