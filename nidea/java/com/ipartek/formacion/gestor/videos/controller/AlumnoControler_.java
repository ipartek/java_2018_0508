package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.videos.model.AlumnoDao;
import com.ipartek.formacion.gestor.videos.pojo.Alumno;


@WebServlet("/alumnoControler_")
public class AlumnoControler_ extends HttpServlet {
	
	static private AlumnoDao Alumnodao;
	long id = 0;

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		/*
		 * System.out.println("Pasamos por doPost()");
		 * 
		 * // 1. Recibir parámetros String usuarioLetra = (String)
		 * request.getParameter("letraAhorcado");
		 * 
		 * // 2. Validar parámetros if (usuarioLetra == null) {
		 * 
		 * request.setAttribute("msg", "Por favor rellena el nombre y no seas vago.");
		 * request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		 * 
		 * } else if (!usuarioLetra.trim().isEmpty()) { request.setAttribute("letra",
		 * usuarioLetra); }
		 * 
		 * // 4. Enviar atributos a la Vista
		 * request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		 */

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doPost( request, response);
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = (String) request.getParameter("nombre");
		String email = (String) request.getParameter("email");
		Alumno alum = new Alumno();
		
		
		try {
			System.out.println(nombre);
			System.out.println(email);
			Alumnodao.insert(new Alumno(calculeId(),nombre,email));
			/*request.setAttribute("libroNuevo", libroNuevo2);
			request.setAttribute("dao", dao);*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("form.jsp").forward(request, response);
		}
		
		
	}

	private long calculeId() {

		return id++;
	}
}
