package com.ipartek.formacion.gestion.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.gestion.dao.CursoDAO;
import com.ipartek.formacion.gestion.pojo.Curso;
import com.ipartek.formacion.gestion.service.IServiceCurso;

public class ServiceCurso implements IServiceCurso {

	private final static Logger LOG = Logger.getLogger(ServiceCurso.class);
	private static ServiceCurso INSTANCE = null;
	private static CursoDAO daoCurso = null;

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

		List<Curso> c = null;
		try {
			c = daoCurso.getAll();
		} catch (Exception e) {
			LOG.error(e);
		}
		return c;
	}

}
