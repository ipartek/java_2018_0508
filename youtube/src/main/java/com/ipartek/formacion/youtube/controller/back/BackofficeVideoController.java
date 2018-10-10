package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class BackofficeVideoController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	private static VideoDAO daoVideo;
	private static UsuarioDAO daoUsuario;

	private static final String VIEW_LISTADO = "videos/index.jsp";
	private static final String VIEW_FORMUALRIO = "videos/formulario.jsp";
	private String view = "";
	private Alert alert;

	private String op;	//Operación a realizar
	private String id_video;
	private String nombre;
	private String codigo;
	private String id_usuario;

	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		daoVideo = VideoDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		daoVideo = null;
		daoUsuario = null;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			alert = null;
			
			getParameters(request,response);
			
			//Buscar operación a realizar
			
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

			default:
				listar(request);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
			alert = new Alert();
			
		}finally {
			//Vas a algún lao
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
			
		}
		
	}

	@Override
	public void getParameters(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		op = (request.getParameter("op") != null)?request.getParameter("op") : OP_LISTAR;
		id_video = request.getParameter("id");
		nombre = request.getParameter("nombre");		
		codigo = request.getParameter("cod");
		id_usuario = request.getParameter("usuario");
		
	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		
		try {
			view = VIEW_LISTADO;
			request.setAttribute("videos", daoVideo.getAll());
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		
		Video video = new Video();
		
		try {
			video.setId(Long.parseLong(id_video));
			video.setNombre(nombre);
			video.setCodigo(codigo);
			
			Usuario u = new Usuario();
			u.setId(Long.parseLong(id_usuario));
			video.setUsuario(u);
				
			if(video.getId() == -1) {	//Crear nuevo video
						
				daoVideo.insert(video);
				alert = new Alert(Alert.SUCCESS, "Video <b>" + video.getNombre() + "</b> creado con éxito");
						
			}else {		//Modificar video existente
						
				daoVideo.update(video);
				alert = new Alert(Alert.SUCCESS, "Video <b>" + video.getNombre() + "</b> modificado con éxito");
						
			}
				
		//Codigo repetido
		}catch(SQLIntegrityConstraintViolationException e){
			e.printStackTrace();
			alert = new Alert(Alert.WARNING, "El video con código <b>" + video.getCodigo() + "</b> ya existe.");
				
		//Longitud de campo codigo
		}catch (Exception e) {
			if(e.getMessage().contains("IDENTIFICADOR")) {
				alert = new Alert(Alert.WARNING, "El código debe ser exactamente de 11 caracteres.");
				e.printStackTrace();
				
			}else {
				e.printStackTrace();
				alert = new Alert();
			}

		}
			
		view = VIEW_FORMUALRIO;
		request.setAttribute("video", video);
		request.setAttribute("usuarios", daoUsuario.getAll());
		
	}
		

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		
		try {
			
			Video video = new Video();
			
			if(Integer.parseInt(id_video) > 0) {
				video = daoVideo.getById(Long.parseLong(id_video));
			}
			
			request.setAttribute("video", video);
			request.setAttribute("usuarios", daoUsuario.getAll());
			view = VIEW_FORMUALRIO;
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
		
		
	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {

		try {
			if(id_video != null && op != null && OP_ELIMINAR.equals(op)) {	//Eliminar
				Video v  = daoVideo.getById(Long.parseLong(id_video));
				if(daoVideo.delete(Long.parseLong(id_video))) {
					alert = new Alert(Alert.SUCCESS, "Video <b>" + v.getNombre() + "</b> eliminado correctamente");
					
				}else {
					alert = new Alert(Alert.WARNING, "No hemos podido eliminar el video");
				}
				
			}			
		
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
		listar(request);
		
		}
		
}


