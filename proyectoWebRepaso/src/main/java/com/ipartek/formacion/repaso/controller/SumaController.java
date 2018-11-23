package com.ipartek.formacion.repaso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class SumaController
 */
@WebServlet("/flujo-clasico")
public class SumaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(SumaController.class);
	String view = "";
	String msg = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recibir parametros
		try {
			view = "resultado.jsp";
			String parametro1 = request.getParameter("op1");
			String parametro2 = request.getParameter("op2");

			// validar los datos

			// aplicar la logica de negocio o llamo a la capa Servicio

			int resultado = Integer.parseInt(parametro1) + Integer.parseInt(parametro2);

			// respondo al usuario (enviar atributos e ir vista)

			request.setAttribute("suma", resultado);
		} catch (NullPointerException e) {
			view = "index.jsp";
			msg = "Por favor no deje sin rellenar ninguno de los campos";
			LOG.error(e);
			request.setAttribute("msg", msg);
		} catch (NumberFormatException e) {
			view = "index.jsp";
			msg = "Por favor introduce numeros enteros en los dos campos";
			LOG.error(e);
			request.setAttribute("msg", msg);

		} catch (Exception e) {
			view = "index.jsp";
			msg = "Lo sentimos hemos tenido un error, vuelve a intentarlo";
			LOG.error(e);
			request.setAttribute("msg", msg);

		} finally {
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
