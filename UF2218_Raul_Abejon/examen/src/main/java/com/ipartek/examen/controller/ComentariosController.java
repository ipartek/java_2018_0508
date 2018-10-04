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
@WebServlet(urlPatterns = { "/comentariosController" })

public class ComentariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean flag = false;
	private static ArrayList<Paginas> paginas;
	private static PaginasDao paginasDao;
	private static Paginas paginaInicio;
	private static ArrayList<Paginas> paginasCoincidencia  ;
	Alerts alerta = new Alerts();

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
		paginasCoincidencia = new ArrayList();
		try {
			String textoAutor = request.getParameter("textoAutor");
			String paginasSeleccionada = request.getParameter("pagina");
			String paginaCoincidencia = request.getParameter("paginaCoincidencia");
			String paginaAnterior = request.getParameter("paginaAnterior");
			String paginaSiguiente = request.getParameter("paginaSiguiente");
			String alertaTextoBuscador = request.getParameter("alertaTexto");
			String alertaTipoBuscador = request.getParameter("alertaTipo");
			String buscarElemento = request.getParameter("buscarElemento");
			int paginasSeleccionadaInt;
			//Paginas paginaCoincidencia;
			Paginas paginaCoincidenciaElemento;
			/**
			 * Todas las condiciones pasaran por aqui asi las tengo todas mas ordenadas
			 * y<br>
			 * despues pregunto de forma individual
			 */
			if (comprobarTexto(textoAutor) || paginasSeleccionada != null || buscarElemento != null
					|| paginaAnterior != null || paginaSiguiente != null || alertaTextoBuscador != null) {
				System.out.println("Texto correcto ");
				if (textoAutor != null) {
					/**
					 * Para cuando tenemos accion por el ingreso de texto del textarea
					 */
					paginaInicio = new Paginas((String) session.getAttribute("usuario"), textoAutor);
					paginasDao.insert(paginaInicio);
				}
				if (paginasSeleccionada != null) {
					/**
					 * Para cuando clickamos desde la paginacion del libro
					 */
					paginasSeleccionadaInt = Integer.parseInt(paginasSeleccionada);
					if (paginasSeleccionadaInt >= 1) {
						buscarPaginaXnumero(paginasSeleccionadaInt);
					}
				}
				if (paginaCoincidencia != null) {
					/**
					 * Para cuando solicitamos buscar texto desde el buscador de texto
					 */
					paginasSeleccionadaInt = Integer.parseInt(paginaCoincidencia);
					buscarPaginaXnumero(paginasSeleccionadaInt);

				}
				if(buscarElemento != null) {
					paginaCoincidenciaElemento = buscarCoincidenciaElemento(buscarElemento);
					//aqui lo que seteamos es lo que se produce en buscarCoincidenciaElemento
					//No es un retorno paginaCoincidencia
					request.setAttribute("paginasCoincidencia", paginasCoincidencia);
				}
				if (paginaAnterior != null) {
					/**
					 * Para cuando tenemos accion desde el boton atras
					 */
					paginasSeleccionadaInt = Integer.parseInt(paginaAnterior);
					paginasSeleccionadaInt = paginasSeleccionadaInt - 1;
					buscarPaginaXnumero(paginasSeleccionadaInt);
				}
				if (paginaSiguiente != null) {
					/**
					 * Para cuando tenemos accion desde el boton siguiente
					 */
					paginasSeleccionadaInt = Integer.parseInt(paginaSiguiente);
					paginasSeleccionadaInt = paginasSeleccionadaInt + 1;
					buscarPaginaXnumero(paginasSeleccionadaInt);
				}
				if (alertaTextoBuscador != null) {
					/**
					 * Para cuando nos vienen datos de alerta cuando introducimos el numero de
					 * pagina
					 */
					alerta.setTexto(alertaTextoBuscador);
					alerta.setTipo(alertaTipoBuscador);
				}
				

				request.setAttribute("autor", (String) session.getAttribute("usuario"));
				request.setAttribute("textoAutor", textoAutor);
				request.setAttribute("nPaginas", paginas.size());
			}

		} catch (Exception e) {
			System.out.println("Error en doProcess *LoginController*");
			e.printStackTrace();
		} finally {
			if (paginaInicio == null) {
				paginaInicio = paginas.get(0);
			}
			if (alerta != null) {
				request.setAttribute("alerta", alerta);
			}
			request.setAttribute("paginas", paginas);
			request.setAttribute("paginaInicio", paginaInicio);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

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
				alerta.setTexto("Hemos encontrado coincidencias en las paginas: " + p.getPaginas());
				alerta.setTipo(Alerts.SUCESS);
				paginaInicio = p;
				break;
			} else {
				alerta.setTexto("No Hemos encontrado coincidencias");
				alerta.setTipo(Alerts.SUCESS);

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

}
