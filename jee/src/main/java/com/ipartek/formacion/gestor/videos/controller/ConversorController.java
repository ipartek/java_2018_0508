package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversor")
public class ConversorController extends HttpServlet {

	

	

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		doProcess(request, response);
		
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		
	}

	
	}
