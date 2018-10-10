package com.ipartek.formacion.txakuretxea.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.txakuretxea.model.PerroDAO;
import com.ipartek.formacion.txakuretxea.pojo.Alert;
import com.ipartek.formacion.txakuretxea.pojo.Perro;


/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PerroDAO daoPerro = null;
	
	private static final String VIEW_HOME = "home.jsp";
	
	private Alert alert = null;
	private String view = "";
	
	private String palabra = "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoPerro = PerroDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoPerro = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		alert = null;
		try {
			view = VIEW_HOME;
			request.setAttribute("perros", daoPerro.getAll());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		alert = null;
		List<Perro> perrosEncontrados = new ArrayList<Perro>();
		
		try {
			palabra = request.getParameter("palabra");
			if(palabra != null) {
				perrosEncontrados = buscarPalabra(palabra);
			}
			request.setAttribute("palabra", palabra);
			request.setAttribute("perrosEncontrados", perrosEncontrados);

			view = VIEW_HOME;
			request.setAttribute("perros", daoPerro.getAll());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	private List<Perro> buscarPalabra(String palabra) {
		List<Perro> perrosEncontrados = daoPerro.busqueda(palabra);
		return perrosEncontrados;
	}

}
