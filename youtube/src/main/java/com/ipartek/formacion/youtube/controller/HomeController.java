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
	
	public static final String OP_ELIMINAR = "1";
	private static VideoArrayListDAO dao;
	private ArrayList<Video> videos;
	private Video videoInicio;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			//parametros
			String id = request.getParameter("id");
			String op = request.getParameter("op");
			
			//eliminar ?			
			if ( op != null && OP_ELIMINAR.equals(op) ) {
				dao.delete(id);
			}
			
			//listado videos
			dao = VideoArrayListDAO.getInstance();
			videos = (ArrayList<Video>) dao.getAll();
			
			
			//video de inicio
			videoInicio = new Video();
			if ( id != null && !OP_ELIMINAR.equals(op) ) {
				videoInicio = dao.getById(id);
			}else if ( !videos.isEmpty()) {
				videoInicio = videos.get(0);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("videos", videos);
			request.setAttribute("videoInicio", videoInicio);
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
			
			//recoger parametros
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			
			//insertar
			videoInicio = new Video(id, nombre);
			dao.insert(videoInicio);
			
			//pedir listado
			dao = VideoArrayListDAO.getInstance();
			videos = (ArrayList<Video>) dao.getAll();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("videos", videos);
			request.setAttribute("videoInicio", videoInicio);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
