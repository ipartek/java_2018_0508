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
@WebServlet(urlPatterns = { "/ebookController" })

public class EbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean flag = false;
	private static ArrayList<Paginas> paginas;
	private static PaginasDao paginasDao;
	private static Paginas paginaInicio;
	private static ArrayList<Paginas> paginasCoincidencia;
	Alerts alerta = new Alerts();
	final String BUSCAR_ELEMENTO = "1";
	final String BUSCAR_PAGINA = "2";
	final String TEXTO_AUTOR = "3";
	final String PAGINA_ANTERIOR = "4";
	final String PAGINA_SIGUIENTE = "5";

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
		HttpSession session = request.getSession();
		paginas = (ArrayList<Paginas>) paginasDao.getAll();
		paginasCoincidencia = new ArrayList<Paginas>();
		int paginasSeleccionadaInt;
		Paginas paginaCoincidenciaXNumero;

		try {
			String accionRequerida = request.getParameter("accionRequerida");
			String buscarElemento = request.getParameter("buscarElemento"); // x1
			String buscarPagina = request.getParameter("buscarPagina");// x2
			String textoAutor = request.getParameter("textoAutor");// x3
			String paginaAnterior = request.getParameter("paginaAnterior");// x4
			String paginaSiguiente = request.getParameter("paginaSiguiente");// x5
			Alerts alerta = (Alerts) request.getAttribute("alerta");
			String alertaLogin = request.getParameter("alertaLogin");
			
			
			if (accionRequerida != null) {
				switch (accionRequerida) {
				case BUSCAR_ELEMENTO:

					if (buscarElemento != null) {
						buscarCoincidenciaElemento(buscarElemento);
						// aqui lo que seteamos es lo que se produce en buscarCoincidenciaElemento
						// No es un retorno paginaCoincidencia
						request.setAttribute("paginasCoincidencia", paginasCoincidencia);
					}
					break;
				case BUSCAR_PAGINA:

					if (buscarPagina != null) {
						paginaCoincidenciaXNumero = buscarPaginaXNumero(buscarPagina);
						if (paginaCoincidenciaXNumero != null) {
							paginaInicio = paginaCoincidenciaXNumero;
						}
					}

					break;
				case TEXTO_AUTOR:
					if (textoAutor != null) {
						/**
						 * Para cuando tenemos accion por el ingreso de texto del textarea
						 */
						if (comprobarTexto(textoAutor)) {
							paginaInicio = new Paginas((String) session.getAttribute("usuario"), textoAutor);
							paginasDao.insert(paginaInicio);
						}
					}
					break;
					case PAGINA_ANTERIOR:
						if (paginaAnterior != null) {
							/**
							 * Para cuando tenemos accion desde el boton atras
							 */
							paginasSeleccionadaInt = Integer.parseInt(paginaAnterior);
							paginasSeleccionadaInt = paginasSeleccionadaInt - 1;
							buscarPaginaXnumero(paginasSeleccionadaInt);
						}
						break;
					case PAGINA_SIGUIENTE:
						if (paginaSiguiente != null) {
							/**
							 * Para cuando tenemos accion desde el boton siguiente
							 */
							paginasSeleccionadaInt = Integer.parseInt(paginaSiguiente);
							paginasSeleccionadaInt = paginasSeleccionadaInt + 1;
							buscarPaginaXnumero(paginasSeleccionadaInt);
						}
						break;
			}
				
			if (alertaLogin != null) {
				request.setAttribute("alerta", alerta);
			}
			

			}
			request.setAttribute("autor", (String) session.getAttribute("usuario"));
			request.setAttribute("textoAutor", textoAutor);
			request.setAttribute("nPaginas", paginas.size());

		} catch (Exception e) {
			System.out.println("Error en doProcess *EbookController*");
			e.printStackTrace();
		} finally {
			if (paginaInicio == null) {
				paginaInicio = paginas.get(0);
			}
			request.setAttribute("alerta", alerta);
			request.setAttribute("paginas", paginas);
			request.setAttribute("paginaInicio", paginaInicio);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	private Paginas buscarPaginaXNumero(String buscarPagina) {
		/**
		 * Buscamos el objeto por su numero de pagina
		 */
		Paginas paginaPorNumero = null;
		if(buscarPagina != "") {
			int buscarPaginaInt = Integer.parseInt(buscarPagina);
			
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
		}else {
			alerta.setTexto("Por favor introduzca algo en el buscador");
			alerta.setTipo(Alerts.DANGER);
		}
		
		
		return paginaPorNumero;
	}

	private void buscarPaginaXnumero(int paginasSeleccionada) {
		/**
		 * entra el numero de pagina clickado desde el selector si hay coincidencia
		 * nos<br>
		 * coloca el comentario de inicio que es el que se ha seleccionado y<br>
		 * actualizamos alertas si no solo actualizamos alertas<br>
		 */
		paginas = (ArrayList<Paginas>) paginasDao.getAll();
		for (Paginas p : paginas) {
			if (paginasSeleccionada == p.getPaginas()) {
				alerta = null;
				paginaInicio = p;
				break;
			} else {
				alerta.setTexto("No Hemos encontrado coincidencias");
				alerta.setTipo(Alerts.DANGER);

			}

		}

	}

	private boolean comprobarTexto(String textoAutor) {
		/**
		 * Valida el texto entrante por parte del autor. Si tiene igual o mas de 25<br>
		 * caracteres devolvemos un true y configuramos el mensaje de de alerta y
		 * estilo<br>
		 * correcta del comentario Si no, devolvemos un false indicamos msg de fallo
		 * y<br>
		 * ponemos el estilo
		 */
		boolean flag = false;
		if (textoAutor != null) {
			if (textoAutor.length() >= 25) {
				flag = true;
				alerta.setTexto("Pagina dada de alta correctamente");
				alerta.setTipo(Alerts.SUCESS);
			} else {
				alerta.setTexto("La pagina debe contener un minimo de 25 caracteres");
				alerta.setTipo(Alerts.DANGER);
			}
		}
		return flag;
	}

	private void buscarCoincidenciaElemento(String buscarElemento) {
		/**
		 * Comprobamos si el contendio de un string esta en alguno de los comentarios
		 */
		String paginasAlert = "";
		if(buscarElemento != "") {
			if (buscarElemento != null) {
				for (Paginas p : paginas) {
					int intIndex = p.getTexto().toLowerCase().indexOf(buscarElemento.toLowerCase());
					System.out.println(p.getTexto());
					if (intIndex != -1) {

						paginasAlert += " " + p.getPaginas() + ", ";
						paginasCoincidencia.add(p);
					}
				}
				if (paginasCoincidencia == null || paginasCoincidencia.size() == 0) {
					alerta.setTexto("!!!No Hemos encontrado texto coincidente !!");
					alerta.setTipo(Alerts.DANGER);

				} else {
					alerta.setTexto("!!!Hemos encontrado texto coincidente !! en las siguientes paginas : " + paginasAlert);
					alerta.setTipo(Alerts.SUCESS);
				}

			}
		}else {
			alerta.setTexto("!!!Introduzca alguna palabra que quiera buscar !!");
			alerta.setTipo(Alerts.DANGER);
		}
		

	}

}
