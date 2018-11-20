package com.andrea.perez.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrea.perez.model.UsuarioDAO;

/**
 * Servlet implementation class checkNombreUsuarioController
 */
@WebServlet("/checknombre")
public class checkNombreUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO daoUsuario;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
		try {			

			// Respondemos con formato JSON y codigo UTF-8
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			String nombre = request.getParameter("nombre");

			// TODO consultar DAO
			if(daoUsuario.getByNombreRepetido(nombre)) {
				out.print("{ \"resultado\": \"nombre " + nombre +" NO disponible"+ "\"}");
				
			}else {
				out.print("{ \"resultado\": \"nombre " + nombre + " disponible"+"\"}");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			out.flush();
		}

	}

}
