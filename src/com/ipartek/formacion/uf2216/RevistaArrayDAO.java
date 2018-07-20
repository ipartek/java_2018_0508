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

}
