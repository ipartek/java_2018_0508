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

import com.ipartek.formacion.prestamolibros.pojo.Alert;
import com.ipartek.formacion.prestamolibros.service.IServicePrestamo;
import com.ipartek.formacion.prestamolibros.service.ServicioPrestamo;

/**
 * Servlet implementation class PrestamoController
 */
@WebServlet("/backoffice/prestamos")
public class PrestamoController extends HttpServlet implements CrudControllable{
	private static final long serialVersionUID = 1L;
	private IServicePrestamo servicioPrestamo;
	private Alert alert;
	private String op;
	private String view;
	private boolean redirect;
	HttpSession session;
	private String idLibro;
	private String idAlumno;
	private String fechaInicio;
	private String fechaDevolucion;


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//daoEditorial = EditorialDAO.getInstance();
		servicioPrestamo = ServicioPrestamo.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		//daoEditorial = null;
		servicioPrestamo = null;
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
			fechaDevolucion = request.getParameter("fechaDevolucion");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			alert = new Alert();
		}

	}

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		redirect=false;
		try {
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

			default:// LISTAR
				listar(request);
				break;

			// buscar operacion a realizar
			}
		} catch (Exception e) {
			e.printStackTrace();

			alert = new Alert();
		} finally {

			session.setAttribute("alert", alert);
			
			if(redirect) {
				response.sendRedirect(request.getContextPath() + view);
			}else {
				request.getRequestDispatcher(view).forward(request, response);
			}
			
			try {
				session.setAttribute("prestamos", servicioPrestamo.prestados());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		
		try {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parsed = format.parse(fechaInicio);
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
				
			if(servicioPrestamo.prestar(Long.parseLong(idLibro), Long.parseLong(idAlumno), sql)) {
				alert = new Alert(Alert.SUCCESS, "Préstamo realizado correctamente.");
			}						
			
		}
		catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}
		
		redirect=true;
		session.setAttribute("libros", servicioPrestamo.librosDisponibles());
		session.setAttribute("alumnos", servicioPrestamo.alumnosDisponibles());
		view = "/backoffice/prestamos/formulario.jsp";
		
	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		request.setAttribute("prestamos", servicioPrestamo.prestados());
		
		//int dias = (int) ((prestamo.getFechaFin().getTime() - prestamo.getFechaInicio().getTime())/86400000);
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
			
			if(servicioPrestamo.devolver(Long.parseLong(idLibro), Long.parseLong(idAlumno),sqlInicio , sqlDevolucion)) {
				alert = new Alert(Alert.SUCCESS, "Préstamo finalizado");
					
			}else {
				alert = new Alert(Alert.WARNING, "No hemos podido finalizar el préstamo");
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
			view = "/backoffice/prestamos/formulario.jsp";
			alert = new Alert();
		}
		redirect = true;
		
	}


}
