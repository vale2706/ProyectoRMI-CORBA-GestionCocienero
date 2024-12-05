package servidor;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import sop_corba.ServidorInt;
import sop_corba.ServidorIntHelper;

public class ServidorDeObjetos {
    public static void main(String[] args) {
        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialHost";
            System.out.println("Ingrese la dirección IP donde escucha el n_s");
            vec[1] = UtilidadesConsola.leerCadena();
            vec[2] = "-ORBInitialPort"; 
            System.out.println("Ingrese el puerto donde escucha el n_s");
            vec[3] = UtilidadesConsola.leerCadena();

            ServidorImpl objRemoto = new ServidorImpl();
            inicializarORB(vec, objRemoto);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Servidor: Saliendo ...");
    }

    private static void inicializarORB(String[] vec, ServidorImpl objRemoto)
            throws ServantNotActive, WrongPolicy, org.omg.CORBA.ORBPackage.InvalidName,
            AdapterInactive, InvalidName, NotFound, CannotProceed {

        // Crear e iniciar el ORB
        ORB orb = ORB.init(vec, null); // Inicia el ORB con las configuraciones de vec (dirección y puerto)

        // Obtén la referencia de RootPOA
        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootpoa.the_POAManager().activate();

        // Genera la referencia del servant (el objeto remoto)
        org.omg.CORBA.Object obj = rootpoa.servant_to_reference(objRemoto);
        ServidorInt href = ServidorIntHelper.narrow(obj);

        // Obtén el link al Naming Service
        org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
        NamingContextExt ncref = NamingContextExtHelper.narrow(objref);

        // Realiza el binding de la referencia del servant en el Naming Service
        String name = "ServidorChat"; // Nombre del objeto remoto
        NameComponent path[] = ncref.to_name(name);
        ncref.rebind(path, href); // Realiza el binding con el Naming Service

        System.out.println("El Servidor está listo y esperando ...");

        // Espera por invocaciones desde los clientes
        orb.run();
    }
}
