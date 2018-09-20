package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class ComentarController
 */
@WebServlet("/ComentarController")
public class ComentarController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet.doGet()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//	Comprobar si hay un usuario logueado
		if (session.getAttribute("usuario") != null) {
			
			String comentario = request.getParameter("comentario");
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			Date fechaPubli = new Date();
			
		}
	}

	/**
	 * @see HttpServlet.doPost()
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
