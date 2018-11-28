package com.ipartek.formacion.perrera.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.perrera.model.PerroDAO;
import com.ipartek.formacion.perrera.pojo.Perro;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static PerroDAO daoPerros;
	private static ArrayList<Perro> perros;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		
		daoPerros = PerroDAO.getInstance();
		daoPerros.cargarPerros();
	}

	@Override
	public void destroy() {
		super.destroy();
		// Se ejecuta al parar el servidor
		daoPerros = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			perros = (ArrayList<Perro>) daoPerros.getAll();
			request.setAttribute("perros", daoPerros.getAll());
			
		} catch (Exception e) {	// Capturar cualquier excepción
			
			e.printStackTrace();
			
		} finally {
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}
}
