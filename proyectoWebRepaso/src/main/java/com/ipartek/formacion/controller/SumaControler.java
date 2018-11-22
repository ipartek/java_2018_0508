package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Alert;
import com.ipartek.formacion.repaso.conection.ConnectionManager;

/**
 * Servlet implementation class sumaControler
 */
@WebServlet("/flujo-clasico")
public class SumaControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_HOME="index.jsp";
	private static final String VIEW_RESULTADO="resultado.jsp";
	

	private final static Logger LOG = Logger.getLogger(ConnectionManager.class);

	public SumaControler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view=VIEW_HOME;
		Alert alert = new Alert();
		
		// recibir parametros
		String s1 = request.getParameter("p1");
		String s2 = request.getParameter("p2");
		int n1=0;
		int n2=0;
		
		// validar
		if (s1 == null || s2 == null) {
			LOG.debug("falta algun parametro por enviar.");
			alert = new Alert(Alert.ALERT_WARNING,
					"Asegutare que envias 2 parametros en la URL");
			//enviamos alert
			request.setAttribute("alert", alert);
			
		}else {
			
			//Compruebo que son numerico
			try {
				n1=Integer.parseInt(s1);
				

			} catch (NumberFormatException excepcion) {
				alert = new Alert(Alert.ALERT_WARNING,
						s1 + "No es un numero");
				request.setAttribute("alert", alert);
			}
			try {
				n2=Integer.parseInt(s2);

			} catch (NumberFormatException excepcion) {
				alert = new Alert(Alert.ALERT_WARNING,
						s2+ "No es un numero");
				request.setAttribute("alert", alert);
			}
			// Aplicar la logica o llamo a la capa service
			int resultado=n1+n2;
			
		}

		// enviar atributos e ir a la vista
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public static boolean isNumeric(String cadena1, String cadena2) {

		boolean resultado;

		try {
			Integer.parseInt(cadena1);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}
}
