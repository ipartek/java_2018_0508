package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RevistasArrayDAO implements CrudAble<Revistas> {

	private static RevistasArrayDAO INSTANCE = null;
	private static List<Revistas> lista = null;

	private RevistasArrayDAO() {
		lista = new ArrayList<Revistas>();
	}

	public static synchronized RevistasArrayDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RevistasArrayDAO();
		}
		return INSTANCE;
	}

	public List<Revistas> getAllDigitales(boolean isDigital) {
		ArrayList<Revistas> resul = new ArrayList<Revistas>();
		for (Revistas pojo : lista) {
			if (pojo.isDigital() == isDigital) {
				resul.add(pojo);
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Revistas pojo) {
		boolean resul = false;
		if (pojo != null) {
			lista.add(pojo);
			resul = true;
		}
		return resul;
	}

	@Override
	public List<Revistas> getAll() {
		return lista;
	}

	@Override
	public Revistas getById(long id) {
		Revistas resul = null;
		for (Revistas libroIteracion : lista) {
			if (id == libroIteracion.getId()) {
				resul = libroIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Revistas pojo) {
		boolean resul = false;
		Revistas rIteracion = null;
		int i = 0;
		if (pojo != null) {
			// Iterator
			Iterator<Revistas> it = lista.iterator();
			while (it.hasNext()) {
				rIteracion = it.next();
				if (rIteracion.getId() == pojo.getId()) {
					lista.set(i, pojo);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		Revistas rIteracion = null;
		for (int i = 0; i < lista.size(); i++) {
			rIteracion = lista.get(i);
			if (id == rIteracion.getId()) {
				resul = lista.remove(rIteracion);
				break;
			}
		}
		return resul;
	}

}
