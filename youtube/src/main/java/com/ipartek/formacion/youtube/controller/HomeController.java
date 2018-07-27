package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.VideoArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static VideoArrayListDAO dao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String id = request.getParameter("id");
			
			if(id != null) {
				dao.delete(id);
			}
			
			dao = VideoArrayListDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);

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
			dao = VideoArrayListDAO.getInstance();
			
			String id = request.getParameter("id");
			String titulo = request.getParameter("titulo");
			
			//insertar
			Video videoNuevo = new Video(id, titulo);
			dao.insert(videoNuevo);
			
			//pedir listado
			dao = VideoArrayListDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
