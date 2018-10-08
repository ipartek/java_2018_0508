package com.ipartek.formacion.txakuretxea.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.txakuretxea.model.PerroDAO;
import com.ipartek.formacion.txakuretxea.pojo.Alert;
import com.ipartek.formacion.txakuretxea.pojo.Chip;
import com.ipartek.formacion.txakuretxea.pojo.Perro;

/**
 * Servlet implementation class AltaPerroController
 */
@WebServlet("/backoffice/altaperro")
public class AltaPerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_FORM_PERROS = "altaPerros.jsp";
	private static final String VIEW_INDEX_BACKOFFICE = "/backoffice/home";
	
	private static PerroDAO daoPerro = null;
	
	private Alert alert = null;
	private String view = "";
	
	//Parametros
	private String nombre;
	private int edad;
	private double peso;
	private String raza;
	private String nChip;
	private String imagen;
	private String apadrinado;
	private String descripcion;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoPerro = PerroDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoPerro = null;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Perro perro = null;
		try {
			getParameters(request);
			
			perro = new Perro();
			
			perro.setNombre(nombre);
			perro.setEdad(edad);
			perro.setPeso(peso);
			perro.setRaza(raza);
			perro.setChip(new Chip(nChip, "", ""));
			perro.setImagen(imagen);
			
			if(apadrinado != null) {
				perro.setApadrinado(true);
			}else {
				perro.setApadrinado(false);
			}
			
			perro.setDescripcion(descripcion);
			
			if(daoPerro.insert(perro)) {
				alert = new Alert(Alert.ALERT_SUCCESS, "Perro registrado con éxito.");
				view = VIEW_INDEX_BACKOFFICE;
			}else {
				alert = new Alert(Alert.ALERT_DANGER, "No se ha podido registrar el perro.");
				view = VIEW_FORM_PERROS;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			view = VIEW_INDEX_BACKOFFICE;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	private void getParameters(HttpServletRequest request) {
		nombre = request.getParameter("nombre");
		edad= Integer.parseInt(request.getParameter("edad"));
		peso= Double.parseDouble(request.getParameter("peso"));
		raza= request.getParameter("raza");
		nChip= request.getParameter("chip");
		imagen= request.getParameter("imagen");
		apadrinado= request.getParameter("apadrinado");
		descripcion= request.getParameter("descripcion");
	}

}
