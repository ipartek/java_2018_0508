package com.ipartek.formacion.youtube.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class CheckNombreUsuarioController
 */
@WebServlet("/checknombre")
public class CheckNombreUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoUsuario = null;
	}
	
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
			 
			 //Recoger parámetro
			 String nombre = request.getParameter("nombreRegistro");
			 String resultado = "";
			 //TODO Consultar al DAO
			 
			 Usuario u = daoUsuario.getByNombre(nombre);
			 
			 if(u != null) {
				 resultado = "{\"resultado\": \"Nombre " + nombre + " no disponible\"}";
			 
			 }else {
				 resultado = "{\"resultado\": \"Nombre " +nombre+" disponible\"}";
			 }
			 
			 //Respuesta salida
			 PrintWriter out = response.getWriter();
			 out.print(resultado);
			 out.flush();
		
		 } catch (Exception e) {
			e.printStackTrace();
		}   
		
	}
	
}
