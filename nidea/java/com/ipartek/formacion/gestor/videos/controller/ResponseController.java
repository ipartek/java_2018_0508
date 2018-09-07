package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ejemplo-response")
public class ResponseController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProccess(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");

			out = response.getWriter();

			out.print("<DOCTYPE HTML>");
			out.print("<html lang='en'>");
			out.print("<head>");
			out.print("<meta charset='utf-8'>");

			out.print("<title>The HTML5 Herald</title>");
			out.print("<meta name='description' content='Response'>");
			out.print("<meta name='author' content='SitePoint'>");

			out.print("<link rel='stylesheet' href='css/styles.css?v=1.0'>");

			out.print("</head>");

			out.print("<body>");
			out.print("<h1> Soy un Response </h1>");
			out.print("<p> Soy un Response </p>");
			out.print("<script src='js/scripts.js'></script>");
			out.print("</body>");
			out.print("</html>");
			

			out.flush();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}	
		}

	}
}
