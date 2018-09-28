package com.ipartek.formacion.libroElectronicoColaborativo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libroElectronicoColaborativo.model.PaginaArrayListDAO;
import com.ipartek.formacion.libroElectronicoColaborativo.pojo.Pagina;

/**
 * Servlet implementation class EscribirController
 */
@WebServlet("/escribir")
public class EscribirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PaginaArrayListDAO dao;
	private ArrayList<Pagina> paginas;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = PaginaArrayListDAO.getInstance();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();

		try {
			
			//recoger parametros
			String contenido = request.getParameter("pagina");
			String autor = "";
			
			Pagina pagina = new Pagina(contenido, autor);
			
			//Añadir pagina nueva
			dao.insert(pagina);
			
			//Listar todas las paginas
			paginas = (ArrayList<Pagina>) dao.getAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("paginas", paginas);
			request.getRequestDispatcher("../home.jsp").forward(request, response);
		}
		
	}

}
