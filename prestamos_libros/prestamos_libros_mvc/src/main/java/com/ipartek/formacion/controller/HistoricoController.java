package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.service.ServiceAlumno;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

/**
 * Servlet implementation class HistoricoController
 */
@WebServlet("/prestamo/historico")
public class HistoricoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ServicePrestamo servicePrestamo;
	private static ServiceAlumno serviceAlumno;
	private static ServiceLibro serviceLibro;
	
	// Logger
	private final static Logger LOG = Logger.getLogger(HistoricoController.class);
	
	private static final String VIEW_HISTORY_PRESTAMO = "historico/listaHistorico.jsp";
	private static final String VIEW_FORM_MODIFICAR = "historico/formPrestamoModificar.jsp";

	private static final String OP_GUARDAR = "2";
	private static final String OP_LISTAR = "1";

	private static final String OP_IR_FORMULARIO = "4";
	
	private String view = "";
	private Alert alert = null;

	// Parametros
	private String op;
	private String idAlumno;
	private String idLibro;
	private String fechaInicio;
	
	private String idAlumnoUpdate;
	private String idLibroUpdate;
	private String fechaInicioUpdate;
	
	private String fechaFin;
	private String fechaRetorno;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		servicePrestamo = ServicePrestamo.getInstance();
		LOG.trace("Servicio prestamo instanciado");
		serviceAlumno = ServiceAlumno.getInstance();
		LOG.trace("Servicio alumno instanciado");
		serviceLibro = ServiceLibro.getInstance();
		LOG.trace("Servicio libro instanciado");
	}

	@Override
	public void destroy() {
		super.destroy();
		servicePrestamo = null;
		LOG.trace("Servicio prestamo destruido");
		serviceAlumno = null;
		LOG.trace("Servicio alumno destruido");
		serviceLibro = null;
		LOG.trace("Servicio libro destruido");
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
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			alert = null;

			// Recoge los parametros de la request y los guarda en variables
			getParameters(request);

			// Dependiendo del valor del parametro op hace una funcion u otra
			switch (op) {

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
			view = VIEW_HISTORY_PRESTAMO;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		Prestamo prestamo = new Prestamo();
		
		prestamo = servicePrestamo.buscarPorId(Long.parseLong(idLibro), Long.parseLong(idAlumno), Date.valueOf(fechaInicio));
		
		request.setAttribute("prestamo", prestamo);
		request.setAttribute("libros", serviceLibro.listar());
		request.setAttribute("alumnos", serviceAlumno.listar());
		view = VIEW_FORM_MODIFICAR;
	}

	private void guardar(HttpServletRequest request) throws Exception {
		view = VIEW_HISTORY_PRESTAMO;
		try {
			if(servicePrestamo.update(Long.parseLong(idLibro), Long.parseLong(idAlumno), Date.valueOf(fechaInicio), Long.parseLong(idLibroUpdate), Long.parseLong(idAlumnoUpdate), Date.valueOf(fechaInicioUpdate), Date.valueOf(fechaFin), Date.valueOf(fechaRetorno))) {
				alert = new Alert(Alert.ALERT_SUCCESS, "Préstamo modificado con éxito.");
				LOG.debug("prestamo modificado");
			}else {
				alert = new Alert(Alert.ALERT_DANGER, "No se ha podido modificar el préstamo.");
				LOG.warn("No se ha podido modificar el prestamo");
			}
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_FORM_MODIFICAR;
		}
		request.setAttribute("prestamos", servicePrestamo.listarHistorico());
	}

	private void listar(HttpServletRequest request) {
		try {
			view = VIEW_HISTORY_PRESTAMO;
			request.setAttribute("prestamos", servicePrestamo.listarHistorico());
			LOG.debug("Listado prestamos devuelto");
		} catch (Exception e) {
			LOG.error(e);
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}
	}

	private void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		idAlumno = request.getParameter("alumno");
		idLibro = request.getParameter("libro");
		fechaInicio = request.getParameter("fechaInicio");
		
		idAlumnoUpdate = request.getParameter("alumnoUpdate");
		idLibroUpdate = request.getParameter("libroUpdate");
		fechaInicioUpdate = request.getParameter("fechaInicioUpdate");
		
		fechaRetorno = request.getParameter("fechaRetorno");
		fechaFin = request.getParameter("fechaFin");
		
		LOG.debug("Parametros recogidos");
	}

}
