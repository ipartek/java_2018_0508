package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.VideoDAO;

/**
 * Servlet implementation class BackofficeVideoController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoDAO dao;
	private static ArrayList<Video> videos = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = VideoDAO.getInstance();
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
		dao = null;
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String op = request.getParameter("op");

		if (op != null) {
			dao.delete(id);

			videos = (ArrayList<Video>) dao.getAll();

			request.setAttribute("videos", videos);
			request.getRequestDispatcher("video/index.jsp").forward(request, response);
		} else {

			if (id == null) {
				videos = (ArrayList<Video>) dao.getAll();

				request.setAttribute("videos", videos);
				request.getRequestDispatcher("video/index.jsp").forward(request, response);
			} else {
				Video video = null;
				try {
					video = new Video();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (Integer.parseInt(id) > 0) {
					video = dao.getById(id);
				}
				request.setAttribute("video", video);
				request.getRequestDispatcher("video/form.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		// Usuario u = (Usuario) request.getSession().getAttribute("usuario");

		Video video = null;
		try {
			video = new Video();
			video.setId(Long.parseLong(id));
			video.setCodigo(codigo);
			video.setNombre(nombre);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Es una modificacion
		if (video.getId() > 0) {
			dao.update(video);
		} else {
			// Es una alta
			dao.insert(video);
		}

		request.setAttribute("video", video);
		request.getRequestDispatcher("video/form.jsp").forward(request, response);

	}

}
