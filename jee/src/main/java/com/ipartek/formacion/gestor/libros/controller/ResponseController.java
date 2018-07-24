package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ejemplo-response")

public class ResponseController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG = Logger.getLogger(PrestamosContoller.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("pasamos por doGet");

		// 1.Recibir para metros
		String parametros = request.getParameter("nombre");

		// 2.Validar parametros

		// 3.llamar modelo

		// 4.enviar Atributos vista
		request.setAttribute("nombre", parametros);

		// 5.Ir a la vista

		request.getRequestDispatcher("listado.jsp").forward(request, response);

	}
	
	protected void doGet1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	

	private void doPost1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
	
	
		PrintWriter out = null;
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			out.println("<!doctype html>");
			out.println("<p>Soy un response</p>");
			
			out.flush();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			if(out != null) {
				out.close();
				
			}
		}

	}
}
