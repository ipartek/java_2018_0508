/**
 * ChuckNorrisServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.chuck;

public class ChuckNorrisServiceLocator extends org.apache.axis.client.Service implements com.chuck.ChuckNorrisService {

    public ChuckNorrisServiceLocator() {
    }


    public ChuckNorrisServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ChuckNorrisServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ChuckNorris
    private java.lang.String ChuckNorris_address = "http://localhost:8080/WS_SOAP_CHUCKNORRIS/services/ChuckNorris";

    public java.lang.String getChuckNorrisAddress() {
        return ChuckNorris_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ChuckNorrisWSDDServiceName = "ChuckNorris";

    public java.lang.String getChuckNorrisWSDDServiceName() {
        return ChuckNorrisWSDDServiceName;
    }

    public void setChuckNorrisWSDDServiceName(java.lang.String name) {
        ChuckNorrisWSDDServiceName = name;
    }

    public com.chuck.ChuckNorris getChuckNorris() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ChuckNorris_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getChuckNorris(endpoint);
    }

    public com.chuck.ChuckNorris getChuckNorris(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.chuck.ChuckNorrisSoapBindingStub _stub = new com.chuck.ChuckNorrisSoapBindingStub(portAddress, this);
            _stub.setPortName(getChuckNorrisWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setChuckNorrisEndpointAddress(java.lang.String address) {
        ChuckNorris_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.chuck.ChuckNorris.class.isAssignableFrom(serviceEndpointInterface)) {
                com.chuck.ChuckNorrisSoapBindingStub _stub = new com.chuck.ChuckNorrisSoapBindingStub(new java.net.URL(ChuckNorris_address), this);
                _stub.setPortName(getChuckNorrisWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ChuckNorris".equals(inputPortName)) {
            return getChuckNorris();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://chuck.com", "ChuckNorrisService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://chuck.com", "ChuckNorris"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ChuckNorris".equals(portName)) {
            setChuckNorrisEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
