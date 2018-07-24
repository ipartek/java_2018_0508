package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

public class RevistaArrayDAO implements CrudAble<Revista> {

	// Metodo Singleton
	private static RevistaArrayDAO INSTANCE = null;

	private static List<Revista> kiosko = null;

	private RevistaArrayDAO() {
		kiosko = new ArrayList<Revista>();
	}

	public static synchronized RevistaArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RevistaArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Revista revista) {

		boolean resul = false;
		if (revista != null) {
			resul = kiosko.add(revista);
		}

		return resul;
	}

	@Override
	public List<Revista> getAll() {

		return kiosko;

	}

	@Override
	public Revista getById(long id) {
		// No necesaria la implementacion
		return null;
	}

	@Override
	public boolean update(Revista revistaUpdate) {
		// No necesaria la implementacion
		return false;
	}

	@Override
	public boolean delete(long id) {
		// No necesaria la implementacion
		return false;
	}

}
