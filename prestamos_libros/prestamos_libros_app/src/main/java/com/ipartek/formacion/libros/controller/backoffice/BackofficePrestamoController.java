package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Prestamo;
import com.ipartek.formacion.libros.service.ServicePrestamo;


/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/prestamos")
public class BackofficePrestamoController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	
	private static ServicePrestamo servicio;

	private static final String VIEW_LISTADO = "prestamos/index.jsp";
	private static final String VIEW_FORMULARIO = "prestamos/form.jsp";

	private String view;
	private Alert alert;

	private String op; 			// Operacion a realizar

	private String id;
	private String id_libro;	// FK Libro
	private String id_alumno;	// FK Alumno
	private String fechaInicio;		// Fecha de Inicio
	
	private String nuevoLibro;		
	private String nuevoAlumno;	
	private String nuevaFecha;		
	private String fechaFin;		// Fecha de Fin
	private String fechaRetorno;	// Fecha de Retorno
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		servicio = ServicePrestamo.getInstance();
		
	}

	@Override
	public void destroy() {
		super.destroy();
		servicio = null;
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

		alert = new Alert();
		try {

			getParameters(request);

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
			
			alert = new Alert(Alert.WARNING, "El préstamo ya existe.");
			e.printStackTrace();

		} catch (SQLException e) { // Longitud de campos incorrecta
			
			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			e.printStackTrace();

		} catch (Exception e) { // Errores que no son de SQL

			alert = new Alert();
			e.printStackTrace();
		
		} finally {

			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(view);;
		}

	}

	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		
		id_libro = request.getParameter("libro");
		id_alumno = request.getParameter("alumno");
		fechaInicio = request.getParameter("fechaInicio");
		nuevoLibro = request.getParameter("nuevoLibro");
		nuevoAlumno = request.getParameter("nuevoAlumno");
		nuevaFecha = request.getParameter("nuevaFecha");
		fechaFin = request.getParameter("fechaFin");
		fechaRetorno = request.getParameter("fechaRetorno");
	}
	

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		
		alert = null;
		view = VIEW_LISTADO;
		request.getSession().setAttribute("prestamos", servicio.prestamosActivos());
	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		
		if ("-1".equals(id_libro)) {
			
			servicio.prestar(Long.parseLong(nuevoAlumno), Long.parseLong(nuevoLibro), parseDate(nuevaFecha));
			alert = new Alert(Alert.SUCCESS, "Préstamo correctamente insertado.");
			
		} else {
		
			servicio.modificarPrestamoActivo(Long.parseLong(id_alumno), Long.parseLong(id_libro), parseDate(fechaInicio),
					Long.parseLong(nuevoAlumno), Long.parseLong(nuevoLibro), parseDate(nuevaFecha), parseDate(fechaFin));
			alert = new Alert(Alert.SUCCESS, "Préstamo correctamente modificado.");
			
		}
		
		view = VIEW_LISTADO;
		request.getSession().setAttribute("prestamos", servicio.prestamosActivos());

	}
	
	
	private java.sql.Date parseDate(String fecha) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(fecha);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		
		return sqlStartDate;
		
	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws Exception {
		alert = null;

		if ("-1".equals(id)) {
			
			request.getSession().setAttribute("prestamo", new Prestamo());
		
		} else {
			
			Prestamo p = new Prestamo();
			
			p = servicio.obtenerPorId(Long.parseLong(id_alumno), Long.parseLong(id_libro), parseDate(fechaInicio));
				
			request.getSession().setAttribute("prestamo", p);
		}
		
		request.getSession().setAttribute("libros", servicio.librosDisponibles());
		request.getSession().setAttribute("alumnos", servicio.alumnosDisponibles());
		
		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		
		if (servicio.devolver(Long.parseLong(id_alumno), Long.parseLong(id_libro), parseDate(fechaInicio), parseDate(fechaRetorno))) {
			
			alert = new Alert(Alert.SUCCESS, "Préstamo devuelto correctamente.");
			
			view = VIEW_LISTADO;
			request.getSession().setAttribute("prestamos", servicio.prestamosActivos());
		}	
	}

}