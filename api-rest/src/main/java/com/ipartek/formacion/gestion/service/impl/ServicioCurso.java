package com.ipartek.formacion.gestion.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.gestion.DAO.CursoDAO;
import com.ipartek.formacion.gestion.conection.ConnectionManager;
import com.ipartek.formacion.gestion.pojo.Curso;

public class ServicioCurso {

	private final static Logger LOG = Logger.getLogger(ConnectionManager.class);
	private static ServicioCurso INSTANCE = null;
	private static CursoDAO daoCurso = null;

	ValidatorFactory factory = null;
	Validator validator = null;

	private ServicioCurso() {
		super();
		daoCurso = CursoDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public static synchronized ServicioCurso getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioCurso();
		}

		return INSTANCE;
	}

	public List<Curso> listarCurso() {
		List<Curso> cursos = new ArrayList<Curso>();

		try {
			cursos = daoCurso.listarCurso();
		} catch (Exception e) {
			LOG.error(e);
		}

		return cursos;
	}

	public List<Curso> listarCursoConProfesor() {
		List<Curso> cursos = new ArrayList<Curso>();

		try {
			cursos = daoCurso.listarCursoProfesor();
		} catch (Exception e) {
			LOG.error(e);
		}

		return cursos;
	}

	public List<Curso> listarCursoAlumno() {
		List<Curso> cursos = new ArrayList<Curso>();

		try {
			cursos = daoCurso.listarCursoAlumno();

		} catch (Exception e) {
			LOG.error(e);
		}

		return cursos;
	}

}
