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

	public static final String OP_PREV = "3";
	public static final String OP_NEXT = "4";
	// public static final String OP_ALEATORIO = "5";

	private static VideoDAO daoVideo;
	private static ComentarioDAO daoComentario;
	private ArrayList<Video> videos;

	private Video videoInicio;
	private Alert alert;

	String id;
	String op;
	String isRandom;

	long idNo;
	int actualPos;

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

		try {

			videos = (ArrayList<Video>) daoVideo.getAll();

		} catch (Exception e) {

			e.printStackTrace();
		}

		isRandom = getCookieValue("cRandom", request);
		System.out.println(isRandom);

		// Recoger Parametros genéricos
		id = request.getParameter("id");
		op = request.getParameter("op");
		
		if (idNo == 0) { // Ningún video ha sido cargado

			idNo = videos.get(0).getId(); // Video por defecto

		} else if (!"false".equals(isRandom)) {

			int rndmPos = (int) (Math.random() * videos.size());
			idNo = videos.get(rndmPos).getId();
			
			op = null;
			System.out.println(idNo);
			System.out.println("Random generado");

		} else if (id != null) { // Casteamos a Long el ID recibido

			idNo = Long.parseLong(id);

		} 
		
		try {
			videoInicio = daoVideo.getById(idNo); // Actualizar video de inicio
		
		} catch (Exception e1) {
	
			e1.printStackTrace();
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
		enviarAtributos(request);

		// Ir a la vista
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	private String getCookieValue(String cName, HttpServletRequest request) {
		String value = null;

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cName)) {
					value = cookie.getValue();
				}
			}
		}

		return value;
	}

	private void enviarAtributos(HttpServletRequest request) {

		request.setAttribute("videos", videos);
		request.setAttribute("videoInicio", videoInicio);
		request.setAttribute("alert", alert);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			if (op != null) {

				switch (op) {
				case OP_PREV:

					reproducirSiguiente(false);
					break;

				case OP_NEXT:

					reproducirSiguiente(true);
					break;

				case OP_ELIMINAR:

					eliminarVideo(idNo);
					alert = new Alert(Alert.PRIMARY, "Video eliminado.");
					break;

				default:

					reproducirPrimerVideo();
					break;
				}

			} else if (!"true".equals(isRandom)) {

				reproducirPrimerVideo();
				System.out.println("Reproducir primer video");

			}

			cargarComentarios();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			if (op != null) {

				switch (op) {
				case OP_MODIFICAR:

					modificarVideo(request);
					alert = new Alert(Alert.SUCCESS, "Video correctamente modificado.");
					break;

				default:

					insertarVideo(request, videoInicio);
					alert = new Alert(Alert.SUCCESS, "Video correctamente insertado.");
					break;
				}
			}

			reproducirPrimerVideo(); // Recuperamos el primer video de la lista

		} catch (Exception e) {

			alert = new Alert();
			e.printStackTrace();
		}

		response.sendRedirect("inicio?alert=" + alert);
	}

	private void reproducirPrimerVideo() throws Exception {

		if (!videos.isEmpty()) { // Videos correctamente cargados

			videoInicio = videos.get(0); // Cargamos el primer video
		}

	}

	private void reproducirSiguiente(boolean avanzar) {

		actualPos = videos.indexOf(videoInicio);

		if (avanzar) { // AVANZAR VIDEO

			if (actualPos == videos.size() - 1) { // Estamos en el ÚLTIMO video

				actualPos = 0;
			} else { // Podemos Avanzar

				actualPos++;
			}

		} else { // RETROCEDER VIDEO

			if (actualPos == 0) { // Estamos en el PRIMER video

				actualPos = videos.size() - 1;
			} else { // Podemos retroceder

				actualPos--;
			}
		}

		videoInicio = videos.get(actualPos); // Recuperamos el video obtenido
	}

	private void cargarComentarios() throws Exception {

		ArrayList<Comentario> comentarios = (ArrayList<Comentario>) daoComentario.getAllByIdVideo(idNo);
		videoInicio.setComentarios(comentarios);

	}

	/**
	 * Procedimiento privado que se encarga de insertar el Video videoInicio.
	 * 
	 * @param request, HttpServletRequest
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
	 * Procedimiento privado que se encarga de modificar el video con el ID
	 * seleccionado de la BBDD.
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
	 * Procedimiento privado que se encarga de eliminar el video con el ID
	 * seleccionado de la BBDD.
	 * 
	 * @param idNo, int, ID del video a eliminar
	 * @throws SQLException, si ocurre un error
	 */
	private void eliminarVideo(long idNo) throws SQLException {

		if (daoVideo.delete(idNo)) { // Video Eliminado

			alert = new Alert(Alert.SUCCESS, "Video eliminado.");

		} else { // Video no eliminado

			alert = new Alert();
			alert.setTexto("El video no puedo eliminarse. Posiblemente, no se encuentre en la base de datos.");
		}

	}

	private void setIdioma(HttpServletRequest request, HttpServletResponse response) {

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
	private void setCookieUltimaVisita(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		if (request.getSession() != session) {

			session = request.getSession(); // Capturar la sesión
			DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss"); // Formatear la fecha

			// Crear la cookie y darle un tiempo de vida
			Cookie cVisita = new Cookie("cVisita", URLEncoder.encode(formatter.format(new Date()).toString(), "UTF-8"));
			cVisita.setMaxAge(60 * 60 * 24 * 365); // 1 año

			// Enviar la cookie al navegador
			response.addCookie(cVisita);
		}

	}

}
