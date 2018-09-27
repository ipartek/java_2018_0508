package com.ipartek.formacion.libroElectronico.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libroElectronico.model.PaginaArrayListDAO;
import com.ipartek.formacion.libroElectronico.model.UsuarioArrayListDAO;
import com.ipartek.formacion.libroElectronico.model.pojo.Pagina;
import com.ipartek.formacion.libroElectronico.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario>usuarios;
	private Pagina pagActual;
	private static UsuarioArrayListDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioArrayListDAO.getInstance();
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
				usuarios=(ArrayList<Usuario>) dao.getAll();
		try {

			
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			
			for (Usuario usuario : usuarios) {
				if (usuario.getNombre().equals(nombre) && usuario.getPass().equals(pass)) {
					HttpSession sesion = request.getSession();
					sesion.setAttribute("usuario", usuario);
					sesion.setMaxInactiveInterval(60*60*60);
					break;
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		
			request.getRequestDispatcher("/home").forward(request, response);
			//response.sendRedirect("privado/listado");

		}
	}

}
