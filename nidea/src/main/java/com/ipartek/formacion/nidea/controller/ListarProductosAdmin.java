package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.nidea.model.ProductosDao;
import com.ipartek.formacion.nidea.pojo.Producto;



/**
 * Servlet implementation class ListarControler
 */
@WebServlet("/listarProductosAdmin")
public class ListarProductosAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductosDao productosDao;
	private static ArrayList<Producto> productos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductosAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList test = new ArrayList<Producto>();
			System.out.println("***GET*** xdd" );
			
			//productos.insert(new Producto());
			
			//listado de videos
			productosDao = ProductosDao.getInstance();
			productos = (ArrayList<Producto>) productosDao.getAll();	
			if (productos != null) {
				request.setAttribute("productos", productos);
				//request.getRequestDispatcher("resultadoProductosAdmin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Error en doget ListarProductosAdmin");
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("resultadoProductosAdmin.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***POST***");
		doGet(request, response);
	}

}
