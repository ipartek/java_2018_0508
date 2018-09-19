package com.ipartek.formacion.youtube.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Filtramos todas las request que coincidan con urlPatterns = { "/backoffice/*" } <br>
 * Comprobamos que el usuario haya pasado por el login para dejarle continuar. <br>
 * Si el usuario no se ha logeado => redirect a '/inicio'
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }, 
		description = "Filtro para comprobar que el usuario se ha logeado a la hora de acceder al backoffice", 
		urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Se ejecuta al destruir el hilo/filtro, normalmente cuando se para la aplicación
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Se ejecuta cuando coincide el urlpattern

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		try {
			
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			
			if(usuario != null) {
				//Pasa la request a través de la cadena de filtros
				chain.doFilter(request, response);
			}else {
				
				informacionCliente(req);
				
				//Usuario no logeado
				res.sendRedirect(req.getContextPath() + "/inicio");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/inicio");
		}
		
		
	}

	/**
	 * Mostramos información sobre la request del cliente.
	 * @param req
	 */
	private void informacionCliente(HttpServletRequest req) {

		System.out.println("-----------------------------");
		
		System.out.println("Remote Host: " + req.getRemoteHost());
		System.out.println("Remote Adress: " + req.getRemoteAddr());
		System.out.println("Remote Port: " + req.getRemotePort());
		System.out.println("Remote User: " + req.getRemoteUser());
		
		System.out.println("");
		System.out.println("Cabeceras:");
		Enumeration nombresCabeceras = req.getHeaderNames();
		String metadato;
		
		while(nombresCabeceras.hasMoreElements()) {
			metadato = (String)nombresCabeceras.nextElement();
			System.out.println(metadato + " : " + req.getHeader(metadato));
		}

		System.out.println("");
		System.out.println("Parámetros:");
		
		Map parametros = req.getParameterMap();		
		Set s = parametros.entrySet();
        Iterator it = s.iterator();
		
        while(it.hasNext()){

            Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();

            String key = entry.getKey();
            String[] value = entry.getValue();

            System.out.println("Clave: " + key);
            System.out.println("Valor: " + Arrays.toString(value));
            
        }
        
        System.out.println("");
		System.out.println("-----------------------------");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Se ejecuta cuando arranca el servidor.
	}

}
