package com.ipartek.formacion.examenLibro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.examenLibro.model.LibroArrayListDAO;
import com.ipartek.formacion.examenLibro.model.Pagina;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LibroArrayListDAO dao;
	public ArrayList<Pagina> libro;
	private Pagina p = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = LibroArrayListDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			HttpSession sesion = request.getSession();
			
			if(sesion.getAttribute("numPagina") == null) {
				sesion.setAttribute("numPagina", 0);
				p = dao.getByIndice(0);
			}else {
				int i = (int) sesion.getAttribute("numPagina");
				p = dao.getByIndice(i);
			}
			
			request.setAttribute("pagina", p);
			request.setAttribute("numPagTotal", dao.getAll().size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
