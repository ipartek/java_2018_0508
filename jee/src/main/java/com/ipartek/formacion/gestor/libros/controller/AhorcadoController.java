package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcado")

public class AhorcadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String palabra = "ceRsar";

	private static char[] huecos = { '_', '_', '_', '_', '_', '_' };

	private static int FALLOS = 0;
	private static final int MAX_FALLOS = 7;
	private static boolean recarga = false;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1.- Recibir Parametros

			// 2.- Validar Parametros
			
			for (int i = 0; i < huecos.length; i++) {
				huecos[i] = '_';
			}

			recarga = false;
			
			// 3.- LLamar modelo DAO

			// 4.- Enviar atributos a la vista

			request.setAttribute("huecos", huecos);
			request.setAttribute("recarga", recarga);

			// 5.- Ir a la vista

			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		char c = ' ';
		boolean chivato = false;

		try {
			// 1.- Recibir Parametros

			if (request.getParameter("letra").length() > 0) {
				c = (char) request.getParameter("letra").toLowerCase().charAt(0);
			}

			// 2.- Validar Parametros

			for (int i = 0; i < palabra.length(); i++) {
				if (c == palabra.toLowerCase().charAt(i)) {
					huecos[i] = c;
					chivato = true;
				}
			}

			boolean terminado = false;

			if (!chivato) {
				FALLOS++;
			} else {
				terminado = solucion();
			}

			// 3.- LLamar modelo DAO

			// 4.- Enviar atributos a la vista

			if (terminado) {
				request.setAttribute("msg", "Zorionak !!! Has ganado");
				recarga = true;
			} else if (FALLOS == MAX_FALLOS) {
				request.setAttribute("msg", "Vaya... no has ganado, otra partidita, la palabra era" + palabra);
				recarga = true;
			}

			
			request.setAttribute("recarga", recarga);
			request.setAttribute("huecos", huecos);
			request.setAttribute("fallos", FALLOS);

			// 5.- Ir a la vista

			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private boolean solucion() {

		boolean resul = true;

		for (int i = 0; i < huecos.length; i++) {
			if (huecos[i] == '_') {
				resul = false;
			}
		}

		return resul;

	}
}
