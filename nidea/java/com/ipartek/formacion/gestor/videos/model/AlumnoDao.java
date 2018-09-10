package com.ipartek.formacion.gestor.videos.model;



import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.gestor.videos.pojo.Alumno;


/**
 * Clase DAO para gestionar la clase Libro con ArrayList. Usamos el Patrón
 * Singleton.
 * 
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 * @author Curso
 * @param <P>
 *
 */
public class AlumnoDao implements CrudAble<Alumno>  {

	private static AlumnoDao INSTANCE = null;
	private static ArrayList<Alumno> alumnos= null;

	private AlumnoDao() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		alumnos = new ArrayList<Alumno>();
		try {
			alumnos.add(new Alumno("El momo - sol de marzo","uno"));
			alumnos.add(new Alumno("Shintoma - Somos de lo malo lo peor","dos"));
			alumnos.add(new Alumno("Nach - Éxodo","tres"));
		} catch (Exception e) {
			System.out.println("Error en VideoArrayListDao");
		}
	}

	public static synchronized AlumnoDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AlumnoDao();
		}

		return INSTANCE;
	}
	
	

	public long calculedId() {
		long id=0;
		id = alumnos.size();
		if(id > 0) {
			return id;
		}else {
			return ++id;
		}
		
		
	}

	@Override
	public boolean insert(Alumno pojo) {
		System.out.println("**INSERTAR**");
		return false;
	}

	@Override
	public List<Alumno> getAll() {
		System.out.println("**LISTAR**");
		return null;
	}

	@Override
	public Alumno getById(long id) {
		System.out.println("**GET BY ID**");
		return null;
	}

	@Override
	public boolean update(Alumno pojo) {
		System.out.println("**UPDATE**");
		return false;
	}

	@Override
	public boolean delete(long id) {
		System.out.println("**DELETE**");
		return false;
	}

	public void escribir() {
		System.out.println("escribir");
		
	}

	

}
