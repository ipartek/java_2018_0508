package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class PublicarComentarioController
 */
@WebServlet("/publicar")
public class PublicarComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComentarioDAO daoComentario;
	
	@Override
	public void init() throws ServletException {
		super.init();
		daoComentario = ComentarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoComentario = null;
	}

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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String id_video = request.getParameter("id_video");
		Alert alert = null;
		
		try {
			
			String texto = request.getParameter("texto");
			HttpSession session = request.getSession();
			
			Video video = new Video();
			video.setId(Long.parseLong(id_video));
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			
			Comentario c = new Comentario(texto, video, usuario);
			
			if(daoComentario.insert(c)) {
				alert = new Alert(Alert.SUCCESS, "Tu comentario está pendiente de moderación");
			
			}else {
				alert = new Alert();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
			
		}finally {
			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + "/inicio?id=" + id_video);
		}
		
	}

}
