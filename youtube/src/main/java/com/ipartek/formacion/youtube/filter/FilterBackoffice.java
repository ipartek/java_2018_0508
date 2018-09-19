package com.ipartek.formacion.youtube.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
 * Filtramos todas las REQUEST que coincidan con URLPattern = { /backoffice/* }
 * Comprobamos que el usuario haya accedido mediante el login para dejarle continuar.
 * Si el usuario no se ha logueado => redirect "inicio"
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }, 
		description = "Filtro para comprobar si un usuario ha sido logueado.", 
		urlPatterns = {"/backoffice/*"}
		)

public class FilterBackoffice implements Filter {

	HttpServletResponse res;
	HttpServletRequest req;
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Se ejecuta al destruir el servidor
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			// Casteamos el ServletRequest -> HttpServletRequest
			req = (HttpServletRequest) request;
			
			// Casteamos el ServletResponse -> HttpServletResponse
			res = (HttpServletResponse) response;
			
			// Capturamos la session
			HttpSession session = req.getSession();
			
			// Capturamos el usuario de la sesión
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
			if (usuario != null) {
				chain.doFilter(request, response);
			} else {
				
				getHeadersInfo(req);		
				res.sendRedirect(req.getContextPath() + "/inicio");
			}			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/inicio");
		}	
	}
	
	/**
	 * Usamos el Request para obtener información del CLIENTE.
	 * @param req
	 */
	private void getHeadersInfo(HttpServletRequest request) {
		
		System.out.println("-------------------------------");
        System.out.println("REMOTE VARIABLES:");
        System.out.println("-------------------------------");
		System.out.println("Remote Host:\t" + req.getRemoteHost());
		System.out.println("Remote IP:\t" + req.getRemoteAddr());
		System.out.println("Remote Port:\t" + req.getRemotePort());
		System.out.println("Remote User:\t" + req.getRemoteUser());
		
        Map<String, String> headerMap = new HashMap<String, String>();
        Enumeration<String> headerNames = request.getHeaderNames();
        
        System.out.println("-------------------------------");
        System.out.println("REQUEST HEADER:");
        System.out.println("-------------------------------");
        while (headerNames.hasMoreElements()) {	// Mientras haya elementos
            
        	String key = headerNames.nextElement();
            String value = request.getHeader(key);
            
            System.out.println(key + ":\t" + value);
            
            headerMap.put(key, value);
        }
        
        System.out.println("-------------------------------");
        System.out.println("REQUEST PARAMETERS:");
        System.out.println("-------------------------------");
        
        //	Obtenemos el Map de parámetros
        Map<String, String[]> parameterMap = req.getParameterMap();
        
        // Recorremos el hashMap y mostramos por pantalla el par valor y clave
        Iterator<Entry<String, String[]>> it = parameterMap.entrySet().iterator();
        
        while (it.hasNext()) {
       
        	    Entry<String, String[]> pairs = it.next();
        	    
        	    String k = (String) pairs.getKey();
        	    String[] v = (String[]) pairs.getValue();
        	    
        	    System.out.print(k + ":\t");
        	    for (int i = 0; i < v.length; i++) {
        	    	System.out.print(v[i] + " ");
        	    }
        	    System.out.println();
        }       
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Se ejecuta cuando se crea el servidor
	}

}
