package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bienvenida")
public class BienvenidoControllerPOST extends HttpServlet{

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG=Logger.getLogger(PrestamosController.class);
	
	@Override
	//Request seria la peticion y response la respuesta
	//doGet===Recibe datos
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO IMPLEMENTAR LOGGER
		System.out.println("pasamos por doPost");
		
		//1.- RECIBIR PARAMETROS
		try {
		String parametroNom=request.getParameter("nombre");
					if(parametroNom!=null && "".equals(parametroNom.trim())) {
						request.setAttribute("nombre", parametroNom);
						request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", "Por favor rellena el nombre y no seas vagete");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//TODO ESTO NO ESTA ACABADO
		}
		//2.-VALIDAR PARAMENTROS
		
		//3.- LLAMAR MODELO DAO
		
		//4.- ENVIAR ATRIBUTOS VISTA
		
		//5.-IR A LA VISTA
		request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
		
	}
}
