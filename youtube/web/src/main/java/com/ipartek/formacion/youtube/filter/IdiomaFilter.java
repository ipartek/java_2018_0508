package com.ipartek.formacion.youtube.filter;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class IdiomaFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" })
public class IdiomaFilter implements Filter {

   public static final String DEFAULT_IDIOMA = "es_ES";
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		String idioma = request.getParameter("idioma");
				
		try {
			
			if ( idioma == null ) {				
				idioma = (String)session.getAttribute("idioma");
			}
			
			if ( idioma == null) {
				//conseguir idioma del usuario a traves de la request
				idioma = request.getLocale().toString();			
				if ( idioma.length() != 5 ) {
					idioma = "es_ES";		
				}	
			}
		}catch (Exception e) {
			idioma = "es_ES";
		}finally {
			//guardar en session
			session.setAttribute("idioma", idioma);		
		}		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}