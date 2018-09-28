package com.casa.practicas.listener;





import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;



/**
 * Application Lifecycle Listener implementation class contadorUsuariosListner
 *
 */
@WebListener
public class contadorUsuariosListner implements HttpSessionAttributeListener {

	//HashMap<String, Usuario> usuariosConectados = new HashMap<String,Usuario>();
   

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
        System.out.println("attributeAdded");
        //Se acaba de loguear un usuario @see LoginControlelr

    }
	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	System.out.println("attributeRemoved");
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("attributeReplaced");
    }
	
}
