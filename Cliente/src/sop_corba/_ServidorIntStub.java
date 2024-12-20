package sop_corba;


/**
* sop_corba/_ServidorIntStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* domingo 1 de diciembre de 2024 03:01:22 PM COT
*/

public class _ServidorIntStub extends org.omg.CORBA.portable.ObjectImpl implements sop_corba.ServidorInt
{

  public boolean registrarCliente (sop_corba.ClienteInt objCallback, String usuario)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registrarCliente", true);
                sop_corba.ClienteIntHelper.write ($out, objCallback);
                $out.write_string (usuario);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return registrarCliente (objCallback, usuario        );
            } finally {
                _releaseReply ($in);
            }
  } // registrarCliente

  public void enviarMensaje (String usuario, String mensaje)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("enviarMensaje", true);
                $out.write_string (usuario);
                $out.write_string (mensaje);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                enviarMensaje (usuario, mensaje        );
            } finally {
                _releaseReply ($in);
            }
  } // enviarMensaje

  public void calificarAtencion (String usuario, float calificacion)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("calificarAtencion", true);
                $out.write_string (usuario);
                $out.write_float (calificacion);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                calificarAtencion (usuario, calificacion        );
            } finally {
                _releaseReply ($in);
            }
  } // calificarAtencion

  public float obtenerPromedioCalificaciones ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("obtenerPromedioCalificaciones", true);
                $in = _invoke ($out);
                float $result = $in.read_float ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return obtenerPromedioCalificaciones (        );
            } finally {
                _releaseReply ($in);
            }
  } // obtenerPromedioCalificaciones

  public String obtenerApreciacion ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("obtenerApreciacion", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return obtenerApreciacion (        );
            } finally {
                _releaseReply ($in);
            }
  } // obtenerApreciacion

  public sop_corba.ServidorIntPackage.DatosCliente[] obtenerUsuariosConectados ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("obtenerUsuariosConectados", true);
                $in = _invoke ($out);
                sop_corba.ServidorIntPackage.DatosCliente $result[] = sop_corba.ServidorIntPackage.ListaClientesHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return obtenerUsuariosConectados (        );
            } finally {
                _releaseReply ($in);
            }
  } // obtenerUsuariosConectados

  public boolean desconectarCliente (sop_corba.ClienteInt objcllbck, String usuario)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("desconectarCliente", true);
                sop_corba.ClienteIntHelper.write ($out, objcllbck);
                $out.write_string (usuario);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return desconectarCliente (objcllbck, usuario        );
            } finally {
                _releaseReply ($in);
            }
  } // desconectarCliente

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/ServidorInt:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ServidorIntStub
