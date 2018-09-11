package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Usuario;


@WebServlet("/login")


	public class UsuarioController extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
	       
	   
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
				
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
			
				//recoger parametros
				String nombre = request.getParameter("nombre");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
			

				
				
				//validar parametros
				
				if ( password.isEmpty()  ) {
					
					//TODO validar resto de campos
					
					request.setAttribute("alert", new Alert( Alert.WARNING , "Faltan campos obligatorios") );
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
		
					
				}else {
				
				
					//crear Producto a traves de parametros recibidos del formulario
					Usuario u = new Usuario();
					u.setNombre(nombre);
					u.setPassword(password);
					u.setEmail(email);
				
					
					//pasa parametro
					request.setAttribute("usuario",  u );
					request.setAttribute("alert", new Alert( Alert.SUCCESS , "Registro Dado de Alta") );
					
					//ir a la vista
					request.getRequestDispatcher("registroUsuarios.jsp").forward(request, response);
				}	
				
				
			}catch (Exception e) {
				
				e.printStackTrace();
				
				//enviar mensaje al usuario
				request.setAttribute("alert", new Alert() );
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}	
				
		}

	}
