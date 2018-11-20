package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Time;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Rol;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/comentarios")
public class BackofficeComentarioController extends HttpServlet implements CrudControllable {
	
	
	private static final long serialVersionUID = 1L;
	private static ComentarioDAO daoComentario = null;
	private static UsuarioDAO daoUsuario = null;
	private static VideoDAO daoVideo = null;
	
	private static final String VIEW_LISTADO = "comentarios/index.jsp";
	private static final String VIEW_FORMULARIO = "comentarios/form.jsp";
	private String view;
	private Alert alert;
	
	private String op; //operacion a realizar
	private String id;
	private Date fecha;
	private String texto;
	private boolean aprobado;
	private String id_video;
	private String id_usuario;
		
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		daoComentario  = ComentarioDAO.getInstance();
		daoVideo  = VideoDAO.getInstance();
		daoUsuario  = UsuarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		daoComentario = null;
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
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

	public void listar(HttpServletRequest request) throws Exception {
		
		alert = null;		
		view = VIEW_LISTADO;
		request.setAttribute("comentarios", daoComentario.getAll());		
		
	}

	public void guardar(HttpServletRequest request) {
		
		Comentario c;
		try {
			c = new Comentario();
			c.setId(Long.parseLong(id));
			c.setFecha(fecha);
			c.setTexto(texto);
			c.setAprobado(aprobado);
			c.setVideo(daoVideo.getById(id_video));
			
			try {
				c.setUsuario(daoUsuario.getById(id_usuario));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			try {
				if( c.getId() > 0 ) {			
					daoComentario.update(c);				
				}else {                 
					daoComentario.insert(c);				
				}			
				alert = new Alert(Alert.SUCCESS, "Comentario guardado con exito");	
			}catch (Exception e) {
				e.printStackTrace();
				alert = new Alert();
			}
			
			view = VIEW_FORMULARIO;
			request.setAttribute("comentario", c);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = VIEW_FORMULARIO;
		if ( id.equalsIgnoreCase("-1")) {
			request.setAttribute("comentario", new Comentario() );
		}else {			
			request.setAttribute("comentario", daoComentario.getById(id));
		}
	}

	
	public void eliminar(HttpServletRequest request) throws Exception {
		
		try {
			if ( daoComentario.delete(id)) {
				alert = new Alert(Alert.SUCCESS, "Comentario Eliminado");
			}else {
				alert = new Alert(Alert.WARNING, "NO se puedo Eliminar");
			}	
		}catch (Exception e) {
			alert = new Alert();
		}	
		view = VIEW_LISTADO;
		request.setAttribute("comentarios", daoComentario.getAll());	
		
	}

	public void getParameters(HttpServletRequest request) {		
		op = ( request.getParameter("op") != null ) ? request.getParameter("op") : OP_LISTAR;		
		id = request.getParameter("id");
		//fecha = Time.parse(arg0)request.getParameter("fecha");		
	}

}
