package com.ipartek.formacion.clases;

import java.rmi.RemoteException;

public class DreddSaysProxy implements com.ipartek.formacion.clases.DreddSays {
  private String _endpoint = null;
  private com.ipartek.formacion.clases.DreddSays dreddSays = null;
  
  public DreddSaysProxy() {
    _initDreddSaysProxy();
  }
  
  public DreddSaysProxy(String endpoint) {
    _endpoint = endpoint;
    _initDreddSaysProxy();
  }
  
  private void _initDreddSaysProxy() {
    try {
      dreddSays = (new com.ipartek.formacion.clases.DreddSaysServiceLocator()).getDreddSays();
      if (dreddSays != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dreddSays)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dreddSays)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dreddSays != null)
      ((javax.xml.rpc.Stub)dreddSays)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ipartek.formacion.clases.DreddSays getDreddSays() {
    if (dreddSays == null)
      _initDreddSaysProxy();
    return dreddSays;
  }
  
  public java.lang.String randomQuote() throws java.rmi.RemoteException{
    if (dreddSays == null)
      _initDreddSaysProxy();
    return dreddSays.randomQuote();
  }
  
  public static void main (String args[]) {
	  DreddSays dreddSays = new DreddSaysProxy();
	  System.out.println("Dredd says:");
	  try {
		  System.out.println(dreddSays.randomQuote());
	  } catch (RemoteException re) {
		  System.err.println("Remote exception: " + re.getMessage());
	  } catch (Exception e) {
		  System.err.println("Exception: " + e.getMessage());
	  }

	}
}