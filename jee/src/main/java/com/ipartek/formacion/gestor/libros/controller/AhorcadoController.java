package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

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

	private static final String PALABRA_SECRETA = "cesRar";
	int contVidas = 7;
	int contAciertos = 0;

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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		String mostrar = "*****";
		String letra = "";
		String respuesta = "";
		String resultado = "";
		boolean fallo = false;

		try {
		

			respuesta = request.getParameter("letra");
			respuesta = respuesta.trim();

			for (int i = 0; i < PALABRA_SECRETA.length(); i++) {
				char letraExtraida = PALABRA_SECRETA.charAt(i);
				letra = Character.toString(letraExtraida);

				if (letra.equals(respuesta)) {
					contAciertos++;
					fallo = false;
					resultado = "¡Esa letra es correcta!";
					request.setAttribute("resultado", resultado);
					request.setAttribute("respuesta", respuesta);
					request.setAttribute("mostrar", mostrar);
					break;

				} else {
					fallo = true;
					resultado = "¡Esa letra es incorrecta!";
					request.setAttribute("resultado", resultado);
					request.setAttribute("respuesta", respuesta);
					request.setAttribute("mostrar", mostrar);
				}

			}

			if (contAciertos == PALABRA_SECRETA.length()) {
				resultado = "¡Has ganado!";
				request.setAttribute("resultado", resultado);
			}

			if (fallo == true) {
				contVidas--;
				request.setAttribute("contVidas", contVidas);
				if (contVidas == 0) {
					resultado = "¡Has perdido!";
					request.setAttribute("resultado", resultado);
					contVidas = 8;
				}
			}


		} finally {
			fallo = false;
			letra = "";
			request.setAttribute("resultado", resultado);
			request.setAttribute("respuesta", respuesta);
			request.setAttribute("mostrar", mostrar);
			request.setAttribute("contVidas", contVidas);
			try {
				request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException o) {
				o.printStackTrace();
			}
		}
	}
	
	void mostrarPalabra(){
		
	}
	
	void comprobarLetra() {
		
	}

}
