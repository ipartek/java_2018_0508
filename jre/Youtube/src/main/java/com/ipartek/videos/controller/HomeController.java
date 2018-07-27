package com.ipartek.videos.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.videos.model.VideoArrayDAO;
import com.ipartek.videos.pojo.Video;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoArrayDAO dao;
	private static final String DEFAULT_PATH = "home.jsp";
	private static Video video;
	private static String msg;
	private static String id;
	private static String titulo;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			dao = VideoArrayDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("listaVideos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			id = request.getParameter("id");
			titulo = request.getParameter("titulo");
			if (id != null && titulo != null) {
				video = new Video(id, titulo);
				if (dao.insert(video)) {
					msg = "El video ha sido añadido a la lista.";
					request.setAttribute("listaVideos", dao.getAll());
				} else {
					msg = "Lo sentimos pero ha ocurrido un error, intentelo de nuevo.";
				}
			} else {
				msg = "Lo sentimos pero debe rellenar los dos campos.";
			}
			dao = VideoArrayDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("listaVideos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
