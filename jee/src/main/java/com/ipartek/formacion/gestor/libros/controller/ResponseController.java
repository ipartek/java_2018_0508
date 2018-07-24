package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ejemplo-response")
public class ResponseController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG=Logger.getLogger(PrestamosController.class);
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		try {
			//Unimos doPost y doGet
				//Esto es loque le vamos a pasar al navegador
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			response.getWriter();
			
			//TODO MAQUETAR LA EXTRUCTURA BASICA DEL HTML
			out.print("<!doctype html>");
			out.print("<html lang=\"es\">");
				out.print("Soy una response");
				
			//Siempre al final
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null) {
				out.close();
			}
		}
		
	}
}
