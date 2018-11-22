package com.ipartek.formacion.gestiondocente.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.gestiondocente.model.CursoDAO;
import com.ipartek.formacion.gestiondocente.pojo.Curso;
import com.ipartek.formacion.gestiondocente.service.IServiceCurso;

public class ServiceCurso implements IServiceCurso {

	private static ServiceCurso INSTANCE = null;
	private static CursoDAO daoCurso = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	private final static Logger LOG = Logger.getLogger(ServiceCurso.class);

	private ServiceCurso() {
		super();
		daoCurso = CursoDAO.getInstance();
	}

	public static synchronized IServiceCurso getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceCurso();
		}
		return INSTANCE;
	}

	@Override
	public List<Curso> listar() {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try {

			cursos = (ArrayList<Curso>) daoCurso.getAll();
		} catch (Exception e) {
			LOG.debug(e);
		}

		return cursos;
	}

}
