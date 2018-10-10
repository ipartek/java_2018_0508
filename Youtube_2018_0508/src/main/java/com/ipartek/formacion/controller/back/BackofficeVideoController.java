package com.ipartek.formacion.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.UsuarioDAO;
import com.ipartek.formacion.model.VideoDAO;
import com.ipartek.formacion.pojo.Alert;
import com.ipartek.formacion.pojo.Video;

/**
 * Servlet implementation class BackofficeVideoController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet implements CrudControllable{
	private static final long serialVersionUID = 1L;
	
	private static VideoDAO daoVideo = null;
	private static UsuarioDAO daoUsuario = null;
	
	Alert alert = null;
	String view = "";
	
	private static final String VIEW_FORM_VIDEOS = "videos/form.jsp";
	private static final String VIEW_INDEX_VIDEOS = "videos/index.jsp";
	
	//Parametros
	private String op; //Operacion a realizar
	private String id; //Id del video
	private String codigo;
	private String titulo; //Nombre del video
	private String usuario; //ID del usuario
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		alert = null;
		daoVideo = VideoDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
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
	public void doProcess(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		try {
			alert=null;
			
			//Recoge los parametros de la request y los guarda en variables
			getParameters(request);
			
			//Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {
				case OP_ELIMINAR:
					eliminar(request); //Elimina un video de la bbdd
					break;
					
				case OP_GUARDAR:
					guardar(request); //Crea o modifica un video en la bbdd
					break;
					
				case OP_IR_FORMULARIO:
					irFormulario(request); //Cambia a la vista del formulario de gestion de video
					break;
	
				default: //Listar
					listar(request); //Cambia a la vista de listado de videos
					break;
			}
		}catch(Exception e) {
			e.printStackTrace();
			view = VIEW_INDEX_VIDEOS;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	@Override
	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op"): OP_LISTAR; 
		id = request.getParameter("id");
		codigo = request.getParameter("codigo");
		titulo = request.getParameter("titulo");
		usuario = request.getParameter("usuario");
	}

	@Override
	public void listar(HttpServletRequest request) {
		view = VIEW_INDEX_VIDEOS;
		try {
			request.setAttribute("videos", daoVideo.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		Video video = null;
		if(Integer.parseInt(id)>0) {
			video = daoVideo.getById(id);
		}else {
			video = new Video();
		}
		request.setAttribute("video", video);
		request.setAttribute("usuarios", daoUsuario.getAll());
		view = VIEW_FORM_VIDEOS;
	}

	@Override
	public void guardar(HttpServletRequest request) {
		Video video = null;
		try {
			video = new Video();
			video.setTitulo(titulo);
			video.setCodigo(codigo);
			
			video.setUsuario(daoUsuario.getById(usuario));
			//video.setUsuario(new Usuario(Long.parseLong(usuario)));
			
				if(id.equals("")) {
					//Crear Video nuevo
					daoVideo.insert(video);
				}else{
					//Modificar Video existente
					video.setId(Long.parseLong(id));
					daoVideo.update(video);
				}
				alert = new Alert(Alert.ALERT_SUCCESS, "Vídeo guardado con éxito.");
				request.setAttribute("usuarios", daoUsuario.getAll());					
			}catch(SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				alert = new Alert(Alert.ALERT_WARNING, "El código del vídeo ya existe.");
			}
			//Longitud campos titulo y codigo
			catch(SQLException e) {
				e.printStackTrace();
				if(e.getMessage().contains("nombre")) {
					alert = new Alert(Alert.ALERT_WARNING, "El nombre del vídeo debe tener máx. 150 caracteres.");
				}else if(e.getMessage().contains("codigo")) {
					alert = new Alert(Alert.ALERT_WARNING, "El código del vídeo debe ser de 11 caracteres exactos.");
				}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
	
		request.setAttribute("video", video);
		view = VIEW_FORM_VIDEOS;
	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		try {
			daoVideo.delete(id);
			alert = new Alert(Alert.ALERT_SUCCESS, "Registro borrado con éxito.");
		}catch(Exception e) {
			e.printStackTrace();
			alert = new Alert(Alert.ALERT_WARNING, "No se ha podido eliminar el registro.");
		}
		view = VIEW_INDEX_VIDEOS;
		request.setAttribute("videos", daoVideo.getAll());
	}

}
