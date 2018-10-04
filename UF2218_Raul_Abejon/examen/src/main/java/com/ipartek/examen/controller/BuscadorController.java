package com.ipartek.examen.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.examen.model.dao.PaginasDao;
import com.ipartek.examen.model.pojo.Alerts;
import com.ipartek.examen.model.pojo.Paginas;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/buscadorControler" })

public class BuscadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean flag = false;
	private static ArrayList<Paginas> paginas;
	private static PaginasDao paginasDao;
	private static Paginas paginaInicio;
	Alerts alerta = new Alerts();
	private static ArrayList<Paginas> paginasCoincidencia;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		paginasDao = PaginasDao.getInstance();
		paginas = (ArrayList<Paginas>) paginasDao.getAll();

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Pasa por doGet");
		doProcess(request, response);
		// this.getServletConfig();
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Paginas paginaCoincidencia;
		HttpSession session = request.getSession();

		try {
			String buscarElemento = request.getParameter("buscarElemento");
			String buscarPagina = request.getParameter("buscarPagina");
			System.out.println("Estamos en BuscadorControler");
			System.out.println(buscarElemento);
			paginaCoincidencia = buscarCoincidenciaElemento(buscarElemento);
			if (paginaCoincidencia != null || buscarPagina != null) {
				if (paginaCoincidencia != null) {
					request.getRequestDispatcher(
							"/comentariosController?paginaCoincidencia=" + paginaCoincidencia.getPaginas())
							.forward(request, response);
				}
				if (buscarPagina != null) {
					paginaCoincidencia = buscarElementoPagina(buscarPagina);
					if (paginaCoincidencia != null) {
						request.getRequestDispatcher(
								"/comentariosController?paginaCoincidencia=" + paginaCoincidencia.getPaginas()
										+ "&alertaTexto=" + alerta.getTexto() + "&alertaTipo=" + alerta.getTipo())
								.forward(request, response);
					} else {
						request.getRequestDispatcher("/comentariosController?alertaTexto=" + alerta.getTexto()
								+ "&alertaTipo=" + alerta.getTipo()).forward(request, response);

					}

				}

			} else {
				request.getRequestDispatcher(
						"/comentariosController?alertaTexto=" + alerta.getTexto() + "&alertaTipo=" + alerta.getTipo())
						.forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("Error en doProcess *LoginController*");
			alerta.setTexto("Pagina no encontrada ");
			alerta.setTipo(Alerts.DANGER);
			e.printStackTrace();
			request.getRequestDispatcher(
					"/comentariosController?alertaTexto=" + alerta.getTexto() + "&alertaTipo=" + alerta.getTipo())
					.forward(request, response);
		} finally {

		}

	}

	private Paginas buscarElementoPagina(String buscarPagina) {
		/**
		 * Buscamos el objeto por su numero de pagina
		 */
		int buscarPaginaInt = Integer.parseInt(buscarPagina);
		Paginas paginaPorNumero = null;
		for (Paginas p : paginas) {
			if (p.getPaginas() == buscarPaginaInt) {
				alerta.setTexto("!!!Tenemos la pagina que solicitas !! Enseguida podras visualizarla en tu ebook");
				alerta.setTipo(Alerts.SUCESS);
				paginaPorNumero = p;
				break;
			} else {
				alerta.setTexto("Pagina no encontrada ");
				alerta.setTipo(Alerts.DANGER);
			}
		}
		return paginaPorNumero;
	}

	private Paginas buscarCoincidenciaElemento(String buscarElemento) {
		/**
		 * Comprobamos si el contendio de un string esta en alguno de los comentarios
		 */
		Paginas paginaCoincidencia = null;
		if (buscarElemento != null) {
			for (Paginas p : paginas) {
				int intIndex = p.getTexto().toLowerCase().indexOf(buscarElemento.toLowerCase());
				System.out.println(p.getTexto());
				if (intIndex != -1) {
					alerta.setTexto("!!!Hemos encontrado texto coincidente !! en las siguientes paginas : "
							+ p.getPaginas() + " Le redirecionamos a la pagina con la primera coincidencia");
					alerta.setTipo(Alerts.SUCESS);
					paginaCoincidencia = p;
					paginasCoincidencia.add(p);
					
				} else {
					alerta.setTexto("!!!No hemos encontrado texto coincidente !!  . Texto buscado : " + buscarElemento);
					alerta.setTipo(Alerts.SUCESS);
				}

			}

		}
		return paginaCoincidencia;
	}

	/*
	 * private void buscarPaginaXnumero(int paginasSeleccionada) {
	 *//**
		 * muy parecida a buscarElementoPagina solo que esta ya recibe un int en vez de
		 * un string
		 *//*
			 * paginas = (ArrayList<Paginas>) paginasDao.getAll(); for(Paginas p : paginas )
			 * { if (paginasSeleccionada == p.getPaginas()) { paginaInicio = p; break; } }
			 * 
			 * }
			 * 
			 * private boolean comprobarTexto(String textoAutor) { boolean flag = false;
			 * if(textoAutor != null) { if (textoAutor.length() >=25) { flag= true; } }
			 * return flag; }
			 */

}
