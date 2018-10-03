package com.ipartek.formacion.libroElectronicoColaborativo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libroElectronicoColaborativo.pojo.Pagina;
import com.ipartek.formacion.libroElectronicoColaborativo.model.PaginaArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static PaginaArrayListDAO dao;
	private static int PAGINA_ACTUAL = 0;
	private static int PAGINA_TOTAL = 0;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		dao = PaginaArrayListDAO.getInstance();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PAGINA_TOTAL = dao.total();
		Pagina p = new Pagina();
		String alert = "";

		try {
			
			int numeroPagina = (request.getParameter("numeroPagina") != null ? Integer.parseInt(request.getParameter("numeroPagina")): PAGINA_ACTUAL);
			p = dao.paginaXPos(numeroPagina);
			request.setAttribute("pagina", p);			
			if (numeroPagina>=0) {
				if (numeroPagina==(PAGINA_ACTUAL-1)) {
					PAGINA_ACTUAL--;
				}else if (numeroPagina==(PAGINA_ACTUAL+1)) {
					PAGINA_ACTUAL++;
				}else {
					PAGINA_ACTUAL = numeroPagina;
				}
			}else {
				alert = "La pagina a la que intentas acceder no existe.";
				request.setAttribute("alert", alert);
			}
			
		} catch (IndexOutOfBoundsException e) {
			alert = "La pagina a la que intentas acceder no existe.";
			request.setAttribute("alert", alert);
			p = dao.paginaXPos(PAGINA_ACTUAL);
			request.setAttribute("pagina", p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("pActual", PAGINA_ACTUAL);
		request.setAttribute("pTotal", PAGINA_TOTAL);
		
		request.setAttribute("paginas", dao.getAll());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}