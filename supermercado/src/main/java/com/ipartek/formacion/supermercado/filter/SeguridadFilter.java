package com.ipartek.formacion.supermercado.filter;

import java.io.IOException;
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
		HttpServletRequest req= (HttpServletRequest)request;
		HttpServletResponse resp= (HttpServletResponse)response;		
		
		try {
			HttpSession sesion = req.getSession();
			Usuario usuario= (Usuario)sesion.getAttribute("usuario");
			
			if (usuario !=null) {
				chain.doFilter(request, response);
			} else {
				resp.sendRedirect(req.getContextPath()+"/login.jsp?msg=Tienes%20que%20estar%20logeado");
			}
			
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

}
