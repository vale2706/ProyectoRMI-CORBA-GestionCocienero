
package servidor.Repositorios;

import servidor.DTO.HamburguesaDTO;

public interface GenerarTurnoRepositoryInt
{   
   public int generarTurno(HamburguesaDTO objHamburgesa);
   public int iniciarSesion(String usuario,String contrasenia);
   public void cambiarEstadoOcupado(String usuario);
   public void cambiarEstadoLibre(String usuario); 
   
}


