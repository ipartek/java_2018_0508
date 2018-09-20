package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.pojo.Comentario;

/**
 * Servlet implementation class ComentarioController
 */
@WebServlet("/comentario")
public class ComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Comentario> comentarios;
  

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

			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			String comentario = request.getParameter("comentario");
			Comentario c = new Comentario(comentario);
			
			if(comentarios == null) {
				comentarios = new ArrayList<>();
			}
			
			comentarios.add(c);
			
			request.setAttribute("fecha", hourdateFormat.format(date));
			request.setAttribute("comentario", comentarios);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

}
