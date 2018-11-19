package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.prestamos_libros.model.CrudControllable;
import com.ipartek.formacion.prestamos_libros.pojo.Alumno;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/prestamo/home")
public class HomeController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;

	private static ServicePrestamo servicePrestamo;
	
	// Logger
	private final static Logger LOG = Logger.getLogger(HomeController.class);

	public static final String OP_DEVOLVER = "6";
	
	private static final String VIEW_HOME_PRESTAMO = "home.jsp";
	private static final String VIEW_FORM_PRESTAMO = "formPrestamo.jsp";

	private String view = "";
	private Alert alert = null;

	// Parametros
	private String op;
	private String idAlumno;
	private String idLibro;
	private String fechaInicio;
	private String fechafin;

	private String fechaRetorno;

	private String idAlumnoUpdate;
	private String idLibroUpdate;
	private String fechaInicioUpdate;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		servicePrestamo = ServicePrestamo.getInstance();
		LOG.trace("Servicio prestamos instanciado");
	}

	@Override
	public void destroy() {
		super.destroy();
		servicePrestamo = null;
		LOG.trace("Servicio prestamos destruido");
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
				
			case OP_DEVOLVER:
				devolverLibro(request);

			default: // Listar
				listar(request); // Cambia a la vista de listado de usuarios
				break;
			}
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_HOME_PRESTAMO;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	private void devolverLibro(HttpServletRequest request) {
		try {
			if(!fechaRetorno.equals("")) {
				Prestamo p = new Prestamo(Date.valueOf(fechaInicio), new Alumno(Long.parseLong(idAlumno),""), new Libro(Long.parseLong(idLibro), "", "", 1, null));
				p.setFecha_retorno(Date.valueOf(fechaRetorno));
				servicePrestamo.devolver(p);
				alert = new Alert(Alert.ALERT_SUCCESS, "Préstamo devuelto.");
				LOG.debug("Libro devuelto. Prestamo finalizado");
			}
		}catch(Exception e) {
			LOG.error(e);
		}

	}

	@Override
	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		idAlumno = request.getParameter("alumno");
		idLibro = request.getParameter("libro");
		fechaInicio = request.getParameter("fechaInicio");
		fechaRetorno = request.getParameter("fechaRetorno");
		fechafin = request.getParameter("fechaFin");

		idAlumnoUpdate = request.getParameter("alumnoUpdate");
		idLibroUpdate = request.getParameter("libroUpdate");
		fechaInicioUpdate = request.getParameter("fechaInicioUpdate");

		LOG.debug("Parametros recogidos");
	}

	@Override
	public void listar(HttpServletRequest request) {
		try {
			view = VIEW_HOME_PRESTAMO;
			request.setAttribute("prestamos", servicePrestamo.listarPrestados());
			LOG.debug("Lista prestamos activos devuelta");
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_HOME_PRESTAMO;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}
	}

	public static int diasRestantes(Date fecha_fin) throws ParseException {
		// Coger la fecha actual
		java.util.Date fechaActualUtil = new java.util.Date();
		//Pasarlo a sql Date
		Date fechaActualSql = new Date(fechaActualUtil.getTime());
		//Calculo de dias restantes
		double diasExactos = (double) (fecha_fin.getTime() - fechaActualSql.getTime()) / (1000 * 60 * 60 * 24);
		//Redondear los dias
		int diasRedondeados = (int) Math.round(diasExactos);

		return diasRedondeados;
	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {

		Prestamo prestamo = new Prestamo();

		List<Libro> librosDis = servicePrestamo.librosDisponibles();
		List<Alumno> alumnosDis = servicePrestamo.alumnosDisponibles();

		if (idLibro != null) {
			prestamo = servicePrestamo.buscarPorId(Long.parseLong(idLibro), Long.parseLong(idAlumno),
					Date.valueOf(fechaInicio));
			librosDis.add(prestamo.getLibro());
			alumnosDis.add(prestamo.getAlumno());

			request.setAttribute("libros", librosDis);
			request.setAttribute("alumnos", alumnosDis);
			
			LOG.debug("Prestamo encontrado");

		} else {
			java.util.Date fechaActual= new java.util.Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			request.setAttribute("fechaActual", sdf.format(fechaActual));
			request.setAttribute("libros", servicePrestamo.librosDisponibles());
			request.setAttribute("alumnos", servicePrestamo.alumnosDisponibles());

			LOG.debug("Prestamo nuevo");
		}
		request.setAttribute("prestamo", prestamo);
		view = VIEW_FORM_PRESTAMO;
	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		view = VIEW_FORM_PRESTAMO;
		Prestamo prestamo = null;
		Alumno a = null;
		Libro l = null;

		try {
			prestamo = new Prestamo();

			l = new Libro();

			a = new Alumno();

			//CREAR PRESTAMO NUEVO
			if (fechaInicioUpdate != null && idAlumno == null && idLibro == null) {
				
				if (idLibroUpdate.equals("-1") || idAlumnoUpdate.equals("-1")) {
					alert = new Alert(Alert.ALERT_WARNING, "Debes seleccionar un alumno y un libro obligatoriamente.");
					LOG.warn("Alumno o Libro no seleccionado");
				} else {
					// Crear Prestamo nuevo
					prestamo = new Prestamo(Date.valueOf(fechaInicioUpdate), new Alumno(Long.parseLong(idAlumnoUpdate),""), new Libro(Long.parseLong(idLibroUpdate), "", "", 1, null));
					if (servicePrestamo.prestar(prestamo)) {
						view = VIEW_HOME_PRESTAMO;
						alert = new Alert(Alert.ALERT_SUCCESS, "Préstamo creado con éxito.");
						LOG.debug("Prestamo creado");
					}
				}

				//MODIFICAR PRESTAMO
			} else if (fechafin != null) {
				// Modificar Prestamo
				view = VIEW_HOME_PRESTAMO;				
				l.setId(Long.parseLong(idLibro));
				prestamo.setLibro(l);
				a.setId(Long.parseLong(idAlumno));
				prestamo.setAlumno(a);
				try {
					if (servicePrestamo.update(Long.parseLong(idLibro), Long.parseLong(idAlumno),
							Date.valueOf(fechaInicio), Long.parseLong(idLibroUpdate), Long.parseLong(idAlumnoUpdate),
							Date.valueOf(fechaInicioUpdate), Date.valueOf(fechafin), null)) {
						alert = new Alert(Alert.ALERT_SUCCESS, "Préstamo modificado con éxito.");
						LOG.debug("Prestamo modificado");
					} else {
						alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
						LOG.warn("No se ha podido modificar el prestamo");
					}
				} catch (Exception e) {
					LOG.error(e);
					view = VIEW_FORM_PRESTAMO;
				}
				request.setAttribute("prestamos", servicePrestamo.listarPrestados());
			} else {
				alert = new Alert(Alert.ALERT_WARNING, "Debes seleccionar una fecha obligatoriamente.");
			}
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_FORM_PRESTAMO;
		}
		request.setAttribute("prestamo", prestamo);
		request.setAttribute("prestamos", servicePrestamo.listarPrestados());
	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {

	}

}
