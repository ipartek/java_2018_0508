package com.ipartek.formacion.adopcionperros.model;

import java.util.ArrayList;
import java.util.List;

public class PerroArrayListDAO implements CrudAble<Perro> {

	private static PerroArrayListDAO INSTANCE = null;
	private static List<Perro> perros = null;

	private PerroArrayListDAO() {
		perros = new ArrayList<>();
		try {

			perros.add(new Perro("goku", 1, "bulldog frances", 7.4, "images/bulldog.jpg", true, new Chip("11-1111-2018", "10", "20")));
			perros.add(new Perro("pilin", 2, "Yorsay", 6, "images/yorsay.png", true, new Chip("11-1111-2018", "10", "20")));
			perros.add(new Perro("peluche", 1, "Labrador", 4, "images/labrador.jpg", true, new Chip("11-1111-2018", "10", "20")));
			perros.add(new Perro("loco", 3, "chihuahua", 3, "images/chihuahua.jpg", true, new Chip("11-1111-2018", "10", "20")));
			perros.add(new Perro("kira", 1, "dalmata", 8, "images/dalmata.jpg", true, new Chip("11-1111-2018", "10", "20")));

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Perro pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
