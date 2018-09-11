package com.ipartek.formacion.nidea.model;

import java.util.ArrayList;
import java.util.List;


import com.ipartek.formacion.nidea.pojo.Producto;




public class ProductosDao implements CrudAble<Producto> {
	private static ProductosDao INSTANCE = null;
	private static ArrayList<Producto> Productos = null;
	private static boolean cargaProductos = false;

	private ProductosDao() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		Productos = new ArrayList<Producto>();
		/*try {
			Productos.add(new Producto("Producto Demo", "prod-1", false, 10, "Lorem Lorem Lorem Lorem Lorem"));
			
		} catch (Exception e) {
			System.out.println("Error en ProductosDao");
		}*/
	}
	
	public static synchronized ProductosDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ProductosDao();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Producto pojo) {
		boolean result = false;

		if (pojo != null) {
			Productos.add(pojo);
			result = true;
		}

		return result;
	}

	@Override
	public List<Producto> getAll() {

		return Productos;
	}

	@Override
	public Producto getById(long id) {
		Producto ProductoCoincidencia = null;
		if (id > 0) {
			for (Producto v : Productos) {
				if (v.getId() == id){
					ProductoCoincidencia = v;
				}
			}
		}
		return ProductoCoincidencia;
	}

	@Override
	public boolean update(Producto pojo) {
		boolean flag = false;

		if (pojo != null) {
			for (int i = 0; i < Productos.size(); i++) {
				if (Productos.get(i).getId() == pojo.getId()) {
					Productos.set(i, pojo);
					flag = true;
				}
			}
		}

		return flag;
	}

	@Override
	public boolean delete(long id) {
		boolean flag = false;
		if (id > 0) {
			for (Producto v : Productos) {
				if (v.getId() == id) {
					Productos.remove(v);
					flag = true;
				}
			}
		}
		return flag;
	}
}
