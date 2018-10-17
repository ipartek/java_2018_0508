package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutController
 */
@WebServlet("/logout")
public class LogOutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie coockies[]  = request.getCookies();
		String usuarioRecordar =null;	
		HttpSession session = request.getSession();
		String checked = null;
		String ur = null;
		
		try{
			
			
			if ( session != null ) {
				session.removeAttribute("usuario");
				session.invalidate();
				session = null;
			}
			//miramos si hay que recordar el usuario o no 
			if(coockies.length > 0) {
				for (Cookie c : coockies){
					if("on".contains(c.getValue())) {
						for(Cookie cu : coockies) {
							if("cUsuario".contains(cu.getName())) {
								usuarioRecordar = cu.getValue();
								
							}
						}
					}
				}
			}
			if (usuarioRecordar != null && !"".contentEquals(usuarioRecordar)) {
				checked = "checked";
				ur = usuarioRecordar;
			}else {
				checked = "";
				ur = "";
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			response.sendRedirect(request.getContextPath() + "/inicio?ur="+usuarioRecordar+"&checked="+checked ); 
		}
	}

}
