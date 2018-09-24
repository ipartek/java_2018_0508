package com.ipartek.formacion.supermercado.filter;

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

import com.ipartek.formacion.supermercado.model.pojo.Usuario;



/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/privado/*" })
public class SeguridadFilter implements Filter {

   
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		try {
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			if(usuario != null) {
				chain.doFilter(request, response);
			}else {
				//se le pasa la request de http
				informacionCliente(req);
				//si el usuario es nulo por lo que no tiene datos de sesion lo rediccionamos a inicio
				res.sendRedirect(req.getContextPath() + "/home");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	
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

}
