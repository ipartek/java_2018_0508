package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class ComentController
 */
@WebServlet("/comentController")
public class ComentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Comentario>comentarios;
	Comentario coment;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (comentarios==null) {
				comentarios= new ArrayList<Comentario>();
			}
			String texto= request.getParameter("comentario");
			Usuario u= (Usuario)request.getSession().getAttribute("usuario");
			Date fecha = new Date();
			coment=new Comentario(texto, u, fecha,(Video)request.getAttribute("videoInicio"));
			comentarios.add(coment);
			request.setAttribute("comentarios", comentarios);
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		}
	
	}

}
