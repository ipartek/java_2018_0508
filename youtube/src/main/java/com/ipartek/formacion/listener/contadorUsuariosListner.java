package com.ipartek.formacion.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class contadorUsuariosListner
 *
 */
@WebListener
public class contadorUsuariosListner implements HttpSessionAttributeListener {

	HashMap<String, Usuario> usuariosConectados = new HashMap<String,Usuario>();
   

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
        System.out.println("attributeAdded");
        //Se acaba de loguear un usuario @see LoginControlelr
        if("usuario".equals(event.getName())) {
        	Usuario u = (Usuario)event.getValue();
        	//cojemos el objeto
        	usuariosConectados.put(u.getNombre(), u);
        	 //Gurdar el contexto aplicacion == ServletContext == aplicationScope
            ServletContext ctx = event.getSession().getServletContext();
            ctx.setAttribute("uConectados", usuariosConectados);
        }
        if("recuerdame".equals(event.getName())) {
        	System.out.println("Evento event.getName contiene recuerdame");

        }
       
    }
	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	System.out.println("attributeRemoved");
    	//Se acaba de desloguear un usuario @see LoginControlelr
        if("usuario".equals(event.getName())) {
        	Usuario u = (Usuario)event.getValue();
        	//cojemos el objeto y lo borramos 
        	usuariosConectados.remove(u.getNombre());
        }
        //Gurdar el contexto aplicacion == ServletContext == aplicationScope
        ServletContext ctx = event.getSession().getServletContext();
        ctx.setAttribute("uConectados", usuariosConectados);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("attributeReplaced");
    }
	
}
