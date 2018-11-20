package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.ComentarioDAO;
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long videoId = -1;
		Alert alert = null;
		
		try {
			
			dao = ComentarioDAO.getInstance();
			
			//parametros
			String texto = request.getParameter("texto");
			videoId = Long.parseLong(request.getParameter("id_video"));
			
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			
			Comentario comentario = new Comentario();
			comentario.setTexto(texto);
			
			comentario.setUsuario(usuario);
			comentario.setVideo(new Video(videoId));
						
			if ( dao.insert(comentario) ) {
				alert = new Alert(Alert.SUCCESS, "Tu comentario esta pendiente de moderación");
			}else {
				alert = new Alert();
			}
			
		}catch (Exception e) {
			alert = new Alert();
			e.printStackTrace();
		}finally {
			request.getSession().setAttribute("alert", alert);
			response.sendRedirect( request.getContextPath() + "/inicio?id="+videoId  );
		}
		
		
		
	}

}