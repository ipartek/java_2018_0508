package com.adriana.prado.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adriana.prado.model.ComentarioArrayDAO;
import com.adriana.prado.model.VideoDAO;
import com.adriana.prado.pojo.Video;
import com.adriana.prado.pojo.Alert;
import com.adriana.prado.pojo.Comentario;
import com.adriana.prado.pojo.Usuario;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String OP_ELIMINAR = "1";
	public static final String OP_MODIFICAR = "2";
	
	//parametros
	private static String id = "";
	private static String codigo = "";
	private static String titulo = "";
	private static String op = "";
	
	//atributos
	private static String msg = "";
	private static VideoDAO dao;
	private static ComentarioArrayDAO daoComentarios;
	private static ArrayList<Video> videos;
	private static ArrayList<Comentario> comentarios;
	private Video videoInicio;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//Se ejecuta solo con la primera peticion. El resto van al service
		super.init(config);
		dao = VideoDAO.getInstance();
		daoComentarios = ComentarioArrayDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		//Se ejecuta al parar el servidor
		super.destroy();
		dao = null;
	}
	
	/**
	 * Cada request de un cliente se ejecuta en un hilo (thread)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Estas lineas se ejecutaran antes de GET o POST
//		System.out.println("Antes de realizar Get o post");
		
		//Gestionar cookies de ultima visita
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Cookie cVisita = new Cookie("cVisita", URLEncoder.encode(dateFormat.format(new Date()), "UTF-8") );
		cVisita.setMaxAge(60*60*24*365); //Un año
		resp.addCookie(cVisita);
		
		//Recuperar todas las cookies
		Cookie[] cookies = req.getCookies();
		
		HttpSession session = req.getSession();
		
		String idioma = req.getParameter("idioma");
		
		try {
			//Idiomas
			//Locale por defecto Español
			
			if(idioma == null) {
				idioma = (String) session.getAttribute("idioma");
			}
			
			if(idioma == null) {
				//Conseguir idioma a traves de la request
				idioma = req.getLocale().toString();
				if(idioma.length() != 5) {
					idioma = "es_ES";
				}
			}
			
//			Locale locale = new Locale("es", "ES");
//			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
//			System.out.println(idiomas.getString("msj.bienvenida"));
//			Locale locale = request.getLocale(); (not empty sessionScope.idioma)?sessionScope.idioma:'es_ES'
			
		}catch(Exception e){
			idioma = "es_ES";	
		}finally {
			//Guardar en sesion
			session.setAttribute("idioma", idioma);
		}
		
//		Locale locale = new Locale(idioma.split("_")[0], idioma.split("_")[1]);
//		ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
		
		super.service(req, resp); //llama a los metodos GET y POST
		
		//despues de Get y Post
		req.setAttribute("videos", videos);
		req.setAttribute("videoInicio", videoInicio);
		String playlist = "";
		for(int i = 1; i<videos.size(); i++) {
			playlist+= videos.get(i).getCodigo()+",";
		}
		req.setAttribute("playlist", playlist);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Alert alert = null;
		try {
			
			id = request.getParameter("id");
			codigo = request.getParameter("codigo");
			op = request.getParameter("op");
			
			
			
			//Eliminar video
			if ( op != null && OP_ELIMINAR.equals(op) ) {
				if(dao.delete(id)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Vídeo eliminado correctamente.");
				}else {
					alert = new Alert(Alert.ALERT_WARNING, "No se ha podido borrar el vídeo.");
				}
			}
			
			//listar videos
			comentarios = (ArrayList<Comentario>) daoComentarios.getAll();
			videos = (ArrayList<Video>) dao.getAll();
			
			
			//Video inicio
			videoInicio = new Video();
			
			if(id!= null && !OP_ELIMINAR.equals(op)) {
				videoInicio = dao.getById(id);
				
				//Guardar video reproducido si el user esta en sesion
				HttpSession session = request.getSession();
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				
				//Si esta loggeado
				if(usuario != null) {
					ArrayList<Video> videosReproducidos = (ArrayList<Video>) session.getAttribute("videosVistos");
					
					if(videosReproducidos == null ) {
						videosReproducidos = new ArrayList<Video>();
					}
					
					videosReproducidos.add(videoInicio);
					session.setAttribute("videosVistos", videosReproducidos);				
					
				}
				
			}else if(!videos.isEmpty()) {
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
		Video videoInicio;
		Video videoEditar = null;
		
		try {
			
			msg = "";
			
			id = request.getParameter("id");
			codigo = request.getParameter("codigo");
			titulo = request.getParameter("titulo");
			
			String id2 = request.getParameter("id2");
			String titulo2 = request.getParameter("titulo2");
			
			if(id2 != null && titulo2 != null) {
				videoEditar = dao.getById(id2);
				videoEditar.setTitulo(titulo2);
				if(dao.update(videoEditar)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Vídeo actualizado correctamente.");
				}else {
					alert = new Alert(Alert.ALERT_DANGER, "No se ha podido actualizar el vídeo.");
				}
			}
						
			if(codigo != null && titulo != null) {
				if(!codigo.equals("") && !titulo.equals("")){
					videoInicio = new Video(codigo, titulo);
					if(dao.insert(videoInicio)) {
						alert = new Alert(Alert.ALERT_SUCCESS, "Registro dado de alta correctamente.");
						request.setAttribute("alert", alert);
					}else
						alert = new Alert(Alert.ALERT_WARNING, "La cancion a introducir ya existe.");
						request.setAttribute("alert", alert );
				}else
					alert = new Alert(Alert.ALERT_WARNING, "Debe introducir un ID y un título.");
			}
			
			videos = (ArrayList<Video>) dao.getAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("alert", alert);
			request.setAttribute("videos", videos);
//			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
