package com.ipartek.formacion.youtube.listener;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UltimaVezListener
 *
 */
@WebListener
public class UltimaVezListener implements HttpSessionListener {

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//TODO Guarda ultima visita real, no hora del sistema -> Servlet, jsp...
    	//gestionar cookies ultima visita
    	/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
    	Cookie cVisita = new Cookie("cVisita", URLEncoder.encode(dateFormat.format(new Date()), "UTF-8"));
    	cVisita.setMaxAge(60*60*24*365); //1año
    	ServletContext ctx = se.getSession().getServletContext();
    	ctx.addCookie(cVisita);*/
    }
	
}
