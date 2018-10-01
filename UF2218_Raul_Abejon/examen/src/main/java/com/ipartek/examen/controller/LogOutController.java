package com.ipartek.examen.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/logout")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Antes de realizar GET o POST LogoutController");

		/*
		 * Cookie recuerdameUsuario = new Cookie("recuerdameUsuario");
		 * 
		 * System.out.println(recuerdame); //recuperar todas las cookies
		 * 
		 * //gestionar cookies ultima visita
		 * 
		 * response.addCookie(recuerdame);
		 */
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Cookie cVisita = new Cookie("cVisita", URLEncoder.encode(dateFormat.format(new Date()), "UTF-8"));
		cVisita.setMaxAge(60 * 60 * 24 * 365);// 1 año
		// gestionar cookies ultima visita
		response.addCookie(cVisita);

		super.service(request, response); // llama a los metodos GET o POST

		// despues de realizar GET o POST

		// request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet en logoutcontroller");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("depost en logoutcontroller");
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		try {
			if (session != null) {
				// para borrar los usuarios de la sesion
				session.removeAttribute("usuario");
				session.invalidate();
				session = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/* request.getRequestDispatcher("home.jsp").forward(request, response); */
			response.sendRedirect(request.getContextPath() + "/comentariosController");
		}

	}

}