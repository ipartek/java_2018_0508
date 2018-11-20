package com.ipartek.formacion.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Alert;
import com.ipartek.formacion.pojo.Prestamo;
import com.ipartek.formacion.service.ServiceAlumno;
import com.ipartek.formacion.service.ServiceLibro;
import com.ipartek.formacion.service.ServicePrestamo;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/prestamos")
public class PrestamoController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(PrestamoController.class);

	private static ServicePrestamo srvcPrestamo = null;
	private static ServiceAlumno srvcAlumno = null;
	private static ServiceLibro srvcLibro = null;

	private static final String VIEW_LISTADO = "/prestamo/prestamos.jsp";
	private static final String VIEW_HISTORICO = "/prestamo/historico.jsp";
	private static final String VIEW_FORMULARIO = "/prestamo/form_prestamos.jsp";
	private String view;
	private Alert alerta = null;

	private String op;
	private String id;
	private String id_alumno;
	private String id_libro;
	private String fecha_inicio;
	private String fecha_fin;
	private String fecha_devolucion;
	HttpSession session;

	@SuppressWarnings("static-access")
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		srvcPrestamo = srvcPrestamo.getInstance();
		srvcAlumno = srvcAlumno.getInstance();
		srvcLibro = srvcLibro.getInstance();
	}

	public void destroy() {
		super.destroy();
		srvcPrestamo = null;
		srvcAlumno = null;
		srvcLibro = null;
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
		session = request.getSession();
		alerta = new Alert();
		try {

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
				listarhistorico(request);
				break;
			case OP_MODIFICAR:
				modificar(request);
				break;
			default: // LISTAR
				listar(request);
				break;
			}

		} catch (Exception e) {
			LOG.debug(e);
			view = VIEW_LISTADO;
		} finally {
			session.setAttribute("alerta", alerta);
			response.sendRedirect(request.getContextPath() + view);

		}
	}

	public void getParameters(HttpServletRequest request) {
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		id_alumno = request.getParameter("id_alumno");
		id_libro = request.getParameter("id_libro");
		fecha_inicio = request.getParameter("fecha_inicio");
		fecha_fin = request.getParameter("fecha_fin");

		fecha_devolucion = request.getParameter("fecha_devolucion");
	}

	public void listar(HttpServletRequest request) throws Exception {
		try {

			alerta = null;
			view = VIEW_LISTADO;

			ArrayList<Prestamo> prestamos = srvcPrestamo.prestados();
			session.setAttribute("prestamos", prestamos);
			session.setAttribute("n_prestamos", prestamos.size());

		} catch (Exception e) {
			LOG.debug(e);
		}
	}

	public void irFormulario(HttpServletRequest request) throws Exception {
		alerta = null;
		view = VIEW_FORMULARIO;

		if ("-1".equalsIgnoreCase(id)) {
			session.setAttribute("prestamo", new Prestamo());
		} else {
			session.setAttribute("prestamo", srvcPrestamo.buscar(Long.parseLong(id)));
		}
		session.setAttribute("alumnos", srvcPrestamo.AlumnosDisponibles());
		session.setAttribute("libros", srvcPrestamo.LibrosDisponibles());
	}

	public void guardar(HttpServletRequest request) throws Exception {
		alerta = null;
		Prestamo p = new Prestamo();

		try {

			if ("-1".equals(id)) {
				p.setAlumno(srvcAlumno.buscar(Long.parseLong(id_alumno)));
				p.setLibro(srvcLibro.buscar(Long.parseLong(id_libro)));
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date parsed = format.parse(fecha_inicio);
					java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());

					p.setFecha_inicio(sqlDate);
				} catch (Exception e) {
					LOG.debug(e);
				}
				alerta = new Alert();

				srvcPrestamo.prestar(p);
				alerta = new Alert("El registro se ha creado con exito.", Alert.SUCCESS);
				view = VIEW_LISTADO;

				ArrayList<Prestamo> prestamos = srvcPrestamo.prestados();
				session.setAttribute("prestamos", prestamos);
				session.setAttribute("n_prestamos", prestamos.size());

			} else {
				p.setId(Long.parseLong(id));
				p.setAlumno(srvcAlumno.buscar(Long.parseLong(id_alumno)));
				p.setLibro(srvcLibro.buscar(Long.parseLong(id_libro)));
				try {

					if (fecha_devolucion == null) {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date parsefi = format.parse(fecha_inicio);
						java.util.Date parseff = format.parse(fecha_fin);
						java.sql.Date sqlDateDevolucionfi = new java.sql.Date(parsefi.getTime());
						java.sql.Date sqlDateDevolucionff = new java.sql.Date(parseff.getTime());

						p.setFecha_inicio(sqlDateDevolucionfi);
						p.setFecha_fin(sqlDateDevolucionff);
						p.setFecha_devuelto(null);
						alerta = new Alert();

						srvcPrestamo.modificar(p);
						alerta = new Alert("El registro se ha modificado con exito.", Alert.SUCCESS);
						view = VIEW_LISTADO;
						ArrayList<Prestamo> prestamos = srvcPrestamo.prestados();
						session.setAttribute("prestamos", prestamos);
						session.setAttribute("n_prestamos", prestamos.size());
					} else {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date parsefi = format.parse(fecha_inicio);
						java.util.Date parseff = format.parse(fecha_fin);
						java.util.Date parsefd = format.parse(fecha_devolucion);
						java.sql.Date sqlDateDevolucionfi = new java.sql.Date(parsefi.getTime());
						java.sql.Date sqlDateDevolucionff = new java.sql.Date(parseff.getTime());
						java.sql.Date sqlDateDevolucionfd = new java.sql.Date(parsefd.getTime());

						p.setFecha_inicio(sqlDateDevolucionfi);
						p.setFecha_fin(sqlDateDevolucionff);
						p.setFecha_devuelto(sqlDateDevolucionfd);

						alerta = new Alert();

						srvcPrestamo.modificar(p);
						alerta = new Alert("El registro se ha modificado con exito.", Alert.SUCCESS);
						view = VIEW_HISTORICO;
						ArrayList<Prestamo> prestamos = srvcPrestamo.historico();
						session.setAttribute("prestamos", prestamos);
						session.setAttribute("n_prestamos", prestamos.size());
					}

				} catch (Exception e) {
					LOG.debug(e);
				}

			}

		} catch (Exception e) {
			LOG.debug(e);
		}

	}

	private void listarhistorico(HttpServletRequest request) throws Exception {
		try {
			alerta = null;
			view = VIEW_HISTORICO;

			ArrayList<Prestamo> prestamos = srvcPrestamo.historico();
			session.setAttribute("prestamos", prestamos);
			session.setAttribute("n_prestamos", prestamos.size());

		} catch (Exception e) {
			LOG.debug(e);
		}
	}

	public void modificar(HttpServletRequest request) throws Exception {
		alerta = null;
		Prestamo p = new Prestamo();

		try {

			p.setId(Long.parseLong(id));
			p.setAlumno(srvcAlumno.buscar(Long.parseLong(id_alumno)));
			p.setLibro(srvcLibro.buscar(Long.parseLong(id_libro)));

			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsefi = format.parse(fecha_inicio);
				java.util.Date parsefd = format.parse(fecha_devolucion);
				java.sql.Date sqlDateDevolucionfi = new java.sql.Date(parsefi.getTime());
				java.sql.Date sqlDateDevolucionfd = new java.sql.Date(parsefd.getTime());

				p.setFecha_inicio(sqlDateDevolucionfi);
				p.setFecha_devuelto(sqlDateDevolucionfd);
			} catch (Exception e) {
				LOG.debug(e);
			}

			alerta = new Alert();

			srvcPrestamo.devolver(p);
			alerta = new Alert("El registro se ha devuelto con exito.", Alert.SUCCESS);
			view = VIEW_LISTADO;

			ArrayList<Prestamo> prestamos = srvcPrestamo.prestados();
			session.setAttribute("prestamos", prestamos);
			session.setAttribute("n_prestamos", prestamos.size());

		} catch (Exception e) {
			LOG.debug(e);
		}

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub

	}

}
