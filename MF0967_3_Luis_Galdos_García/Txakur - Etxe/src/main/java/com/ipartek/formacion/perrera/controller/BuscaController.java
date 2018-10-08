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
import com.ipartek.formacion.perrera.pojo.Alert;
import com.ipartek.formacion.perrera.pojo.Chip;
import com.ipartek.formacion.perrera.pojo.Perro;

/**
 * Servlet implementation class AltaController
 */
@WebServlet("/buscar")
public class BuscaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PerroDAO daoPerros;
	
	// Datos del perro
	String busqueda;  
	
	ArrayList<Perro> perrosEncontrados;
	
	Alert alert;
	
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

	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			busqueda = request.getParameter("txtBuscar");
			perrosEncontrados = daoPerros.busqueda(busqueda);	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			request.setAttribute("perrosEncontrados", perrosEncontrados);
			request.setAttribute("busqueda", busqueda);
			request.setAttribute("numResultados", perrosEncontrados.size());
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
		}
		
	}

}
