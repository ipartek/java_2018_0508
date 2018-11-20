package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BuscarController
 */
@WebServlet("/backoffice/buscar")
public class BuscarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario;
	private Alert alert;

	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		daoUsuario = UsuarioDAO.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		daoUsuario = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String buscador = request.getParameter("buscador");
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
			ArrayList<Usuario> usuariosEncontrados = new ArrayList<Usuario>();
			
			for(Usuario u : usuarios) {
				if(u.getNombre().toLowerCase().contains(buscador.toLowerCase())) {
					usuariosEncontrados.add(u);
				}
			}
			
			alert = new Alert(Alert.SUCCESS, "Se han encontrado " + usuariosEncontrados.size() + " usuarios cuyo nombre contiene '" + buscador + "'");
			
			if(usuariosEncontrados.size() == 0) {
				alert.setTipo(Alert.DANGER);
			}
			
			if(usuariosEncontrados.size() == 1) {
				alert.setTexto("Se ha encontrado " + usuariosEncontrados.size() + " usuario cuyo nombre contiene '" + buscador + "'");
			}
			
			request.setAttribute("alert", alert);
			request.setAttribute("usuarios", usuariosEncontrados);
			request.setAttribute("nUsuarios", usuariosEncontrados.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
			
		}finally {
			request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
		}
		
		
		
	}

}
