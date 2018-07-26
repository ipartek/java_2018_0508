package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrestamosController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   //parametros
	private String paramUser;	
	private String paramPasswd;
		
	//atributos
	private String mensaje = "";
	private String usuario = "";
	private String contrasenya = "";
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
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
			
			paramUser = request.getParameter("user");
			paramPasswd = request.getParameter("password");
			
			usuario= paramUser;
			contrasenya= paramPasswd;
			
			
			if ("admin".equals(usuario) && "1234".equals(contrasenya)) { //quedaría mejor con unas constantes!!!
				
				mensaje="BIENVENIDO";


			} else {
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
	
			}
			
				
		}
		catch (Exception e){
			
			mensaje="Por favor introduzca un usuario y contraseña correctos";
			e.printStackTrace();
			
		}
		finally {
			
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("usuario", usuario);
			request.setAttribute("contrasenya", contrasenya);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
	}
	



}
