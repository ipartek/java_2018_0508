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
		urlPatterns = { "/logout" })

public class LogOut extends HttpServlet {
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
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			session = null;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			response.sendRedirect(request.getContextPath() + "/home");
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	

	

}
