package com.ipartek.formacion.libroElectronico.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libroElectronico.model.PaginaArrayListDAO;
import com.ipartek.formacion.libroElectronico.model.pojo.Pagina;
import com.ipartek.formacion.libroElectronico.model.pojo.Usuario;
import com.ipartek.formacion.libroElectronico.pojo.Alert;

/**
 * Servlet implementation class PaginaController
 */
@WebServlet("/pagina")
public class PaginaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PaginaArrayListDAO dao;
	private ArrayList<Pagina> paginas;
	private Pagina pagActual;
	private Pagina pagAnterior;
	private Pagina pagSiguiente;
	private int numPag;
	private Alert alerta;
	private static final int MINPALABRAS=25;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = PaginaArrayListDAO.getInstance();
		
		
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		alerta = new Alert(Alert.DANGER, "La página debe tener al menos 25 palabras");
		try {
			String texto =request.getParameter("texto");
			
			
			Pagina pag = new Pagina();
			HttpSession sesion= request.getSession();
			Usuario u = (Usuario) sesion.getAttribute("usuario");
			
			int palabras=pag.contarPalabras(texto);
			if (palabras>=MINPALABRAS) {
				paginas = (ArrayList<Pagina>) dao.getAll();
				numPag=paginas.size();
				
				pag.setId(numPag+1);
				pag.setAutor(u.getNombre()+" "+u.getPass());
				pag.setTexto(texto);
				paginas.add(pag);
				alerta.setTexto("Página agregada correctamente.");
				alerta.setTipo(Alert.SUCCESS);
				request.setAttribute("alert", alerta);
				request.getRequestDispatcher("home").forward(request, response);
			}else {
				request.setAttribute("alert", alerta);
				request.setAttribute("texto", texto);
				request.getRequestDispatcher("nuevaPagina.jsp").forward(request, response);;
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
