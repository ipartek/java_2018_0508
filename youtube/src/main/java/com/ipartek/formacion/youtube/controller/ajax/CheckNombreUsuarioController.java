package com.ipartek.formacion.youtube.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckNombreUsuarioController
 */
@WebServlet("/checknombre")
public class CheckNombreUsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//Responde con formato JSON
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			
	        //recoger paramatro
	        String nombre = request.getParameter("nombre");
			
	        //TODO consultar DAO
	        
	        //Respuesta Salida
	        
	        //response.setStatus(HttpServletResponse.SC_OK);
	        
			PrintWriter out = response.getWriter();	        
	        out.print("{ \"resultado\": \"Nombre Disponible "+nombre+" \" }");
	        out.flush();
	        
		}catch (Exception e) {
			e.printStackTrace();
		}  
	}

}
