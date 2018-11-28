package com.ipartek.formacion.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.game.pojo.Alert;

/**
 * Servlet implementation class SumaController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static Alert alert;

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	private static final long serialVersionUID = 1L;

	private String psw;
	private String usuario;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			boolean logueado = false;

			usuario = request.getParameter("usuario");
			psw = request.getParameter("password");

			if ("admin".equals(usuario) && "admin".equals(psw)) {
				logueado = true;
			}

			request.getSession().setAttribute("logueado", logueado);

			alert = new Alert(Alert.WARNING, "Credenciales incorrectos.");
			request.getSession().setAttribute("alert", alert);

		} catch (Exception e) {

			LOG.error(e);

		} finally {

			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
