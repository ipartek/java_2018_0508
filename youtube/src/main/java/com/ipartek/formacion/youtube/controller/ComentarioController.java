package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class ComentarioController
 */
@WebServlet("/comentario")
public class ComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String texto = (String) request.getParameter("comentario-usuario");

			HttpSession session = request.getSession();
			Usuario u = (Usuario) session.getAttribute("usuario");
			String autor = u.getNombre();

			Comentario c = new Comentario(autor, texto);

			ArrayList<Comentario> listaComentarios = (ArrayList<Comentario>) session.getAttribute("comentario");
			if (listaComentarios == null) {
				listaComentarios = new ArrayList<Comentario>();
			}
			listaComentarios.add(c);

			session.setAttribute("comentario", listaComentarios);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.sendRedirect(request.getContextPath() + "/inicio");
		}
	}

}
