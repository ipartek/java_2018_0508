package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.pojo.Producto;
import com.ipartek.formacion.supermercado.model.pojo.ProductoArrayListDAO;
import com.ipartek.formacion.supermercado.model.pojo.Usuario;
import com.ipartek.formacion.supermercado.model.pojo.UsuarioArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/altaProducto" })
public class AltaProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductoArrayListDAO productosDao;
	private ArrayList<Producto> productos;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		productosDao = ProductoArrayListDAO.getInstance();

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		productosDao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
		this.getServletConfig();
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String numero2 = getInitParameter("numeroProductos").toString();
		// TODO mirar cojer parametros de inicio

		try {
			String nombreProducto = request.getParameter("nombreProducto");
			float precioProducto = Float.parseFloat(request.getParameter("precioProducto")) ;
			//String cantidadProducto = request.getParameter("cantidadProducto");
			int cantDescuento =Integer.parseInt(request.getParameter("cantDescuento"));
			float litro =Float.parseFloat(request.getParameter("litro"));
			String descripcion = request.getParameter("descripcion");
			String imagen = request.getParameter("imagen");
			
			dameId();
			productos.add(new Producto(dameId(),nombreProducto,precioProducto,cantDescuento,imagen,precioProducto,descripcion));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}

	private int dameId() {
		int idDao= 0;
		productos = (ArrayList<Producto>) productosDao.getAll();
		idDao = productos.size();
		return idDao;
		
	}

	

}
