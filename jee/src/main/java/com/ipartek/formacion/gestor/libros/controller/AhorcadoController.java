package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcado")
public class AhorcadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG=Logger.getLogger(PrestamosController.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO IMPLEMENTAR LOGGER
		System.out.println("pasamos por doPost");

		// 1.- RECIBIR PARAMETROS
		String vacio="_ _ _ _ _ ";
		request.setAttribute("palabra-clave",vacio);
		try {
			String parametroLetra = request.getParameter("letra");
			if (parametroLetra != null && !"".equals(parametroLetra.trim()) && parametroLetra.length()==1) {
				request.setAttribute("letra", parametroLetra);
				if(parametroLetra=="c" || parametroLetra=="C") {
					request.setAttribute("1letra", parametroLetra.toUpperCase());
				}
				
				//request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Por favor rellene el siguiente campo con 1 letra");
				request.getRequestDispatcher("jugar.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO ESTO NO ESTA ACABADO
		}
		// 2.-VALIDAR PARAMENTROS

		// 3.- LLAMAR MODELO DAO

		// 4.- ENVIAR ATRIBUTOS VISTA

		// 5.-IR A LA VISTA
		//request.getRequestDispatcher("jugar.jsp").forward(request, response);

	}
}
