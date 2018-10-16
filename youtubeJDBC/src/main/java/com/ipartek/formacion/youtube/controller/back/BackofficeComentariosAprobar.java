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
@WebServlet("/backoffice/comentario/aprobar")
public class BackofficeComentariosAprobar extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	private static final String VIEW_INICIO = "/comentario/index.jsp";
	public static final String OP_EDITAR = "1";
	public static final String OP_APROBAR = "5";

	
	Alert alerta ;
	String op ;
	String id ;
	String usuarioId;
	String videoId;
	String texto;
	String[] registros;
	
	private static UsuariosDaoJDBC usuariosJDBC;
	private ArrayList<Usuario> usuarios;
	private static VideoDAO videosDao;
	private ArrayList<Video> videos;
	private static ComentariosDao comentariosDao;
	private static ArrayList<Comentario> comentarios;
	private static ArrayList<Comentario> comentariosSinAprobar;


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
			getParameters(request);

			
			if(op == null) {
				op = "";
			}
			switch (op) {
			case OP_APROBAR:
				aprobar(request);
				break;
			
			default: // LISTAR
				listar(request);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("comentarios", comentariosSinAprobar);
			request.getRequestDispatcher("/backoffice/comentario/aprobar.jsp").forward(request,response);
		}
	}

	private void aprobar(HttpServletRequest request) {
		try {
			Comentario c = new Comentario();
			for (String s : registros) { 
				c = ComentariosDao.getInstance().getById(s);
				if (c != null) {
					c.setAprobado(true);
					comentariosDao.updateAprobado(c);					
				}
			}
			listar(request);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			getParameters(request);

			
			if(op == null) {
				op = "";
			}
			switch (op) {
			case OP_APROBAR:
				aprobar(request);
				break;	
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("comentarios", comentariosSinAprobar);
			request.getRequestDispatcher("/backoffice/comentario/aprobar.jsp").forward(request,response);
		}
	}

	

	private void getParameters(HttpServletRequest request) {
		op = request.getParameter("op");
		registros = request.getParameterValues(("registro"));
		if (registros != null) {
			op ="5";
		}

	}

	private void listar(HttpServletRequest request) throws Exception {
		comentariosSinAprobar = new ArrayList<Comentario>();
		comentarios = (ArrayList<Comentario>) comentariosDao.getAll();
		for(Comentario c : comentarios) {
			if(!c.isAprobado()) {
				comentariosSinAprobar.add(c);
			}
		}
		
		
		
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
