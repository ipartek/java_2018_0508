package com.ipartek.formacion.perrera.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.perrera.model.PerroDAO;
import com.ipartek.formacion.perrera.pojo.Alert;
import com.ipartek.formacion.perrera.pojo.Chip;
import com.ipartek.formacion.perrera.pojo.Perro;

/**
 * Servlet implementation class AltaController
 */
@WebServlet("/alta")
public class AltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PerroDAO daoPerros;
	
	
	// Datos del perro
	String nombre;
	String raza;
	String imagen;
	String edad;
	String peso;
	String adoptado;
	
	int numEdad;
	float numPeso;
	boolean esAdoptado;
	
	//	Datos del chip
	String numero;
	String latitud;
	String longitud;
	
	float numLatitud;
	float numLongitud;
	
	Chip chip;
	Perro perro;   
	
	Alert alert;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"	
		daoPerros = PerroDAO.getInstance();
		daoPerros.cargarPerros();
	}

	@Override
	public void destroy() {
		super.destroy();
		// Se ejecuta al parar el servidor
		daoPerros = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			recogerParametros(request);
			procesarParametros();
			crearPerro();

			if (daoPerros.insert(perro)) {
				alert = new Alert ("El perro se ha dado de alta correctamente", Alert.SUCCESS);
			} else {
				alert = new Alert ("No se ha podido dar de alta.", Alert.WARNING);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("inicio").forward(request, response);
		}
		
	}

	private void crearPerro() {
		
		// Primero creamos el Chip
		chip = new Chip(numero, numLatitud, numLongitud);
		
		// Después creamos el perro
		perro = new Perro(); // Asignamos una imagen por defecto
		
		// Establecemos sus atributos
		perro.setId(daoPerros.getAll().size());
		perro.setNombre(nombre);
		perro.setRaza(raza);
		perro.setImg(imagen);
		
		perro.setEdad(numEdad);
		perro.setPeso(numPeso);
		perro.setEsApadrinado(esAdoptado);
		
		// Por último, asignamos el chip
		perro.setChip(chip);
	}

	private void procesarParametros() {
		
		// Datos del Perro	
		if (edad != null) {
			numEdad = Integer.parseInt(edad);
		}
		
		if (peso != null) {
			numPeso = Float.parseFloat(peso);
		}
		
		if (adoptado != null) {
			esAdoptado = true;
		} else {
			esAdoptado = false;
		}
		
		// Datos del Chip
		if (latitud != null) {
			numLatitud = Float.parseFloat(latitud);
		}
		
		if (longitud != null) {
			numLongitud = Float.parseFloat(longitud);
		}
		
	}

	private void recogerParametros(HttpServletRequest request) {
		
		// Datos del Perro	
		nombre = request.getParameter("nombre");
		raza = request.getParameter("raza");
		imagen = request.getParameter("imagen");
		edad = request.getParameter("edad");
		peso = request.getParameter("peso");
		adoptado = request.getParameter("adoptado");
	
		// Datos del chip
		numero = request.getParameter("numChip");
		latitud = request.getParameter("latitud");
		longitud = request.getParameter("longitud");
		
	}

}
