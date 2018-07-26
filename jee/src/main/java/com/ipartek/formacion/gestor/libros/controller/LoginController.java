package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_LOGIN = "login.jsp";
	private static final String VIEW_SALUDO = "saludo.jsp";
	//Constantes
	private static String defectoUsu="admin";
	private static String defectoContra="1234";
	
	private  String paramUsuario = "";//INTRODUCE EL CLIENTE
	private  String paramContra = "";//INTRODUCE EL CLIENTE
	private  String mensaje="";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);// Porque recibimos los conversores por post

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);// Porque aterrizamos en conversor.jsp por get
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// TODA LA EXTRUCTURA
			dispatch = request.getRequestDispatcher(VIEW_LOGIN);
						
			paramUsuario=request.getParameter("usuario");
			paramContra=request.getParameter("contraseina");
			
			//if(paramUsuario !=null) {
				
				if(paramUsuario.equalsIgnoreCase(defectoUsu) && paramContra.equals(defectoContra)) {	//Si es admin
					request.setAttribute("nombre",paramUsuario);
					dispatch=request.getRequestDispatcher(VIEW_SALUDO);
				}else {
					mensaje="ERROR.Usted no puede acceder ya que no es admin";
				}
			//}
			
			
		

		} catch (Exception e) {
			request.setAttribute("msg","Lo sentimos pero tenemos un fallo inesperado ");
			e.printStackTrace();
			
		} finally {
			request.setAttribute("msg", mensaje);
			dispatch.forward(request, response);
		}

	}

}
