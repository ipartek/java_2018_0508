package com.ipartek.formacion.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.UsuarioDAO;

/**
 * Servlet implementation class CheckNombreUsuarioController
 */
@WebServlet("/checknombre")
public class CheckNombreUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UsuarioDAO daousuario = null;

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
		try {
			daousuario = UsuarioDAO.getInstance();
			//Responde con formato json
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        
	        //Recoger parametros
	        String nombre = request.getParameter("nombre");
	        
	        //Llamar al dao
	        boolean resul = daousuario.getByNombre(nombre);
	        
	        //Respuesta Salida
//	        response.setStatus(HttpServletResponse.SC_OK);
	        
			PrintWriter out = response.getWriter();
	        out.print("{\"resultado\": "+resul+"}");
	        out.flush();   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}
