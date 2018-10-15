package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.ComentariosDao;
import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/backoffice/comentario")
public class BackofficeComentariosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String vista = "lista-comentario";
	private static final String VIEW_INICIO = "/comentario/index.jsp";
	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	
	Alert alerta ;
	String op ;
	String id ;
	String usuarioId;
	String videoId;
	String texto;
	
	private static UsuariosDaoJDBC usuariosJDBC;
	private ArrayList<Usuario> usuarios;
	private static VideoDAO videosDao;
	private ArrayList<Video> videos;
	private static ComentariosDao comentariosDao;
	private static ArrayList<Comentario> comentarios;


	String editar = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		comentariosDao = ComentariosDao.getInstance();
		usuariosJDBC = usuariosJDBC.getInstance();
		videosDao = videosDao.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor

		comentariosDao = null;
	}

	/**
	 * Cada request se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Antes de realizar GET o POST");

		super.service(request, response); // llama a los metodos GET o POST

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			doProcess(request, response);

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
			doProcess(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			getParameters(request);
			
			if(op == null) {
				op = "";
			}
			switch (op) {
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_IR_FORMULARIO:
				irFormulario(request);
				break;
			case OP_GUARDAR:
				guardar(request);
				break;

			default: // LISTAR
				listar(request);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("videos", videos);
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("comentarios", comentarios);
			request.setAttribute("vista", vista);
			request.getRequestDispatcher("comentario/index.jsp").forward(request,response);
		}

	}

	private void getParameters(HttpServletRequest request) {
		op = request.getParameter("op");
		vista = request.getParameter("vista");
		usuarioId = request.getParameter("usuarioId");
		videoId = request.getParameter("videoId");
		id = request.getParameter("id");
		texto = request.getParameter("texto");
		
		
	}

	private void listar(HttpServletRequest request) throws Exception {
		comentarios = (ArrayList<Comentario>) comentariosDao.getAll();
		vista = "lista-comentario";
		
	}

	private void guardar(HttpServletRequest request) throws Exception {
		if(id != null) {
			if("".contentEquals(id)) {//creamos
				Usuario u = new Usuario();
				u.setId(Long.parseLong(usuarioId));
				Video v = new Video();
				v.setId(Long.parseLong(videoId));
				Comentario c = new Comentario();
				c.setTexto(texto);
				c.setUsuario(u);
				c.setVideo(v);
				comentariosDao.insert(c);
			}else {
				Usuario u = new Usuario();
				u.setId(Long.parseLong(usuarioId));
				Video v = new Video();
				v.setId(Long.parseLong(videoId));
				Comentario c = new Comentario();
				c.setId(Long.parseLong(id));
				c.setTexto(texto);
				c.setUsuario(u);
				c.setVideo(v);
				comentariosDao.update(c);
			}
			
		}
		
	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		Comentario comentarioSeleccionado = new Comentario();
		vista = "form-comentario";
		usuarios = (ArrayList<Usuario>) usuariosJDBC.getAll();
		videos = (ArrayList<Video>) videosDao.getAll();
		if (id != null) {
			comentarioSeleccionado = comentariosDao.getById(id);
			request.setAttribute("comentarioSeleccionado", comentarioSeleccionado);
		}
	}

	private void eliminar(HttpServletRequest request) throws Exception {
		comentariosDao.delete(id);
		
	}

}
