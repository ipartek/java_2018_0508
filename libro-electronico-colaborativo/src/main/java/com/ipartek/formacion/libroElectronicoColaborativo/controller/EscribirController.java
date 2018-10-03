package com.ipartek.formacion.libroElectronicoColaborativo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libroElectronicoColaborativo.model.PaginaArrayListDAO;
import com.ipartek.formacion.libroElectronicoColaborativo.pojo.Pagina;
import com.ipartek.formacion.libroElectronicoColaborativo.pojo.Usuario;

/**
 * Servlet implementation class EscribirController
 */
@WebServlet("/escribir")
public class EscribirController extends HttpServlet {
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
			
			int numeroPagina = Integer.parseInt(request.getParameter("nPagina"));
			String texto = (String) request.getParameter("texto");
			String autor = u.getNombre();
			Pagina p = new Pagina(autor, texto);
			
			dao = PaginaArrayListDAO.getInstance();
			dao.insert(p);
			
			numeroPagina++;
			request.setAttribute("numeroPagina", numeroPagina);
			request.getRequestDispatcher("home").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
