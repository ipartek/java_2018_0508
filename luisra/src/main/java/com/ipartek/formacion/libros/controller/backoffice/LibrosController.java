package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libros.model.EditorialDAO;
import com.ipartek.formacion.libros.model.LibroDAO;
import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.pojo.Libro;

/**
 * Servlet implementation class AlumnosController
 */
@WebServlet("/backoffice/libros")
public class LibrosController extends HttpServlet implements ICRUDController {
	private static final long serialVersionUID = 1L;

	private static final String VISTA_LISTA = "libros/index.jsp";
	
	private static LibroDAO librosDAO;
	private static EditorialDAO editorialDAO;
	
	private ArrayList<Libro> libros;

	String op;
	String id;
	String vista;
	String n_ejemplares;
	
	private String titulo;
	private String isbn;
	private String idEditorial;

	Alert alerta;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		librosDAO = LibroDAO.getInstance();
		editorialDAO = EditorialDAO.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			getParameters(request);
					
			switch (op) {
			
			case OP_IR_FORMULARIO:

				break;

			case OP_ELIMINAR:
				eliminar(request);
				break;
			
			case OP_GUARDAR:
				guardar(request);
				break;
					
			default:
				
				listar(request);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		
		} finally {

			request.setAttribute("libros", libros);
			request.getRequestDispatcher(vista).forward(request, response);
		}

	}

	@Override
	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null ? request.getParameter("op") : OP_LISTAR);
		id = request.getParameter("id");
		n_ejemplares = request.getParameter("ejemplares");
		titulo = request.getParameter("titulo");
		isbn = request.getParameter("isbn");
		idEditorial = request.getParameter("idEditorial"); 

	}

	@Override
	public void listar(HttpServletRequest request) throws SQLException, Exception {
		vista = VISTA_LISTA;
		libros = (ArrayList<Libro>) librosDAO.getAll();
	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException, Exception {
		Libro l = new Libro();
		boolean resul = false;

		l = librosDAO.getById(Long.parseLong(id));

		if (l != null) {
			
			l.setTitulo(titulo);
			l.setIsbn(isbn);
			
			Editorial e = new Editorial();
			e.setId(Long.parseLong(idEditorial));
			l.setEditorial(e);
			
			resul = librosDAO.update(l);

			if (resul == true) {
				
				alerta.setTipo(Alert.SUCCESS);
				alerta.setTexto("Alumnos actualizado correctamente.");
			
			} else {
				
				alerta.setTipo(Alert.DANGER);
				alerta.setTexto("Hemos tenido un problema acutalizando el libro.");
			}
		
		} else {
			
			l = new Libro();
			l.setTitulo(titulo);
			l.setIsbn(isbn);
			
			Editorial e = new Editorial();
			e.setId(Long.parseLong(idEditorial));
			l.setEditorial(e);
			
			resul = librosDAO.loopInsertLibro(l, Integer.parseInt(n_ejemplares) );
		}
		listar(request);

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws NumberFormatException, Exception {


	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {

		boolean resul = false;

		resul = librosDAO.delete(id);
		if (resul) {
			
			alerta.setTipo(Alert.SUCCESS);
			alerta.setTexto("Alumno eliminado correctamente");
		
		} else {
			
			alerta.setTipo(Alert.DANGER);
			alerta.setTexto("Hemos tenido un problema al eliminar el libro");

		}
		listar(request);

	}

}