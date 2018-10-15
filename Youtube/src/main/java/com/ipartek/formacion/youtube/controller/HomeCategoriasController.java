package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.CategoriaDAO;
import com.ipartek.formacion.youtube.pojo.Alert;

/**
 * Servlet implementation class HomeCategoriasController
 */
@WebServlet("/categorias")
public class HomeCategoriasController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_CATEGORIAS = "home-categorias.jsp";
    
	private static CategoriaDAO daoCategoria;
	
	private static Alert alert;
	private static String view;
	private static String id;
   
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		daoCategoria = CategoriaDAO.getInstance();

	}

	@Override
	public void destroy() {
		super.destroy();
		
		daoCategoria = null;
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		super.service(request, response); // LLAMADA a los metodos GET o POST
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			request.setAttribute("categorias", daoCategoria.getAll());
			view = VIEW_CATEGORIAS;
			request.getRequestDispatcher(view).forward(request, response);
			
		} catch (Exception e) {
			
			alert = new Alert();
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
