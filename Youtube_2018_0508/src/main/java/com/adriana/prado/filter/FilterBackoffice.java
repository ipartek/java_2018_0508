package com.adriana.prado.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
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

import com.adriana.prado.pojo.Usuario;

/**
 * Filtramos todas las request que coincidan con urlPatterns = { "/backoffice/*" }
 * Comprobamos que el usuario haya pasado por el login para dejarle continuar
 * Si el usuario no ha pasado por login => redirect "/inicio"
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Se ejecuta al destuir el hilo o al parar la app
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Cada vez que coincide la url del filtro se ejecuta
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
				
			try {
			
			HttpSession session =  req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
			if(usuario != null) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}else {
				//TODO comprobar rol del usuario. Si es 0, pasa, sino, no puede
				
				informacionCliente(req);
				
				//usuario no loggeado
				res.sendRedirect(req.getContextPath() + "/inicio");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/inicio");
		}
	}

	/**
	 * Mostramos informacion sobre la request del cliente
	 * @param req
	 */
	private void informacionCliente(HttpServletRequest req) {
		System.out.println("----------------------------------------");
		
		
		System.out.println("Remote Host: "+req.getRemoteHost());
		System.out.println("Remote Address: "+req.getRemoteAddr());
		System.out.println("Remote Port: "+req.getRemotePort());
		System.out.println("Remote User: "+req.getRemoteUser());
		
		System.out.println("");
		System.out.println("Cabeceras: ");
		Enumeration<String> nombresCabeceras = req.getHeaderNames();
		String metadato;
		
		while(nombresCabeceras.hasMoreElements()) {
			metadato = (String) nombresCabeceras.nextElement();
			System.out.println(metadato + ": " + req.getHeader(metadato));
		}
		
		System.out.println("");
		System.out.println("Parámetros: ");
		
		Enumeration<String> parameterNames = req.getParameterNames();
		while (parameterNames.hasMoreElements()) {
		    String key = (String) parameterNames.nextElement();
		    String val = req.getParameter(key);
		    System.out.println("Key: "+key+", Value: "+val);
		}
		
		System.out.println("----------------------------------------");
	}

	/**
	 * Se ejecuta al iniciar la app
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Se ejecuta en la primera peticion
	}

}
