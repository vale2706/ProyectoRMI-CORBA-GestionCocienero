package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.HamburguesaDTO;


//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGeneradorTurnoInt extends Remote
{
    //Definicion del primer método remoto
    public int generarTurno(HamburguesaDTO objHamburgesa) throws RemoteException;
    
}
