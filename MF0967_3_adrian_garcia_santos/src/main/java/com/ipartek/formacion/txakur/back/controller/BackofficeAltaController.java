package com.ipartek.formacion.txakur.back.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.txakur.model.PerroArrayDAO;
import com.ipartek.formacion.txakur.pojo.Alert;
import com.ipartek.formacion.txakur.pojo.Chip;
import com.ipartek.formacion.txakur.pojo.Perro;

/**
 * Servlet implementation class BackofficeAltaController
 */
@WebServlet("/backoffice/alta")
public class BackofficeAltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PerroArrayDAO daoPerro;
	private Alert alert;
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		daoPerro = PerroArrayDAO.getInstance();
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
		daoPerro = null;
		
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		try {
			
			String nombre = request.getParameter("nombre");
			int edad = Integer.parseInt(request.getParameter("edad"));
			String raza = request.getParameter("raza");
			String id = request.getParameter("id");
			float peso = Float.parseFloat(request.getParameter("peso"));
			String apadrinado = request.getParameter("apadrinado");
			double latitud = Double.parseDouble(request.getParameter("lat"));
			double longitud = Double.parseDouble(request.getParameter("long"));
			String imagen = request.getParameter("img");
			
			boolean isApadrinado = false;
			
			if("0".equals(apadrinado)) {
				isApadrinado = true;
			}
			
			Perro p = new Perro(nombre, edad, raza, peso, isApadrinado, new Chip(id, latitud, longitud), imagen);
			
			if(daoPerro.insert(p)) {
				alert = new Alert(Alert.SUCCESS, p.getNombre() + " ha sido registrado correctamente.");
				session.setAttribute("alert", alert);
				response.sendRedirect(request.getContextPath() + "/backoffice/home");
				
			}else {
				alert = new Alert();
				session.setAttribute("alert", alert);
				response.sendRedirect(request.getContextPath() + "/backoffice/formulario.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
			request.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + "/backoffice/formulario.jsp");
		}	
		
	}

}
