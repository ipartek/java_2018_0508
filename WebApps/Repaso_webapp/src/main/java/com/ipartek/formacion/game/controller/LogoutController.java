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
@WebServlet("/logout")
public class LogoutController extends HttpServlet {

	private static Alert alert;

	private static final Logger LOG = Logger.getLogger(LogoutController.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			request.getSession().removeAttribute("logueado");

			alert = new Alert(Alert.WARNING, "Sesión cerrada.");
			request.getSession().setAttribute("alert", alert);

		} catch (Exception e) {

			LOG.error(e);

		} finally {

			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

}
