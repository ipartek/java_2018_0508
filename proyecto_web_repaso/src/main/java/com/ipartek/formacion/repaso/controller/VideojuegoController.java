package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
	private String msgError;
	private ValidatorFactory factory;
	private Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		factory = null;
		validator = null;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("listado.jsp").forward(request, response);
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
				view = VIEW_LISTADO;
				//TODO guardar en BBDD
				
			}else {
				for (ConstraintViolation<Juego> violation : violations) {
					
					msgError += violation.getPropertyPath() + ": " + violation.getMessage() + "<br>";
				}
			
			}
			
		}catch(IllegalArgumentException e){
			LOG.error(e);
			msgError = "Introduzca una fecha válida";
			
		} catch (Exception e) {
			LOG.error(e);
			msgError = "Lo sentimos, tenemos un error no controlado";
		
		}finally {
			
			request.setAttribute("juego", juego);
			request.setAttribute("juegos", juegosMock());
			request.setAttribute("msgError", msgError);
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}
	
	private ArrayList<Juego> juegosMock(){
		
		ArrayList<Juego> juegos = new ArrayList<Juego>();	
		juegos.add(new Juego("The Simpsons Hit & Run"));	
		juegos.add(new Juego("Killzone 2"));	
		juegos.add(new Juego("Grand Theft Auto San Andreas"));	
		juegos.add(new Juego("Red Dead Redemption"));
		
		return juegos;
		
	}

}
