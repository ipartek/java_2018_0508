package com.ipartek.formacion.superValery.model;

import java.util.ArrayList;
import java.util.List;

public class ProductoArrayListDAO implements CrudAble<Producto> {

	private static ProductoArrayListDAO INSTANCE = null;
	private static List<Producto> productos = null;

	private ProductoArrayListDAO() {
		// crear ArrayLista vacio
		productos = new ArrayList<Producto>();
		try {

//			//crear los videos con la lista de comentarios
			productos.add(new Producto(0120, "PUERTO DE INDIAS", 18, 0, "imagenes/puertoIndias.jpg", 34,
					"DFSDFSDFDSSDFSDFSDFSDF"));
			productos.add(new Producto(0121, "PUERTO DE INDIAS", 18, 50, "imagenes/puertoIndias.jpg", 34,
					"DFSDFSDFDSSDFSDFSDFSDF"));
			productos.add(new Producto(0121, "PUERTO DE INDIAS", 18, 15, "imagenes/puertoIndias.jpg", 34,
					"DFSDFSDFDSSDFSDFSDFSDF"));
			productos.add(new Producto(0121, "PUERTO DE INDIAS", 18, 75, "imagenes/puertoIndias.jpg", 34,
					"DFSDFSDFDSSDFSDFSDFSDF"));
			productos.add(new Producto(0120, "PUERTO DE INDIAS", 9.5f, 0, "imagenes/puertoIndias.jpg", 34,
					"DFSDFSDFDSSDFSDFSDFSDF"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized ProductoArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ProductoArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Producto pojo) {
		return productos.add(pojo);
	}

	@Override
	public List<Producto> getAll() {
		return productos;
	}

	@Override
	public Producto getById(String id) {
		Producto resul = null;
		if (id != null) {
			for (Producto p : productos) {
				if (id.equals(p.getId())) {
					resul = p;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Producto pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Producto p = null;
		if (id != null) {
			for (int i = 0; i < productos.size(); i++) {
				p = productos.get(i);
				if (id.equals(p.getId())) {
					resul = productos.remove(p);
					break;
				}
			}
		}
		return resul;
	}

}