/**
 * AreaServiceSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.AreaService;

public class AreaServiceSOAPSkeleton implements org.tempuri.AreaService.AreaService_PortType, org.apache.axis.wsdl.Skeleton {
    private org.tempuri.AreaService.AreaService_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/AreaService/", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tempuri.org/AreaService/", "dimensions"), org.tempuri.AreaService.Dimensions.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("calculateRectArea", _params, new javax.xml.namespace.QName("http://tempuri.org/AreaService/", "area"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "CalculateRectArea"));
        _oper.setSoapAction("http://tempuri.org/AreaService/NewOperation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("calculateRectArea") == null) {
            _myOperations.put("calculateRectArea", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("calculateRectArea")).add(_oper);
    }

    public AreaServiceSOAPSkeleton() {
        this.impl = new org.tempuri.AreaService.AreaServiceSOAPImpl();
    }

    public AreaServiceSOAPSkeleton(org.tempuri.AreaService.AreaService_PortType impl) {
        this.impl = impl;
    }
    public float calculateRectArea(org.tempuri.AreaService.Dimensions parameters) throws java.rmi.RemoteException
    {
        float ret = impl.calculateRectArea(parameters);
        return ret;
    }

}
