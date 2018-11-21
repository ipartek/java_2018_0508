/**
 * AreaServiceSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.AreaService;

public class AreaServiceSOAPImpl implements org.tempuri.AreaService.AreaService_PortType{
    public float calculateRectArea(org.tempuri.AreaService.Dimensions parameters) throws java.rmi.RemoteException {
        return parameters.getHeight()*parameters.getWidth();
    }

}
