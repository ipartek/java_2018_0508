package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Producto;

/**
 * Servlet implementation class FormularioController
 */
@WebServlet(description = "Controlador para un formulario", urlPatterns = { "/formulario" })
public class FormularioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatch = null;

	private static final String VIEW_FORM = "formulario.jsp";
	private static final String VIEW_RESUL = "resultado.jsp";

	private static final String ALERTA_CODIGO = "Lo sentimos ha ocurrido un error.";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dispatch = request.getRequestDispatcher(VIEW_FORM);
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Alert a = new Alert();
		try {

			dispatch = request.getRequestDispatcher(VIEW_RESUL);

			// Recoger Parametros

			String nombre = request.getParameter("nombre");
			String codigo = request.getParameter("codigo");
			float precio = Float.parseFloat(request.getParameter("precio"));
			String oferta = request.getParameter("oferta");
			String descripcion = request.getParameter("descripcion");

			// Validarlos

			if (codigo.isEmpty()) {

				a.setTexto("El codigo no puede estar vacio.");
				a.setTipo(Alert.WARNING);
				dispatch = request.getRequestDispatcher(VIEW_FORM);
				request.setAttribute("alert", a);

			} else {

				// Pasar parametros
				Producto p = new Producto();
				p.setNombre(nombre);
				p.setCodigo(codigo);
				p.setPrecio(precio);
				p.setOferta(("on".equalsIgnoreCase(oferta))?true:false);
				p.setDescripcion(descripcion);

				request.setAttribute("producto", p);

				// Se ha creado el producto
				a.setTexto("El producto se ha creado bien.");
				a.setTipo(Alert.SUCCESS);
				request.setAttribute("alert", a);
			}

		} catch (NumberFormatException e) {
			
			a.setTexto("Disculpa, introduce numeros en el campo del precio.");
			a.setTipo(Alert.WARNING);
			dispatch = request.getRequestDispatcher(VIEW_FORM);
			request.setAttribute("alert", a);
			
		} catch (Exception e) {
			
			dispatch = request.getRequestDispatcher(VIEW_FORM);
			request.setAttribute("alert", a);
			
		} finally {
			// Ir a la vista
			dispatch.forward(request, response);

		}

	}

}
