package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.Pagina;
import com.ipartek.formacion.model.PaginaArrayListDAO;
import com.ipartek.formacion.model.Usuario;

/**
 * Servlet implementation class PaginaController
 */
@WebServlet("/escribir")
public class PaginaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static PaginaArrayListDAO dao;
   	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			HttpSession session = request.getSession();
			Usuario u = (Usuario) session.getAttribute("usuario");
			
			int nPagina = Integer.parseInt(request.getParameter("nPagina"));
			String texto = (String) request.getParameter("texto");
			String autor = u.getNombre();
			Pagina p = new Pagina(autor, texto);
			
			dao = PaginaArrayListDAO.getInstance();
			dao.insert(p);
			
			nPagina++;
			request.setAttribute("nPagina", nPagina);
			request.getRequestDispatcher("home").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
