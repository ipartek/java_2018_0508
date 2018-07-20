package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las Revista con ArrayList
 * Usamos patrón singleton
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Adrian Garcia
 *
 */
public class RevistaArrayDAO implements CrudAble2<Revista> {
	
	public static RevistaArrayDAO INSTANCE = null;
	public static List<Revista> lista = null;
	
	private RevistaArrayDAO() {
		lista = new ArrayList<Revista>();
		
	}
	
	public static synchronized RevistaArrayDAO getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new RevistaArrayDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(Revista revista) {
		boolean resultado = false;
		
		if(revista != null) {
			resultado = lista.add(revista);
		}
		return resultado;
	}
	

	@Override
	public List<Revista> getAll() {

		return lista;
	}

	@Override
	public Revista getById(long id) {

		return null;
	}

	@Override
	public boolean update(Revista pojo) {

		return false;
	}

	@Override
	public boolean delete(long id) {

		return false;
	}

}
