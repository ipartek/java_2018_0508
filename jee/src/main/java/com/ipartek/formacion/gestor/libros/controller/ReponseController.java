package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrestamosController
 */
@WebServlet("/ejemplo-response")
public class ReponseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final Logger LOG = Logger.getLogger(PrestamosController.class);


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
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		PrintWriter out = null;
		
		try {
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");		
		
			out = response.getWriter();
			
			//TODO maquetar la esctrucutra basica del html
			out.print("<!doctype html>");
			out.print("<p>Soy un Response</p>");
			
			//siempre al final
			out.flush();
			
			
		} catch (Exception e) {		
			e.printStackTrace();
			
		}finally {			
			if ( out != null ) {
				out.close();
			}
		}
		
		
		
	}


}


