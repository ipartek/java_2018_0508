package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.pojo.Libro;

/**
 * Clase DAO para gestionar los Libro en un arraylist
 * Usamos patron Singleton
 * @author Curso
 *
 */
public class LibroDAO implements CrudAble<Libro>{

	private static LibroDAO INSTANCE = null;
	private static List<Libro> lista = null;
	
	private LibroDAO() {
		lista = new ArrayList<Libro>();
	}
	
	public static synchronized LibroDAO getInstance(long mock1Id, String mock1Isbn, String mock1Titulo, String mock1Editorial, boolean mock1Prestado) {
		if(INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(Libro pojo) {
		
		return false;
	}

	@Override
	public List<Libro> getAll() {
		return lista;
	}

	@Override
	public Libro getById(long id) {
		Libro resul = null;
		
		//Buscar video a modificar
		for (Libro libroIteracion : lista) {
			if(id == libroIteracion.getId()) { //Libro encontrado
				resul = libroIteracion;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Libro pojo) {
		return false;
	}

	@Override
	public boolean delete(long id) {
		return false;
	}

}
