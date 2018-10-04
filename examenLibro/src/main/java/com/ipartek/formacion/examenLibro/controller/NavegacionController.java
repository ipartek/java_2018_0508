package com.ipartek.formacion.examenLibro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examenLibro.model.LibroArrayListDAO;
import com.ipartek.formacion.examenLibro.model.Pagina;

@WebServlet("/navegacion")
public class NavegacionController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static LibroArrayListDAO dao;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = LibroArrayListDAO.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("operacion");
		String alert = "";
		
		if(operacion != null && operacion.equals("siguiente")) {
			if (request.getSession().getAttribute("numPagina") != null) {
				int numPagina = (int) request.getSession().getAttribute("numPagina");
				numPagina++;

				List<Pagina> libro = dao.getAll();

				if (numPagina < libro.size()) {
					request.getSession().setAttribute("numPagina", numPagina);
				}
			} else {
				request.getSession().setAttribute("numPagina", 0);
				
			
			}
			
		}else if(operacion != null && operacion.equals("anterior")) {
			if (request.getSession().getAttribute("numPagina") != null) {
				int numPagina = (int) request.getSession().getAttribute("numPagina");
				numPagina--;
				
				if (numPagina >= 0) {
					request.getSession().setAttribute("numPagina", numPagina);
				}
			} else {
				request.getSession().setAttribute("numPagina", 0);
			}
		
		}else {
			
			try {
				String selecPagina = request.getParameter("selecPagina");

				int i = new Integer(selecPagina);
				
				i--;

				List<Pagina> libro = dao.getAll();

				if (i >= 0 && i < libro.size()) {
					request.getSession().setAttribute("numPagina", i);
				}else {
					
					alert = "La pagina a la que intentas acceder no existe.";
					request.setAttribute("alert", alert);
				}
				
				
			} catch (IndexOutOfBoundsException  e) {
				alert = "La pagina a la que intentas acceder no existe.";
				request.setAttribute("alert", alert);
			}
			
		}
		
		response.sendRedirect(request.getContextPath() + "/home");
	}

}
