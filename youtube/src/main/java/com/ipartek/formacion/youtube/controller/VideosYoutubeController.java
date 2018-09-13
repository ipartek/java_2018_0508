package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.VideoYoutubeArrayListDAO;
import com.ipartek.formacion.youtube.pojo.VideoYoutubePOJO;

/**
 * Servlet implementation class VideosYoutubeController
 */
@WebServlet("/")
public class VideosYoutubeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static VideoYoutubeArrayListDAO dao;
	private static ArrayList<VideoYoutubePOJO> videos;
	private static String msg;

	/**
	 * @see HttpServletRequest, HttpServletResponse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VideoYoutubePOJO vSeleccionado;
		
		try {
			
			String id = request.getParameter("id"); 
			
			dao = VideoYoutubeArrayListDAO.getInstance();
			
			videos = (ArrayList<VideoYoutubePOJO>) dao.getAll();
			request.setAttribute("videos", videos);
			
			
			if (id == null) { // Video por defecto
						
				vSeleccionado = videos.get(0);
				
			} else { // Hay un video seleccionado
				
				vSeleccionado = dao.getById(id);
			}	
			
			
			request.setAttribute("vSeleccionado", vSeleccionado);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
	
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServletRequest, HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id;
		String titulo;
		VideoYoutubePOJO videoInsertar;
		String claseAlert = "alert-warning";
		
		try {
			
			id = request.getParameter("id");
			titulo = request.getParameter("titulo");
			
			videoInsertar = new VideoYoutubePOJO(id, titulo);
			
			dao.insert(videoInsertar); // Insertamos video
			dao = VideoYoutubeArrayListDAO.getInstance();
			
			videos = (ArrayList<VideoYoutubePOJO>) dao.getAll();
			
			msg = "Video insertado correctamente.";
			
			claseAlert = "alert-success";

		} catch (Exception e) {
			
			msg = e.getMessage();
			
			e.printStackTrace();

		} finally {

			request.setAttribute("msg", msg);
			request.setAttribute("claseAlert", claseAlert);
			request.setAttribute("videos", videos);
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}


}
