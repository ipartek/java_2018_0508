package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Comentario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/comentarios")
public class BackofficeComentarioController extends HttpServlet implements CrudControllable{
	private static final long serialVersionUID = 1L;
	private static ComentarioDAO daoComentario = null;
	private static VideoDAO daoVideo = null;
	private static UsuarioDAO daoUsuario = null;
	
	private static final String VIEW_LISTADO = "comentarios/index.jsp";
	private static final String VIEW_FORMULARIO = "comentarios/form.jsp";
	private String view;
	private Alert alert;
	
	private String op; //operacion a realizar
	private String id;
	private String texto;
	private boolean aprobado;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		daoComentario = ComentarioDAO.getInstance();
		daoVideo = VideoDAO.getInstance();
		daoUsuario= UsuarioDAO.getInstance();
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
		int totalComentarios=daoComentario.getAll().size();
		
		request.setAttribute("totalComentarios", totalComentarios);	
		request.setAttribute("comentarios", daoComentario.getAll());		
		
	}

	public void guardar(HttpServletRequest request) {
		Comentario c = new Comentario();
		
		try {
			
			c.setId(Long.parseLong(id));
			c.setTexto(texto);
			c.setAprobado(aprobado);
		
		
			if( c.getId() > 0 ) {			
				daoComentario.update(c);				
			}else {                 
				daoComentario.insert(c);				
			}			
			alert = new Alert(Alert.SUCCESS, "Comentario guardado con exito");	
	
		
		
			
		// nombre repetido
		} catch ( SQLIntegrityConstraintViolationException e ) {
			e.printStackTrace();
			alert = new Alert(Alert.WARNING, "<b>" + c.getTexto() +  "</b> ya existe !!!" );
		
		//longitud campos nombre y password
		}catch (SQLException e) {
			e.printStackTrace();
			if ( e.getMessage().contains("nombre")) {
				alert = new Alert(Alert.WARNING, "El <b>nombre</b> debe ser inferior a 50 caracteres");
			}else {
				alert = new Alert(Alert.WARNING, "La <b>contraseña</b> debe ser inferior a 20 caracteres");
			}			
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}	
		
		
		view = VIEW_FORMULARIO;
		request.setAttribute("comentario", c);
		
		try {
			request.setAttribute("videos", daoVideo.getAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = VIEW_FORMULARIO;
		if ( id.equalsIgnoreCase("-1")) {
			request.setAttribute("comentario", new Comentario() );
		}else {			
			request.setAttribute("comentario", daoComentario.getById( Long.parseLong(id)));
		}
		
		request.setAttribute("videos", daoVideo.getAll());
	}

	
	public void eliminar(HttpServletRequest request) throws Exception {
		
		try {
			daoComentario.delete(Long.parseLong(id));
			alert = new Alert(Alert.SUCCESS, "Comentario Eliminado");
		}catch (Exception e) {
			alert = new Alert(Alert.WARNING, "No podemos eliminar el comentario");
		}	
		view = VIEW_LISTADO;
		request.setAttribute("comentarios", daoComentario.getAll());	
		
	}

	public void getParameters(HttpServletRequest request) {
		
		op = ( request.getParameter("op") != null ) ? request.getParameter("op") : OP_LISTAR;		
		id = request.getParameter("id");
		texto = request.getParameter("texto");

	}
}