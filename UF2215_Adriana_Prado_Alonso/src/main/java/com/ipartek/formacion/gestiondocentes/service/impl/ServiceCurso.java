package com.ipartek.formacion.gestiondocentes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.gestiondocentes.model.CursoDAO;
import com.ipartek.formacion.gestiondocentes.pojo.Curso;
import com.ipartek.formacion.gestiondocentes.service.IServiceCurso;

public class ServiceCurso implements IServiceCurso{
	private static ServiceCurso INSTANCE = null;
	
	private CursoDAO daoCurso = null;
	
	// Logger
	private final static Logger LOG = Logger.getLogger(ServiceCurso.class);
	
	private ServiceCurso() {
		super();
		daoCurso = CursoDAO.getInstance();
		LOG.trace("Instanciado el DAO de Curso");
	}
	
	public static synchronized ServiceCurso getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceCurso();
		}

		return INSTANCE;
	}

	@Override
	public List<Curso> listadoCursos() {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try {
			cursos = (ArrayList<Curso>) daoCurso.getAllCursos();
			LOG.debug("Listado de cursos devuelto");
		} catch (Exception e) {
			LOG.error(e);
		}
		return cursos;
	}

	@Override
	public List<Curso> listadoCursosProfesores() {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try {
			cursos = (ArrayList<Curso>) daoCurso.getCursosProfesores();
			LOG.debug("Listado de cursos mas profesores devuelto");
		} catch (Exception e) {
			LOG.error(e);
		}
		return cursos;
	}

	@Override
	public List<Curso> listadoCursosProfesoresAlumnos() {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try {
			cursos = (ArrayList<Curso>) daoCurso.getCursosProfesoresAlumnos();
			LOG.debug("Listado de cursos mas profesores y alumnos devuelto");
		} catch (Exception e) {
			LOG.error(e);
		}
		return cursos;
	}
	
	
}
