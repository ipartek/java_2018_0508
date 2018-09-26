package com.ipartek.formacion.libreriaelectronica.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libreriaelectronica.model.Pagina;
import com.ipartek.formacion.libreriaelectronica.model.PaginaArrayDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PaginaArrayDAO dao;
	private static ArrayList<Pagina> paginas;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			dao = PaginaArrayDAO.getInstance();
			paginas = (ArrayList<Pagina>) dao.getAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//En el home que se muestre solo la portada
			request.setAttribute("pagina", paginas.get(0));
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
