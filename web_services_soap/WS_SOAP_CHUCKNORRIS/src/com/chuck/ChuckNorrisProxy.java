package com.chuck;

public class ChuckNorrisProxy implements com.chuck.ChuckNorris {
  private String _endpoint = null;
  private com.chuck.ChuckNorris chuckNorris = null;
  
  public ChuckNorrisProxy() {
    _initChuckNorrisProxy();
  }
  
  public ChuckNorrisProxy(String endpoint) {
    _endpoint = endpoint;
    _initChuckNorrisProxy();
  }
  
  private void _initChuckNorrisProxy() {
    try {
      chuckNorris = (new com.chuck.ChuckNorrisServiceLocator()).getChuckNorris();
      if (chuckNorris != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)chuckNorris)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)chuckNorris)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (chuckNorris != null)
      ((javax.xml.rpc.Stub)chuckNorris)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.chuck.ChuckNorris getChuckNorris() {
    if (chuckNorris == null)
      _initChuckNorrisProxy();
    return chuckNorris;
  }
  
  public java.lang.String dimeFrase() throws java.rmi.RemoteException{
    if (chuckNorris == null)
      _initChuckNorrisProxy();
    return chuckNorris.dimeFrase();
  }
  
  
}