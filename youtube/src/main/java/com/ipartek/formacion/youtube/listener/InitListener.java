package com.ipartek.formacion.youtube.listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
@WebListener
public class InitListener implements ServletContextListener {
	

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Se ejecuta al parar el tomcat");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Se ejecuta al iniciar el tomcat");
    	
    	Usuario u1 = new Usuario("admin", "admin");
    	Usuario u2 = new Usuario("pepe", "pepe");
    	Usuario u3 = new Usuario("manoli", "manoli");
    	Usuario u4 = new Usuario("josepo", "josepo");
    	
    	ArrayList<Usuario> usuariosPermitidos = new ArrayList<Usuario>();
    	usuariosPermitidos.add(u1);
    	usuariosPermitidos.add(u2);
    	usuariosPermitidos.add(u3);
    	usuariosPermitidos.add(u4);
    	
    	sce.getServletContext().setAttribute("usuariosPermitidos", usuariosPermitidos);
    	
    }
	
}
