package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.AlumnoDAO;
import com.ipartek.formacion.pojo.Alumno;

public class ServiceAlumno implements IServiceAlumno {
	
	private static ServiceAlumno INSTANCE = null;
	private static AlumnoDAO daoAlumno = AlumnoDAO.getInstance();
	
	private ServiceAlumno() {
		super();
	}

	public static synchronized ServiceAlumno getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceAlumno();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Alumno a) throws Exception {
		boolean resul = false;
		if(daoAlumno.insert(a)) {
			resul = true;
		}
		return resul;
	}

	@Override
	public boolean modificar(Alumno a) throws Exception {
		boolean resul = false;
		if(daoAlumno.update(a)) {
			resul = true;
		}
		return resul;
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		boolean resul = false;
		if(daoAlumno.delete(Long.toString(id))) {
			resul = true;
		}
		return resul;
	}

	@Override
	public Alumno buscarPorId(long id) throws Exception {
		Alumno alumno = null;
		alumno = daoAlumno.getById(Long.toString(id));
		return alumno;
	}

	@Override
	public List<Alumno> listar() throws Exception {
		ArrayList<Alumno> alumnos = null;
		alumnos = (ArrayList<Alumno>) daoAlumno.getAll();
		return alumnos;
	}

}
