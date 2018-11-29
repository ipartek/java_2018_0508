package com.ipartek.formacion.gestor.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.dao.PersonaDAO;
import com.ipartek.formacion.gestor.pojo.Persona;

@WebServlet("/migracion")
public class MigracionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO dao;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = PersonaDAO.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int personasTotales = 0;
		int personasCreadas = 0;
		int errores = 0;

		try {
			File f = new File("c:/ficheros/personas.txt");
			System.out.println(f.getAbsolutePath());
			BufferedReader br = new BufferedReader(new FileReader(f));
			Persona p = new Persona();
			String line = null;
			while ((line = br.readLine()) != null) {
				String tmp[] = line.split(",");
				if (tmp.length == 7 && tmp[5].length() == 9) {
					p.setNombre(tmp[0]);
					p.setApellido1(tmp[1]);
					p.setApellido2(tmp[2]);
					p.setEmail(tmp[4]);
					p.setDni(tmp[5]);

					if (dao.crear(p)) {
						personasCreadas++;
					} else {
						errores++;
					}

				} else {
					errores++;
				}

				personasTotales++;
			}

			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("personasTotales", personasTotales);
			request.setAttribute("personasCreadas", personasCreadas);
			request.setAttribute("errores", errores);
			request.getRequestDispatcher("migrar.jsp").forward(request, response);
		}
	}

}
