package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class PublicarController
 */
@WebServlet("/publicar")
public class PublicarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ComentarioDAO dao;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		long videoId = -1;
		Alert alert = null;
		
		try {
			
			dao = ComentarioDAO.getInstance();
				
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			String texto = request.getParameter("texto");
			videoId = Long.parseLong(request.getParameter("id_video"));
				
			Comentario comentario = new Comentario();
			comentario.setTexto(texto);
			comentario.setUsuario(usuario);
			comentario.setVideo(new Video(videoId));
			
			if(dao.insert(comentario)) {
				alert = new Alert(Alert.SUCCESS, "Tu comentario esta pendiente de moderación.");
			}else {
				alert = new Alert();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}finally {
			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + "/inicio?id="+videoId);
		}
		
	}

}
