package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrestamosController
 */
@WebServlet("/juega")
public class AhorcadoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatch = null;
	private static final String VIEW = "ahorcado.jsp";

	private static final String PALABRA_SECRETA = "ceRsar";
	private static final int INTENTOS = 7;
	private static int aciertos = 0;
	private static int fallos = 0;
	private static String mensaje = "";
	private static String mostrar = "******";
	private static boolean terminado = false;
	private static String jdn = null; // jugar de nuevo

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			dispatch = request.getRequestDispatcher(VIEW);

			jdn = (String) request.getParameter("jdn");
			if (jdn != null) {

				aciertos = 0;
				fallos = 0;
				terminado = false;
				mostrar = "******";

			} else {

				comprobarSiAcierta(request);

			} // jugar de nuevo

		} catch (Exception e) {
			mensaje = "Introduce una letra por favor";

		} finally {

			request.setAttribute("intentos", INTENTOS);
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("aciertos", aciertos);
			request.setAttribute("fallos", fallos);
			request.setAttribute("mostrar", mostrar);
			request.setAttribute("terminado", terminado);
			dispatch.forward(request, response);
		}

	}

	/**
	 * Comprobar si la letra introducida es correcta
	 * @param request
	 */
	private void comprobarSiAcierta(HttpServletRequest request) {

		char letra = Character.toLowerCase(request.getParameter("letra").charAt(0));
		boolean acierto = false;
		
		for (int i = 0; i < PALABRA_SECRETA.length(); i++) {
			
			if (letra == Character.toLowerCase(PALABRA_SECRETA.charAt(i)) ) {
				aciertos++;
				acierto = true;
				mostrar = replaceCharAt(mostrar, i, letra); 
			}			
		}
		
		if ( !acierto ) { 
			fallos++;
		}	
		

		if (aciertos == PALABRA_SECRETA.length()) {
			mensaje = "¡Has Ganado!";
			terminado = true;
		} else if (fallos == INTENTOS) {
			mensaje = "¡Has perdido!";
			terminado = true;
		}

	}

	public static String replaceCharAt(String s, int pos, char c) {
		return s.substring(0, pos) + c + s.substring(pos + 1);
	}

}
