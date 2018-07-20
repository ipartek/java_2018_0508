package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

public class RevistaDAO implements CrudAble<Revista> {

	private static RevistaDAO INSTANCE = null;
	private static List<Revista> lista = null;

	public RevistaDAO() {
		lista = new ArrayList<Revista>();

	}

	public static synchronized RevistaDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RevistaDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Revista revista) {
		boolean correcto = false;
		if (revista != null) {
			lista.add(revista);
			correcto = true;
		}
		return correcto;
	}

	@Override
	public List<Revista> getAll() {
		return lista;
	}

	@Override
	public Revista getById(long id) {
		Revista revistaBuscada = null;
		for (Revista revista : lista) {
			if (revista.getId() == id) {
				revistaBuscada = revista;
				break;
			}
		}
		return revistaBuscada;
	}

	@Override
	public boolean update(Revista revistaActualizada) {

		boolean found = false;
		if (revistaActualizada != null) {
			for (Revista revista : lista) {
				if (revista.getId() == revistaActualizada.getId()) {
					revista = revistaActualizada;
					found = true;
				}
			}
		}
		return found;

	}

	@Override
	public boolean delete(long id) {
		boolean eliminado = false;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				eliminado = lista.remove(lista.get(i));
				break;
			}
		}
		return eliminado;
	}

}
