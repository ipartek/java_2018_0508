package com.ipartek.formacion.perrera.model;

import java.util.ArrayList;
import java.util.List;

public class PerroArrayListDAO implements CrudAble<Perro> {

	private static PerroArrayListDAO INSTANCE = null;
	private static List<Perro> perros = null;

	private PerroArrayListDAO() {
		perros = new ArrayList<Perro>();
		try {
			perros.add(new Perro("asuka", 3, "caniche", 3f, false, new Chip("111111", "2018", 324, 234),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnJ0ezJBptIA6gXJRdtiC6LRfvv81udw3mO_IV1VSlfLFohvaM"));
			perros.add(new Perro("linda", 3, "caniche", 3f, true, new Chip("111111", "2018", 324, 234),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnJ0ezJBptIA6gXJRdtiC6LRfvv81udw3mO_IV1VSlfLFohvaM"));
			perros.add(new Perro("asuka", 3, "snouzers", 3f, false, new Chip("111111", "2018", 324, 234),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnJ0ezJBptIA6gXJRdtiC6LRfvv81udw3mO_IV1VSlfLFohvaM"));
			perros.add(new Perro("linda", 3, "caniche", 3f, true, new Chip("111111", "2018", 324, 234),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnJ0ezJBptIA6gXJRdtiC6LRfvv81udw3mO_IV1VSlfLFohvaM"));
			perros.add(new Perro("asuka", 3, "caniche", 3f, false, new Chip("111111", "2018", 324, 234),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnJ0ezJBptIA6gXJRdtiC6LRfvv81udw3mO_IV1VSlfLFohvaM"));
			perros.add(new Perro("linda", 3, "pincher", 3f, false, new Chip("111111", "2018", 324, 234),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnJ0ezJBptIA6gXJRdtiC6LRfvv81udw3mO_IV1VSlfLFohvaM"));
			perros.add(new Perro("asuka", 3, "golden", 3f, true, new Chip("111111", "2018", 324, 234),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnJ0ezJBptIA6gXJRdtiC6LRfvv81udw3mO_IV1VSlfLFohvaM"));
			perros.add(new Perro("linda", 3, "caniche", 3f, false, new Chip("111111", "2018", 324, 234),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnJ0ezJBptIA6gXJRdtiC6LRfvv81udw3mO_IV1VSlfLFohvaM"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized PerroArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PerroArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Perro pojo) {
		return perros.add(pojo);
	}

	@Override
	public List<Perro> getAll() {
		return perros;
	}

	@Override
	public Perro getById(String id) {
		return null;

	}

	@Override
	public boolean update(Perro pojo) {
		return false;

	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;

		return resul;
	}

}
