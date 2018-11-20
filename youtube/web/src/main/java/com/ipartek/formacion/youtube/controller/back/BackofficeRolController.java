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
import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.pojo.Rol;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/roles")
public class BackofficeRolController extends HttpServlet implements CrudControllable{
	private static final long serialVersionUID = 1L;
	private static RolDAO daoRol = null;
	
	private static final String VIEW_LISTADO = "roles/index.jsp";
	private static final String VIEW_FORMULARIO = "roles/form.jsp";
	private String view;
	private Alert alert;
	
	private String op; //operacion a realizar
	private String id;
	private String nombre;
		
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		daoRol  = RolDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		daoRol = null;
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
		
		int totalRoles=daoRol.getAll().size();
		
		request.setAttribute("totalRoles", totalRoles);
		request.setAttribute("roles", daoRol.getAll());		
		
	}

	public void guardar(HttpServletRequest request) {
		
		Rol r = new Rol();
		r.setId(Long.parseLong(id));
		r.setNombre(nombre);		
		
		try {
			if( r.getId() > 0 ) {			
				daoRol.update(r);				
			}else {                 
				daoRol.insert(r);				
			}			
			alert = new Alert(Alert.SUCCESS, "Rol guardado con exito");	
	
		// nombre repetido
		} catch ( SQLIntegrityConstraintViolationException e ) {
			e.printStackTrace();
			alert = new Alert(Alert.WARNING, "<b>" + r.getNombre() +  "</b> ya existe !!!" );
		
		//longitud campos nombre y password
		}catch (SQLException e) {
			e.printStackTrace();			
			alert = new Alert(Alert.WARNING, "El <b>nombre</b> debe ser inferior a 50 caracteres");					
		}catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}	
				
		view = VIEW_FORMULARIO;
		request.setAttribute("rol", r);
		
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = VIEW_FORMULARIO;
		if ( id.equalsIgnoreCase("-1")) {
			request.setAttribute("rol", new Rol() );
		}else {			
			request.setAttribute("rol", daoRol.getById( Long.parseLong(id)));
		}
	}

	
	public void eliminar(HttpServletRequest request) throws Exception {
		
		try {
			if ( daoRol.delete(Long.parseLong(id))) {
				alert = new Alert(Alert.SUCCESS, "Rol Eliminado");
			}else {
				alert = new Alert(Alert.WARNING, "NO se puedo Eliminar");
			}	
		}catch (Exception e) {
			alert = new Alert(Alert.WARNING, "No podemos eliminar el rol porque tiene usuarios asociados");
		}	
		view = VIEW_LISTADO;
		request.setAttribute("roles", daoRol.getAll());	
		
	}

	public void getParameters(HttpServletRequest request) {		
		op = ( request.getParameter("op") != null ) ? request.getParameter("op") : OP_LISTAR;		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");		
	}

}