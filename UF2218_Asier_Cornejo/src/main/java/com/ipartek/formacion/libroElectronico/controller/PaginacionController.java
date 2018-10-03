package com.ipartek.formacion.libroElectronico.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libroElectronico.model.PaginaArrayListDAO;
import com.ipartek.formacion.libroElectronico.model.pojo.Pagina;

/**
 * Servlet implementation class PaginacionController
 */
@WebServlet("/paginacion")
public class PaginacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Pagina pagActual;
	private Pagina pagAnterior;
	private Pagina pagSiguiente;
	private int numPag;
	private static PaginaArrayListDAO dao;
	private ArrayList<Pagina> paginas;
	public static final String OP_SIGUIENTE = "1";
	public static final String OP_ANTERIOR = "2";

	@Override
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
		paginas=(ArrayList<Pagina>) dao.getAll();
		int numPags= dao.getAll().size();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			pagActual = dao.getById(id);
			String op = request.getParameter("op");

			if (op!=null && OP_SIGUIENTE.equals(op) ) {
				pagSiguiente = dao.getById(id + 1);
				if (pagSiguiente.getId()<=paginas.size()) {
					pagActual = pagSiguiente;
				}

			} else {
				pagAnterior = dao.getById(id - 1);
				if (pagAnterior.getId()>=0) {
					pagActual = pagAnterior;
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			request.setAttribute("numeroPaginas", numPags);
			request.setAttribute("pagActual", pagActual);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

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
