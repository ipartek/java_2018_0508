package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.CrudAble;

/**
 * 
 * @author Curso
 *
 */
public class RevistaDAO implements CrudAble<Revista> {

	private static RevistaDAO INSTANCE = null;
	private static ArrayList<Revista> lista;

	private RevistaDAO() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		lista = new ArrayList<Revista>();
	}

	public static synchronized RevistaDAO getInstance() {
		return (INSTANCE == null ? new RevistaDAO() : INSTANCE);
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
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Revista getById(long id) {
		Revista revista = null;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				revista = lista.get(i);
				break;
			}
		}
		return revista;
	}

	@Override
	public boolean update(Revista pojo) {
		boolean result = false;

		if (pojo != null) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == pojo.getId()) {
					lista.set(i, pojo);
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;

		for (Revista revistaIteracion : lista) {
			if (id == revistaIteracion.getId()) { // Libro encontrado
				result = lista.remove(revistaIteracion); // Eliminamos Libro y comprobamos
				break;
			}
		}

		return result;
	}

}
