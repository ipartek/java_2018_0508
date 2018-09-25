package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductoArrayListDAO implements CrudAble<Producto> {

	private static ProductoArrayListDAO INSTANCE = null;
	private static List<Producto> productos = null;
	private boolean chivato = false;

	private ProductoArrayListDAO() {
		productos = new ArrayList<Producto>();
		try {
			productos.add(new Producto(0120, "Cuerno de unicornio", 18, 0, "images/default_product.jpg", "18€/L", "Al rico cuerno de unicornio machacado"));
			productos.add(new Producto(0121, "Cuerno de unicornio", 18, 50, "images/default_product_2.jpg", "18€/L", "Al rico cuerno de unicornio machacado"));
			productos.add(new Producto(0121, "Cuerno de unicornio", 18, 15, "images/default_product.jpg", "18€/L", "Al rico cuerno de unicornio machacado"));
			productos.add(new Producto(0121, "Cuerno de unicornio", 18, 75, "images/default_product_2.jpg", "18€/L", "Al rico cuerno de unicornio machacado"));
			productos.add(new Producto(0120, "Cuerno de unicornio", 9.5f, 0, "images/default_product.jpg", "18€/L", "Al rico cuerno de unicornio machacado"));
			productos.add(new Producto(0121, "Cuerno de unicornio", 9.25f, 50, "images/default_product_2.jpg", "18€/L", "Al rico cuerno de unicornio machacado"));
			productos.add(new Producto(0121, "Cuerno de unicornio", 9.125f, 15, "images/default_product.jpg", "18€/L", "Al rico cuerno de unicornio machacado"));
			productos.add(new Producto(0121, "Cuerno de unicornio", 9.5f, 75, "images/default_product_2.jpg", "18€/L", "Al rico cuerno de unicornio machacado"));
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
		if(!chivato) {
			Collections.reverse(productos);
			chivato = true;
		}
		return productos;
	}

	@Override
	public Producto getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Producto getById(Long id) {
		Producto resul = null;
		if (id != null) {
			for (Producto v : productos) {
				if (id == v.getId()) {
					resul = v;
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
		Producto v = null;
		if ( id != null ) { 
			for (int i = 0; i < productos.size(); i++) {
				v = productos.get(i); 
				if (id.equals(v.getId()) ) { 
					resul = productos.remove(v);
					break;
				}
			}
		}	
		return resul;
	}

}
