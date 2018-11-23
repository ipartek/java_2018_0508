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
	private final static Logger LOG = Logger.getLogger(SumaController.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = "";
		try {
			//recibir parametros			
			int p1 = Integer.parseInt(request.getParameter("op1"));
			int p2 = Integer.parseInt(request.getParameter("op2"));
			
			//validar
			
			//aplicarla logica de negocio o llamo a la capa Servicio
			int resultado = p1 + p2;
			
			//respondo al usuario (enviar atributos e ir a la vista)
			request.setAttribute("suma", resultado);
		}catch(Exception e) {
			mensaje = "Introduce correctamente los numeros por favor";
			request.setAttribute("mensaje", mensaje);
			e.printStackTrace();
			LOG.error(e);
		}finally {
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
