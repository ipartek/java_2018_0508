package com.ipartek.formacion.nombre_app.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.nombre_app.pojo.Usuario;

/**
 * Application 'Lifecycle' Listener implementation class
 * ContadorUsuariosListener
 *
 */
@WebListener
public class ContadorUsuariosListener implements HttpSessionAttributeListener {

	HashMap<String, Usuario> usuariosConectados = new HashMap<String, Usuario>();

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {

		gestionarAtributo(event, false);
		actualizarContexto(event);

	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {

		gestionarAtributo(event, true);
		actualizarContexto(event);
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * Procedimiento privado que detecta el nombre del atributo 'event' y lo
	 * gestiona.
	 * 
	 * @param event, HttpSessionBindingEvent
	 * @param eliminado, boolean, indica si el atributo ha sido añadido <b>false<b>
	 *        o eliminado <b>true<b>
	 */
	private void gestionarAtributo(HttpSessionBindingEvent event, boolean eliminado) {

		if ("usuario".equals(event.getName())) { // El evento o atributo es 'Usuario'
			Usuario u = (Usuario) event.getValue(); // Capturamos el Usuario

			if (!eliminado) { // El atributo se ha añadido
				usuariosConectados.put(u.getNombre(), u);

			} else { // El atributo se ha eliminado
				usuariosConectados.remove(u.getNombre());
			}
		}
	}

	/**
	 * Procedimiento privado que actualiza el contexto de la aplicación
	 * sobreescribiendo (o escribiendo) el atributo uConectados.
	 * 
	 * @param event, HttpSessionBindingEvent
	 */
	private void actualizarContexto(HttpSessionBindingEvent event) {

		// Guardar en contexto aplicacion == ServletContext == aplicationScope
		ServletContext ctx = event.getSession().getServletContext();
		ctx.setAttribute("uConectados", usuariosConectados);
	}

}
