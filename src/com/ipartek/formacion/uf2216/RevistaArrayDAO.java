package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.model.CrudAble;

public class RevistaArrayDAO implements CrudAble<Revista> {

	private static RevistaArrayDAO INSTANCE = null;
	private static List<Revista> revista = null;

	private RevistaArrayDAO() {
		revista = new ArrayList<Revista>();
	}

	public static synchronized RevistaArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RevistaArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Revista pojo) {
		boolean resul = false;
		if (pojo != null) {
			resul = revista.add(pojo);
		}
		return resul;
	}

	@Override
	public List<Revista> getAll() {
		return revista;
	}

	@Override
	public Revista getById(long id) {
		Revista resul = null;
		// foreach
		for (Revista revistaIteracion : revista) {
			if (id == revistaIteracion.getId()) {
				resul = revistaIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Revista revistaUpdate) {
		boolean resul = false;
		Revista revistaIteracion = null;
		int i = 0;
		if (revistaUpdate != null) {
			// Iterator
			Iterator<Revista> it = revista.iterator();
			while (it.hasNext()) {
				revistaIteracion = it.next();
				if (revistaIteracion.getId() == revistaUpdate.getId()) {
					revista.set(i, revistaUpdate);
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

		Revista rIteracion = null;

		// buscar video a eliminar
		for (int i = 0; i < revista.size(); i++) {

			rIteracion = revista.get(i); // video sobre el que iteramos

			if (id == rIteracion.getId()) { // video encontrado
				resul = revista.remove(rIteracion);
				break;
			}
		}

		return resul;
	}

	
}