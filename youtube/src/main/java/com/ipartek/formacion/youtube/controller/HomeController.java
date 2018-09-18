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

import com.ipartek.formacion.youtube.model.VideoArrayListDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String OP_ELIMINAR = "1";
	private static VideoArrayListDAO dao;
	private ArrayList<Video> videos;
	private Video videoInicio;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la primera peticion, el resto de peticiones iran al
		// service
		dao = VideoArrayListDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// Se ejecuta cuando se para el servidor
		dao = null;
	}

	/**
	 * Cada peticion de un cliente se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Antes de realizar GET o POST

		System.out.println("Antes de GET o POST");

		super.service(request, response); // llama a los metodos GET o POST

		// Despues de realizar GET o POST
		request.setAttribute("videos", videos);
		request.setAttribute("videoInicio", videoInicio);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// parametros
			String id = request.getParameter("id");
			String op = request.getParameter("op");

			// eliminar ?
			if (op != null && OP_ELIMINAR.equals(op)) {
				dao.delete(id);
			}

			// listado videos
			videos = (ArrayList<Video>) dao.getAll();

			// video de inicio
			videoInicio = new Video();
			if (id != null && !OP_ELIMINAR.equals(op)) {
				videoInicio = dao.getById(id);

				// guardar video si el usuario esta en session

				HttpSession session = request.getSession();
				Usuario u = (Usuario) session.getAttribute("usuario");

				if (u != null) {

					ArrayList<Video> reproducidos = (ArrayList<Video>) session.getAttribute("videosUsuario");
					if (reproducidos == null) {
						reproducidos = new ArrayList<Video>();
					}
					reproducidos.add(videoInicio);
					session.setAttribute("videosUsuario", reproducidos);
					
				}

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

			// recoger parametros
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");

			// insertar
			videoInicio = new Video(id, nombre);
			dao.insert(videoInicio);

			// pedir listado
			videos = (ArrayList<Video>) dao.getAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}