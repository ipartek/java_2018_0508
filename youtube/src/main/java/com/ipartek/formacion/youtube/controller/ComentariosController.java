package com.ipartek.formacion.youtube.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.*;
import com.ipartek.formacion.pojo.Comentarios;
import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.pojo.Video;





/**
 * Servlet implementation class ListarControler
 */
@WebServlet("/ComentariosControler")
public class ComentariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ComentariosDao comentariosDao;
	private static VideoArrayListDAO videosDao;
	private static ArrayList<Video> videos;
	private static ArrayList<Comentarios> comentarios;
	private static Comentarios comentario;

       
    
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		//inicializamos el arraydao de usuarios
		
	}
	
/*	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		//comentariosDao = null;
	}
	*/
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Antes de realizar GET o POST");
		System.out.println(request.getContextPath());
		
		super.service(request, response);  //llama a los metodos GET o POST
				
		//despues de realizar GET o POST
/*		if(usuarios != null) {
			request.setAttribute("usuarios", usuarios);
		}
		
		request.setAttribute("usuarios", usuarios);*/
		//nos vamos a index pasando por el controlador mapeado con inicio limpiado la url
		//response.sendRedirect(request.getContextPath() + "/inicio" ); 
		request.getRequestDispatcher("/inicio").forward(request, response);
		
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***GET***");
		doProcess(request,response);
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***POST***");
		doProcess(request,response);
			
		
		
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			System.out.println("***POST***");
			HttpSession session = request.getSession();
			comentariosDao =  ComentariosDao.getInstance();
			comentarios = (ArrayList<Comentarios>) comentariosDao.getAll();
			videosDao =  VideoArrayListDAO.getInstance();
			videos = (ArrayList<Video>) videosDao.getAll();
			//recogemos parametros
			String comentarioUsuario = request.getParameter("text");
			String videoId = request.getParameter("videoId");
			//String comentarioUsuario = request.getParameter("nombreUsuario");
			System.out.println(comentarioUsuario);
			System.out.println(videoId);
			Usuario u = (Usuario) session.getAttribute("usuario");
			System.out.println(u.getNombre());
			comentario = new Comentarios(u.getNombre(),comentarioUsuario,videoId );
			comentarios.add(comentario);
			if(videos != null) {
				for(Video v : videos) {
					//si el videoId del comentario es igual al id del video añadimos al video el comentario 
					if (comentario.getVideoId().contentEquals(v.getId())) {
						v.setComentarios(comentario);
					}
				}
			}
			
			request.setAttribute("comentarios", comentarios);
			session.setAttribute("comentarios", comentarios);
			
			

			
			//validamos


			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			/*alert.setTexto(msg);
			request.setAttribute("error", error);
			request.getRequestDispatcher("index.jsp").forward(request, response);*/
			//response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}
		
	}





}
