package com.ipartek.formacion.youtube.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.ComentariosDao;
import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/publicar")
public class ComentariosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String OP_ELIMINAR = "1";
	public static final String OP_MODIFICAR = "2";
	private static VideoDAO videoDao;
	private static ComentariosDao comentariosDao;
	private static UsuariosDaoJDBC usuarioDao;

	String editar = null;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		videoDao = VideoDAO.getInstance();
		usuarioDao = usuarioDao.getInstance();
		comentariosDao = ComentariosDao.getInstance();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		videoDao = null;
		usuarioDao = null;
		comentariosDao = null;
	}
	
	
	/**
	 * Cada request se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Antes de realizar GET o POST");
		
		

		
		
		super.service(request, response);  //llama a los metodos GET o POST
				

		
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			doProcess(request, response);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			doProcess(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
	}


	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id_video = request.getParameter("id_video");
			String id_usuario = request.getParameter("id_usuario");
			String texto = request.getParameter("texto");
			Usuario u = new Usuario();
			Video v = new Video();
			
			Comentario c = new Comentario();
			c.setTexto(texto);
			c.setUsuario(u);
			c.setVideo(v);
			comentariosDao.insert(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}
