package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.repaso.conection.ConnectionManager;
import com.ipartek.formacion.repaso.pojo.Juego;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/transaction")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL_INSERT = "INSERT INTO `juego` (`titulo`, `fecha_lanzamiento`) VALUES (?, ?);";


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = ConnectionManager.getConnection();
		
		try {
			// Deshabilitar que guarde de forma automatica
			con.setAutoCommit(false);
			
			for (int i = 0; i < 5; i++) {
				Juego juego= new Juego();
						java.sql.PreparedStatement pst = con.prepareStatement(SQL_INSERT);
							pst.setString(1, juego.getTitulo());
							pst.setDate(2, juego.getFechaLanzamiento());
			
				
			}

			// Si todo funviona guardar
			con.commit();
			
			//volver al estado original
			con.rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
