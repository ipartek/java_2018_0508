package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;
import com.ipartek.formacion.libros.service.ServiceAlumno;
import com.ipartek.formacion.libros.service.ServiceEditorial;
import com.ipartek.formacion.libros.service.ServiceLibro;
import com.ipartek.formacion.libros.service.ServicePrestamo;


/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/prestamos")
public class BackofficePrestamoController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	
	private static ServicePrestamo prestamoServicio;
	private static ServiceAlumno alumnoServicio;
	private static ServiceEditorial editorialServicio;
	private static ServiceLibro libroServicio;

	private static final String VIEW_LISTADO = "prestamos/index.jsp";
	private static final String VIEW_FORMULARIO = "prestamos/form.jsp";
	private final static Logger LOG = Logger.getLogger(BackofficePrestamoController.class);

	private String view;
	private Alert alert;

	private String op; 			// Operacion a realizar

	private String id;
	private String id_libro;	// FK Libro
	private String id_alumno;	// FK Alumno
	private String fechaInicio;		// Fecha de Inicio
	
	private String nuevoTitulo;
	private String nuevoIsbn;
	private String nuevaEditorial;
	private String editorial;
	private String nuevoAlumno;			
	private String fechaFin;		// Fecha de Fin
	private String fechaRetorno;	// Fecha de Retorno
	private String libroOrig;
	private String alumnoOrig;
	private String fechaOrig;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		prestamoServicio = ServicePrestamo.getInstance();
		alumnoServicio = ServiceAlumno.getInstance();
		editorialServicio = ServiceEditorial.getInstance();
		libroServicio = ServiceLibro.getInstance();
		
	}

	@Override
	public void destroy() {
		super.destroy();
		prestamoServicio = null;
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
			
			if (e.getMessage().contains("Duplicate entry")){
				LOG.debug(e.getMessage());
				alert = new Alert(Alert.WARNING, "El alumno ya existe");
				
			}

		} catch (SQLException e) { // Longitud de campos incorrecta
			LOG.debug(e.getMessage());
			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			

		} catch (Exception e) { // Errores que no son de SQL
			LOG.debug(e.getMessage());
			alert = new Alert();
			
		
		} finally {

			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(view);;
		}

	}

	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		libroOrig = request.getParameter("libroOrig");//Parametro que nos permite distingir si es acutlizacion o registro nuevo
		alumnoOrig = request.getParameter("alumnoOrig");//Parametro que nos permite distingir si es acutlizacion o registro nuevo
		fechaOrig = request.getParameter("fechaIOrig");//Parametro que nos permite distingir si es acutlizacion o registro nuevo
		id_libro = request.getParameter("libros");
		id_alumno = request.getParameter("alumnos");//select alumnos form
		fechaInicio = request.getParameter("fechaInicio");
		nuevoAlumno = request.getParameter("nuevoAlumno");//campo oculto para la creacion de nuevo alumno
		fechaFin = request.getParameter("fechaFin");
		fechaRetorno = request.getParameter("fechaRetorno");
		//atributos del nuevo libro desde prestamos
		nuevoTitulo = request.getParameter("nuevoTitulo");
		nuevoIsbn = request.getParameter("nuevoIsbn");
		nuevaEditorial = request.getParameter("nuevaEditorial");
		editorial = request.getParameter("editorial");

	}
	

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		
		alert = null;
		view = VIEW_LISTADO;
		request.getSession().setAttribute("prestamos", prestamoServicio.prestamosActivos());
	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		
		
		if(nuevoAlumno != null && !"".contains(nuevoAlumno)) {
			ArrayList<Alumno> alumnos = (ArrayList<Alumno>) alumnoServicio.listar();
			Alumno nAlumno = new Alumno();
			nAlumno.setNombre(nuevoAlumno);
			
			if(!alumnoServicio.crear(nAlumno)) {
				alert.setTipo(Alert.DANGER);
				alert.setTexto("Prueba con otro nombre de alumno ");
			}
			
			id_alumno = String.valueOf(nAlumno.getId());
		}
		
		if( !nuevoTitulo.equals("") && !nuevoIsbn.equals("") && !editorial.equals("")	|| !nuevaEditorial.equals("")  ) {
			Editorial e = new Editorial();
			if(nuevaEditorial != null && !nuevaEditorial.contains(nuevaEditorial)) {
				
				e.setNombre(nuevaEditorial);
				editorialServicio.crear(e);
				editorial = String.valueOf(e.getId());
			}else {
				e = editorialServicio.obtener(Long.parseLong(editorial));
				System.out.println("as");
			}
			Libro l = new Libro();
			l.setTitulo(nuevoTitulo);
			l.setIsbn(nuevoIsbn);
			l.setEditorial(e);
			libroServicio.crearVarios(l, 1);
			
			id_libro = String.valueOf(l.getId() );
		}
		
		//prestamoServicio.obtenerPorId(Long.parseLong(id_alumno),Long.parseLong(id_libro), parseDate(fechaInicio));
		
		if ("-1".equals(id)) {
			
			prestamoServicio.prestar(Long.parseLong(id_alumno), Long.parseLong(id_libro), parseDate(fechaInicio));
			alert = new Alert(Alert.SUCCESS, "Préstamo correctamente creado.");
			
		} else {
		
			prestamoServicio.modificarPrestamoActivo(Long.parseLong(alumnoOrig), Long.parseLong(libroOrig), parseDate(fechaOrig),
					Long.parseLong(id_alumno), Long.parseLong(id_libro), parseDate(fechaInicio), parseDate(fechaFin));
			alert = new Alert(Alert.SUCCESS, "Préstamo correctamente modificado.");
			
		}
		
		
		view = VIEW_LISTADO;
		request.getSession().setAttribute("prestamos", prestamoServicio.prestamosActivos());

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
		
		if("-1".equals(id)) {
			
			request.getSession().setAttribute("prestamo", new Prestamo());;
		}

		if ("-1".equals(id)) {
			
			request.getSession().setAttribute("prestamo", new Prestamo());
		
		} else {
			
			Prestamo p = new Prestamo();
			
			p = prestamoServicio.obtenerPorId(Long.parseLong(id_alumno), Long.parseLong(id_libro), parseDate(fechaInicio));
				
			request.getSession().setAttribute("prestamo", p);
		}
		
		request.getSession().setAttribute("editoriales", editorialServicio.listar());
		request.getSession().setAttribute("libros", prestamoServicio.librosDisponibles());
		request.getSession().setAttribute("alumnos", prestamoServicio.alumnosDisponibles());
		
		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		
		if (prestamoServicio.devolver(Long.parseLong(id_alumno), Long.parseLong(id_libro), parseDate(fechaInicio), parseDate(fechaRetorno))) {
			
			alert = new Alert(Alert.SUCCESS, "Préstamo devuelto correctamente.");
			
			view = VIEW_LISTADO;
			request.getSession().setAttribute("prestamos", prestamoServicio.prestamosActivos());
		}	
	}

}