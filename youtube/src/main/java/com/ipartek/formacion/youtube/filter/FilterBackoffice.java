package com.ipartek.formacion.youtube.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

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

import com.ipartek.formacion.pojo.Usuario;

/**
 * Filtramos todas las request que coincidan con urlPatterns = /backoffice/*
 * Comprobamos que el usuario haya pasado por el login para dejarle continuar
 * Si el usuario no ha pasado por login  redirect a /inicio
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }
					, 
		description = "filtro de seguridad para comprar que exista la sesion de usuario", 
		urlPatterns = { 
				"/FilterBackoffice", 
				"/backoffice/*"
		})
public class FilterBackoffice implements Filter {

   
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Se ejecuta al para la aplicacion
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Se ejecuta cuando coincide el filtro
		//castramos el objeto a un httpservletrequest para pdoer tener acceso a la sesion
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res =(HttpServletResponse) response;
		try {
			
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
			if(usuario != null) {
				chain.doFilter(request, response);
			}else {
				//se le pasa la request de http
				informacionCliente(req);
				//si el usuario es nulo por lo que no tiene datos de sesion lo rediccionamos a inicio
				res.sendRedirect(req.getContextPath() + "/inicio");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "/inicio");
		}	
	}
	/**
	 * Mostramos la informacion de la request del cliente
	 * @param req
	 */
	private void informacionCliente(HttpServletRequest req) {
		System.out.println("*******************************");
		
		
		System.out.println(req.getRemoteAddr());
		System.out.println(req.getRemoteHost());
		System.out.println(req.getRemotePort());
		System.out.println(req.getRemoteUser());
		System.out.println(req.getHeaderNames());
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("nombre"));
		
		
		Enumeration nombresCabeceras = req.getHeaderNames();
		
		String metaDato;
		System.out.println("Metadatos");
		while(nombresCabeceras.hasMoreElements()) {
			metaDato = (String) nombresCabeceras.nextElement();
			System.out.println(metaDato + ":" + req.getHeader(metaDato));
		}
		System.out.println("***Parametros***");
		//Map hmParametros = req.getParameterMap();
		
		System.out.println("*******************************");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Se ejecuta en la primera peticion
		System.out.println("Solo se ejecuta una vez");
	}

}
