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
@WebServlet(urlPatterns = { "/home" }, initParams = {
		@WebInitParam(name = "numeroProductos", value = "10", description = "Nmeros de productos a mostrar en la pagina inicial") })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductoArrayListDAO productosDao;
	private ArrayList<Producto> productos;
	private static UsuarioArrayListDAO usuariosDao;
	private ArrayList<Usuario> usuarios;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		productosDao = ProductoArrayListDAO.getInstance();
		usuariosDao = UsuarioArrayListDAO.getInstance();
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
			String emailUsuario = request.getParameter("emailUsuario");
			String passUsuario = request.getParameter("passUsuario");
			if (emailUsuario != null && passUsuario != null) {
				request.setAttribute("usuario", dameUsuario(emailUsuario, passUsuario));
			}

			productos = (ArrayList<Producto>) productosDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}

	private Usuario dameUsuario(String emailUsuario, String passUsuario) {
		usuarios = (ArrayList<Usuario>) usuariosDao.getAll();
		for (Usuario u : usuarios) {
			if (emailUsuario.contentEquals(u.getEmail()) && passUsuario.contentEquals(u.getPassword())) {
				return u;
			}
		}
		return null;
	}

}
