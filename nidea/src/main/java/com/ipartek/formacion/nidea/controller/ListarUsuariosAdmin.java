package com.ipartek.formacion.nidea.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.ipartek.formacion.nidea.model.UsuariosDao;
import com.ipartek.formacion.nidea.pojo.Usuario;



/**
 * Servlet implementation class ListarControler
 */
@WebServlet("/listarUsuariosAdmin")
public class ListarUsuariosAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuariosDao usuariosDao;
	private static ArrayList<Usuario> usuarios;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarUsuariosAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			System.out.println("***GET*** listarUsuariosAdmin" );
			
			//productos.insert(new Producto());
			
			//listado de videos
			usuariosDao = UsuariosDao.getInstance();
			usuarios = (ArrayList<Usuario>) usuariosDao.getAll();	
			if (usuarios != null) {
				request.setAttribute("usuarios", usuarios);
				//request.getRequestDispatcher("resultadoProductosAdmin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Error en doget listarUsuariosAdmin");
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("resultadoUsuariosAdmin.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***POST***");
		doGet(request, response);
	}

}
