package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.Coche;
import com.ipartek.formacion.pojo.Usuario;

public class CocheDao {
	private static CocheDao INSTANCE = null;
	private static List<Coche> coche = null;

	private CocheDao() {
		coche = new ArrayList<Coche>();

	}
	public static synchronized CocheDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CocheDao();
		}
		return INSTANCE;
	}

	public boolean insert(Coche pojo) {
		boolean resul = false;
		if (pojo != null) {
			resul = coche.add(pojo);
		}
		return resul;
	}

	public List<Coche> getAll() {

		return coche;
	}

	public Coche getById(long id) {
		Coche cocheIteracion = null;
		Coche resul = null;
		for (int i = 0; i < coche.size(); i++) {
			cocheIteracion = coche.get(i);
			if (cocheIteracion.getId() == id) {
				resul = cocheIteracion;
				break;
			}
		}
		return resul;
	}

	public boolean update(Coche pojo) {
		boolean resul = false;
		Coche cocheIteracion = null;
		int i = 0;
		// comprobamos si es null hacer comprobacion
		if (pojo != null) {
			// iterator
			Iterator<Coche> it = coche.iterator();
			while (it.hasNext()) {
				cocheIteracion = it.next();
				if (cocheIteracion.getId() == pojo.getId()) {
					coche.set(i, pojo);
					resul = true;
					break;
				}

			}
		}
		return resul;
	}

	public boolean delete(long id) {

		boolean resul = false;
		Coche cocheIteracion = null;
		for (int x = 0; x < coche.size(); x++) {
			cocheIteracion = coche.get(x);
			if (id == cocheIteracion.getId()) {
				resul = coche.remove(cocheIteracion);
			}
		}

		return resul;
	}
}
