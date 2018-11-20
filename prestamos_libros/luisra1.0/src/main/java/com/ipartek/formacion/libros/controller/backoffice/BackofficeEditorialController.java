package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.service.ServiceEditorial;


/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/editoriales")
public class BackofficeEditorialController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	private static ServiceEditorial editorialService = null;
	private final static Logger LOG = Logger.getLogger(BackofficeEditorialController.class);

	private static final String VIEW_LISTADO = "editoriales/index.jsp";
	private static final String VIEW_FORMULARIO = "editoriales/form.jsp";

	private String view;
	private Alert alert;

	private String op; // Operacion a realizar

	private String id;
	private String nombre;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		editorialService = ServiceEditorial.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		editorialService = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		alert = null;
		
		try {

			getParameters(request);
			
			if(nombre != null) {
				alert = new Alert();
				nombre= nombre.trim();
				if(nombre.length() <= 2 || nombre.length() >= 50) {
					
					throw new Exception("El nombre de la Editorial debe tener entre 2 y 50 caracteres");				
				}
			}

			switch (op) {
			case OP_ELIMINAR:

				eliminar(request);
				break;
			case OP_IR_FORMULARIO:

				irFormularioDeAlta(request);
				break;
			case OP_GUARDAR:

				guardar(request);
				break;
			default: // LISTAR

				listar(request);
				break;
			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada
			LOG.debug(e.getMessage());
			alert = new Alert(Alert.WARNING, "Esta intentando alterar un registro que tiene relacion con otros");

		} catch (SQLException e) { // Longitud de campos incorrecta
			LOG.debug(e.getMessage());
			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			

		} catch (Exception e) { // Errores que no son de SQL
			LOG.debug(e.getMessage());
			alert = new Alert();
			alert.setTipo(Alert.DANGER);
			alert.setTexto(e.getMessage());
			view = VIEW_LISTADO;
			
			
		} finally {

			request.getSession().setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
	}
	

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		
		view = VIEW_LISTADO;
		request.getSession().setAttribute("editoriales", editorialService.listar());
	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException {
		Editorial editorial = new Editorial();
		
		editorial.setId(Long.parseLong(id));
		editorial.setNombre(nombre);

		try {

			if (editorial.getId() > 0) {
				
				editorialService.modificar(editorial);//UPDATE
				alert = new Alert(Alert.SUCCESS, "Editorial modificado.");
				listar(request);
			} else {
				
				editorialService.crear(editorial); // INSERT
				alert = new Alert(Alert.SUCCESS, "Editorial creado.");
				listar(request);
			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada
			LOG.debug(e.getMessage());
			view = VIEW_LISTADO;
			alert = new Alert(Alert.WARNING, "La editorial ya existe.");
			view = VIEW_FORMULARIO;

		} catch (SQLException e) { // Longitud de campos incorrecta
			LOG.debug(e.getMessage());
			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			view = VIEW_FORMULARIO;
			

		} catch (Exception e) { // Errores que no son de SQL
			LOG.debug(e.getMessage());
			alert = new Alert();
			view = VIEW_FORMULARIO;
			
		}

		
		request.setAttribute("editorial", editorial);

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws Exception {
		alert = null;

		if (id.equalsIgnoreCase("-1")) {
			
			request.getSession().setAttribute("editorial", new Editorial());
		
		} else {
			
			request.getSession().setAttribute("editorial", editorialService.obtener(Long.parseLong(id)));
		}

		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		

			if (editorialService.eliminar(id)) {
				
				alert = new Alert(Alert.SUCCESS, "Editorial eliminado.");
				view = VIEW_LISTADO;
				listar(request);
			}else {
				
				alert = new Alert(Alert.WARNING, "No podemos eliminar la editorial porque tiene libros asociados.");
				view = VIEW_LISTADO;
				
			}

		

			
		
	}

}