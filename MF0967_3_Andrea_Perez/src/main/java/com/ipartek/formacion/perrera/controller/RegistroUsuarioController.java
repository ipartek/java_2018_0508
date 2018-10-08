package com.ipartek.formacion.perrera.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.perrera.model.Alert;
import com.ipartek.formacion.perrera.model.Chip;
import com.ipartek.formacion.perrera.model.Perro;
import com.ipartek.formacion.perrera.model.PerroArrayListDAO;

/**
 * Servlet implementation class RegistroUsuarioController
 */
@WebServlet("/registro")
public class RegistroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_REGISTRO = "/privado/alta_perro.jsp";
	private static final String VIEW_HOME = "home";

	private static PerroArrayListDAO daoPerros;
	private static ArrayList<Perro> perros;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// Se ejecuta solo con la primera peticion. El resto van al service
		super.init(config);
		daoPerros = PerroArrayListDAO.getInstance();

	}

	@Override
	public void destroy() {
		// Se ejecuta al parar el servidor
		super.destroy();
		daoPerros = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = VIEW_REGISTRO;
		Alert alert = null;

		try {

			Perro p = new Perro();
			Chip c = new Chip();

			// Recoger parametros
			String apadrinado = (String) request.getParameter("apadrinado");
			String nombre = (String) request.getParameter("nombre");
			String edad = (String) request.getParameter("edad");
			String raza = (String) request.getParameter("raza");
			String peso = (String) request.getParameter("peso");
			String numero1 = (String) request.getParameter("numero1");
			String numero2 = (String) request.getParameter("numero2");
			String anyo = (String) request.getParameter("anyo");
			String img = (String) request.getParameter("img");
			String latitud = (String) request.getParameter("latitud");
			String longitud = (String) request.getParameter("longitud");

			if ("".equals(apadrinado)) {
				p.setApadrinado(true);
			}else {
				p.setApadrinado(false);
			}

			// guardamos datos del chip
			String numeroID = numero1 + "-" + numero2;
			c.setNumero(numeroID);
			c.setAnyo(anyo);
			c.setLatitud(Long.parseLong(latitud));
			c.setLongitud(Long.parseLong(longitud));

			// guardamos datos del animal
			p.setNombre(nombre);
			p.setEdad(Integer.parseInt(edad));
			p.setPeso(Float.parseFloat(peso));
			p.setRaza(raza);

			if (img != null) {
				p.setImg(img);
			}

			p.setChip(c);

			if (daoPerros.insert(p)) {
				alert = new Alert(Alert.ALERT_SUCCESS, "Añadido nuevo registro");
				view = VIEW_HOME;
			} else {
				alert = new Alert(Alert.ALERT_WARNING, "Error al registrar al nuevo animal");
				view = VIEW_REGISTRO;
			}

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();

		} finally {
			// enviar atributos e ir a la vista

			if (view.equals(VIEW_HOME)) {
				request.getSession().setAttribute("alert", alert);
				response.sendRedirect(request.getContextPath() + "/" + VIEW_HOME);
			} else {
				request.setAttribute("alert", alert);
				request.getRequestDispatcher(view).forward(request, response);
			}

		}
	}

}
