package com.ipartek.formacion.libroElectronico.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libroElectronico.model.PaginaArrayListDAO;
import com.ipartek.formacion.libroElectronico.model.pojo.Pagina;
import com.ipartek.formacion.libroElectronico.model.pojo.Usuario;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")

public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PaginaArrayListDAO dao;
	private ArrayList<Pagina> paginas;
	private Pagina pagActual;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = PaginaArrayListDAO.getInstance();

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor
		dao = null;
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			pagActual = dao.getById(1);

			HttpSession sesion = request.getSession();
			Usuario usuario = (Usuario) sesion.getAttribute("usuario");

			int numeroPaginas = dao.getAll().size();

			request.setAttribute("numeroPaginas", numeroPaginas);
			paginas = (ArrayList<Pagina>) dao.getAll();
			request.setAttribute("paginas", paginas);
			request.setAttribute("pagActual", pagActual);
		} catch (Exception e) {

		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}

}
