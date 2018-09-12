package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.nidea.model.ProductosDao;
import com.ipartek.formacion.nidea.model.UsuariosDao;
import com.ipartek.formacion.nidea.pojo.Producto;
import com.ipartek.formacion.nidea.pojo.Usuario;



/**
 * Servlet implementation class ListarControler
 */
@WebServlet("/LoginUsuariosControler")
public class LoginUsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuariosDao usuariosDao;
	private static ArrayList<Usuario> Usuarios;
	private boolean accessSignal;
	private String estilos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsuariosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList test = new ArrayList<Producto>();
		System.out.println("***GET***");
		
		request.getRequestDispatcher("usuarioLoginBienvenida.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("***POST***");
			//recogemos parametros
			String nombreUsuario = request.getParameter("nombreUsuario");
			String passUsuario = request.getParameter("passUsuario");
			usuariosDao = usuariosDao.getInstance();
			
			//validaciones
			accessSignal = comprobarUsuario(nombreUsuario, passUsuario);
			String estilos = actualizarEstilos();
			
			
			//
			
			request.setAttribute("accessSignal", accessSignal);
			request.setAttribute("estilos", estilos);
			
			doGet(request, response);
		} catch (Exception e) {
			System.out.println("Error en IdentificacionUsuarioControler");
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("usuarioLoginBienvenida.jsp").forward(request, response);
		}
		
	}

	private String actualizarEstilos() {
		String est = null;
		
		if(accessSignal == true) {
			est= "alert alert-success";
		}else {
			est = "alert alert-danger";
		}
		return est;
	}

	private boolean comprobarUsuario(String nombreUsuario, String passUsuario) {
		Usuarios = (ArrayList<Usuario>) usuariosDao.getAll();
		for (Usuario u : Usuarios) {
			if (nombreUsuario.equals(u.getNombre()) && passUsuario.equals(u.getPassword())){
				accessSignal = true;
			}
		}
		return accessSignal;
	}

}
