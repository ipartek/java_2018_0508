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

import com.ipartek.formacion.model.VideoArrayListDAO;
import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class VideoYoutubeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String OP_ELIMINAR = "1";
	private static VideoArrayListDAO dao;
	private ArrayList<Video> videos;
	private Video videoInicio;
	private ArrayList<Video> listaVideos = new ArrayList<Video>();

	
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
		System.out.println("Antes de realizar GET o POST VideoYoutubeController");
		
		
		
		//recuperar todas las cookies
		Cookie coockies[]  = request.getCookies();
		
		super.service(request, response);  //llama a los metodos GET o POST
		Cookie recuerdame = new Cookie("recuerdame",(String) request.getSession().getAttribute("recuerdame"));
		
		
		
		//comprobamos si se ha elegido un idoma desde el selector
		String idioma = request.getParameter("idioma");
		System.out.println(idioma);
		if(idioma != null) {
			Cookie cookieIdioma = new Cookie("cookieIdioma",idioma);
			String[] parts = idioma.split("_");
			Locale locale = new Locale(parts[0],parts[1]);
			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
			response.addCookie(cookieIdioma);
		}
		
		//guardo historial
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		
		if(recuerdame.getValue() != null) {
			System.out.println(recuerdame);
			response.addCookie(recuerdame);
		}else {
			recuerdame.setValue("off");
			response.addCookie(recuerdame);
		}
		
		
		System.out.println(request.getParameter("usuario"));
		if("on".equals(request.getSession().getAttribute("recuerdame"))) {
			
			System.out.println("Tenemos on en recuerdame");
			System.out.println("Pasamos a crear cookie con el nombre de usuario a recordar");
			if(u != null) {
				
				Cookie usuarioRecordar = new Cookie("usuarioRecordar",u.getNombre()) ;
				response.addCookie(usuarioRecordar);
			}
		}
				
		//despues de realizar GET o POST
		if(listaVideos != null) {
			request.setAttribute("listaVideos", listaVideos);
		}
		
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
			//guardo historial
			HttpSession session = request.getSession();
			Usuario usaurio = (Usuario) session.getAttribute("usuario");
			
			//Historico de canciones reproducidas
			//Nos aseguramos que haya sesion de usuario logueado
			if (usaurio != null) {
				//Vemos que se haya clickado algun video
				if(id != null) {
					for(Video v : videos) {
						if (id.contentEquals(v.getId()) ) {
							listaVideos.add(v);
						}
					}
				}
			}
			
			
			//video de inicio
			videoInicio = new Video();
			if ( id != null && !OP_ELIMINAR.equals(op) ) {
				videoInicio = dao.getById(id);
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
			
			System.out.println(nombre);
			
			//insertar
			videoInicio = new Video(id, nombre);
			//solo le dejamos insertar si hay valores en el video
			if (videoInicio.getId() != null && videoInicio.getNombreCancion() != null) {
				dao.insert(videoInicio);
			}
			
			
			//pedir listado			
			videos = (ArrayList<Video>) dao.getAll();
			if(videoInicio.getNombreCancion() == null) {
				doGet(request,response);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}