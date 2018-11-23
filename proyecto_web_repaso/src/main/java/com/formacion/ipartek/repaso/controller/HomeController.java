package com.formacion.ipartek.repaso.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.formacion.ipartek.repaso.pojo.Alert;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/flujo-clasico")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int op1;
	private int op2;
	private int suma;

	private static String view = "";
	private Alert alert = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(HomeController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.trace("Entra en el get de HomeController");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.trace("Entra en el post de HomeController");
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		view = "";
		try {
			// Recibir parametros
			getParameters(request, response);
			// Validar
			// Aplicar la logica de negocio
			suma = op1 + op2;
			// Enviar atributos
			alert = new Alert(Alert.ALERT_SUCCESS, "Suma realizada correctamente.");
			request.setAttribute("alert", alert);
			request.setAttribute("suma", suma);
			view = "resultado.jsp";
		} catch (NumberFormatException e) {
			LOG.error(e);
			alert = new Alert(Alert.ALERT_WARNING, "Debes introducir números obligatoriamente.");
			request.setAttribute("alert", alert);
			view = "index.jsp";
		} catch (Exception e) {
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
			request.setAttribute("alert", alert);
			view = "index.jsp";
			LOG.error(e);
		} finally {
			// Pasar a la siguiente vista
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	private void getParameters(HttpServletRequest request, HttpServletResponse response) {
		op1 = Integer.parseInt(request.getParameter("op1"));
		op2 = Integer.parseInt(request.getParameter("op2"));
	}

}
