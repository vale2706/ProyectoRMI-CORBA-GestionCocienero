package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.HamburguesaDTO;
import servidor.Repositorios.GenerarTurnoRepositoryInt;
public class ControladorGeneradorTurnoImpl extends UnicastRemoteObject implements ControladorGeneradorTurnoInt {

    private final GenerarTurnoRepositoryInt objRepositorio;

    public ControladorGeneradorTurnoImpl(GenerarTurnoRepositoryInt objRepositorio) throws RemoteException {
        super();
        this.objRepositorio = objRepositorio;
    }
    
    @Override
    public int generarTurno(HamburguesaDTO objHamburguesa) {
       return this.objRepositorio.generarTurno(objHamburguesa);
    }

}
