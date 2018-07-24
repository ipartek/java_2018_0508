package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar")
public class ListadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG = Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Pasamos por doGet()");
		
		//1. Recibir parámetros
		//2. Validar parámetros
		//3. Llamar al modelo
		//4. Enviar atributos a la Vista
		//5. Ir a la vista
		request.getRequestDispatcher("listados.jsp").forward(request, response);
	}

}
