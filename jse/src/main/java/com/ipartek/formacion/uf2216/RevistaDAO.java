package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

public class RevistaDAO implements Gestiones<Revista> {

	private static RevistaDAO INSTANCE = null;
	private static List<Revista> lista = null;

	private RevistaDAO() {
		lista = new ArrayList<Revista>();
	}

	public static synchronized RevistaDAO getInstance() {
		if (INSTANCE == null)
			INSTANCE = new RevistaDAO();
		return INSTANCE;
	}

	@Override
	public List<Revista> GetAll() {
		return lista;
	}

	@Override
	public boolean insert(Revista pojo) {
		boolean resul = false;
		if (pojo != null) {
			resul = lista.add(pojo);
			resul = true;
		}

		return resul;
	}

}
