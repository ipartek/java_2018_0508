package com.ipartek.formacion.cursos.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.cursos.api.controller.CursosController;
import com.ipartek.formacion.cursos.model.AlumnoDAO;
import com.ipartek.formacion.cursos.model.CursoDAO;
import com.ipartek.formacion.cursos.pojo.Alumno;
import com.ipartek.formacion.cursos.pojo.Curso;

public class ServiceCurso {

	private static final Logger LOG = Logger.getLogger(ServiceCurso.class);
	
	private static ServiceCurso INSTANCE = null;

	private static CursoDAO daoCurso;
	private static AlumnoDAO daoALumno;

	private ServiceCurso() {
		super();

		daoCurso = CursoDAO.getInstance();
		LOG.debug("Cargado DAO Curso.");
		LOG.debug(daoCurso);
		
		daoALumno = AlumnoDAO.getInstance();
		LOG.debug("Cargado DAO Alumno.");
		LOG.debug(daoALumno);
	}

	public static synchronized ServiceCurso getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServiceCurso();
		}

		return INSTANCE;
	}

	public List<Curso> listar() throws Exception {

		ArrayList<Curso> cursos = (ArrayList<Curso>) daoCurso.getAll();
		ArrayList<Alumno> alumnos;
		
		for (int i = 0; i < cursos.size() ; i++ ) {
			
			alumnos = (ArrayList<Alumno>) daoALumno.getAlumnosPorCurso(cursos.get(i).getCodigo());
			cursos.get(i).setAlumnos(alumnos);
		}
		
		return cursos;

	}

	public Curso buscarCodigo(long codigo) throws Exception {

		Curso curso = daoCurso.getById(codigo);

		ArrayList<Alumno> alumnos = (ArrayList<Alumno>) daoALumno.getAlumnosPorCurso(curso.getCodigo());
		curso.setAlumnos(alumnos);

		return curso;
	}

}
