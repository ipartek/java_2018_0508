package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private ComentarioDAO daoComentario;
	Alert alerta;
	
	
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
	
		daoComentario= ComentarioDAO.getInstance();
		
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		daoComentario=null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
		long videoId= Long.parseLong(request.getParameter("id_video"));
		try {
			String texto=request.getParameter("texto");
			
			Usuario usuario= (Usuario) request.getSession().getAttribute("usuario");
			Comentario comentario = new Comentario();
			comentario.setTexto(texto);
			comentario.setUsuario(usuario);
			comentario.setVideo(new Video(videoId));
			
			if (daoComentario.insert(comentario)) {
				alerta= new Alert(Alert.SUCCESS, "Tu comentario está pendiente de aprobación");

			} else {
				alerta= new Alert(Alert.DANGER, "No hemos podido recibir tu comentario");

			} 
			request.getSession().setAttribute("alert", alerta);
			response.sendRedirect(request.getContextPath()+"/inicio?id="+videoId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			alerta= new Alert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
