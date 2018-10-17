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
import com.casa.practicas.pojo.Alerts;
import com.casa.practicas.pojo.Chip;
import com.casa.practicas.pojo.Perro;



/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/registroPerros" }, initParams = {
		@WebInitParam(name = "numeroProductos", value = "10", description = "Nmeros de productos a mostrar en la pagina inicial") })
public class RegistroPerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PerrosDao perrosDao;
	private ArrayList<Perro> perros;
	Alerts alerta = new Alerts();


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
			perros = (ArrayList<Perro>) perrosDao.getAll();
			String nombrePerro = request.getParameter("nombrePerro");
			String razaPerro = request.getParameter("razaPerro");
			String edadPerro = request.getParameter("edadPerro");
			String pesoPerro = request.getParameter("pesoPerro");
			String chipPerro = request.getParameter("chipPerro");
			String imagenPerro = request.getParameter("imagenPerro");
			String latitudChip = request.getParameter("latitudChip");
			String longitudChip = request.getParameter("longitudChip");
			String apadrinadoPerro = request.getParameter("apadrinadoPerro");

			boolean apadrinado= false;
			String op = request.getParameter("op");
			if (apadrinadoPerro != null) {
				if("on".contentEquals(apadrinadoPerro)) {
					apadrinado = true;
				}
			}
			
			Chip perroChip = new Chip(chipPerro,latitudChip,longitudChip);
			Perro perroNuevo = new Perro(getDaoId(),nombrePerro,Integer.parseInt(edadPerro),razaPerro,Double.parseDouble(pesoPerro),perroChip,apadrinado,imagenPerro);
			perrosDao.insert(perroNuevo);
			alerta.setTexto("Perro "+nombrePerro+" dado de alta correctametne");
			


			System.out.println("HomeController doProcess");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("perros", perros);
			request.getRequestDispatcher("listadoControler?vista=lista-perro&op=1").forward(request, response);
		}

	}

	public int getDaoId() {
		int id = perrosDao.getAll().size();
		return id+1;
	}
}

	