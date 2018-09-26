package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

public class PaginaArrayListDAO implements CrudAble<Pagina> {

	private static PaginaArrayListDAO INSTANCE = null;
	private static List<Pagina> libro = null;

	private PaginaArrayListDAO() {
		libro = new ArrayList<Pagina>();
		try {
			Pagina p = new Pagina();
			p.setAutor("Anonimo");
			libro.add(p);
			libro.add(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized PaginaArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PaginaArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Pagina pojo) {
		return libro.add(pojo);
	}

	@Override
	public List<Pagina> getAll() {
		return libro;
	}

	@Override
	public Pagina getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Pagina pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Pagina paginaXPos(int nPagina) {
		Pagina p = new Pagina();
		p = libro.get(nPagina);
		return p;
	}
	
	public int total() {
		return libro.size();
	}

}
