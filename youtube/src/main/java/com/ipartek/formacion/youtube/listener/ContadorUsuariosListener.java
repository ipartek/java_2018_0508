package com.ipartek.formacion.youtube.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.youtube.pojo.Usuario;

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
	public void attributeAdded(HttpSessionBindingEvent event) {
		// Se acaba de logear un usuario @see LoginController
		if ("usuario".equals(event.getName())) {
			Usuario u = (Usuario) event.getValue();
			usuariosConectados.put(u.getNombre(), u);
			
			// ServletContext == aplicationScope
			ServletContext ctx = event.getSession().getServletContext();
			ctx.setAttribute("uConectados", usuariosConectados);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// Se acaba de des-logear un usuario @see LogOutController
		if ("usuario".equals(event.getName())) {
			Usuario u = (Usuario) event.getValue();
			usuariosConectados.remove(u.getNombre());
			
			ServletContext ctx = event.getSession().getServletContext();
			ctx.removeAttribute("uConectados");
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}

}
