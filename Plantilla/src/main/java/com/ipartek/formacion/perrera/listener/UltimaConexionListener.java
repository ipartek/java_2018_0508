package com.ipartek.formacion.nombre_app.listener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener que controla la última visita de cada HttpSession (no confundir session con usuario)
 *
 */
@WebListener
public class UltimaConexionListener implements HttpSessionListener {


	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         
    	
		try {
			
			HttpSession session = se.getSession();
			session.setMaxInactiveInterval(0);

	    	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	    	String oldString = format.format(new Date(session.getLastAccessedTime()));
	    	
	    	Date okDate = format.parse(oldString);
			session.setAttribute("ultimaConexion", okDate);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	 
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
