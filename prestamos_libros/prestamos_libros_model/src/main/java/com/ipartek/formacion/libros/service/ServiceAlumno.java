package com.ipartek.formacion.libros.service;

import java.util.List;

import com.ipartek.formacion.libros.model.AlumnoDAO;
import com.ipartek.formacion.libros.pojo.Alert;
import com.ipartek.formacion.libros.pojo.Alumno;

public class ServiceAlumno implements ICRUDService<Alumno> {

	private static ServiceAlumno INSTANCE = null;

	private static AlumnoDAO alumnosDAO;

	private ServiceAlumno() {
		super();
		alumnosDAO = AlumnoDAO.getInstance();
	}

	public static synchronized ServiceAlumno getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServiceAlumno();
		}

		return INSTANCE;
	}

	@Override
	public List<Alumno> listar() throws Exception {

		return alumnosDAO.getAll();
	}

	public List<Alumno> listarDisponibles() throws Exception {

		return alumnosDAO.getAllDisponible();
	}

	@Override
	public Alumno obtener(long id) throws Exception {

		return alumnosDAO.getById(id);
	}

	@Override
	public boolean crear(Alumno pojo) throws Exception {
		if(pojo.getNombre() != null) {
			
			pojo.setNombre(pojo.getNombre().trim()); ;
			if(pojo.getNombre().length() < 2 || pojo.getNombre().length() > 50) {
				
				throw new Exception("El nombre del alumno debe tener entre 2 y 50 caracteres");
			}
		}
		
		boolean resul = false;
		resul = alumnosDAO.insert(pojo);

		return resul;
	}

	@Override
	public boolean modificar(Alumno pojo) throws Exception {
		
		if(pojo.getNombre() != null) {
			
			pojo.setNombre(pojo.getNombre().trim()); ;
			if(pojo.getNombre().length() <= 2 || pojo.getNombre().length() >= 50) {
				
				throw new Exception("El nombre del alumno debe tener entre 2 y 50 caracteres");
			}
		}
		
		boolean resul = false;
		resul = alumnosDAO.update(pojo);

		return resul;
	}

	@Override
	public boolean eliminar(String id) throws Exception {

		boolean resul = false;
		resul = alumnosDAO.delete(id);

		return resul;
	}

}