package com.andrea.perez.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andrea.perez.model.PaginaDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Pagina;
import com.andrea.perez.pojo.Usuario;

@WebServlet("/paginaControl")
public class PaginaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int MINPALABRAS = 25;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Recogemos datos del formEscribir
		String texto = request.getParameter("texto");

		// Validamos que el texto tenga mas de 25 palabras

		HttpSession sesion = request.getSession();
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		StringTokenizer st = new StringTokenizer(texto);
		int numPag = 0;
		Alert alert = null;

		try {

			// Controla numero de palabras insertadas
			if (st.countTokens() >= MINPALABRAS) {

				PaginaDAO daoPag = PaginaDAO.getInstance();
				ArrayList<Pagina> paginas = (ArrayList<Pagina>) daoPag.getAll();

				numPag = paginas.size();
				// Creamos nueva pagina con los datos
				Pagina pag = new Pagina(numPag + 1,texto,u.getNombre());
				// Agregamos pagina al libro
				paginas.add(pag);
				alert = new Alert(Alert.ALERT_SUCCESS, "Pagina creada con exito.Vuelve al principal para verlo");
				
				request.setAttribute("alert", alert);
				

			} else {
				alert = new Alert(Alert.ALERT_WARNING,
						"Palabras insuficientes,recuerda que tiene que ser como minimo 25 palabras");
				request.setAttribute("texto", texto);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}finally {
			request.setAttribute("alert", alert);

			request.getRequestDispatcher("backoffice/escribirPagina.jsp").forward(request, response);
		}

	}
}
