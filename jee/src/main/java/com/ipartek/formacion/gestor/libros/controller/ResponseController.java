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
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doProcess(request,response);
	}

	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		PrintWriter out = null;
		try {
			// TODO Auto-generated method stub
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			out = response.getWriter();
			
			//TODO maquetar la estructura basica del html
			out.print("<!DOCTYPE html>");
			out.print("<p>Soy una response</p>");
			
			//siempre al final
			out.flush();
			
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
			
		}finally {
			if(out!=null) {
				out.close();
			}
			
		}
		
		
		
	}

}
