package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import com.ipartek.formacion.youtube.model.VideoYoutubeDAO;
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
	private static VideoYoutubeDAO dao;
	private ArrayList<VideoYoutube> videos;
	private VideoYoutube videoInicio;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = VideoYoutubeDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor
		dao = null;
	}

	/**
	 * Cada request se ejecuta en un hilo o thread.
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Antes de realizar GET o POST");
		setIdioma(request, response);

		super.service(request, response); // Llama a los metodos GET o POST

		session = request.getSession();

		setCookieUltimaVisita(request, response);

		// Después de realizar GET o POST
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

			cargarVideos(request, response);

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

			// recoger parametros
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");

			// insertar
			videoInicio = new VideoYoutube();
			dao.insert(videoInicio);

			// pedir listado
			videos = (ArrayList<VideoYoutube>) dao.getAll();

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
				// conseguir idioma del usuario a traves de la request
				idioma = request.getLocale().toString();
				if (idioma.length() != 5) {
					idioma = "es_ES";
				}
			}
		} catch (Exception e) {
			idioma = "es_ES";
		} finally {
			// Guardar en session el idioma
			session.setAttribute("idioma", idioma);
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

		// Parametros
		String id = request.getParameter("id");
		String op = request.getParameter("op");
		
		int idNo;
		
		if (id != null) {
			idNo = Integer.parseInt(id);
		} else {
			idNo = 1;
		}
		

		// Eliminar ?
		if (op != null && OP_ELIMINAR.equals(op)) {
			dao.delete(idNo);
		}

		// Listado videos
		videos = (ArrayList<VideoYoutube>) dao.getAll();

		// Video de inicio
		videoInicio = new VideoYoutube();
		if (id != null && !OP_ELIMINAR.equals(op)) {
			videoInicio = dao.getById(idNo);

			// Guardar video reproducido si esta usuario logueado

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

}
