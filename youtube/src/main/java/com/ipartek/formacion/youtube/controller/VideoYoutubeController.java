package com.ipartek.formacion.youtube.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.VideoArrayListDao;
import com.ipartek.formacion.pojo.Video;

/**
 * Servlet implementation class VideoYoutubeController
 */
@WebServlet("/")
public class VideoYoutubeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoArrayListDao videosDao;
	private static ArrayList<Video> videos;
	private static String enlaceClickado;
	String urlYoutube="https://www.youtube.com/" ;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			//entrada de parametros
			String senal = request.getParameter("anadir") ;
			String enlaceClickado = request.getParameter("id");
			
			
			if(enlaceClickado != null ) {
				System.out.println(enlaceClickado);
				urlYoutube += enlaceClickado;
			}
			
			if (senal != null && senal.contains("anadir")){
				String id = request.getParameter("id");
				String nombreCancion = request.getParameter("nombreCancion");
				Video v = new Video(id,nombreCancion);
				videosDao.insert(v);
			}
			
			//listado de videos
			videosDao = VideoArrayListDao.getInstance();
			videos = (ArrayList<Video>) videosDao.getAll();	

			System.out.println("doGet");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("idSeleccionado", urlYoutube);
			request.setAttribute("videos", videos);
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
			System.out.println("doPost");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
