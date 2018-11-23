package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
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

import com.ipartek.formacion.repaso.dao.JuegoDAO;
import com.ipartek.formacion.repaso.pojo.Juego;

/**
 * Servlet implementation class VideojuegoController
 */
@WebServlet("/videojuego")
public class VideojuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(VideojuegoController.class);
	
	private static final String VIEW_INDEX = "index.jsp";
	private static final String VIEW_LISTADO = "listado.jsp";
	
	private static JuegoDAO daoJuego;
	
	private String msgError;
	
	private ValidatorFactory factory;
	private Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoJuego = JuegoDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoJuego = null;
		factory = null;
		validator = null;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("juegos", daoJuego.getAll());
		request.getRequestDispatcher(VIEW_LISTADO).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = VIEW_INDEX;
		msgError = "";
		Juego juego = new Juego();
		
		try {
			
			//Recoger parámetros
			String titulo = request.getParameter("titulo");
			String fechaLanzamiento = request.getParameter("fechaLanzamiento");
			
			juego.setTitulo(titulo);
			juego.setFechaLanzamiento(Date.valueOf(fechaLanzamiento));
			
			//Validar
			Set<ConstraintViolation<Juego>> violations = validator.validate(juego);
			
			if(violations.isEmpty()) {
				
				if(daoJuego.crear(juego)) {
					view = VIEW_LISTADO;
				
				}else {
					msgError = "No se ha podido crear el videojuego";
				}
				
			}else {
				for (ConstraintViolation<Juego> violation : violations) {
					
					msgError += violation.getPropertyPath() + ": " + violation.getMessage() + "<br>";
				}
			
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			LOG.error(e);
			msgError = "El videojuego ya existe, por favor introduce un título diferente";
			
		}catch(IllegalArgumentException e){
			LOG.error(e);
			msgError = "Introduzca una fecha válida";
			
		} catch (Exception e) {
			LOG.error(e);
			msgError = "Lo sentimos, tenemos un error no controlado";
		
		}finally {
			
			request.setAttribute("juego", juego);
			request.setAttribute("juegos", daoJuego.getAll());
			request.setAttribute("msgError", msgError);
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}

}
