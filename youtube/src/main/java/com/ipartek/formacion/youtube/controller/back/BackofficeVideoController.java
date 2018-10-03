package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static VideoDAO dao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = VideoDAO.getInstance();
		try {
		ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
		
		String id = request.getParameter("id");
		
		if(id == null) { //Si el ID es nulo, lista todos los usuarios
			request.setAttribute("videos", videos);
			request.getRequestDispatcher("videos/index.jsp").forward(request, response);
		}else {
			Video video = new Video();
			if(Integer.parseInt(id) > 0) { //Si el ID es mayor que cero, muestra los datos de ese usuario, si no crea uno nuevo
				video = dao.getById(id);
			}
			request.setAttribute("video", video);
			request.getRequestDispatcher("videos/formulario.jsp").forward(request, response);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
		//recoger parametros
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		
		//TODO Comprobar si es CREAR o MODIFICAR y llamar al DAO
		
		Video video = new Video();
		video.setCodigo(codigo);
		video.setNombre(nombre);
		
		request.setAttribute("video", video);
		request.getRequestDispatcher("videos/formulario.jsp").forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
