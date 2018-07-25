package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConversorController
 */
@WebServlet("/conversor")
public class ConversorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_CONVERSOR = "conversor.jsp";
	private static RequestDispatcher dispatch = null;
	private static final float METRO_PIE_VALUE = 3.28084f;
	

	public ConversorController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opc="";
		float value=0;
		try {
			opc = request.getParameter("formulario");
			if (opc != null && !opc.isEmpty()) {
				
				value = Float.parseFloat(request.getParameter("value"));
				
				if ("1".equals(opc)) {
					request.setAttribute("pies", value * METRO_PIE_VALUE);
					request.setAttribute("value1",value);
				} else {
					request.setAttribute("metros", value / METRO_PIE_VALUE);
					request.setAttribute("value2",value);

				}
				
				dispatch = request.getRequestDispatcher(VIEW_CONVERSOR);

			} else {
				request.setAttribute("pies",0);
				request.setAttribute("metros",0);
			}

		} catch (NumberFormatException e) {
			request.setAttribute("error", e.getMessage());
			if(!opc.isEmpty()) {
				request.setAttribute("msg"+opc, "Error, el valor '"+request.getParameter("value")+"' no es correcto, tienes que introducir un numero.");
			}

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());

		} finally {
			dispatch = request.getRequestDispatcher(VIEW_CONVERSOR);
			dispatch.forward(request, response);
		}

	}
	

}
