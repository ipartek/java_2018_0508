package com.ipartek.formacion.txakuretxea.filter;

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

import com.ipartek.formacion.txakuretxea.pojo.Usuario;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/backoffice/*")
public class LoginFilter implements Filter {
	
	private static final String VIEW_LOGIN = "/login.jsp";
	private static final String VIEW_HOME = "/home";

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
				//Pass the request along the filter chain
				chain.doFilter(request, response);
			}else {
				res.sendRedirect(req.getContextPath()+VIEW_LOGIN+"?msg=Tienes%20que%20estar%20logueado");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath()+VIEW_HOME);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
