package com.ipartek.formacion.youtube.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class "HomeListener"
 *
 */
@WebListener
public class HomeListener implements ServletContextListener {


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    	System.out.println("Servidor Destruido.");
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         
    	System.out.println("Servidor iniciado....");
    	
    }
	
}
