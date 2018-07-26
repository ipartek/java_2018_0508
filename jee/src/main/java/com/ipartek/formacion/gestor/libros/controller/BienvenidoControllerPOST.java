package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bienvenida")
public class BienvenidoControllerPOST extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO IMPLEMENTAR LOGGER
		System.out.println("pasamos por doPost");


		try {
			String parametroNom = request.getParameter("nombre");
			if (parametroNom != null && !"".equals(parametroNom.trim())) {
				request.setAttribute("nombre", parametroNom);
				request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Por favor rellena el nombre y no seas vagete");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO ESTO NO ESTA ACABADO
		}
		request.getRequestDispatcher("bienvenida.jsp").forward(request, response);

	}
}
