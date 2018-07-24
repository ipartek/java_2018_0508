package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saludo
 */
@WebServlet("/saludo2")
public class Saludo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saludo2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String user = req.getParameter("nombre");
    if ("pepe".equals(user)) {
    response(resp, "login ok");
    } else {
    response(resp, "Error de login");
    }
    }
     
    private void response(HttpServletResponse resp, String msg)
    throws IOException {
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<t1>" + msg + "</t1>");
    out.println("</body>");
    out.println("</html>");
    }

}
