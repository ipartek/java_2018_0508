package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las Revista en un arraylist
 * Usamos patron Singleton
 * @author Curso
 *
 */
public class RevistaDAO implements CrudAble<Revista>{
	
	private static RevistaDAO INSTANCE = null;
	private static List<Revista> listaRevistas = null;
	
	private RevistaDAO() {
		listaRevistas = new ArrayList<Revista>();
	}
	
	public static synchronized RevistaDAO getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new RevistaDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(Revista pojo) {
		boolean resul = false;
		if(pojo != null) {
			resul = listaRevistas.add(pojo);
		}
		return resul;
	}

	@Override
	public List<Revista> getAll() {
		return listaRevistas;
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
