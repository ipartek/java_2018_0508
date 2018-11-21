package com.ipartek.formacion.youtube.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.dao.CheckNombreDAO;

/**
 * Servlet implementation class CheckNombreUsuarioController
 */
@WebServlet("/checknombre")
public class CheckNombreUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CheckNombreDAO daoCheckNombre = null;
	
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		daoCheckNombre = CheckNombreDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		daoCheckNombre = null;
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
			
			//recoger parametro
			String nombre = request.getParameter("nombre");
			
			//TODO consultar DAO
			
			//Respuesta Salida
			PrintWriter out = response.getWriter();
			if(daoCheckNombre.comprobarNombre(nombre)) {
				out.print("{ \"resultado\": \"Nombre disponible "+nombre+" \"}");
			}else {
				out.print("{ \"resultado\": \"Nombre no disponible "+nombre+" \"}");
			}
			out.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
