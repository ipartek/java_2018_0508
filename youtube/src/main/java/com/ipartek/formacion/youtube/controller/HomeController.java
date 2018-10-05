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

import com.ipartek.formacion.youtube.model.VideoYoutubeDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.VideoYoutube;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HttpSession session;

	public static final String OP_ELIMINAR = "1";
	public static final String OP_MODIFICAR = "2";

	private static VideoYoutubeDAO dao;
	private ArrayList<VideoYoutube> videos;

	private VideoYoutube videoInicio;
	private Alert alert;

	String id;
	String op;
	String playlist = "";

	int idNo;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = VideoYoutubeDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// Se ejecuta al parar el servidor
		dao = null;
	}

	/**
	 * Cada request se ejecuta en un hilo o thread.
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ----- ANTES del GET o del POST --------
		// Recoger Parametros
		id = request.getParameter("id");
		op = request.getParameter("op");

		if (id != null) { // Casteamos a Integer
			idNo = Integer.parseInt(id);

		} else {
			idNo = 1;
			try {
				videos = (ArrayList<VideoYoutube>) dao.getAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Establecer idioma
		setIdioma(request, response);

		super.service(request, response); // LLAMADA a los metodos GET o POST

		// ------ DESPUÉS de realizar GET o POST -----
		session = request.getSession();

		// Guardar última visita en cookies
		setCookieUltimaVisita(request, response);

		// Actualizar listado
		try {
			videos = (ArrayList<VideoYoutube>) dao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cargarPlaylist();

		// Enviar Atributos
		request.setAttribute("videos", videos);
		request.setAttribute("playlist", playlist);
		request.setAttribute("videoInicio", videoInicio);
		request.setAttribute("alert", alert);
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	private void cargarPlaylist() {
		playlist = "";
		for (int i = 1; i < videos.size(); i++) {
			playlist += videos.get(i).getCod() + ",";
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			cargarVideos(request, response);

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

			if (op != null && OP_MODIFICAR.equals(op)) { // Modificar Video

				VideoYoutube video = dao.getById(idNo);

				String nuevoTitulo = request.getParameter("nuevoTitulo");
				String nuevoCodigo = request.getParameter("nuevoCod");

				video.setNombre(nuevoTitulo);
				video.setCod(nuevoCodigo);

				modificarVideo(video);
				alert = new Alert();
				alert.setTexto("Video correctamente modificado.");
				alert.setTipo(Alert.SUCCESS);

			} else {
				// Recoger parametros
				String cod = request.getParameter("cod");
				String nombre = request.getParameter("nombre");

				// Insertar Video
				videoInicio = new VideoYoutube(cod, nombre);
				insertarVideo(videoInicio);
			}

		} catch (Exception e) {
			e.printStackTrace();
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
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException, si no consigue formatear correctamente
	 *                                       la fecha
	 */
	private void setCookieUltimaVisita(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		if (request.getSession() != session) {
			session = request.getSession();

			// Gestionar cookies para la Última visita
			DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

			Cookie cVisita = new Cookie("cVisita", URLEncoder.encode(formatter.format(new Date()).toString(), "UTF-8"));
			cVisita.setMaxAge(60 * 60 * 24 * 365); // 1 año
			response.addCookie(cVisita);
		}

	}

	private void cargarVideos(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (op != null && OP_ELIMINAR.equals(op)) { // Eliminar Video
			eliminarVideo(idNo);
		}

		// Video de inicio
		videoInicio = new VideoYoutube();

		if (id != null && !OP_ELIMINAR.equals(op)) {
			videoInicio = dao.getById(idNo);

			// Guardar videos reproducido si esta usuario logueado
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");

			if (usuario != null) { // Logeado

				ArrayList<VideoYoutube> reproducidos = (ArrayList<VideoYoutube>) session.getAttribute("reproducidos");
				if (reproducidos == null) {
					reproducidos = new ArrayList<VideoYoutube>();
				}
				reproducidos.add(videoInicio);
				session.setAttribute("reproducidos", reproducidos);
			}

		} else if (!videos.isEmpty()) {
			videoInicio = videos.get(0);
		}
	}

	private void insertarVideo(VideoYoutube videoInicio) throws SQLException {

		alert = new Alert();

		if (!dao.insert(videoInicio)) { // Video insertado
			alert.setTexto("Lo sentimos, el video no ha sido correctamente insertado. Posiblemente, el código de video "
					+ "esté duplicado.");
			alert.setTipo(Alert.DANGER);

		} else { // Video no insertado
			alert.setTexto("El video se insertó correctamente.");
			alert.setTipo(Alert.SUCCESS);
			videoInicio = videos.get(0); // Recuperamos el primer video de la lista
		}
	}

	private void modificarVideo(VideoYoutube video) throws SQLException {

		if (dao.update(video)) {
			alert = new Alert(Alert.SUCCESS, "Video eliminado.");
		} else {
			alert = new Alert();
			alert.setTexto("El video no puedo modificarse. Posiblemente, no se encuentre en la base de datos.");
		}
	}

	private void eliminarVideo(int idNo) throws SQLException {

		if (dao.delete(idNo)) { // Video Eliminado
			alert = new Alert(Alert.SUCCESS, "Video eliminado.");
		} else { // Video no eliminado
			alert = new Alert();
			alert.setTexto("El video no puedo eliminarse. Posiblemente, no se encuentre en la base de datos.");
		}

	}

}
