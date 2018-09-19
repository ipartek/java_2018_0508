package com.ipartek.formacion.youtube.listener;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		Usuario u = (Usuario)se.getSession().getAttribute("usuario");
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) se.getSession().getServletContext().getAttribute("usuariosPermitidos");
		usuarios.remove(u);
		se.getSession().getServletContext().setAttribute("usuariosConectados", usuarios);
	}

}
