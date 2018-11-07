package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;
import com.ipartek.formacion.libros.service.PrestamoService;

/**
 * Servlet implementation class EditorialController
 */
@WebServlet("/backoffice/prestamos")
public class PrestamosController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;

	PrestamoService servicio;

	private static final String VIEW_LISTADO = "prestamos/index.jsp";

	private static String view = VIEW_LISTADO;
	private static Alert alert;

	private static String op; // Operacion a realizar
	private static String idAlumno; // ID a eliminar / modificar
	private static String idLibro;
	private static String fechaInicio;
	private static String fechaFin;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		servicio = PrestamoService.getInstance();
	}

	@Override
	public void destroy() {

		super.destroy();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	/**
	 * @see ICRUDController#doProcess(HttpServletRequest, HttpServletResponse)
	 */
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			getParameters(request);

			if (op != null) {

				switch (op) {
				case OP_LISTAR:

					listar(request);
					break;

				case OP_ELIMINAR://Pasa a op_devolver

					eliminar(request);
					break;

				case OP_GUARDAR:

					guardar(request);
					break;

				case OP_IR_FORMULARIO:

					irFormularioDeAlta(request);
					break;

				default:

					listar(request);
					break;
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
			view = VIEW_LISTADO;

		} finally {

			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	/**
	 * @see ICRUDController#getParameters(HttpServletRequest)
	 */
	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		idAlumno = request.getParameter("idAlumno");
		idLibro = request.getParameter("idLibro");
		fechaInicio = request.getParameter("fechaInicio");
		fechaFin = request.getParameter("fechaFin");

	}

	/**
	 * @see ICRUDController#eliminar(HttpServletRequest)
	 */
	public void eliminar(HttpServletRequest request) throws Exception {

		Alumno a = new Alumno();

		a.setId(Integer.parseInt(idAlumno));

		Libro l = new Libro();

		l.setId(Integer.parseInt(idLibro));

		Prestamo p = new Prestamo();

		p.setAlumno(a);
		p.setLibro(l);

	}

	/**
	 * @see ICRUDController#irFormularioDeAlta(HttpServletRequest)
	 */
	public void irFormularioDeAlta(HttpServletRequest request) throws NumberFormatException, Exception {

	}

	/**
	 * @see ICRUDController#listar(HttpServletRequest)
	 */
	public void listar(HttpServletRequest request) throws SQLException, Exception {

		alert = null;
		view = VIEW_LISTADO;

		request.setAttribute("editoriales", servicio.listar());
	}

	/**
	 * @see ICRUDController#guardar(HttpServletRequest)
	 */
	public void guardar(HttpServletRequest request) throws SQLException, Exception {
		Prestamo prestamo = new Prestamo();
		if(idAlumno!= null && idLibro != null) {
			Alumno a = new Alumno();
			
			
			
		}

	}

}
