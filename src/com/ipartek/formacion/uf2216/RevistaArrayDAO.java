package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

public class RevistaArrayDAO implements CrudAble<Revista>{

	private static RevistaArrayDAO INSTANCE = null;
	private static List<Revista> lista = null;

	private RevistaArrayDAO() {
		lista = new ArrayList<Revista>();
	}

	
	public static synchronized RevistaArrayDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RevistaArrayDAO();
		}
		return INSTANCE;
	}

	
	
	@Override
	public boolean insert(Revista pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Revista> getAll() {
		// TODO Auto-generated method stub
		return null;
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
