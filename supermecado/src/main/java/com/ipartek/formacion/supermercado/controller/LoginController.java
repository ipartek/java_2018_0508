package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.pojo.Usuario;
import com.ipartek.formacion.supermercado.model.pojo.UsuarioArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(
		urlPatterns = { "/login" })

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioArrayListDAO usuariosDao;
	private ArrayList<Usuario> usuarios;
	boolean flag = false;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuariosDao = UsuarioArrayListDAO.getInstance();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		usuariosDao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Pasa por doGet");
		doProcess(request,response);
		//this.getServletConfig();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String emailUsuario = request.getParameter("emailUsuario");
			String passUsuario = request.getParameter("passUsuario");
			System.out.println(emailUsuario);
			System.out.println(passUsuario);
			if(comprobarUSuario(emailUsuario,passUsuario,session)) {
				System.out.println("Autentificacion correcta" + emailUsuario);
				session.setMaxInactiveInterval(60*60); // 1min
				//request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("/home?emailUsuario="+emailUsuario+"&passUsuario="+passUsuario).forward(request, response);
				//response.sendRedirect(request.getContextPath() + "/home" );
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("Error en doProcess *LoginController*");
			e.printStackTrace();
		}
		
	}

	private boolean comprobarUSuario(String emailUsuario, String passUsuario, HttpSession session) {
		usuarios = (ArrayList<Usuario>) usuariosDao.getAll();
		for (Usuario u : usuarios) {
			if (emailUsuario.contentEquals(u.getEmail()) && passUsuario.contentEquals(u.getPassword()) ) {
				flag = true;
				//guardo en session el usuario en el momento que validamos
				//De esta forma ya tendra acceso a /privado/*
				session.setAttribute("usuario", u);
			}
		}
		return flag;
		
	}

	

}
