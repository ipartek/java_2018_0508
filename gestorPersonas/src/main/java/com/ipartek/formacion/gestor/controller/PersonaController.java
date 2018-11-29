package com.ipartek.formacion.gestor.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.gestor.dao.PersonaDAO;
import com.ipartek.formacion.gestor.pojo.Persona;

/**
 * Servlet implementation class PersonaController
 */
@WebServlet("/persona")
public class PersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_LISTADO = "index.jsp";
	private static final String VIEW_FORMULARIO = "formulario.jsp";
	private PersonaDAO dao;
	private ValidatorFactory factory;
	private Validator validator;
	private static final Logger LOG = Logger.getLogger(PersonaController.class);

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		dao = PersonaDAO.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = VIEW_LISTADO;
		String op = request.getParameter("op");
		
		if(op==null) {
			
			op="0";
			
		}
		
		try {
			
			switch (op) {
			case "1":
				String id = request.getParameter("id");
				Persona p = dao.getById(Long.parseLong(id));
				request.setAttribute("persona", p);
				view = VIEW_FORMULARIO;
				break;
			case "2":
				String filtro = request.getParameter("filtro");
				String palabra = request.getParameter("palabra");
				
				if("0".equals(filtro)) {
					List<Persona> personas = dao.getAll();
					request.setAttribute("personas", personas);
				}else if("1".equals(filtro)) {
					List<Persona> personas = dao.getAllDni(palabra);
					request.setAttribute("personas", personas);
				}else if("2".equals(filtro)) {
					List<Persona> personas = dao.getAllEmail(palabra);
					request.setAttribute("personas", personas);
				}else {
					List<Persona> personas = dao.getAllNombreApellidos(palabra);
					request.setAttribute("personas", personas);
				}
				
				break;
			default:
				List<Persona> personas = dao.getAll();
				request.setAttribute("personas", personas);
				break;
			}

		} catch (Exception e) {
			LOG.error(e);

		} finally {
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = VIEW_LISTADO;

		try {

			// recoger parametros
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String apellido1 = request.getParameter("apellido1");
			String apellido2 = request.getParameter("apellido2");
			String email = request.getParameter("email");
			String dni = request.getParameter("dni");

			Persona persona = new Persona();
			persona.setNombre(nombre);
			persona.setApellido1(apellido1);
			persona.setApellido2(apellido2);
			persona.setEmail(email);
			persona.setDni(dni);

			// validar
			Set<ConstraintViolation<Persona>> violations = validator.validate(persona);
			if (violations.isEmpty()) {

				try {
					if (id == null || "".equals(id)) {
						if (dao.crear(persona)) {
							List<Persona> personas = dao.getAll();
							request.setAttribute("personas", personas);
						} else {
							request.setAttribute("info", "Lo sentimos pero no se ha podido crear");
						}
					} else {
						persona.setId(Long.parseLong(id));
						dao.modificar(persona);
						List<Persona> personas = dao.getAll();
						request.setAttribute("personas", personas);
					}
				} catch (Exception e) {
					LOG.error(e);
					List<Persona> personas = dao.getAll();
					request.setAttribute("personas", personas);
					request.setAttribute("info", "la persona ya existe, por favor elije otro nombre");
				}

			} else {
				List<Persona> personas = dao.getAll();
				request.setAttribute("personas", personas);
				request.setAttribute("info", violations);
			}

		} catch (Exception e) {

			LOG.error(e);
			request.setAttribute("info", "Lo sentimos tenemos un error no controlado");

		} finally {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
