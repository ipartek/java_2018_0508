package com.ipartek.formacion.supermercado.filter;

import java.io.IOException;
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

import com.ipartek.formacion.supermercado.model.Usuario;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter("/privado/*")
public class SeguridadFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		try {

			HttpSession session = req.getSession();
			Usuario u = (Usuario) session.getAttribute("usuario");
			
			if (u != null) {
				chain.doFilter(request, response);	
			}else {
				res.sendRedirect(req.getContextPath()+ "/login.jsp");
			}

			
		} catch (Exception e) {
			res.sendRedirect(req.getContextPath()+ "/login.jsp");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
