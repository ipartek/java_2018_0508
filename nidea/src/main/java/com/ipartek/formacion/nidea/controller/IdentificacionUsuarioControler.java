package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.nidea.model.ProductosDao;
import com.ipartek.formacion.nidea.pojo.Producto;
import com.ipartek.formacion.nidea.pojo.Usuario;



/**
 * Servlet implementation class ListarControler
 */
@WebServlet("/identificacionUsuarioControler")
public class IdentificacionUsuarioControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Usuario> Usuarios;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdentificacionUsuarioControler() {
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
		System.out.println("***POST***");
		request.getRequestDispatcher("usuarioLoginBienvenida.jsp").forward(request, response);
		doGet(request, response);
	}

}
