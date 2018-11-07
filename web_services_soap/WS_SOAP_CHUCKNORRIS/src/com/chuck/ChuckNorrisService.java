/**
 * ChuckNorrisService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.chuck;

public interface ChuckNorrisService extends javax.xml.rpc.Service {
    public java.lang.String getChuckNorrisAddress();

    public com.chuck.ChuckNorris getChuckNorris() throws javax.xml.rpc.ServiceException;

    public com.chuck.ChuckNorris getChuckNorris(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
