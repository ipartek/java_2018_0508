/**
 * AreaService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.AreaService;

public class AreaService_ServiceLocator extends org.apache.axis.client.Service implements org.tempuri.AreaService.AreaService_Service {

    public AreaService_ServiceLocator() {
    }


    public AreaService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AreaService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AreaServiceSOAP
    private java.lang.String AreaServiceSOAP_address = "http://tempuri.org";

    public java.lang.String getAreaServiceSOAPAddress() {
        return AreaServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AreaServiceSOAPWSDDServiceName = "AreaServiceSOAP";

    public java.lang.String getAreaServiceSOAPWSDDServiceName() {
        return AreaServiceSOAPWSDDServiceName;
    }

    public void setAreaServiceSOAPWSDDServiceName(java.lang.String name) {
        AreaServiceSOAPWSDDServiceName = name;
    }

    public org.tempuri.AreaService.AreaService_PortType getAreaServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AreaServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAreaServiceSOAP(endpoint);
    }

    public org.tempuri.AreaService.AreaService_PortType getAreaServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.AreaService.AreaServiceSOAPStub _stub = new org.tempuri.AreaService.AreaServiceSOAPStub(portAddress, this);
            _stub.setPortName(getAreaServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAreaServiceSOAPEndpointAddress(java.lang.String address) {
        AreaServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.AreaService.AreaService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.AreaService.AreaServiceSOAPStub _stub = new org.tempuri.AreaService.AreaServiceSOAPStub(new java.net.URL(AreaServiceSOAP_address), this);
                _stub.setPortName(getAreaServiceSOAPWSDDServiceName());
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
        if ("AreaServiceSOAP".equals(inputPortName)) {
            return getAreaServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/AreaService/", "AreaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/AreaService/", "AreaServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AreaServiceSOAP".equals(portName)) {
            setAreaServiceSOAPEndpointAddress(address);
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
