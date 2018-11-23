package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.repaso.conection.ConnectionManager;
import com.ipartek.formacion.repaso.pojo.Juego;

/**
 * Servlet implementation class TransaccionController
 */
@WebServlet("/transaccion")
public class TransaccionController extends HttpServlet {

	private static final String SQL_INSERT = "INSERT INTO `juego` (`titulo`, `fecha_lanzamiento`) VALUES ( ?, ? );";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = ConnectionManager.getConnection();

		try {

			// deshabilitar que guarde de forma automatica
			// con.setAutoCommit(false);

			for (int i = 0; i < 5; i++) {

				Juego juego = new Juego("titulo" + i);

				PreparedStatement pst = con.prepareStatement(SQL_INSERT);
				pst.setString(1, juego.getTitulo());
				pst.setDate(2, juego.getFechaLanzamiento());

				if (i == 3) {
					throw new Exception("Opsssssssssssssssss");
				}

			}

			// Si todo funciona guardar
			// con.commit();

			// volver al estado original
			// con.rollback();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		/**
		 * 
		 * Comprobar que el motor de base datos sea INNODB con motor MYISAM no funciona
		 * 
		 * 
		 **/
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/game?useSSL=false", "root", "root");

		try {

			// deshabilitar que guarde de forma automatica
			con.setAutoCommit(false);

			for (int i = 0; i < 5; i++) {

				Juego juego = new Juego("titulo" + i);

				try (PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
					pst.setString(1, juego.getTitulo());
					pst.setDate(2, juego.getFechaLanzamiento());

					pst.executeUpdate();
					System.out.println("insertado " + juego);

					/*
					 * if (i == 1) { // volver al estado original
					 * 
					 * throw new Exception("Opsssssssssssssssss");
					 * 
					 * }
					 */
				}

			} // end for

			// Si todo funciona guardar
			con.commit();
			System.out.println("Comitamos");

		} catch (Exception e) {

			e.printStackTrace();
			con.rollback();
			System.out.println("Rollback");
		}

	}

}
