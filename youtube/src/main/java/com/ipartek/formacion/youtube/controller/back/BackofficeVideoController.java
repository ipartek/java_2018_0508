package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoDAO daoVideo = null;
	private static UsuarioDAO daoUsuario = null;
	private ArrayList<Usuario> usuarios;
	
	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2";  //insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	
	private static final String VIEW_LISTADO = "videos/index.jsp";
	private static final String VIEW_FORMULARIO = "videos/formulario.jsp";
	private String view;
	private Alert alert;
	
	private String op; //operacion a realizar
	private String id;
	private String codigo;
	private String nombre;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			alert = new Alert();
			
			getParameters(request);
			
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

			default:  //LISTAR
				listar(request);
				break;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
			alert = new Alert();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
			
		}
		
	}
	
	private void listar(HttpServletRequest request) throws Exception {
		
		alert = null;		
		view = VIEW_LISTADO;
		request.setAttribute("videos", daoVideo.getAll());		
		
	}
	
	private void guardar(HttpServletRequest request) throws Exception {
		
		Video v = new Video();
		v.setId(Long.parseLong(id));
		v.setCodigo(codigo);
		v.setNombre(nombre);
		
		try {
			if( v.getId() > 0 ) {                // UPDATE
				daoVideo.update(v);
			}else {                              //INSERT
				daoVideo.insert(v);
			}
			
			alert = new Alert(Alert.SUCCESS, "Video guardado con exito");

		}catch(Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
		view = VIEW_FORMULARIO;
		request.setAttribute("video", v);
		
	}
	
	private void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = VIEW_FORMULARIO;
		
		usuarios = (ArrayList<Usuario>)daoUsuario.getAll();
		
		if ( id.equalsIgnoreCase("-1")) {
			request.setAttribute("usuarios", usuarios );
			request.setAttribute("video", new Video() );
		}else {	
			request.setAttribute("usuarios", usuarios );
			request.setAttribute("video", daoVideo.getById(id));
		}
	}
	
	private void eliminar(HttpServletRequest request) throws Exception{
		try {
			daoVideo.delete(id);
			alert = new Alert(Alert.SUCCESS, "Video Eliminado");
		}catch(Exception e) {
			alert = new Alert(Alert.WARNING, "No hemos podido eliminar este video");
		}
		view = VIEW_LISTADO;
		request.setAttribute("video", daoVideo.getAll());
	}
	
	private void getParameters(HttpServletRequest request) {
		op = ( request.getParameter("op") != null ) ? request.getParameter("op") : OP_LISTAR;		
		id = request.getParameter("id");
		codigo = request.getParameter("codigo");
		nombre = request.getParameter("nombre");
	}

}
