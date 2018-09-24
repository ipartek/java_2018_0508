package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
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

import com.ipartek.formacion.model.UsuariosDaoJDBC;
import com.ipartek.formacion.model.VideoArrayListDAO;
import com.ipartek.formacion.model.VideoDao;
import com.ipartek.formacion.model.VideoDaoJDBC;
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
	private static VideoDaoJDBC daoJdbc;
	
	private ArrayList<Video> videos;
	private Video videoInicio;
	private ArrayList<Video> listaVideos = new ArrayList<Video>();

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		//dao = VideoArrayListDAO.getInstance();
		daoJdbc = VideoDaoJDBC.getInstance();
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
		
		informacionCliente(request);
		
		super.service(request, response);  //llama a los metodos GET o POST
		Cookie recuerdame = new Cookie("recuerdame",(String) request.getSession().getAttribute("recuerdame"));
		
		//omprobamos si se ha elegido un idoma desde el selector
		String idioma = request.getParameter("idioma");
		
		//creanis session para poder acceder al atributo usuario para crear un obj Usuario**
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		
		/**
		 * Miramos si hay valor en la cookie donde guardamos el check de recuerdame
		 * Si esta clickada añadimos con su valor por defecto on
		 * si por el contrario es null la ponemos a off para una mejor comprension de su estado
		 */
		if(recuerdame.getValue() != null) {
			System.out.println(recuerdame);
			response.addCookie(recuerdame);
		}else {
			recuerdame.setValue("off");
			response.addCookie(recuerdame);
		}
		
		/**
		 *  con el usuario obj sacado atraves de la sesion creo la cookie con el nombre del usuario
			que usaremos para en caso de que el check recuerdame este en on poner el nombre de usuario
			en el campo usuario del login
			
		 */
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
		
		if(idioma != null) {
			/**
			 * tengo que redireccionar nuevamente para que refresquen el cambio de lenguaje
			 * solo entrara aqui cuando se clikca en los enlaces de lenguajes
			 * actualiza lenguaje redirecciona nuevamente al controlador
			 * no pasando por aqui esa segunda vez y estando en la vista ya el valor del nuevo lenguaje
			 * 
			 */
			Cookie cookieIdioma = new Cookie("cookieIdioma",idioma);
			String[] parts = idioma.split("_");
			Locale locale = new Locale(parts[0],parts[1]);
			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
			response.addCookie(cookieIdioma);
			response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}else {
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		
		
		
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
			//videos = (ArrayList<Video>) dao.getAll();comento JDBC
			videos = (ArrayList<Video>) daoJdbc.getAll();
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
				//videoInicio = dao.getById(id);JDBC
				videoInicio = daoJdbc.getById(id);
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
				
				//dao.insert(videoInicio);JDBC
				daoJdbc.insert(videoInicio);
			}
			
			
			//pedir listado			
			//videos = (ArrayList<Video>) dao.getAll();
			videos = (ArrayList<Video>) daoJdbc.getAll();
			if(videoInicio.getNombreCancion() == null) {
				doGet(request,response);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	private void informacionCliente(HttpServletRequest req) {
		System.out.println("*******************************");
		
		
		System.out.println(req.getRemoteAddr());
		System.out.println(req.getRemoteHost());
		System.out.println(req.getRemotePort());
		System.out.println(req.getRemoteUser());
		System.out.println(req.getHeaderNames());
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("nombre"));
		
		
		Enumeration nombresCabeceras = req.getHeaderNames();
		
		String metaDato;
		System.out.println("Metadatos");
		while(nombresCabeceras.hasMoreElements()) {
			metaDato = (String) nombresCabeceras.nextElement();
			System.out.println(metaDato + ":" + req.getHeader(metaDato));
		}
		System.out.println("***Parametros***");
		//Map hmParametros = req.getParameterMap();
		
		System.out.println("*******************************");
		
	}

}