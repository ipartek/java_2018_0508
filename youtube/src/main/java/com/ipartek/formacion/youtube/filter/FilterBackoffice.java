package com.ipartek.formacion.youtube.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
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
 * Servlet Filter implementation class FilterBackoffice
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, description = "Comprobar que el usuario que accede al backoffice esta logeado o no", urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Se ejecuta al destruir el filtro (normalmente cuando se para la applicacion)
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Se ejecuta cuando coincide el urlpattern
		// place your code here
		
		HttpServletRequest req= (HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		try {
			
			HttpSession sesion = req.getSession();
			Usuario usuario=(Usuario)sesion.getAttribute("usuario");
			
			if (usuario!=null) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath()+"/inicio");
				informacionCliente(req);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//Se ejecuta al iniciar la app
	}

	/**
	 * Mostramos informacion sobre la request del cliente
	 * 
	 * 
	 * @param req
	 */
	
	public void informacionCliente(HttpServletRequest req) {
		
		
		System.out.println("**********************************");
		System.out.println("Remote address"+req.getRemoteAddr());
		System.out.println("Remote Host"+req.getRemoteHost());
		System.out.println("Remote Port"+req.getRemotePort());
		System.out.println("Remote User"+req.getRemoteUser());
		
		System.out.println("Cabeceras: ");
		Enumeration nombresCabeceras= req.getHeaderNames();
		String metadato;
		while (nombresCabeceras.hasMoreElements()) {
			metadato = (String) nombresCabeceras.nextElement();
			System.out.println(metadato+ " : "+req.getHeader(metadato));
		}
		
		System.out.println("Parametros: ");
		Map<String, String[]> parametros=req.getParameterMap();
		for (Entry<String, String[]> entry : parametros.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + (Arrays.toString(entry.getValue())));
		}
	}
	

}
