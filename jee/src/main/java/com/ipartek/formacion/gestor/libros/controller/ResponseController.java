package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ejemplo-response") // llama al controller cuando se pulse la URL listar.

public class ResponseController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// TODO implementar LOOGER
	// Logger log = Logger.getLogger(PrestamosController.class.getName());

	// Recibir datos
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		puentear(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		puentear(request, response);
	}

	/**
	 * @see
	 * @param request
	 * @param response
	 */
	private void puentear(HttpServletRequest request, HttpServletResponse response) {

		//Para responder directamente desde el controler al navegador
		PrintWriter out = null;
		try {
			// Generar respuesta type
			response.setContentType("text/html");
			// juego de caracteres
			response.setCharacterEncoding("UTF-8");

			out = response.getWriter();

			// TODO maquetar la estructura basica del html
			out.print("<p>Soy un response</p>");

			//Siempre al final
			out.flush();

			response.getWriter();
		} catch (Exception e) {// COGEMOS TODAs las excepciones
			
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

}
