package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
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

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HttpSession session;

	public static final String OP_ELIMINAR = "1";
	public static final String OP_MODIFICAR = "2";

	private static VideoDAO daoVideo;
	private static ComentarioDAO daoComentario;
	private ArrayList<Video> videos;

	private Video videoInicio;
	private Alert alert;

	String id;
	String op;
	String playlist = "";

	int idNo;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoVideo = VideoDAO.getInstance();
		daoComentario = ComentarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoVideo = null;
		daoComentario = null;
	}

	/**
	 * Cada request se ejecuta en un hilo o thread.
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoger Parametros genéricos
		id = request.getParameter("id");
		op = request.getParameter("op");

		if (id != null) { // Casteamos a Integer el ID recibido

			idNo = Integer.parseInt(id);

		} else {

			idNo = 1; // Video por defecto

			try {

				videos = (ArrayList<Video>) daoVideo.getAll();

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		setIdioma(request, response); // Establecer idioma

		super.service(request, response); // LLAMADA a los metodos GET o POST

		session = request.getSession();

		setCookieUltimaVisita(request, response); // Guardar última visita en cookies

		try {

			videos = (ArrayList<Video>) daoVideo.getAll(); // Actualizar listado de videos

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Enviar Atributos
		envarAtributos(request);

		// Ir a la vista
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	private void envarAtributos(HttpServletRequest request) {
		
		request.setAttribute("videos", videos);
		request.setAttribute("playlist", playlist);
		request.setAttribute("videoInicio", videoInicio);
		request.setAttribute("alert", alert);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			cargarVideos(request, response);
			cargarPlaylist();
			cargarComentarios();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private void cargarComentarios() throws Exception {
		
		ArrayList<Comentario> comentarios = (ArrayList<Comentario>) daoComentario.getAllByIdVideo(videoInicio.getId());
		videoInicio.setComentarios(comentarios);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			if (op != null && OP_MODIFICAR.equals(op)) { // Modificar Video

				modificarVideo(request);
				alert = new Alert(Alert.SUCCESS, "Video correctamente modificado.");

			} else { // Crear video
				
				insertarVideo(request, videoInicio);
				alert = new Alert(Alert.SUCCESS, "Video correctamente insertado.");

			}
			
			videoInicio = videos.get(0); // Recuperamos el primer video de la lista

		} catch (Exception e) {
			
			alert = new Alert();
			e.printStackTrace();
		}
	}
	
	private void cargarVideos(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (op != null && OP_ELIMINAR.equals(op)) { // Eliminar Video
			eliminarVideo(idNo);
		}

		// Video de inicio
		videoInicio = new Video();

		if (id != null && !OP_ELIMINAR.equals(op)) {
			
			videoInicio = daoVideo.getById(idNo);

			// Guardar videos reproducido si esta usuario logueado
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");

			if (usuario != null) { // Logueado

				ArrayList<Video> reproducidos = (ArrayList<Video>) session.getAttribute("reproducidos");
				
				if (reproducidos == null) {
					reproducidos = new ArrayList<Video>();
				}
				
				reproducidos.add(videoInicio);
				session.setAttribute("reproducidos", reproducidos);
			}

		} else if (!videos.isEmpty()) { // Videos correctamente cargados
			
			videoInicio = videos.get(0); // Cargamos el primer video
		}
	}

	private void cargarPlaylist() {
		playlist = "";
		
		for (int i = 1; i < videos.size(); i++) {
			playlist += videos.get(i).getCod() + ",";
		}
	}

	/**
	 * Procedimiento privado que se encarga de insertar el Video videoInicio.
	 * 
	 * @param videoInicio, video
	 * @throws SQLException, si ocurre un error 
	 */
	private void insertarVideo(HttpServletRequest request, Video videoInicio) throws Exception {

		alert = new Alert();
		
		// Recoger parametros
		String cod = request.getParameter("cod");
		String nombre = request.getParameter("nombre");
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		// Insertar Video
		videoInicio = new Video(cod, nombre, usuario);

		if (!daoVideo.insert(videoInicio)) { // Video no insertado

			alert = new Alert(Alert.DANGER, "El video no se ha podido insertar. Posiblemente, el código ya exista.");
			
		} 
	}

	/**
	 * Procedimiento privado que se encarga de modificar el video con el ID seleccionado de la BBDD.
	 * 
	 * @param idNo, int, ID del video a modificar
	 * @throws SQLException, si ocurre un error 
	 */
	private void modificarVideo(HttpServletRequest request) throws Exception {

		Video video = daoVideo.getById(idNo);
		
		// Recoger parámetros
		String nuevoTitulo = request.getParameter("nuevoTitulo");
		String nuevoCodigo = request.getParameter("nuevoCod");

		video.setNombre(nuevoTitulo);
		video.setCod(nuevoCodigo);
		
		if (daoVideo.update(video)) { // Video correctamente modificado

			alert = new Alert(Alert.SUCCESS, "Video eliminado.");

		} else { // Video no modificado

			alert = new Alert();
			alert.setTexto("El video no puedo modificarse. Posiblemente, no se encuentre en la base de datos.");
		}
	}
	
	/**
	 * Procedimiento privado que se encarga de eliminar el video con el ID seleccionado de la BBDD.
	 * 
	 * @param idNo, int, ID del video a eliminar
	 * @throws SQLException, si ocurre un error 
	 */
	private void eliminarVideo(int idNo) throws SQLException {

		if (daoVideo.delete(idNo)) { // Video Eliminado

			alert = new Alert(Alert.SUCCESS, "Video eliminado.");

		} else { // Video no eliminado

			alert = new Alert();
			alert.setTexto("El video no puedo eliminarse. Posiblemente, no se encuentre en la base de datos.");
		}

	}

	private void setIdioma (HttpServletRequest request, HttpServletResponse response) {

		// Gestión del idioma
		HttpSession session = request.getSession();
		String idioma = request.getParameter("idioma");

		try {

			if (idioma == null) {
				idioma = (String) session.getAttribute("locale");
			}

			if (idioma == null) {

				idioma = request.getLocale().toString(); // Conseguir idioma del usuario a traves de la request
				if (idioma.length() != 5) {
					idioma = "es_ES";
				}
			}
		} catch (Exception e) {

			idioma = "es_ES"; // Idioma por defecto
		} finally {

			session.setAttribute("idioma", idioma); // Guardar en session el idioma
		}
	}

	/**
	 * Procedimiento que gestiona la cookie de la última visita.
	 * 
	 * @param request, HttpServletRequest
	 * @param response, HttpServletResponse
	 * @throws UnsupportedEncodingException, si no consigue formatear correctamente
	 *                                       la fecha
	 */
	private void setCookieUltimaVisita (HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		if (request.getSession() != session) {
			
			session = request.getSession();	 // Capturar la sesión
			DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss"); // Formatear la fecha

			// Crear la cookie y darle un tiempo de vida
			Cookie cVisita = new Cookie("cVisita", URLEncoder.encode(formatter.format(new Date()).toString(), "UTF-8"));
			cVisita.setMaxAge(60 * 60 * 24 * 365); // 1 año
			
			// Enviar la cookie al navegador
			response.addCookie(cVisita);
		}

	}

}
