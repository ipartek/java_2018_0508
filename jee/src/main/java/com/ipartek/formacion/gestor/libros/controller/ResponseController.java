package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.libros.model.LibroArrayDAO;
import com.ipartek.formacion.gestor.libros.pojo.Libro;

@WebServlet("/ejemplo-response")

public class ResponseController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		try {

			// 1.- Recibir Parametros

			// 2.- Validar Parametros

			// 3.- LLamar modelo DAO

			// 4.- Enviar atributos a la vista

			// 5.- Ir a la vista

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
