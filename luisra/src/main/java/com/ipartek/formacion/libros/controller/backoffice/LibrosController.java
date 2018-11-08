package com.ipartek.formacion.libros.controller.backoffice;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/backoffice/libros_")
public class LibrosController extends HttpServlet implements ICRUDController {
	private static final long serialVersionUID = 1L;

	private static final String VISTA_LISTA = "libros/index.jsp";
	
	private static LibroDAO librosDAO;
	private static EditorialDAO editorialDAO;

	private String op;
	private String id;
	private String vista;
	private String n_ejemplares;
	
	private String titulo;
	private String isbn;
	private String idEditorial;
	private String editorial;

	private static Alert alert;

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
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			alert = new Alert();
		
		} finally {

			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(vista);
		}

	}

	@Override
	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null ? request.getParameter("op") : OP_LISTAR);
		id = request.getParameter("id");
		n_ejemplares = request.getParameter("ejemplares");
		titulo = request.getParameter("titulo");
		isbn = request.getParameter("isbn");
		idEditorial = request.getParameter("editorial"); 

	}

	@Override
	public void listar(HttpServletRequest request) throws SQLException, Exception {
		vista = VISTA_LISTA;
		request.getSession().setAttribute("libros", librosDAO.getAll());
		request.getSession().setAttribute("editoriales", editorialDAO.getAll());
		if(librosDAO.getAll() != null && editorialDAO.getAll() != null) {
			alert.setTexto("");
			alert.setTipo("");
		}

	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException, Exception {
		Libro l = new Libro();
		boolean resul = false;

		l = librosDAO.getById(Long.parseLong(id));
		alert = new Alert();

		if (l != null) {
			
			l.setTitulo(titulo);
			l.setIsbn(isbn);
			
			Editorial e = new Editorial();
			e.setId(Long.parseLong(idEditorial));
			l.setEditorial(e);
			
			resul = librosDAO.update(l);
			
			if (resul == true) {	
				
				alert.setTipo(Alert.SUCCESS);
				alert.setTexto("Libro modificado correctamente.");
			
			}
		
		} else {
			
			l = new Libro();
			l.setTitulo(titulo);
			l.setIsbn(isbn);
			
			Editorial e = new Editorial();
			e.setId(Long.parseLong(idEditorial));
			l.setEditorial(e);
			
			resul = librosDAO.loopInsertLibro(l, Integer.parseInt(n_ejemplares) );
			
			if (resul == true) {	
				
				alert.setTipo(Alert.SUCCESS);
				alert.setTexto("Libro insertado correctamente.");
			
			}
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
		alert = new Alert();
		
		if (resul) {
			
			alert.setTipo(Alert.SUCCESS);
			alert.setTexto("Libro eliminado correctamente.");
		
		}
		
		listar(request);

	}

}