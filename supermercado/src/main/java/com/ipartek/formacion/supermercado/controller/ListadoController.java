package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;
import com.ipartek.formacion.supermercado.model.pojo.Producto;

/**
 * Servlet implementation class ListadoController
 */
@WebServlet("/privado/listado")
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoArrayListDAO dao;
	private ArrayList<Producto> productos;
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = ProductoArrayListDAO.getInstance();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			productos=(ArrayList<Producto>) dao.getAll();
			request.setAttribute("productos", productos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("/privado/listado.jsp").forward(request, response);
		}
		
	}

}
