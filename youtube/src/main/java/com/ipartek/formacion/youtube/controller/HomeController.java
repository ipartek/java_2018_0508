package com.ipartek.formacion.youtube.controller;

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

import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
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
	private ArrayList<Video> videos;
	private Video videoInicio;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la primera peticion, el resto de peticiones iran al
		// service
		dao = VideoDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// Se ejecuta cuando se para el servidor
		dao = null;
	}

	/**
	 * Cada peticion de un cliente se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Antes de realizar GET o POST

		// System.out.println("Antes de GET o POST");

		// Gestion de cookies

		idioma(request, response);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String fecha = dateFormat.format(new Date());
		Cookie ultimaVisita = new Cookie("uVisita", URLEncoder.encode(fecha, "UTF-8"));
		ultimaVisita.setMaxAge(60 * 60 * 24 * 365); // 1 año
		response.addCookie(ultimaVisita);

		// Cookie cookies[] = request.getCookies();

		super.service(request, response); // llama a los metodos GET o POST

		request.setAttribute("fecha", URLEncoder.encode(fecha, "UTF-8"));
		// Despues de realizar GET o POST
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

		HttpSession session = request.getSession();
		Alert alert = null;
		
		try {

			// parametros
			String id = request.getParameter("id");
			String op = request.getParameter("op");

			// eliminar ?
			if (op != null && OP_ELIMINAR.equals(op)) {
				alert = new Alert();
				if(dao.delete(id)) {
					alert.setTexto("Se ha eliminado el video de la lista. :D");
					alert.setTipo(Alert.SUCCESS);
				}
			}

			// listado videos
			videos = (ArrayList<Video>) dao.getAll();

			// video de inicio
			videoInicio = new Video();
			if (id != null && !OP_ELIMINAR.equals(op)) {
				videoInicio = dao.getById(id);

				// guardar video si el usuario esta en session

				Usuario u = (Usuario) session.getAttribute("usuario");

				if (u != null) {

					ArrayList<Video> reproducidos = (ArrayList<Video>) session.getAttribute("videosUsuario");
					if (reproducidos == null) {
						reproducidos = new ArrayList<Video>();
					}
					reproducidos.add(videoInicio);
					session.setAttribute("videosUsuario", reproducidos);

				}

			} else if (!videos.isEmpty()) {
				videoInicio = videos.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Alert alert = null;
		
		try {

			// recoger parametros
			String codigo = request.getParameter("codigo");
			String nombre = request.getParameter("nombre");

			// insertar un video
			videoInicio = new Video(codigo, nombre);
			boolean añadido = dao.insert(videoInicio);
			alert =  new Alert();
			if(añadido) {
				alert.setTexto("Se ha añadido el video a la lista. :D");
				alert.setTipo(Alert.SUCCESS);
			}else {
				alert.setTexto("El video no se ha podido añadir, igual ya existe en la lista. :D");
				alert.setTipo(Alert.WARNING);
			}

			// pedir listado
			videos = (ArrayList<Video>) dao.getAll();

		}catch (Exception e) {
			e.printStackTrace();
			alert =  new Alert();
		}finally {
			session.setAttribute("alert", alert);
		}
	}

	private void idioma(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String idioma = request.getParameter("idioma");
		try {

			if (idioma == null) {
				idioma = (String) session.getAttribute("idioma");
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
			// guardar en session
			session.setAttribute("idioma", idioma);
		}

	}

}