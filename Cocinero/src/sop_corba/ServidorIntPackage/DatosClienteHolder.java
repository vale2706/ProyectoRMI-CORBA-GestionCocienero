package sop_corba.ServidorIntPackage;

/**
* sop_corba/ServidorIntPackage/DatosClienteHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* domingo 1 de diciembre de 2024 03:01:22 PM COT
*/

public final class DatosClienteHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.ServidorIntPackage.DatosCliente value = null;

  public DatosClienteHolder ()
  {
  }

  public DatosClienteHolder (sop_corba.ServidorIntPackage.DatosCliente initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.ServidorIntPackage.DatosClienteHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.ServidorIntPackage.DatosClienteHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.ServidorIntPackage.DatosClienteHelper.type ();
  }

}