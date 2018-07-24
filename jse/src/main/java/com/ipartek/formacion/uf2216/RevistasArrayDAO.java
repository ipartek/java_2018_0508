package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

public class RevistasArrayDAO implements CrudAble<Revistas> {

	private static RevistasArrayDAO INSTANCE = null;
	private static List<Revistas> lista = null;
	private static long id = 1;

	private RevistasArrayDAO() {
		lista = new ArrayList<Revistas>();
	}

	public static synchronized RevistasArrayDAO getIntance() {
		if (INSTANCE == null) {
			INSTANCE = new RevistasArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Revistas pojo) {
		boolean result = false;
		if (pojo != null) {
			pojo.setId(id);
			result = lista.add(pojo);
			id++;
		}

		return result;

	}

	@Override
	public Revistas getByID(long id) {
		Revistas aux = null;

		for (Revistas videoIteracion : lista) {
			if (id == videoIteracion.getId()) {
				aux = videoIteracion;
				break;
			}
		}
		return aux;
	}

	@Override
	public boolean update(Revistas pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Revistas> getAll() {
		return lista;
	}

}
