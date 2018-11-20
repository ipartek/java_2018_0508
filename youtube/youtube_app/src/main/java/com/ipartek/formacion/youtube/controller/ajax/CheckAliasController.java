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
 * Servlet implementation class FormularioRegistroController
 */
@WebServlet("/checkAlias")
public class CheckAliasController extends HttpServlet {
	
	UsuarioDAO daoUsuario;
	
	private static final long serialVersionUID = 1L;
	
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
		
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			String nickname = request.getParameter("alias");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			Usuario user = daoUsuario.getByName(nickname);
			
			PrintWriter out = response.getWriter();
			if (user != null) {
				
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				out.print("{}");
			
			} else {
				
				response.setStatus(HttpServletResponse.SC_OK);
				out.print("{}");
			}
			
			out.flush();
			
			//escribirJSON(response, nombre);
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
