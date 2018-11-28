package com.ipartek.formacion.game.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.game.pojo.Alert;

/**
 * Servlet implementation class SumaController
 */
@WebServlet("/suma")
public class SumaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(SumaController.class);
	
	private static Alert alert;

	private String operando1;
	private String operando2;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			if (!operando1.isEmpty() && !operando2.isEmpty()) {
				
				operando1 = request.getParameter("op1");
				operando2 = request.getParameter("op2");

				float suma = Float.parseFloat(operando1) + Float.parseFloat(operando2);
				
				request.getSession().setAttribute("suma", suma);
			
			} else {
				
				alert = new Alert(Alert.WARNING, "Los operandos no deben estar vaciós.");
				request.getSession().setAttribute("alert", alert);
			}


		} catch (Exception e) {

			LOG.error(e);

		} finally {

			response.sendRedirect("suma.jsp");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
