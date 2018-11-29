package com.ipartek.formacion.personas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.personas.service.PersonaService;

/**
 * Servlet implementation class BusquedaController
 */
@WebServlet("/buscar")
public class BusquedaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PersonaService servicio;
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		servicio = PersonaService.getInstance();
	}

	@Override
	public void destroy() {

		super.destroy();
		servicio = null;
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			String txtBusqueda = request.getParameter("busqueda");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			
			Gson gson = new Gson();
	        
			String jsonResultado = gson.toJson( servicio.buscar( txtBusqueda ) );
				
			out.print( jsonResultado );
				
			out.flush();		
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
