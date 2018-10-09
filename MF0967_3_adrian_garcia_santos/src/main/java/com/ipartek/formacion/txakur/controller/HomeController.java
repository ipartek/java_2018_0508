package com.ipartek.formacion.txakur.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.txakur.model.PerroArrayDAO;
import com.ipartek.formacion.txakur.pojo.Perro;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PerroArrayDAO daoPerro;
	private ArrayList<Perro> perros;
	
	@Override
	public void init() throws ServletException {
		super.init();
		daoPerro = PerroArrayDAO.getInstance();

		
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoPerro = null;
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
			
			perros = (ArrayList<Perro>) daoPerro.getAll();
			request.setAttribute("perros", perros);
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		
		
	}

}
