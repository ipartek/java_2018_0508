package com.ipartek.formacion.txakuretxea.controller;

import java.io.IOException;

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
	
	private String op = "";
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
		Perro perro = null;
		try {
			
			op = request.getParameter("op");
			
			if(op.equals("1")) {
				palabra = request.getParameter("palabra");
				if(palabra != null) {
					perro = buscarPalabra(palabra);
				}
				request.setAttribute("perro", perro);
			}

			view = VIEW_HOME;
			request.setAttribute("perros", daoPerro.getAll());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	private Perro buscarPalabra(String palabra) {
		Perro p = null;
		if(palabra.contains("-")) {
			p = daoPerro.getByChip(palabra);
		}else {
			p = daoPerro.getByNombre(palabra);
		}
		return p;
	}

}
