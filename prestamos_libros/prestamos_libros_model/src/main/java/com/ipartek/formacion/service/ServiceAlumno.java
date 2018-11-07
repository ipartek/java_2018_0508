package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.model.AlumnoDAO;
import com.ipartek.formacion.pojo.Alumno;

public class ServiceAlumno implements IServiceAlumno {

	AlumnoDAO daoAlumno;

	private static ServiceAlumno INSTANCE = null;

	private ServiceAlumno() {
		super();
		daoAlumno = AlumnoDAO.getInstance();
	}

	public static synchronized ServiceAlumno getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceAlumno();
		}
		return INSTANCE;
	}
	
	
	@Override
	public ArrayList<Alumno> listar() throws Exception {
		ArrayList<Alumno> Alumnos = new ArrayList<Alumno>();
		Alumnos = (ArrayList<Alumno>) daoAlumno.getAll();
		return Alumnos;
	}

	@Override
	public boolean crear(Alumno Alumno) throws Exception {
		boolean resul = false;
		resul = daoAlumno.insert(Alumno);
		return resul;
	}

	@Override
	public boolean modificar(Alumno Alumno) throws Exception {
		boolean resul = false;
		resul = daoAlumno.update(Alumno);
		return resul;
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		boolean resul = false;
		resul = daoAlumno.delete(id);
		return resul;
	}

	@Override
	public Alumno buscar(long id) throws Exception {
		Alumno e = null;
		e = daoAlumno.getById(id);
		return e;
	}

}
