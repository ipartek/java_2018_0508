package com.ipartek.formacion.examenLibro.model;

import java.util.ArrayList;
import java.util.List;

public class LibroArrayListDAO implements CrudAble<Pagina> {
	public static LibroArrayListDAO INSTANCE = null;
	public static List<Pagina> libro = null;

	private LibroArrayListDAO() {
		libro = new ArrayList<Pagina>();
		try {

			Usuario u = new Usuario("paulo", "cohelo");
			Pagina p1 = new Pagina("Erase Una vez......", u);
			Pagina p2 = new Pagina("pagina 2", u);

			libro.add(p1);
			libro.add(p2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized LibroArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Pagina pojo) {
		libro.add(pojo);
		return true;
	}

	@Override
	public List<Pagina> getAll() {
		return libro;
	}

	@Override
	public Pagina getById(String id) {
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

	public Pagina getByIndice(int i) {
		return libro.get(i);
	}

}
