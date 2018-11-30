package com.ipartek.formacion.repaso.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.pojo.Alert;
import com.ipartek.formacion.repaso.pojo.Alumno;
import com.ipartek.formacion.repaso.service.AlumnoService;

/**
 * Servlet implementation class ArchivoController
 */
@WebServlet("/archivo")
public class ArchivoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(ArchivoController.class);

	ValidatorFactory factory = null;
	Validator validator = null;
	Alert alerta = new Alert();

	AlumnoService servicioAlumno = null;
	int alumnosDniDuplicado = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArchivoController() {
		super();
		servicioAlumno = AlumnoService.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

		// TODO Auto-generated constructor stub
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

			procesarArchivo(request, response);
		} catch (SQLException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				alumnosDniDuplicado++;
			}

		}

	}

	protected void procesarArchivo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		long startTime = System.currentTimeMillis();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		Alumno a = new Alumno();
		String op = request.getParameter("op");
		int registrosGuardados = 0;
		int registrosNoGuardados = 0;
		int nLineasCamposIns = 0;// cuenta el numero de lineas menores de 7 campos
		int nLineasVacias = 0;
		int lineasTotales = 0;
		int dniDuplicados = 0;// recoge los errores por duplicidad arrojados por la db
		int nlineasCampoNombreVacio = 0;
		int nlineasCampoApellido1Vacio = 0;
		int nlineasCampoApellido2Vacio = 0;
		int nlineasCampoEmailVacio = 0;
		int nlineasCampoDniLongitud = 0;
		int registrosBorrados = 0;

		// Para la captura de las lineas que no pasan la valadicacion de
		// javax.validation
		String lineasVacias = " ";
		String lineasCampoIns = " ";
		String lineasCampoNombreVacio = " ";
		String lineasDniDuplicados = " ";// recoge la linea que provoca error de duplicidad en la db
		String lineasCampoApellido1Vacio = " ";
		String lineasCampoApellido2Vacio = " ";
		String lineasCampoEmailVacio = " ";
		String lineasCampoDniLongitud = " ";
		String msgControl = "";// lo usare para filtrar el conteo de determinados fallos
		Set<ConstraintViolation<Alumno>> violations = null;

		try {
			if (op.contains("2")) {
				registrosBorrados = EliminiarDatos();
				// Inicializo los valores despues de borrar los registros
				registrosGuardados = 0;
				registrosNoGuardados = 0;
				nLineasCamposIns = 0;// cuenta el numero de lineas menores de 7 campos
				nLineasVacias = 0;
				lineasTotales = 0;
				dniDuplicados = 0;// recoge los errores por duplicidad arrojados por la db
				nlineasCampoNombreVacio = 0;
				nlineasCampoApellido1Vacio = 0;
				nlineasCampoApellido2Vacio = 0;
				nlineasCampoEmailVacio = 0;
				nlineasCampoDniLongitud = 0;

			}
			if (op.contains("1")) {

				// File("/home/drohne/java/java_2018_0508/gestion_alumnos/alumnos_test.txt");
				archivo = new File("c:/alumnos.txt");

				fr = new FileReader(archivo);
				br = new BufferedReader(fr);

				String linea = null;

				while ((linea = br.readLine()) != null) {
					lineasTotales++;
					String[] lineaCampos = new String[linea.length()];
					// lineas vacias
					if (linea.length() == 0) {
						nLineasVacias++;
						registrosNoGuardados++;
						lineasVacias += String.valueOf(lineasTotales) + ", ";
						continue;
					}

					lineaCampos = linea.split(",");
					// Lineas con menos de 7 campos
					if (lineaCampos.length != 7) {

						registrosNoGuardados++;
						nLineasCamposIns++;
						lineasCampoIns += String.valueOf(lineasTotales) + ", ";
						continue;
					}

					if (lineaCampos.length == 7) {

						a.setNombre(lineaCampos[0]);
						a.setApellido1(lineaCampos[1]);
						a.setApellido2(lineaCampos[2]);
						a.setEmail(lineaCampos[4]);
						a.setDni(lineaCampos[5]);

						violations = validator.validate(a);
						if (violations.size() > 0) {
							registrosNoGuardados++;
							for (ConstraintViolation<Alumno> violation : violations) {

								msgControl = violation.getPropertyPath() + ":" + violation.getMessage();

								if (msgControl.contains("nombre:no puede estar vacío")) {

									lineasCampoNombreVacio += String.valueOf(lineasTotales) + ", ";
									nlineasCampoNombreVacio++;
								}
								if (msgControl.contains("apellido1:no puede estar vacío")) {

									lineasCampoApellido1Vacio += String.valueOf(lineasTotales) + ", ";
									nlineasCampoApellido1Vacio++;

								}
								if (msgControl.contains("apellido2:no puede estar vacío")) {

									lineasCampoApellido2Vacio += String.valueOf(lineasTotales) + ", ";
									nlineasCampoApellido2Vacio++;
								}
								if (msgControl.contains("dni:la longitud tiene que estar entre")) {

									lineasCampoDniLongitud += String.valueOf(lineasTotales) + ", ";
									nlineasCampoDniLongitud++;
								}
								if (msgControl.contains("email:no puede estar vacío")) {

									lineasCampoEmailVacio += String.valueOf(lineasTotales) + ", ";
									nlineasCampoEmailVacio++;
								}
							}
						} else {
							try {

								servicioAlumno.crear(a);
								registrosGuardados++;

							} catch (SQLIntegrityConstraintViolationException e) {

								if (e.getMessage().contains("Duplicate entry")) {
									dniDuplicados++;
									registrosNoGuardados++;
									lineasDniDuplicados += String.valueOf(lineasTotales) + ", ";
									continue;

								}
								LOG.error(e.getMessage());
							}

						}

					}

				}
			}
		} finally {
			long endTime = System.currentTimeMillis();
			long segundosTotales = (endTime - startTime);
			request.setAttribute("tiempoEjecucion", segundosTotales);
			request.setAttribute("registrosBorrados", registrosBorrados);
			request.setAttribute("dniDuplicados", dniDuplicados);
			request.setAttribute("registrosGuardados", registrosGuardados);
			request.setAttribute("registrosNoGuardados", registrosNoGuardados);
			request.setAttribute("nLineasCamposIns", nLineasCamposIns);
			request.setAttribute("lineasCampoIns", lineasCampoIns);
			request.setAttribute("lineasVacias", lineasVacias);
			request.setAttribute("lineasTotales", lineasTotales);
			request.setAttribute("lineasDniDuplicados", lineasDniDuplicados);
			request.setAttribute("lineasCamposMal", lineasCampoNombreVacio);
			request.setAttribute("nlineasCampoNombreVacio", nlineasCampoNombreVacio);
			request.setAttribute("lineasCampoNombreVacio", lineasCampoNombreVacio);
			request.setAttribute("lineasCampoDniLongitud", lineasCampoDniLongitud);
			request.setAttribute("nlineasCampoDniLongitud", nlineasCampoDniLongitud);
			request.setAttribute("nLineasVacias", nLineasVacias);
			request.setAttribute("nlineasCampoApellido1Vacio", nlineasCampoApellido1Vacio);
			request.setAttribute("lineasCampoApellido1Vacio", lineasCampoApellido1Vacio);
			request.setAttribute("nlineasCampoApellido2Vacio", nlineasCampoApellido2Vacio);
			request.setAttribute("lineasCampoApellido2Vacio", lineasCampoApellido2Vacio);
			request.setAttribute("lineasCampoEmailVacio", lineasCampoEmailVacio);
			request.setAttribute("nlineasCampoEmailVacio", nlineasCampoEmailVacio);

			try {

				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				LOG.error(e2.getMessage());
			}
			request.getRequestDispatcher("/resumen.jsp").forward(request, response);
		}

	}

	private int EliminiarDatos() throws SQLException {
		int lineasAfectadas = 0;

		lineasAfectadas = servicioAlumno.eliminar();
		return lineasAfectadas;
	}

}
