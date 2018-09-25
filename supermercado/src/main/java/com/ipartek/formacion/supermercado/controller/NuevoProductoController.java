package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.Alert;
import com.ipartek.formacion.supermercado.model.Producto;
import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;

/**
 * Servlet implementation class NuevoProductoController
 */
@WebServlet(description = "Servlet que se encarga de gestionar el alta y la baja de los productos.", urlPatterns = {
		"/alta-producto" })
public class NuevoProductoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ProductoArrayListDAO dao;
	
	Producto p;

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		dao = ProductoArrayListDAO.getInstance();
	}

	public void destroy() {
		
		dao = null;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doProccess(request, response);
	}
	
	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alert alert = new Alert();
		
		try {
			
			crearProducto(request);

			if (p != null) {
				dao.getAll().add(p);
			}
			
			alert = new Alert ("Producto creado con éxito.", Alert.SUCCESS);
			
			
		} catch (Exception e){
			
			e.printStackTrace();
			
		} finally {
			
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("/privado/alta-producto.jsp").forward(request, response);
		}
		
	}

	private void crearProducto(HttpServletRequest request) {
		Float pPrecio = 0f;
		int pDescuento = 0;
		
		// Recoger parámetros
		String pNombre = request.getParameter("nombre");
		
		if (request.getParameter("precio") != null) {
			pPrecio = Float.parseFloat(request.getParameter("precio"));
		}
		
		if (request.getParameter("cant-descuento") != null) {
			pDescuento = Integer.parseInt(request.getParameter("cant-descuento"));
		} 
		
		String pPrecioUnidad = request.getParameter("litro");
		String pDescripcion = request.getParameter("descripcion");
		String pImg = request.getParameter("imagen");
		
		if (pPrecio > 0) {
			p = new Producto(10, pPrecio, pDescuento, pNombre, pPrecioUnidad, pImg, pDescripcion);	
		}
		
		
	}

	

}
