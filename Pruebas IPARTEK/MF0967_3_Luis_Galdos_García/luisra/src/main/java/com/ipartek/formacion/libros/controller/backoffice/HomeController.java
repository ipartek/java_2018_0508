package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/backoffice/inicio")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; 
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	public static String vista = "";
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}


	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

}
