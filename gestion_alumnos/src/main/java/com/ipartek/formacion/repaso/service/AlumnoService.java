package com.ipartek.formacion.repaso.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ipartek.formacion.repaso.dao.AlumnoDAO;
import com.ipartek.formacion.repaso.pojo.Alumno;

public class AlumnoService {

	private static AlumnoService INSTANCE = null;
	
	AlumnoDAO alumnoDAO = null;

	public static synchronized AlumnoService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AlumnoService();
		}
		return INSTANCE;
	}

	public AlumnoService() {
		super();
		alumnoDAO = AlumnoDAO.getInstance();
		
	}
	
	

	public List<Alumno> listar() throws SQLException {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos = alumnoDAO.listar();
		return alumnos;

	}

	public boolean crear(Alumno a) throws SQLException {
		boolean resul = false;

		if (alumnoDAO.crearAlumno(a)) {
			resul = true;
		}

		return resul;
	}

	public boolean actualizar(Alumno a) throws SQLException {
		boolean resul = false;

		if (alumnoDAO.actualziar(a)) {
			resul = true;
		}

		return resul;

	}

	public List<Alumno> buscarPor(String busqueda) throws SQLException {
		
		List<Alumno> alumnosPorDni = new ArrayList<Alumno>();
		List<Alumno> alumnosPorEmail = new ArrayList<Alumno>();
		List<Alumno> alumnosPorNombre = new ArrayList<Alumno>();
		List<Alumno> alumnosPorapellido1 = new ArrayList<Alumno>();
		List<Alumno> alumnosPorapellido2 = new ArrayList<Alumno>();
		List<Alumno> alumnosFinales = new ArrayList<Alumno>();
		
		alumnosPorDni = alumnoDAO.buscarPorDni(busqueda);
		alumnosPorEmail = alumnoDAO.buscarPorEmail(busqueda);
		alumnosPorNombre = alumnoDAO.buscarPorNombre(busqueda);
		alumnosPorapellido1 = alumnoDAO.buscarPorApellido1(busqueda);
		alumnosPorapellido2 = alumnoDAO.buscarPorApellido2(busqueda);

		if (!alumnosPorDni.isEmpty()) {

			concatList(alumnosPorDni,alumnosFinales);		
		}
		
		if (!alumnosPorEmail.isEmpty()) {

			concatList(alumnosPorEmail, alumnosFinales);
		}
		if (!alumnosPorNombre.isEmpty()) {

			concatList(alumnosPorNombre, alumnosFinales);
		}
		if (!alumnosPorapellido1.isEmpty()) {

			concatList(alumnosPorapellido1, alumnosFinales);
		}
		if (!alumnosPorapellido2.isEmpty()) {

			concatList(alumnosPorapellido2, alumnosFinales);
		}
		


		return alumnosFinales;
	}

	public void concatList(List<Alumno> alumnosPorDni,List<Alumno> alumnosFinales) {

		for(Alumno a : alumnosPorDni) {
			alumnosFinales.add(a);
		}
		
		
	}

}
