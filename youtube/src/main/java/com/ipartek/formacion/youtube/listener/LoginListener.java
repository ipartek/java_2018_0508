package com.ipartek.formacion.youtube.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
@WebListener
public class LoginListener implements HttpSessionAttributeListener {

	ArrayList<String> usuariosEnLinea;
	HttpServletRequest request;

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         
    	// Usuario logueado @see LoginController
    	if ("usuario".equals(event.getName())) {
        	 if (usuariosEnLinea == null) {
        		 usuariosEnLinea = new ArrayList<String>();
        	 } 
        	 usuariosEnLinea.add(event.getValue().toString());
        	 
        	 // ServletContext == AplicationScope 
        	 ServletContext context = event.getSession().getServletContext();
        	 context.setAttribute("numUsuariosEnLinea", numUsuariosEnLinea());
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	if ("usuario".equals(event.getName())) {
       	 	usuariosEnLinea.remove(event.getValue().toString());
        }
    }
    
    /**
     * Función privada que devuelve el número de usuarios logueados.
     * @return integer, el tamaño del arrayList usuariosEnLinea.
     */
    private int numUsuariosEnLinea() {
    	return usuariosEnLinea.size();
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }
	
}
