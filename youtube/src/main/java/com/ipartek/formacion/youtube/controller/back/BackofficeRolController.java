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

import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/roles")
public class BackofficeRolController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static RolDAO daoRol = null;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2";// INSERT id=-1 O UPDATE id>0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	private static final String VIEW_LISTADO = "roles/index.jsp";
	private static final String VIEW_FORMULARIO = "roles/form.jsp";

	private String view;
	private Alert alerta;

	private String op;// operacion a realizar
	private String id;
	private String nombre;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoRol = RolDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoRol = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			alerta = new Alert();
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

			default:// LISTAR

				listar(request);
				break;
			
			// buscar operacion a realizar
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			alerta = new Alert();
		} finally {

			request.setAttribute("alert", alerta);
			request.getRequestDispatcher(view).forward(request, response);
			try {
				listar(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void guardar(HttpServletRequest request) {
		Rol rol = new Rol();
		rol.setNombre(nombre);
		rol.setId(Long.parseLong(id));
		
		

		try {
			if (rol.getId() == -1) {
				daoRol.insert(rol);
				alerta = new Alert(Alert.SUCCESS, "Rol " + rol.getNombre() + " añadido correctamente");
				
			} else {
				daoRol.update(rol);
				alerta = new Alert(Alert.SUCCESS, "Rol " + rol.getNombre() + " modificado correctamente");
			}

			

		} catch (SQLIntegrityConstraintViolationException e) {// nombre repetido
			e.printStackTrace();
			alerta = new Alert(Alert.WARNING, "El rol " + rol.getNombre() + " ya existe!!");
		} catch (SQLException e) {
			if (e.getMessage().contains("nombre")) {
				alerta = new Alert(Alert.WARNING, "El nombre de rol debe ser inferior a 50 caracteres");

			} 
		} catch (Exception e) {
			e.printStackTrace();
			alerta = new Alert();
			// longitud de campos nombre y password

		}
		view = VIEW_FORMULARIO;
		request.setAttribute("rol", rol);
	}

	private void listar(HttpServletRequest request) throws Exception {
		alerta = null;
		view = VIEW_LISTADO;
		int numRoles = daoRol.getAll().size();
		request.setAttribute("roles", daoRol.getAll());
		request.setAttribute("numRoles", numRoles);
	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		alerta = null;
		view = VIEW_FORMULARIO;
		if (id.equalsIgnoreCase("-1")) {
			request.setAttribute("rol", new Rol());
		} else {

			request.setAttribute("rol", daoRol.getById(Long.parseLong(id)));
		}

	}

	// TODO despues del cafe gestionar la Exception

	private void eliminar(HttpServletRequest request) throws Exception {
		view = VIEW_LISTADO;
		
		
		try {
			Rol rol = daoRol.getById(Long.parseLong(id));
			daoRol.delete(Long.parseLong(id));
			alerta = new Alert(Alert.SUCCESS, "Rol " + rol.getNombre() + " eliminado correctamente");
		}	catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				alerta = new Alert(Alert.WARNING, "El rol que intenta eliminar tiene usuarios asociados");
		} catch (Exception e) {
			e.printStackTrace();
			alerta= new Alert();
		}
		
		request.setAttribute("roles", daoRol.getAll());
		
		
		

	}

	private void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		
	}
}