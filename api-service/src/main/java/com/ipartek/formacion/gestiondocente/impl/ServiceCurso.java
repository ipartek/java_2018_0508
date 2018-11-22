package com.ipartek.formacion.gestiondocente.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.gestiondocente.dao.CursosDao;
import com.ipartek.formacion.gestiondocente.pojo.Curso;

public class ServiceCurso {

	private static ServiceCurso INSTANCE = null;
	private static CursosDao cursosDao = null;

	static ValidatorFactory factory = null;
	static Validator validator = null;

	public static synchronized ServiceCurso getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServiceCurso();
		}

		return INSTANCE;
	}

	public ServiceCurso() {
		cursosDao = CursosDao.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();
	}

	public List<Curso> listar() throws Exception {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		cursos = (ArrayList<Curso>) cursosDao.getAllCursos();

		return cursos;
	}

	public List<Curso> listaCursosProfesoresr() throws Exception {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		cursos = (ArrayList<Curso>) cursosDao.getAllCursosProfesores();

		return cursos;
	}

}
