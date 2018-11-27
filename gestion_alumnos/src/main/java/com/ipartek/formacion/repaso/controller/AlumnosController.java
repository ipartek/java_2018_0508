package com.ipartek.formacion.repaso.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.pojo.Alumno;
import com.ipartek.formacion.repaso.service.AlumnoService;

/**
 * Servlet implementation class AlumnosController
 */
@WebServlet("/alumnos")
public class AlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AlumnoService alumnoService = null;
	
	private final static Logger LOG = Logger.getLogger(AlumnosController.class);

	
	//vistas
	final String FORMULARIO = "formulario.jsp";
	final String LISTADO = "home.jsp";
	final String RESULTADO = "resultado.jsp";
	//acciones
	final String LISTAR = "1";
	final String IR_FORMULARIO = "2";
	final String GUARDAR_ACTUALIZAR = "3";
	final String BUSCAR_POR = "4";
	String vista = LISTADO;
	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlumnosController() {
		super();
		alumnoService = AlumnoService.getInstance();

	}

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
			// recoger parametros
			String op = request.getParameter("op");
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String apellido1 = request.getParameter("apellido1");
			String apellido2 = request.getParameter("apellido2");
			String dni = request.getParameter("dni");
			String email = request.getParameter("email");
			String busqueda = request.getParameter("buscador");
			// procesar parametros validad

			if (op == null || op.equals("")) {
				op = "1";
			}

			switch (op) {
			case LISTAR:
				vista = LISTADO;
				break;

			case IR_FORMULARIO:

				if (id.equals("-1")) {
					vista = FORMULARIO;
				} else {
					vista = FORMULARIO;
					Alumno a = new Alumno();
					a.setId(Long.parseLong(id));
					a.setNombre(nombre);
					a.setApellido1(apellido1);
					a.setApellido2(apellido2);
					a.setDni(dni);
					a.setEmail(email);
					request.setAttribute("alumno", a);
				}
				break;
			case GUARDAR_ACTUALIZAR:
				Alumno a = new Alumno();
				a.setId(Long.parseLong(id));
				a.setNombre(nombre);
				a.setApellido1(apellido1);
				a.setApellido2(apellido2);
				a.setDni(dni);
				a.setEmail(email);
				if(id.equals("-1")) {
					
					if(alumnoService.crear(a)) {
						vista = LISTADO;
					}else {
						vista = FORMULARIO;
					}
					
				}else {
					if(alumnoService.actualizar(a)) {
						vista = LISTADO;
					}else {
						vista = FORMULARIO;
					}
				}
			case BUSCAR_POR:
				ArrayList<Alumno> alumnoBuscado = new ArrayList<Alumno>();
				alumnoBuscado = (ArrayList<Alumno>) alumnoService.buscarPor(busqueda);
				
			 	vista = RESULTADO;
			 	request.setAttribute("alumnosBuscados", alumnoBuscado);
			}

			
			cargarAlumnos();
			request.setAttribute("alumnos", alumnoService.listar());

		}catch (SQLException e){
			
			LOG.error(e.getMessage());
		}
		
		catch (Exception e) {
			
			LOG.error(e.getMessage());
		} finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}

	private void cargarAlumnos() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		Alumno a = new Alumno();

		try {

			if (alumnoService.listar().size() <= 0) {

				archivo = new File("/home/drohne/java/java_2018_0508/gestion_alumnos/alumnos.txt");
				fr = new FileReader(archivo);
				br = new BufferedReader(fr);

				// Lectura del fichero
				String linea = null;

				while ((linea = br.readLine()) != null) {

					System.out.println(linea.length());
					String[] lineaCampos = new String[linea.length()];
					lineaCampos = linea.split(",");
					if (lineaCampos.length == 7) {

						a.setNombre(lineaCampos[0]);
						a.setApellido1(lineaCampos[1]);
						a.setApellido2(lineaCampos[2]);
						a.setDni(lineaCampos[3]);
						a.setEmail(lineaCampos[4]);

						alumnoService.crear(a);
					}
					continue;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
