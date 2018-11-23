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
	private static final Logger LOG = Logger.getLogger(SumaController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("entro");

		try {
			// recibir parametros
			String p1 = request.getParameter("op1");
			String p2 = request.getParameter("op2");
			// validar
			
			// aplicar la logica de negocio - o llamo a capa Servicio

			int resultado = Integer.parseInt(p1) + Integer.parseInt(p2);

			// responde al usuario ( enviar atributos e ir vista )
			request.setAttribute("suma", resultado);
			
		} catch (NumberFormatException e) {
			request.setAttribute("msj", "Deben ser numeros y no contener letras");
		
		} catch (Exception e) {
			request.setAttribute("msj", "Lo sentimos pero se produjo un fallo");
			LOG.error(e);
		} finally {
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
		}

		LOG.trace("salgo");
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