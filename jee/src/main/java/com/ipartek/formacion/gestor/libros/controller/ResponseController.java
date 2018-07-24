package com.ipartek.formacion.gestor.libros.controller; 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ejemplo-response")  //La url a la que hay que escuchar, SIEMPRE empieza por barra( / )
public class ResponseController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//private static final Logger log = Logger.getLogger(PrestamosController.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
		
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		PrintWriter out = null;
		
		try {
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
		
			out = response.getWriter();
			
			//TODO maquetar la estructura básica de html
			out.print("<!doctype html>");
			out.print("<p>Soy una response</p>");		
			
			//Siempre al final
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
