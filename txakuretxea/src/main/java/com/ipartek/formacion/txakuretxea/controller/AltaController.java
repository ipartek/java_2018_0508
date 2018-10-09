package com.ipartek.formacion.txakuretxea.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.Chip;
import com.ipartek.formacion.supermercado.model.Perro;
import com.ipartek.formacion.supermercado.model.PerroArrayListDAO;

/**
 * Servlet implementation class AltaController
 */
@WebServlet("/alta")
public class AltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PerroArrayListDAO dao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = PerroArrayListDAO.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String nombre = request.getParameter("nombre");
			String edad = request.getParameter("edad");
			String raza = request.getParameter("raza");
			String peso = request.getParameter("peso");
			boolean apadrinado = false;
			if("on".equals(request.getParameter("apadrinado"))){
				apadrinado = true;
			}
			String numIdentificacion = request.getParameter("numIdentificacion");
			
			Perro p = new Perro(nombre, Integer.parseInt(edad), raza, Double.parseDouble(peso), apadrinado, new Chip(numIdentificacion, "0", "0"));
			
			dao.insert(p);			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			response.sendRedirect("home");
		}

	}

}
