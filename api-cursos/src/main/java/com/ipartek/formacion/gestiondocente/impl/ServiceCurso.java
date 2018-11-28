package com.ipartek.formacion.gestiondocente.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.gestiondocente.dao.AlumnosDao;
import com.ipartek.formacion.gestiondocente.dao.CursosDao;
import com.ipartek.formacion.gestiondocente.dao.MaestrosDao;
import com.ipartek.formacion.gestiondocente.pojo.Alumno;
import com.ipartek.formacion.gestiondocente.pojo.Cliente;
import com.ipartek.formacion.gestiondocente.pojo.Curso;
import com.ipartek.formacion.gestiondocente.pojo.Profesor;

public class ServiceCurso {

	private static ServiceCurso INSTANCE = null;
	private static CursosDao cursosDao = null;
	private static MaestrosDao mastrosDao = null;
	private static AlumnosDao alumnosDao = null;

	static ValidatorFactory factory = null;
	static Validator validator = null;
	private final String LISTAR = "0";
	private final String LISTAR_CON_MAESTROS = "1";
	private final String LISTAR_CON_MAESTROS_ALUMNOS = "2";

	public static synchronized ServiceCurso getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServiceCurso();
		}

		return INSTANCE;
	}

	public ServiceCurso() {
		alumnosDao = AlumnosDao.getInstance();
		mastrosDao = MaestrosDao.getInstance();
		cursosDao = CursosDao.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();
	}

	public List<Curso> listar(String accion) throws Exception {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		if (accion != null) {

			Profesor profe = new Profesor();
			Alumno alumno = new Alumno();

			switch (accion) {
			case LISTAR:

				cursos = (ArrayList<Curso>) cursosDao.getAllCursos();

				break;
			case LISTAR_CON_MAESTROS:

				cursos = (ArrayList<Curso>) cursosDao.getAllCursosProfesores();
				for (Curso c : cursos) {
					profe = mastrosDao.getById(c.getProfesor().getCodigo());
					c.setProfesor(profe);
				}

				break;

			case LISTAR_CON_MAESTROS_ALUMNOS:

				cursos = (ArrayList<Curso>) cursosDao.getAllCursosProfesoresAlumnos();

				if (cursos != null) {

					for (Curso c : cursos) {
						
						profe = mastrosDao.getById(c.getProfesor().getCodigo());
						c.setProfesor(profe);

						alumno = alumnosDao.getById(c.getAlumno().getCodigo());
						c.setAlumno(alumno);

						
					
						
					}

				}
				break;
			default:
				throw new Exception("Por favor introduzca una opcion valida");
			}
		}
		return cursos;
	}

	public List<Curso> listaCursosProfesoresr() throws Exception {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		cursos = (ArrayList<Curso>) cursosDao.getAllCursosProfesores();

		return cursos;
	}

}
