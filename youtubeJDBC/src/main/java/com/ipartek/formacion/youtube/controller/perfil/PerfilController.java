package com.ipartek.formacion.youtube.controller.perfil;


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

import org.jsoup.Connection.Request;

import com.ipartek.formacion.youtube.model.ComentariosDao;
import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/perfil/inicio")
public class PerfilController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String OP_ELIMINAR = "1";
	public static final String OP_MODIFICAR = "2";
	public static final String OP_VIDEO = "5";
	public static final String OP_COMENTARIO = "6";
	public static final String OP_PRINCIPAL = "-1";
	public static final String VISTA_PRINCIPAL = "/perfil/index.jsp";
	public static final String VISTA_VIDEO = "/perfil/video/index.jsp";
	public static final String VISTA_COMENTARIO = "/perfil/comentario/index.jsp";
	private static VideoDAO videosDao;
	private static ComentariosDao comentariosDao;
	private ArrayList<Comentario> comentarios;
	private static UsuariosDaoJDBC usuariosDao;
	private ArrayList<Video> videos;	
	private Video videoInicio;
	String editar = null;
	String op = "";
	String accion = "";
	String vista  ;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		videosDao = VideoDAO.getInstance();
		comentariosDao = comentariosDao.getInstance();
		usuariosDao = usuariosDao.getInstance();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		videosDao = null;
		comentariosDao = null;
		
	}
	
	
	/**
	 * Cada request se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		super.service(request, response);  //llama a los metodos GET o POST

	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			doProcess(request,response);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			doProcess(request,response);

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			try {
				System.out.println("DoProcess en PerfilController");
				//videos = null;
				HttpSession session = request.getSession();
				getParameters(request);
				
				switch (op) {
				case OP_VIDEO:
					switch (accion) {

					case OP_MODIFICAR:
						listarVideos(session);
						break;
					case OP_ELIMINAR:
						listarVideos(session);
						break;

					default:
						listarVideos(session);
					}
					break;
				case OP_COMENTARIO:
					switch (accion) {

					case OP_MODIFICAR:
						listarComentarios(session);
						break;
					case OP_ELIMINAR:
						listarComentarios(session);
						break;

					default:
						listarComentarios(session);
						break;
					}
				/*case OP_PRINCIPAL:
					switch (accion) {
					default:
						vista = VISTA_PRINCIPAL;
					}*/
				
				
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (vista == null || "-1".contentEquals(op)) {
					vista = VISTA_PRINCIPAL;
				}
				request.setAttribute("videos", videos);
				request.setAttribute("comentarios", comentarios);
				request.getRequestDispatcher(vista).forward(request, response);
			}
		
	}


	private void getParameters(HttpServletRequest request) {
		op = request.getParameter("op");
		accion = request.getParameter("accion");
		if (accion == null) {
			accion = "";
		}
		if (op == null) {
			op = "";
		}
		
		
	}


	private void listarComentarios(HttpSession session) {
		try {
			Usuario u = (Usuario) session.getAttribute("usuario");
			vista = VISTA_COMENTARIO;
			comentarios = (ArrayList<Comentario>) comentariosDao.getAllByActiveUser(u);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}	
	}


	private void listarVideos(HttpSession session) {
		/**
		 * Lista videos filtrados por usuario
		 */
		try {
			Usuario u = (Usuario) session.getAttribute("usuario");

			videos = (ArrayList<Video>) videosDao.getByActiveUser(u);
			vista = VISTA_VIDEO;
		} catch (Exception e) {
			e.printStackTrace();
			
		}	
		
	}

}


