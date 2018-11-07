package com.ipartek.formacion.prestamolibros.service;

import java.util.List;

import com.ipartek.formacion.prestamolibros.model.AlumnoDAO;
import com.ipartek.formacion.prestamolibros.pojo.Alumno;

public class ServicioAlumno implements IService<Alumno>{
	
	private static ServicioAlumno INSTANCE = null;
	
	private AlumnoDAO daoAlumno;
	
	private ServicioAlumno() {
		super();
		daoAlumno = AlumnoDAO.getInstance();
	}

	public static synchronized ServicioAlumno getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioAlumno();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Alumno a) throws Exception {
		
		return daoAlumno.insert(a);
	}

	@Override
	public boolean modificar(Alumno a) throws Exception {
		
		return daoAlumno.update(a);
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		
		return daoAlumno.delete(id);
	}

	@Override
	public Alumno buscar(long id) throws Exception {
		
		return daoAlumno.getById(id);
	}

	@Override
	public List<Alumno> listar() throws Exception {
		
		return daoAlumno.getAll();
	}
	
	

}
