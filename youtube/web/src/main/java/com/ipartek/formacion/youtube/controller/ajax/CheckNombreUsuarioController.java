package com.ipartek.formacion.youtube.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.UserDefinedFileAttributeView;

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
	
	private UsuarioDAO daoUsuario;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		daoUsuario=UsuarioDAO.getInstance();
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		daoUsuario=null;
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
		Usuario usuario=null;
		try {
			
			// Respondemos con formato JSON Y UTF-8
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			//Recogemos el parametro
			String nombre=request.getParameter("nombre").trim();
			
			//consultar al dao
			usuario= daoUsuario.getByNombre(nombre);
			
			if (usuario!=null) {
				PrintWriter out = response.getWriter();
				out.print("{\"resultado\": \"Nombre No Disponible "+nombre+"\"}");
				out.flush();
			} else {
				PrintWriter out = response.getWriter();
				out.print("{\"resultado\": \"Nombre Disponible "+nombre+"\"}");
				out.flush();
			}

			//Respuesta salida
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
