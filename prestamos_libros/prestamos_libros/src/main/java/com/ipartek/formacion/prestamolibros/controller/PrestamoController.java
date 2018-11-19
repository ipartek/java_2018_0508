package com.ipartek.formacion.prestamolibros.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.prestamolibros.controller.pojo.Alert;
import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.service.IService;
import com.ipartek.formacion.prestamolibros.service.IServicePrestamo;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;
import com.ipartek.formacion.prestamolibros.service.ServicioLibro;
import com.ipartek.formacion.prestamolibros.service.ServicioPrestamo;

/**
 * Servlet implementation class PrestamoController
 */
@WebServlet("/backoffice/prestamos")
public class PrestamoController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	private static final String OP_HISTORICO = "5";
	private static final String OP_IR_A_MODIFICAR = "6";
	private static final String OP_MODIFICAR = "7";
	private IServicePrestamo servicioPrestamo;
	private IService<Alumno> servicioAlumno;
	private IService<Libro> servicioLibro;
	private Alert alert;
	private String op;
	private String view;
	private boolean redirect;
	HttpSession session;
	private String idLibro;
	private String idAlumno;
	private String fechaInicio;
	private String fechaFin;
	private String oldIdLibro;
	private String oldIdAlumno;
	private String oldFechaInicio;
	private String fechaDevolucion;
	private String fechaActual;
	
	private final static Logger LOG = Logger.getLogger(PrestamoController.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// daoEditorial = EditorialDAO.getInstance();
		servicioPrestamo = ServicioPrestamo.getInstance();
		servicioAlumno = ServicioAlumno.getInstance();
		servicioLibro = ServicioLibro.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		// daoEditorial = null;
		servicioPrestamo = null;
		servicioAlumno = null;
		servicioLibro = null;
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
	public void getParameters(HttpServletRequest request) {

		try {
			request.setCharacterEncoding(ENCODE);
			op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
			idAlumno = request.getParameter("alumno");
			idLibro = request.getParameter("libro");
			fechaInicio = request.getParameter("fechaInicio");
			fechaFin = request.getParameter("fechaFin");
			fechaDevolucion = request.getParameter("fechaDevuelto");
			oldIdAlumno = request.getParameter("oldAlumno");
			oldIdLibro = request.getParameter("oldLibro");
			oldFechaInicio = request.getParameter("oldFechaInicio");

		} catch (UnsupportedEncodingException e) {
			LOG.debug(e);
			alert = new Alert();
		}

	}

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		redirect = false;
		
		try {
			Date date = new Date();
			fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);
			request.setAttribute("fechaInicio", fechaActual);
			alert = null;
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

			case OP_HISTORICO:
				historico(request);
				break;

			case OP_IR_A_MODIFICAR:
				irModificar(request);
				break;

			case OP_MODIFICAR:
				modificar(request);
				break;

			default:// LISTAR
				listar(request);
				break;

			// buscar operacion a realizar
			}
		} catch (Exception e) {
			LOG.debug(e);

			alert = new Alert();
		} finally {

			session.setAttribute("alert", alert);

			if (redirect) {
				response.sendRedirect(request.getContextPath() + view);
			} else {
				request.getRequestDispatcher(view).forward(request, response);
			}

			try {
				session.setAttribute("prestamos", servicioPrestamo.prestados());
				session.setAttribute("historico", servicioPrestamo.historico());
			} catch (Exception e) {
				LOG.debug(e);
			}

		}

	}

	private void modificar(HttpServletRequest request) throws Exception {

		try {
			view = "/backoffice/prestamos/prestamo.jsp";

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parsed = format.parse(fechaInicio);
			java.sql.Date sql = new java.sql.Date(parsed.getTime());

			Date parsed2 = format.parse(fechaFin);
			java.sql.Date sql2 = new java.sql.Date(parsed2.getTime());

			Date parsed4 = format.parse(oldFechaInicio);
			java.sql.Date sql4 = new java.sql.Date(parsed4.getTime());

			if (fechaDevolucion == null) {

				if (servicioPrestamo.modificarPrestamo(Long.parseLong(idLibro), Long.parseLong(idAlumno), sql, sql2,
						Long.parseLong(oldIdLibro), Long.parseLong(oldIdAlumno), sql4)) {
					alert = new Alert(Alert.SUCCESS, "Préstamo modificado correctamente.");
				}
			} else {

				Date parsed3 = format.parse(fechaDevolucion);
				java.sql.Date sql3 = new java.sql.Date(parsed3.getTime());

				if (servicioPrestamo.modificarHistorico(Long.parseLong(idLibro), Long.parseLong(idAlumno), sql, sql2,
						sql3, Long.parseLong(oldIdLibro), Long.parseLong(oldIdAlumno), sql4)) {
					alert = new Alert(Alert.SUCCESS, "Préstamo modificado correctamente.");
					view = "/backoffice/prestamos/historico.jsp";
				}
			}

		} catch (Exception e) {
			LOG.debug(e);
			alert = new Alert();
		}

		redirect = true;
		session.setAttribute("prestamos", servicioPrestamo.prestados());

	}

	private void irModificar(HttpServletRequest request) throws Exception {
		alert = null;
		view = "prestamos/modificar.jsp";
		request.setAttribute("libro", servicioLibro.buscar(Long.parseLong(idLibro)));
		request.setAttribute("alumno", servicioAlumno.buscar(Long.parseLong(idAlumno)));
		request.setAttribute("libros", servicioPrestamo.librosDisponibles());
		request.setAttribute("alumnos", servicioPrestamo.alumnosDisponibles());
		request.setAttribute("fechaInicio", fechaInicio);
		request.setAttribute("fechaFin", fechaFin);
		request.setAttribute("fechaDevuelto", fechaDevolucion);

	}

	private void historico(HttpServletRequest request) throws Exception {
		request.setAttribute("historico", servicioPrestamo.historico());
		LOG.debug("Listar histórico");
		view = "prestamos/historico.jsp";

	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {

		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parsed = format.parse(fechaInicio);
			java.sql.Date sql = new java.sql.Date(parsed.getTime());

			if (servicioPrestamo.prestar(Long.parseLong(idLibro), Long.parseLong(idAlumno), sql)) {
				alert = new Alert(Alert.SUCCESS, "Préstamo realizado correctamente.");
			}

		} catch (Exception e) {
			LOG.debug(e);
			alert = new Alert();
		}

		redirect = true;
		session.setAttribute("libros", servicioPrestamo.librosDisponibles());
		session.setAttribute("alumnos", servicioPrestamo.alumnosDisponibles());
		view = "/backoffice/prestamos/formulario.jsp";

	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		request.setAttribute("prestamos", servicioPrestamo.prestados());
		view = "prestamos/prestamo.jsp";

	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = "prestamos/formulario.jsp";
		request.setAttribute("libros", servicioPrestamo.librosDisponibles());
		request.setAttribute("alumnos", servicioPrestamo.alumnosDisponibles());
		

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {

		try {
			view = "/backoffice/prestamos/prestamo.jsp";

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parsed = format.parse(fechaDevolucion);
			java.sql.Date sqlDevolucion = new java.sql.Date(parsed.getTime());

			Date parsed2 = format.parse(fechaInicio);
			java.sql.Date sqlInicio = new java.sql.Date(parsed2.getTime());

			if (servicioPrestamo.devolver(Long.parseLong(idLibro), Long.parseLong(idAlumno), sqlInicio,
					sqlDevolucion)) {
				alert = new Alert(Alert.SUCCESS, "Préstamo finalizado");

			} else {
				alert = new Alert(Alert.WARNING, "No hemos podido finalizar el préstamo");
			}

		} catch (Exception e) {
			LOG.debug(e);
			view = "/backoffice/prestamos/formulario.jsp";
			alert = new Alert();
		}
		redirect = true;

	}

}
