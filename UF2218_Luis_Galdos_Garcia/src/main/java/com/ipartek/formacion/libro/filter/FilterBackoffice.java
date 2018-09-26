package com.ipartek.formacion.libro.filter;

import java.io.IOException;
import java.util.Enumeration;

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

import com.ipartek.formacion.libro.pojo.Usuario;


/**
 *  Filtramos todas las REQUEST que coincidan con urlPatterns = { "/backoffice/*" }  <br>
 *  Comprobamos que el usuario haya pasado por el login para dejarle continuar.<br>
 *  Si el usuario no se ha logeado => redirect "/inicio"
 *  
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST } 
					, urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {

   

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Se ejecuta al destruir el filtro");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		try {			
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
			if ( usuario != null ) {
				// Pass the request along the filter chain
				chain.doFilter(request, response);
			}else {
				
				getInformacionCliente(req);
				
				//Usuario no logeado
				res.sendRedirect( req.getContextPath() + "/inicio");
			}	
		}catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect( req.getContextPath() + "/inicio");
		}	
	}

	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Se ejecuta al inciar la App Web");
	}

	
	/**
	 * Mostramos informacion sobre la Request del cliente
	 * 
	 * @param req
	 */
	private void getInformacionCliente(HttpServletRequest req) {
		
		System.out.println("----------------------------------------");
				
		System.out.println("RemoteHost: " + req.getRemoteHost() );
		System.out.println("RemoteAddr: " + req.getRemoteAddr() );
		System.out.println("RemotePort: " + req.getRemotePort() );
		System.out.println("RemoteUser: " + req.getRemoteUser() );
		
		System.out.println("");
		System.out.println("CABECERA:");
		
		Enumeration<String> nombresCabeceras = req.getHeaderNames();
		
		String metadato;
		
		while ( nombresCabeceras.hasMoreElements() ) {
			metadato = (String)nombresCabeceras.nextElement();
			System.out.println("    " + metadato + ": " + req.getHeader(metadato));
		}
		
		System.out.println("");
		System.out.println("PARAMETROS:");
		
		Enumeration<String> parameterNames = req.getParameterNames();
		
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String[] paramValues = req.getParameterValues(paramName);
			for (int i = 0; i < paramValues.length; i++) {
				String paramValue = paramValues[i];
				System.out.println("    " + paramName + ": " + paramValue);
			}

		}
				
		System.out.println("----------------------------------------");
	}
	
}
