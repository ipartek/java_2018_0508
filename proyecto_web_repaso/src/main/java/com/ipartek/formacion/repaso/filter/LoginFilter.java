package com.ipartek.formacion.repaso.filter;

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

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/videojuego" })
public class LoginFilter implements Filter {
	
	private final static Logger LOG = Logger.getLogger(LoginFilter.class);

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		try {
			
			HttpSession session = req.getSession();
			
			if(session.getAttribute("login") != null) {
				chain.doFilter(request, response);
			}else {
				session.setAttribute("msgLogin", "Inicia sesión para acceder al área privada almendrao!");
				res.sendRedirect(req.getContextPath() + "/index.jsp");
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
