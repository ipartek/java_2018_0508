package com.ipartek.formacion.ahorcado.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcado")
public class AhorcadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW_AHORCADO = "ahorcado.jsp";
	private static final int INTENTOS_AHORCADO = 7;
	private RequestDispatcher dispatch = null;
	private char[] arrayLetras = new char[] { '_', '_', '_', '_', '_' };
	public static int cont = 0;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_AHORCADO).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dispatch = request.getRequestDispatcher(VIEW_AHORCADO);
			// recibir parametros
			String letra = request.getParameter("letra");
			// validar parametros si proceden
			if (letra != null && !letra.equals("".trim())) {
				if (letra.equalsIgnoreCase("c"))
					arrayLetras[0] = 'C';
				else if (letra.equalsIgnoreCase("e"))
					arrayLetras[1] = 'E';
				else if (letra.equalsIgnoreCase("s"))
					arrayLetras[2] = 'S';
				else if (letra.equalsIgnoreCase("a"))
					arrayLetras[3] = 'A';
				else if (letra.equalsIgnoreCase("r"))
					arrayLetras[4] = 'R';
				else {
					cont++;
					request.setAttribute("msg",
							"La letra introducida no está. Le quedan " + (INTENTOS_AHORCADO - cont) + " intentos.");
				}
				request.setAttribute("letras", arrayLetras);
			} else
				request.setAttribute("msg", "Debes introducir una letra.");

			if (cont >= 7) {
				request.setAttribute("msg", "No te quedan más intentos.");
				arrayLetras = new char[] { '_', '_', '_', '_', '_' };
				request.setAttribute("letras", arrayLetras);
				cont = 0;
			}
			
			for(int i = 0; i<arrayLetras.length;i++) {
				if(arrayLetras[i] == '_')
					break;
				else
					arrayLetras = new char[] { '_', '_', '_', '_', '_' };
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dispatch.forward(request, response);
		}
	}
}
