package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/altaUsuario")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao = UsuarioDAO.getInstance();

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

		// TODO cristo redentor
		try {
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			String pass2 = request.getParameter("pass2");
			/*
			 * if (nombre != null && pass != null && pass2 != null) {
			 * if(DAO.mirarNombre(nombre)) { if (pass.equals(pass2)) { insert }else {
			 * 
			 * } }else {
			 * 
			 * } }
			 */
			Usuario u = new Usuario(nombre, pass);
			dao.insert(u);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
