package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.conection.ConnectionManager;

/**
 * Servlet implementation class sumaControler
 */
@WebServlet("/flujo-clasico")
public class SumaControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int p1;
	private int p2;
	private int suma;
	private static String view = "";

	private final static Logger LOG = Logger.getLogger(SumaControler.class);

	private void getParameters(HttpServletRequest request, HttpServletResponse response) {
		p1 = Integer.parseInt(request.getParameter("p1"));
		p2 = Integer.parseInt(request.getParameter("p2"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("Entro al controller");
		try {
			// Recibir parametros
			getParameters(request, response);

			// Aplicar la logica de negocio
			suma = p1 + p2;

			// Enviar atributos
			request.setAttribute("suma", suma);
			view = "resultado.jsp";
			
			LOG.debug("Salgo del controller");
				
		} catch (NumberFormatException e) {
			LOG.error("NUMBERFORMAT.....Se esperaba 2 números.");
			request.setAttribute("alerta", "Valores no validos, inserte 2 números");
			view = "index.jsp";
		} catch (Exception e) {
			request.setAttribute("alerta", "INESPERADO...Valores no validos, inserte 2 números");
			LOG.error(e);
		}

		// Ir a la siguiente vista
		request.getRequestDispatcher(view).forward(request, response);
	}

}
