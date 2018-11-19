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
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;
import com.ipartek.formacion.service.ServiceAlumno;
import com.ipartek.formacion.service.ServiceLibro;
import com.ipartek.formacion.service.ServicePrestamo;

/**
 * Servlet implementation class HistoricoController
 */
@WebServlet("/prestamo/historico")
public class HistoricoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(HistoricoController.class);

	private static ServicePrestamo servicePrestamo;
	private static ServiceAlumno serviceAlumno;
	private static ServiceLibro serviceLibro;

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
		serviceAlumno = ServiceAlumno.getInstance();
		serviceLibro = ServiceLibro.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		servicePrestamo = null;
		serviceAlumno = null;
		serviceLibro = null;
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
			e.printStackTrace();
			view = VIEW_HISTORY_PRESTAMO;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
			LOG.error("Ha ocurrido un error no controlado.");
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	private void irFormulario(HttpServletRequest request) throws Exception {

		Prestamo p = new Prestamo();

		Libro l = new Libro();
		l.setId(Long.parseLong(idLibro));
		p.setLibro(l);

		Alumno a = new Alumno();
		a.setId(Long.parseLong(idAlumno));
		p.setAlumno(a);

		p.setFecha_prestado(Date.valueOf(fechaInicio));

		p = servicePrestamo.buscarPorId(p);

		request.setAttribute("prestamo", p);
		request.setAttribute("libros", serviceLibro.listar());
		request.setAttribute("alumnos", serviceAlumno.listar());
		view = VIEW_FORM_MODIFICAR;
	}

	private void guardar(HttpServletRequest request) throws Exception {
		view = VIEW_HISTORY_PRESTAMO;
		try {
			if (servicePrestamo.modificar(Long.parseLong(idLibro), Long.parseLong(idAlumno), Date.valueOf(fechaInicio),
					Long.parseLong(idLibroUpdate), Long.parseLong(idAlumnoUpdate), Date.valueOf(fechaInicioUpdate),
					Date.valueOf(fechaFin), Date.valueOf(fechaRetorno))) {
				alert = new Alert(Alert.ALERT_SUCCESS, "Préstamo modificado con éxito.");
				LOG.debug("Préstamo modificado con éxito.");
			} else {
				alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
				LOG.error("Ha ocurrido un error no controlado.");
				
			}
		} catch (Exception e) {
			
			view = VIEW_FORM_MODIFICAR;
			LOG.error(e);
		}
		request.setAttribute("prestamos", servicePrestamo.listarHistorico());
	}

	private void listar(HttpServletRequest request) {
		try {
			view = VIEW_HISTORY_PRESTAMO;
			request.setAttribute("prestamos", servicePrestamo.listarHistorico());
		} catch (Exception exception) {
			exception.printStackTrace();
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
			LOG.error("Ha ocurrido un error no controlado.");
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
	}

}
