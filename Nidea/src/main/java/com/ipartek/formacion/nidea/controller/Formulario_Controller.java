package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Producto;


/**
 * @see HttpServlet
 * @author Curso
 *
 */
@WebServlet("/formulario")
public class Formulario_Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String WARNING_MSG = "Faltan campos obligatorios.";
	private static final String DARK_MSG = "El precio debe ser un número.";
	
	private String codigo;
	private String nombre;	
	private String descripcion;
	private String img;
	
	private String strOferta;
	private boolean esOferta;
	
	private String strPrecio;
	private float precio;
	
	private Producto producto;
       
    
    public Formulario_Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Petición GET: ").append(request.getContextPath());
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			receiveParameters(request, response);
			Alert alert = validateParameters();
			
			if (alert != null) {
				request.setAttribute("alerta", new Alert());
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
			} 
			
 			sendAttributes(request);
			request.getRequestDispatcher("formulario_resultado.jsp").forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("alerta", new Alert());
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}	
		
	}
	
	private void receiveParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		esOferta = false;
		
		codigo = request.getParameter("cod").toString(); 
		nombre = request.getParameter("nombre").toString();
		descripcion = request.getParameter("desc").toString(); 
		strPrecio = request.getParameter("precio").toString(); 
		strOferta = request.getParameter("ckbxOferta").toString();
		img = request.getParameter("img").toString();
		
		if (("on").equalsIgnoreCase(strOferta)) {
			esOferta = true;
		}
		
	}
	
	private Alert validateParameters() {
		
		Alert alerta = null;
		
		if (((codigo == null || codigo.trim().isEmpty()) || (nombre == null || nombre.trim().isEmpty()) 
				|| (img == null || img.trim().isEmpty()))) {
			
			alerta = new Alert(WARNING_MSG, Alert.WARNING);
		}
		
		try {
			
            precio = Float.parseFloat(strPrecio);
            
        } catch (NumberFormatException excepcion) {
            
        	alerta = new Alert(DARK_MSG, Alert.DARK);
        }
		
		return alerta;
	}
	
	private void sendAttributes(HttpServletRequest request) {
		
		producto = new Producto(codigo, nombre, descripcion, esOferta, precio, img);
		
		request.setAttribute("producto", producto);
	}

}
