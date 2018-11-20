package com.ipartek.formacion.prestamos_libros.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.prestamos_libros.controller.pojo.Alert;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.pojo.Usuario;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

/**
 * Servlet implementation class PrestamoController
 */
@WebServlet("/backoffice/prestamo")
public class PrestamoController extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(PrestamoController.class);
	private static final long serialVersionUID = 1L;
	private ServicePrestamo prestamoService;
	
	public static final String OP_LISTAR = "1";
	public static final String OP_LISTAR_DEVUELTOS = "2";
	public static final String OP_GUARDAR_PRESTAMO = "3"; // insert id == null o update id != null
	public static final String OP_IR_FORMULARIO = "4";
	public static final String OP_DEVOLUCION = "5";
	public static final String OP_IR_FORMULARIO_EDITAR = "6";
	public static final String OP_EDITAR_PRESTAMO = "7";
	public static final String OP_IR_FORMULARIO_EDITAR_HISTORICO = "8";
	public static final String OP_EDITAR_HISTORICO = "9";
	

	private static final String VIEW_LISTADO = "index.jsp";
	private static final String VIEW_LISTADO_PRESTAMO_DEVUELTO = "librosDevueltos/librosDevueltos.jsp";
	private static final String VIEW_FORMULARIO_ANADIR_PRESTAMO = "anadirPrestamos/formAnadirPrestamo.jsp";
	private static final String VIEW_FORMULARIO_EDITAR_PRESTAMO = "anadirPrestamos/formEditarPrestamo.jsp";
	private static final String WIEW_FORMULARIO_EDITAR_HISTORICO = "librosDevueltos/formEditarHistorico.jsp";
	
	
	private String view;
	private Alert alert;
	
	private String op; // operacion a realizar
	private String libro;
	private String usuario;
	private String fecha_inicio;
	private String fecha_fin;
	private String fecha_devolucion;
	private String libroAntiguo;
	private String usuarioAntiguo;
	private String fecha_inicioAntiguo;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrestamoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		prestamoService = new ServicePrestamo();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		prestamoService = null;
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			alert = null;

			getParameters(request);
			Prestamo p = new Prestamo();
			Libro l = new Libro();
			Usuario u = new Usuario();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			switch (op) {
			case OP_LISTAR:
				List<Prestamo> prestamos = prestamoService.listar();
				request.setAttribute("prestamos", prestamos);
				view = VIEW_LISTADO;
				
				break;
			case OP_LISTAR_DEVUELTOS:
				List<Prestamo> devueltos = prestamoService.listardevueltos();
				request.setAttribute("devueltos", devueltos);
				
				view = VIEW_LISTADO_PRESTAMO_DEVUELTO;
				break;
			case OP_IR_FORMULARIO:
				List<Libro> librosDisponibles = prestamoService.listarLibrosDisponibles();
				List<Usuario> usuariosDisponibles = prestamoService.listarUsuariosDisponibles();
				
				request.setAttribute("libros", librosDisponibles);
				request.setAttribute("usuarios", usuariosDisponibles);
				
				view = VIEW_FORMULARIO_ANADIR_PRESTAMO;
				break;
			case OP_GUARDAR_PRESTAMO:
				try {
					l.setId(Long.parseLong(libro));
					p.setLibro(l);
					u.setId(Long.parseLong(usuario));
					p.setUsuario(u);
					p.setFecha_inicio(new java.sql.Date(sdf.parse(fecha_inicio).getTime()));
					
					if(prestamoService.crear(p)) {
						alert = new Alert(Alert.SUCCESS, "El prestamo se dio de alta correctamente.");
					}else {
						alert = new Alert(Alert.DANGER, "No se pudo dar de alta el prestamo.");
					}
				}catch(SQLIntegrityConstraintViolationException x) {
					x.printStackTrace();
					alert = new Alert(Alert.DANGER, "Ese prestamo ya existe, introduce otro por favor.");
				}catch(Exception e) {
					LOG.error(e);
				}
				
				List<Prestamo> prestados = prestamoService.listar();
				request.setAttribute("prestamos", prestados);
				
				view = VIEW_LISTADO;
				break;
				
			case OP_DEVOLUCION:
				try {
					
					l.setId(Long.parseLong(libro));
					p.setLibro(l);
					u.setId(Long.parseLong(usuario));
					p.setUsuario(u);
					p.setFecha_inicio( new java.sql.Date(sdf.parse(fecha_inicio).getTime()));
					p.setFecha_devuelto(new java.sql.Date(sdf.parse(fecha_devolucion).getTime()));
					
					if(prestamoService.devolver(p)) {
						alert = new Alert(Alert.SUCCESS, "Se realizo la devolución con exito.");
					}else {
						alert = new Alert(Alert.DANGER, "No se pudo realizar la devolución.");
					}
					
				}catch(Exception e) {
					LOG.error(e);
				}
				
				List<Prestamo> devueltos2 = prestamoService.listardevueltos();
				request.setAttribute("devueltos", devueltos2);
				
				view = VIEW_LISTADO_PRESTAMO_DEVUELTO;
				break;
			case OP_IR_FORMULARIO_EDITAR:
				Prestamo prestamo = prestamoService.getByIds(libro, usuario, fecha_inicio);
				List<Libro> libros = prestamoService.listarLibrosDisponibles();
				List<Usuario> usuarios = prestamoService.listarUsuariosDisponibles();
				
				request.setAttribute("prestamo", prestamo);
				request.setAttribute("libros", libros);
				request.setAttribute("usuarios", usuarios);
				
				view = VIEW_FORMULARIO_EDITAR_PRESTAMO;
				
				break;
			case OP_EDITAR_PRESTAMO:
				
				try {
					
					Prestamo prestamoAntiguo = new Prestamo();
					prestamoAntiguo.setFecha_inicio(new java.sql.Date(sdf.parse(fecha_inicioAntiguo).getTime()));
					Libro libAntiguo = new Libro();
					libAntiguo.setId(Long.parseLong(libroAntiguo));
					prestamoAntiguo.setLibro(libAntiguo);
					Usuario usuAntiguo = new Usuario();
					usuAntiguo.setId(Long.parseLong(usuarioAntiguo));
					prestamoAntiguo.setUsuario(usuAntiguo);				
					
					p.setFecha_inicio(new java.sql.Date(sdf.parse(fecha_inicio).getTime()));
					p.setFecha_fin(new java.sql.Date(sdf.parse(fecha_fin).getTime()));
					l.setId(Long.parseLong(libro));
					p.setLibro(l);
					u.setId(Long.parseLong(usuario));
					p.setUsuario(u);
					
					if(prestamoService.modificarPrestamo(p, prestamoAntiguo)) {
						alert = new Alert(Alert.SUCCESS, "El prestamo se ha modificado correctamente.");
					}else {
						alert = new Alert(Alert.DANGER, "No se pudo modificar el prestamo.");
					}
					
				}catch(Exception e) {
					LOG.error(e);
				}
				
				List<Prestamo> librosPrestados = prestamoService.listar();
				request.setAttribute("prestamos", librosPrestados);
				
				view = VIEW_LISTADO;
				
				break;
				
			case OP_IR_FORMULARIO_EDITAR_HISTORICO:
				Prestamo prestamoH = prestamoService.historicoGetByIds(libro, usuario, fecha_inicio);
				List<Libro> librosH = prestamoService.listarLibrosDisponibles();
				List<Usuario> usuariosH = prestamoService.listarUsuariosDisponibles();
				
				request.setAttribute("prestamo", prestamoH);
				request.setAttribute("libros", librosH);
				request.setAttribute("usuarios", usuariosH);
				
				view = WIEW_FORMULARIO_EDITAR_HISTORICO;
				
				break;
			
			case OP_EDITAR_HISTORICO:
				
				try {
					
					Prestamo prestamoAntiguo = new Prestamo();
					prestamoAntiguo.setFecha_inicio(new java.sql.Date(sdf.parse(fecha_inicioAntiguo).getTime()));
					Libro libAntiguo = new Libro();
					libAntiguo.setId(Long.parseLong(libroAntiguo));
					prestamoAntiguo.setLibro(libAntiguo);
					Usuario usuAntiguo = new Usuario();
					usuAntiguo.setId(Long.parseLong(usuarioAntiguo));
					prestamoAntiguo.setUsuario(usuAntiguo);				
					
					p.setFecha_inicio(new java.sql.Date(sdf.parse(fecha_inicio).getTime()));
					p.setFecha_devuelto(new java.sql.Date(sdf.parse(fecha_devolucion).getTime()));
					l.setId(Long.parseLong(libro));
					p.setLibro(l);
					u.setId(Long.parseLong(usuario));
					p.setUsuario(u);
					
					if(prestamoService.modificarHistorico(p, prestamoAntiguo)) {
						alert = new Alert(Alert.SUCCESS, "El prestamo del historico se ha modificado correctamente.");
					}else {
						alert = new Alert(Alert.DANGER, "No se pudo modificar el prestamo del historico.");
					}
					
				}catch(Exception e) {
					LOG.error(e);
				}
				
				List<Prestamo> dev = prestamoService.listardevueltos();
				request.setAttribute("devueltos", dev);
				
				view = VIEW_LISTADO_PRESTAMO_DEVUELTO;
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);

		}

	}

	private void getParameters(HttpServletRequest request) {
		op = request.getParameter("op");
		libro = request.getParameter("libro");
		usuario = request.getParameter("usuario");
		fecha_inicio = request.getParameter("fechaInicio");
		fecha_fin = request.getParameter("fechaFin");
		fecha_devolucion = request.getParameter("datedevolucion");
		libroAntiguo = request.getParameter("idlibroAntiguo");
		usuarioAntiguo = request.getParameter("idUsuarioAntiguo");
		fecha_inicioAntiguo = request.getParameter("fechaInicioAntiguo");
	}
	
	
}
