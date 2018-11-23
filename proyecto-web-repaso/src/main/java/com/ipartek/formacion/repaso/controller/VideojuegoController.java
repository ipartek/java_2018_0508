package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.pojo.Juego;

/**
 * Servlet implementation class VideojuegoController
 */
@WebServlet("/videojuego")
public class VideojuegoController extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(VideojuegoController.class);
	private static final long serialVersionUID = 1L;
	
	private final static String VISTA_INDEX = "index.jsp";
	private final static String VISTA_LISTADO = "listado.jsp";
	String vista = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Entro");
		
		try {
			//recoger parametros
			String titulo = request.getParameter("titulo");
			//String fLanzamiento = request.getParameter("fechaLanzamiento");
			
			//validar parametros
			if((titulo != null) && (!titulo.trim().equals(""))) {
				//Guardar en Pojo
				Juego j = new Juego();
				j.setTitulo(titulo);
				//j.setFechaLanzamiento(fechaLanzamiento);
				
				request.setAttribute("juego", j);
				vista = VISTA_LISTADO;
			}else {
				request.setAttribute("info", "Introduce correctamente el titulo por favor");
				vista = VISTA_INDEX;
			}
			
			//TODO guardar en bbdd
			
		}catch(Exception e) {
			LOG.error(e);
			request.setAttribute("info", "Lo sentimos tenemos un error no controlado");
			vista = VISTA_INDEX;
		}finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}

		LOG.trace("Salgo");
	}

}
