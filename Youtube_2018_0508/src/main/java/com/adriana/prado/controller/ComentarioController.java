package com.adriana.prado.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adriana.prado.pojo.Usuario;

/**
 * Servlet implementation class ComentarioController
 */
@WebServlet("/comentar")
public class ComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private String comentario;
	private LocalDateTime ldt;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//usuario = (Usuario) request.getParameter("user");
		}catch(Exception e) {
			
		}finally {
			response.sendRedirect(request.getContextPath() + "/inicio");
		}
	}

}
