package com.casa.practicas.controller;





import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casa.practicas.model.PerrosDao;
import com.casa.practicas.pojo.Perro;





/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/listadoControler" }, initParams = {
		@WebInitParam(name = "numeroProductos", value = "10", description = "Nmeros de productos a mostrar en la pagina inicial") })
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PerrosDao perrosDao;
	private ArrayList<Perro> perros;
	String vista = "lista-perro";
	String plantilla ="home.jsp";
	final String LISTAR_USUARIOS = "1";
	final String FORMULARIO_USUARIOs = "2";



	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		perrosDao = perrosDao.getInstance();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {

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
			System.out.println("HomeController doProcess");
			perros = (ArrayList<Perro>) perrosDao.getAll();
			vista = request.getParameter("vista");
			String op = request.getParameter("op");
			
			if(op != null) {
				switch (op) {
				case LISTAR_USUARIOS:
					perros = (ArrayList<Perro>) perrosDao.getAll();
					//plantilla = "privado/resultadoUsuariosAdmin.jsp";
					request.setAttribute("vista", "lista-perro");
					break;
				case FORMULARIO_USUARIOs:
					vista = "formulario-perro";
					request.setAttribute("vista", vista);
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("perros", perros);
			request.getRequestDispatcher("privado/listado.jsp").forward(request, response);
		}

	}
}

	