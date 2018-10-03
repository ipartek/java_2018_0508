package com.adriana.prado.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.adriana.prado.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class ContadorUsuariosListener
 *
 */
@WebListener
public class ContadorUsuariosListener implements HttpSessionAttributeListener {
	
	HashMap<String, Usuario> usuariosConectados = new HashMap<String, Usuario>();

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	//Se acaba de loggear un usuario @see LoginController
    	if(event.getName().equals("usuario")) {
    		Usuario u = (Usuario) event.getValue();
    	 	usuariosConectados.put(u.getNombre(), u); 
    	}
    	
    	//Guardar en contexto app == ServletContext == ApplicationScope
    	ServletContext ctx = event.getSession().getServletContext();
    	ctx.setAttribute("uConectados", usuariosConectados);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	//Se acaba de desloggear un usuario
    	if(event.getName().equals("usuario")) {
    		Usuario u = (Usuario) event.getValue();
    	 	usuariosConectados.remove(u.getNombre()); 
    	}
    	
    	//Guardar en contexto app == ServletContext == ApplicationScope
    	ServletContext ctx = event.getSession().getServletContext();
    	ctx.setAttribute("uConectados", usuariosConectados);
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	
    }
	
}
