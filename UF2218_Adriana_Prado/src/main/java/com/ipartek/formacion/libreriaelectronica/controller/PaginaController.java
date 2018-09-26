package com.ipartek.formacion.libreriaelectronica.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libreriaelectronica.model.Pagina;
import com.ipartek.formacion.libreriaelectronica.model.PaginaArrayDAO;

/**
 * Servlet implementation class PaginaController
 */
@WebServlet("/pagina")
public class PaginaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PaginaArrayDAO dao;
	private static ArrayList<Pagina> paginas;
	
	private static int numPagina = 0;
	private static int buscarPagina = 0;
	private static boolean esUltimo;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = PaginaArrayDAO.getInstance();
		paginas = (ArrayList<Pagina>) dao.getAll();
		Pagina p = new Pagina();
		String msg = "";
		try {
			buscarPagina = Integer.parseInt(request.getParameter("buscarPagina"));
			if(buscarPagina != 0) {
				p = dao.getById(buscarPagina);
				if(p != null) {
					request.setAttribute("pagina", p);
					request.setAttribute("totalPaginas", dao.length());
				}else {
					msg = "No se ha encontrado la pagina solicitada.";
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(p != null) {
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath() + "/home?msg="+msg);
			}
		}
		
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		esUltimo = false;
		dao = PaginaArrayDAO.getInstance();
		paginas = (ArrayList<Pagina>) dao.getAll();
		
		try {
			numPagina = Integer.parseInt(request.getParameter("id"));		
	
			Pagina p = dao.getById(numPagina);
			
			if(p != null) {
				request.setAttribute("pagina", p);
				if(p.getId() == dao.length()-1) {
					esUltimo = true;
				}
				request.setAttribute("esUltimo", esUltimo);
				request.setAttribute("totalPaginas", dao.length());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(numPagina <= 0) {
				response.sendRedirect(request.getContextPath() + "/home");
			}else {
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		}
	}
}
