package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.VideoArrayListDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String OP_ELIMINAR = "1";
	private static VideoArrayListDAO dao;
	private ArrayList<Video> videos;	
	private Video videoInicio;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = VideoArrayListDAO.getInstance();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}
	
	
	/**
	 * Cada request se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Antes de realizar GET o POST");
		
		super.service(request, response);  //llama a los metodos GET o POST
				
		//despues de realizar GET o POST
		request.setAttribute("videos", videos);
		request.setAttribute("videoInicio", videoInicio);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}
	
	
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
			videos = (ArrayList<Video>) dao.getAll();
			
			
			//video de inicio
			videoInicio = new Video();
			if ( id != null && !OP_ELIMINAR.equals(op) ) {
				videoInicio = dao.getById(id);
				
				//guardar video reproducido si esta usuario en session
				HttpSession session = request.getSession();
				Usuario usuario = (Usuario)session.getAttribute("usuario");
				if ( usuario != null ) { //Logeado
				
					ArrayList<Video> reproducidos = (ArrayList<Video>)session.getAttribute("reproducidos");
					if ( reproducidos == null ) {
						reproducidos = new ArrayList<Video>();
					}
					reproducidos.add(videoInicio);
					session.setAttribute("reproducidos", reproducidos);										
					
				}				
				
			}else if ( !videos.isEmpty()) {
				videoInicio = videos.get(0);
			}
			

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
			
			//recoger parametros
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			
			//insertar
			videoInicio = new Video(id, nombre);
			dao.insert(videoInicio);
			
			//pedir listado			
			videos = (ArrayList<Video>) dao.getAll();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}
