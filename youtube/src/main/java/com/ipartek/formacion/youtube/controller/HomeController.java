package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Video;
import com.ipartek.formacion.youtube.model.VideoArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String OP_ELIMINAR = "1";
	private static VideoArrayListDAO dao;
	private ArrayList<Video> videos;
	private ArrayList<Video> videosReproducidos;
	private Video videoInicio;
	
	private HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Parametros
			String id = request.getParameter("id");
			String op = request.getParameter("op");

			// Eliminar
			if (op != null && OP_ELIMINAR.equals(op)) {
				dao.delete(id);
			}

			// Listado videos
			videos = (ArrayList<Video>) dao.getAll();
			
			// Video de inicio
			videoInicio = new Video();
			
			if (id != null && !OP_ELIMINAR.equals(op)) {
				videoInicio = dao.getById(id);
			} else if (!videos.isEmpty()) {
				videoInicio = videos.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			// Parametros
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");

			// Insertar
			videoInicio = new Video(id, nombre);
			dao.insert(videoInicio);

			// Listado videos
			videos = (ArrayList<Video>) dao.getAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException { // Se ejecutará sólo la 1ª petición

		super.init(config);
		dao = VideoArrayListDAO.getInstance();
	}

	@Override
	public void destroy() { // Se ejecutará cuando se detenga el Servidor
		
		super.destroy();
		dao = null;
	}
	
	/**
	 * Cada petición (request) se ejecuta en un Thread.
	 * 
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Antes de realizar GET o POST...");
		
		super.service(request, response);	// LLamada a los métodos GET o POST
		
		// Después de realizar GET o POST
		request.setAttribute("videos", videos);
		request.setAttribute("videoInicio", videoInicio);
		request.getRequestDispatcher("home.jsp").forward(request, response);	
	}

}
