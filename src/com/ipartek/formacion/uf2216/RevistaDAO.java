package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

public class RevistaDAO implements CrudAble<Revista> {

	private static RevistaDAO INSTANCE = null;
	private static List<Revista> lista = null;

	private RevistaDAO() {
		lista = new ArrayList<Revista>();
	}

	public static synchronized RevistaDAO getInstance() {
		if (INSTANCE == null) {

			INSTANCE = new RevistaDAO();

		}

		return INSTANCE;

	}

	@Override
	public boolean insert(Revista pojo) {
		boolean result = false;
		if (pojo != null) {
			result = lista.add(pojo);

		}

		return result;
	}

	@Override
	public List<Revista> getAll() {
		return lista;
	}

	// El resto de metodos por el momento no son necesarios,Se dejan por si en un
	// futuro lo fueran.

	@Override
	public Revista getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Revista pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll(List<Revista> list) {
		// TODO Auto-generated method stub
		return false;
	}

}
