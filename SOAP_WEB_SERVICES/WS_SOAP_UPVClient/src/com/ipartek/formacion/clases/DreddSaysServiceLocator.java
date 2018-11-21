/**
 * DreddSaysServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.clases;

public class DreddSaysServiceLocator extends org.apache.axis.client.Service implements com.ipartek.formacion.clases.DreddSaysService {

    public DreddSaysServiceLocator() {
    }


    public DreddSaysServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DreddSaysServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DreddSays
    private java.lang.String DreddSays_address = "http://localhost:8080/WS_SOAP_UPV/services/DreddSays";

    public java.lang.String getDreddSaysAddress() {
        return DreddSays_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DreddSaysWSDDServiceName = "DreddSays";

    public java.lang.String getDreddSaysWSDDServiceName() {
        return DreddSaysWSDDServiceName;
    }

    public void setDreddSaysWSDDServiceName(java.lang.String name) {
        DreddSaysWSDDServiceName = name;
    }

    public com.ipartek.formacion.clases.DreddSays getDreddSays() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DreddSays_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDreddSays(endpoint);
    }

    public com.ipartek.formacion.clases.DreddSays getDreddSays(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ipartek.formacion.clases.DreddSaysSoapBindingStub _stub = new com.ipartek.formacion.clases.DreddSaysSoapBindingStub(portAddress, this);
            _stub.setPortName(getDreddSaysWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDreddSaysEndpointAddress(java.lang.String address) {
        DreddSays_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ipartek.formacion.clases.DreddSays.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ipartek.formacion.clases.DreddSaysSoapBindingStub _stub = new com.ipartek.formacion.clases.DreddSaysSoapBindingStub(new java.net.URL(DreddSays_address), this);
                _stub.setPortName(getDreddSaysWSDDServiceName());
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
        if ("DreddSays".equals(inputPortName)) {
            return getDreddSays();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://clases.formacion.ipartek.com", "DreddSaysService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://clases.formacion.ipartek.com", "DreddSays"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DreddSays".equals(portName)) {
            setDreddSaysEndpointAddress(address);
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
