package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.CrudControllable;
import com.ipartek.formacion.pojo.Alert;
import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.service.ServiceEditorial;

/**
 * Servlet implementation class EditorialController
 */
@WebServlet("/prestamo/editorial")
public class EditorialController extends HttpServlet implements CrudControllable{
	private static final long serialVersionUID = 1L;

//	private static EditorialDAO daoEditorial;
	
	private static ServiceEditorial serviceEditorial;

	private static final String OP_LISTAR = "1";
	private static final String OP_GUARDAR = "2"; // Insert o update en funcion del id (-1 o >0)
	private static final String OP_ELIMINAR = "3";
	private static final String OP_IR_FORMULARIO = "4";

	private String view = "";
	private Alert alert = null;

	private static final String VIEW_FORM_EDITORIAL = "editorial/formEditorial.jsp";
	private static final String VIEW_INDEX_EDITORIAL = "editorial/index.jsp";

	// Parametros
	private String op; // Operacion a realizar
	private String id;
	private String nombre;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
//		daoEditorial = EditorialDAO.getInstance();
		serviceEditorial = ServiceEditorial.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
//		daoEditorial = null;
		serviceEditorial = null;
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

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		view = VIEW_INDEX_EDITORIAL;
		try {
			alert = null;

			// Recoge los parametros de la request y los guarda en variables
			getParameters(request);

			// Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {
			case OP_ELIMINAR:
				eliminar(request); // Elimina una editorial de la bbdd
				break;

			case OP_GUARDAR:
				guardar(request); // Crea o modifica un editorial en la bbdd
				break;

			case OP_IR_FORMULARIO:
				irFormulario(request); //Cambia a la vista del formulario de gestion de editorial
				break;

			default: // Listar
				listar(request); // Cambia a la vista de listado de editoriales
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_INDEX_EDITORIAL;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	@Override
	public void listar(HttpServletRequest request) {
		try {
//			request.setAttribute("editoriales", daoEditorial.getAll());
			request.setAttribute("editoriales", serviceEditorial.listar());
		} catch (Exception exception) {
			exception.printStackTrace();
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}
	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		view = VIEW_FORM_EDITORIAL;
		Editorial e = null;
		try {
			e = new Editorial();
			
			e.setNombre(nombre);

			if (id != null && id.equals("")){

				if (("").equals(nombre)) {
					alert = new Alert(Alert.ALERT_WARNING, "El campo nombre no puede estar vacio.");
				} else {
					// Crear Editorial nueva
					if (serviceEditorial.crear(e)) {
						alert = new Alert(Alert.ALERT_SUCCESS, "Editorial guardada con éxito.");
					}
				}

			} else {
				// Modificar Editorial existente
				e.setId(Long.parseLong(id));

				if (("").equals(nombre.trim())) {
					alert = new Alert(Alert.ALERT_WARNING, "El campo nombre no puede estar vacio.");
				} else {
					if (serviceEditorial.modificar(e)) {
						alert = new Alert(Alert.ALERT_SUCCESS, "Editorial modificada con éxito.");
					}
				}

			}

		} catch (SQLIntegrityConstraintViolationException slqIntegrity) {
			slqIntegrity.printStackTrace();
			alert = new Alert(Alert.ALERT_WARNING,
					"El registro <b>" + e.getNombre() + "</b> no se puede registrar porque ya existe!!");

		} catch (Exception exception) {
			exception.printStackTrace();
		}
//		request.setAttribute("editoriales", daoEditorial.getAll());
		request.setAttribute("editorial", e);
	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {

		if (id != null) {
			try {
				if (serviceEditorial.eliminar(Long.parseLong(id))) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Se ha eliminado el registro");
				}

			}catch (SQLIntegrityConstraintViolationException slqIntegrity) {
				slqIntegrity.printStackTrace();
				alert = new Alert(Alert.ALERT_WARNING,
						" no se puede eliminar porque tiene libros asociados");
			}
			catch (Exception e) {

				e.printStackTrace();
				alert = new Alert();

			}
			view = VIEW_INDEX_EDITORIAL;
//			request.setAttribute("editoriales", daoEditorial.getAll());
			request.setAttribute("editoriales", serviceEditorial.listar());
		}

	}

	@Override
	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id"); // 0 = crear, 1 = modificar
		nombre = request.getParameter("nombre");
	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		Editorial editorial = null;
		if(Integer.parseInt(id)>0) {
//			editorial = daoEditorial.getById(id);
			editorial = serviceEditorial.buscarPorId(Long.parseLong(id));
		}else {
			editorial = new Editorial();
		}
		request.setAttribute("editorial", editorial);
		view = VIEW_FORM_EDITORIAL;
	}

}
