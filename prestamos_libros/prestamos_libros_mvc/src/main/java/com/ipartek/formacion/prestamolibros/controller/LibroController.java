package com.ipartek.formacion.prestamolibros.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.prestamolibros.controller.pojo.Alert;
import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.service.IService;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;
import com.ipartek.formacion.prestamolibros.service.ServicioLibro;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/backoffice/biblioteca")
public class LibroController extends HttpServlet implements CrudControllable {
	private static final long serialVersionUID = 1L;
	//private LibroDAO daoLibro;
	//private EditorialDAO daoEditorial;
	private IService<Libro> servicioLibro;
	private IService<Editorial> servicioEditorial;
	private Alert alert;
	private String op;
	private String view;
	private String id;
	private String titulo;
	private String isbn;
	private String idEditorial;
	private String numLibros;
	private boolean redirect;
	private HttpSession session;
	
	private final static Logger LOG = Logger.getLogger(LibroController.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//daoLibro = LibroDAO.getInstance();
		//daoEditorial = EditorialDAO.getInstance();
		
		servicioLibro = ServicioLibro.getInstance();
		servicioEditorial = ServicioEditorial.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		//daoLibro = null;
		//daoEditorial = null;
		
		servicioLibro = null;
		servicioEditorial = null;
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

	public void getParameters(HttpServletRequest request) {
		try {
			
			request.setCharacterEncoding(ENCODE);
			op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
			id = request.getParameter("id");
			titulo = request.getParameter("titulo");
			isbn = request.getParameter("isbn");
			idEditorial = request.getParameter("editorial");
			numLibros=request.getParameter("numLibros");
		
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
			LOG.debug(e);

			alert = new Alert();
		} finally {
			session.setAttribute("alert", alert);

			if(redirect) {
				response.sendRedirect(request.getContextPath() + view);
			}else {
				request.getRequestDispatcher(view).forward(request, response);
			}
			
			try {
				session.setAttribute("editoriales", servicioEditorial.listar());
				session.setAttribute("libros", servicioLibro.listar());
			} catch (Exception e) {
				LOG.debug(e);
			}
			
		}

	}

	@Override
	public void guardar(HttpServletRequest request) throws Exception {
		Libro libro = new Libro();

		try {

			libro.setId(Long.parseLong(id));
			libro.setIsbn(isbn);
			libro.setTitulo(titulo);
			libro.setEditorial(servicioEditorial.buscar(Long.parseLong(idEditorial)));
			
			
			if("".equals(libro.getTitulo().trim()) || "".equals(libro.getIsbn().trim())) {
				alert = new Alert(Alert.WARNING, "Introduce un valor alfanumérico por favor");
			}else {
				
				if (libro.getId() == -1) {
					
					for (int i = 0; i < Integer.parseInt(numLibros); i++) {
						
						if(servicioLibro.crear(libro)) {			
							
							if(Integer.parseInt(numLibros) == 1) {
							
								alert = new Alert(Alert.SUCCESS, "Libro <b>" + libro.getTitulo() + "</b> creado correctamente.");
							
							}else {
								alert = new Alert(Alert.SUCCESS, "Libro <b>" + libro.getTitulo() + "</b> creado correctamente " + numLibros +" veces.");
							}
						}
					
					}
					
				} else {
					if(servicioLibro.modificar(libro)) {
						alert = new Alert(Alert.SUCCESS, "Libro <b>" + libro.getTitulo() + "</b> modificado correctamente.");
					}
				}
			
			}

		}

		catch (Exception e) {
			LOG.debug(e);
			alert = new Alert();
		}

		session.setAttribute("libro", libro);
		redirect = true;
		view = "/backoffice/libros/formulario.jsp";

	}

	@Override
	public void listar(HttpServletRequest request) throws Exception {
		
		request.setAttribute("libros", servicioLibro.listar());
		view = "libros/libro.jsp";
		
	}

	@Override
	public void irFormulario(HttpServletRequest request) throws Exception {
		alert = null;
		view = "libros/formulario.jsp";
		if (id.equalsIgnoreCase("-1")) {
			request.setAttribute("libro", new Libro());
		} else {

			request.setAttribute("libro", servicioLibro.buscar(Long.parseLong(id)));

		}
		request.setAttribute("editoriales", servicioEditorial.listar());

	}

	@Override
	public void eliminar(HttpServletRequest request) throws Exception {
		
		Libro l = new Libro();
		 
		try {
			if(id != null && op != null && OP_ELIMINAR.equals(op)) {	//Eliminar
				
				l  = servicioLibro.buscar(Long.parseLong(id));
				
				if(servicioLibro.eliminar(Long.parseLong(id))) {
					view = "/backoffice/libros/libro.jsp";
					alert = new Alert(Alert.SUCCESS, "Libro <b>" + l.getTitulo() + "</b> eliminado correctamente");
					
				}else {
					session.setAttribute("libro", l);
					view = "/backoffice/libros/formulario.jsp";
					alert = new Alert(Alert.DANGER, "No hemos podido eliminar el libro");
				}
				
			}	
			
		
		}catch(SQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			session.setAttribute("libro", l);
			view = "/backoffice/libros/formulario.jsp";
			alert = new Alert(Alert.WARNING, "No se puede eliminar el libro ya que está prestado");
		
		}catch (Exception e) {
			LOG.debug(e);
			alert = new Alert();
		}
		
		redirect = true;
		
	}

}

