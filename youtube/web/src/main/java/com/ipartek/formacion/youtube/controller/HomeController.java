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

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String OP_ELIMINAR = "1";
	public static final String OP_MODIFICAR = "2";
	
	
	private static VideoDAO dao;
	private static ComentarioDAO daoComentarios;
	private ArrayList<Video> videos;	
	private Video videoInicio;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = VideoDAO.getInstance();
		daoComentarios = ComentarioDAO.getInstance();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
		daoComentarios = null;
	}
	
	
	/**
	 * Cada request se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Antes de realizar GET o POST");
		
		
		//idiomas @see com.ipartek.formacion.youtube.filter.IdiomaFilter
		HttpSession session = request.getSession();
		String idioma = (String)session.getAttribute("idioma");		
		Locale locale = new Locale( idioma.split("_")[0] , idioma.split("_")[1] );			
		ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
		
		
		super.service(request, response);  //llama a los metodos GET o POST
				
		//despues de realizar GET o POST
		request.setAttribute("videos", videos);
		request.setAttribute("videoInicio", videoInicio);
		try {
			request.setAttribute("comentarios", daoComentarios.getAllByVideo(videoInicio.getId()));
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		String playlist = "";
		for (int i=0; i < videos.size(); i++) {
			playlist += videos.get(i).getCodigo() + ",";
		}
		
		request.setAttribute("pa", dao.ejemploPA(24));
		request.setAttribute("playlist", playlist);		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Alert alert = null;
		try {
			
			//parametros
			String id = request.getParameter("id");
			String op = request.getParameter("op");
			
			//eliminar ?			
			if ( op != null && OP_ELIMINAR.equals(op) ) {
				if ( dao.delete( Long.parseLong(id) ) ) {
					alert = new Alert(Alert.SUCCESS, "Video Eliminado correctamente");
				}else {
					alert = new Alert();
				}
			}
			
			//listado videos			
			videos = (ArrayList<Video>) dao.getAll();
			
			
			//video de inicio
			videoInicio = new Video();
			if ( id != null && !OP_ELIMINAR.equals(op) ) {
				videoInicio = dao.getById( Long.parseLong(id) );
				
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
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Alert alert = null;
		try {
						
			//recoger parametros
			String codigo = request.getParameter("codigo");
			String nombre = request.getParameter("nombre");
			String op = request.getParameter("op");
			String id = request.getParameter("id");
			
			if ( op != null && OP_MODIFICAR.equals(op)) {    // modificar
				
				Video v = dao.getById( Long.parseLong(id) );
				v.setNombre(nombre);
				
				if ( dao.update(v) ) {
					alert = new Alert(Alert.SUCCESS, "Video Modificado");
				}else {
					alert = new Alert();
				}
				
				
			}else {  										 //insertar
							
				videoInicio = new Video(codigo, nombre);
				if ( dao.insert(videoInicio) ) {
					alert = new Alert(Alert.SUCCESS, "Gracias por subir tu Video");
				}else {
					alert = new Alert(Alert.WARNING, "ERROR, no se pudo crear el video, por favor asegurate que no este duplicado el Video.");
				}
			}	
			
			//pedir listado			
			videos = (ArrayList<Video>) dao.getAll();
			

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
		}
	}

}