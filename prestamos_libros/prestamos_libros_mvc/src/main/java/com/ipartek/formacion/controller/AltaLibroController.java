package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.prestamos_libros.model.CrudControllable;
import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;

/**
 * Servlet implementation class AltaLibroController
 */
@WebServlet("/prestamo/altalibro")
public class AltaLibroController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	
	private static ServiceLibro serviceLibro = null;
	private static ServiceEditorial serviceEditorial = null;
	
	// Logger
	private final static Logger LOG = Logger.getLogger(AltaLibroController.class);

	private static final String OP_LISTAR = "1";
	private static final String OP_GUARDAR = "2"; // Insert o update en funcion del id (-1 o >0)
	private static final String OP_ELIMINAR = "3";
	private static final String OP_IR_FORMULARIO = "4";

	private Alert alert = null;
	private String view = "";
	
	private static final String VIEW_INDEX_LIBRO = "libro/index.jsp";
	private static final String VIEW_FORM_LIBRO = "libro/formLibro.jsp";

	private String id;
	private String titulo;
	private String isbn;
	private String cant;
	private String idEditorial;
	private String op;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		serviceLibro = ServiceLibro.getInstance();
		LOG.trace("Servicio libro instanciado");
		serviceEditorial = ServiceEditorial.getInstance();
		LOG.trace("Servicio editorial instanciado");
	}

	@Override
	public void destroy() {
		super.destroy();
		serviceLibro = null;
		LOG.trace("Servicio libro destruido");
		serviceEditorial = null;
		LOG.trace("Servicio editorial destruido");
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
		view = VIEW_INDEX_LIBRO;
		try {
			alert = null;

			// Recoge los parametros de la request y los guarda en variables
			getParameters(request);

			// Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {
			case OP_ELIMINAR:
				eliminar(request); // Elimina un usuario de la bbdd
				break;

			case OP_GUARDAR:
				guardar(request); // Crea o modifica un usuario en la bbdd
				break;

			case OP_IR_FORMULARIO:
				irFormulario(request); // Cambia a la vista del formulario de gestion de usuario
				break;

			default: // Listar
				listar(request); // Cambia a la vista de listado de usuarios
				break;
			}
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_INDEX_LIBRO;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	@Override
	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		titulo = request.getParameter("titulo");
		isbn = request.getParameter("isbn");
		cant = request.getParameter("cant");
		idEditorial = request.getParameter("editorial");
		LOG.debug("Parametros recogidos");
	}

	@Override
	public void listar(HttpServletRequest request) {
		Libro l = null;
		try {
			if (id != null) {
				l = serviceLibro.buscarPorId(Long.parseLong(id));
			} else {
				l = new Libro();
			}
			request.setAttribute("editoriales", serviceEditorial.listar());
			request.setAttribute("libros", serviceLibro.listar());
			request.setAttribute("libro", l);
			request.setAttribute("cant", l.getCant());
			
			LOG.debug("Listado libros devuelto");

		} catch (Exception e) {
			LOG.error(e);
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}
	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		view = VIEW_FORM_LIBRO;
		Libro l = null;
		Editorial e = null;
		try {
			l = new Libro();
			
			l.setTitulo(titulo);
			l.setIsbn(isbn);

			if (id != null && id.equals("")) {

				if (("").equals(titulo.trim())) {
					alert = new Alert(Alert.ALERT_WARNING, "El campo título no puede estar vacío.");
					LOG.warn("Campo titulo vacio");
				} else {
					if(idEditorial.equals("-1")) {
						alert = new Alert(Alert.ALERT_WARNING, "Debes seleccionar una editorial.");
						LOG.warn("Campo editorial vacio");
					}else {
						e = new Editorial();
						e.setId(Long.parseLong(idEditorial));
						
						l.setEditorial(e);
						
						// Crear Libro nuevo
						if(!cant.equals("")) {
							l.setCant(Integer.parseInt(cant));
						}
						if (serviceLibro.crear(l)) {
							if (l.getCant() > 1) {
								alert = new Alert(Alert.ALERT_SUCCESS, "Libros guardados con éxito.");
							} else {
								alert = new Alert(Alert.ALERT_SUCCESS, "Libro guardado con éxito.");
							}
							LOG.debug("Libro creado");
						}
					}
				}

			} else {
				e = new Editorial();
				e.setId(Long.parseLong(idEditorial));
				
				l.setEditorial(e);
				// Modificar Libro existente
				l.setId(Long.parseLong(id));

				if (("").equals(titulo.trim())) {
					alert = new Alert(Alert.ALERT_WARNING, "El campo título no puede estar vacío.");
					LOG.warn("Campo titulo vacio");
				} else {
					if (serviceLibro.modificar(l)) {
						alert = new Alert(Alert.ALERT_SUCCESS, "Libro modificado con éxito.");
						LOG.debug("Libro modificado con exito");
					}
				}

			}

		} catch (SQLIntegrityConstraintViolationException slqIntegrity) {
			LOG.error(slqIntegrity);
			alert = new Alert(Alert.ALERT_WARNING,
					"El registro <b>" + l.getTitulo() + "</b> no se puede registrar porque ya existe!!");
			view = VIEW_FORM_LIBRO;
		} catch (Exception exception) {
			LOG.error(exception);
			view = VIEW_FORM_LIBRO;
		}
		request.setAttribute("libro", l);
		request.setAttribute("editoriales", serviceEditorial.listar());
	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		view = VIEW_INDEX_LIBRO;
		if (id != null) {
			try {
				if (serviceLibro.eliminar(Long.parseLong(id))) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Se ha eliminado el registro");
					LOG.debug("Libro eliminado");
				}

			} catch (SQLIntegrityConstraintViolationException slqIntegrity) {
				LOG.error(slqIntegrity);
				alert = new Alert(Alert.ALERT_WARNING, "No se puede eliminar porque tiene préstamos asociados");
			} catch (Exception e) {
				LOG.error(e);
				alert = new Alert();

			}
			request.setAttribute("libros", serviceLibro.listar());
			request.setAttribute("editoriales", serviceEditorial.listar());
		}
	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		Libro libro = null;
		if(Integer.parseInt(id)>0) {
			libro = serviceLibro.buscarPorId(Long.parseLong(id));
			LOG.debug("Libro encontrado");
		}else {
			libro = new Libro();
			LOG.debug("Libro nuevo");
		}
		request.setAttribute("editoriales", serviceEditorial.listar());
		request.setAttribute("libro", libro);
		view = VIEW_FORM_LIBRO;
	}

}
