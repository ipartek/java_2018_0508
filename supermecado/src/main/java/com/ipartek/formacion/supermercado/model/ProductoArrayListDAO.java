package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.List;

public class ProductoArrayListDAO implements CrudAble<Producto> {

	private static ProductoArrayListDAO INSTANCE = null;
	private static List<Producto> productos = null;

	private ProductoArrayListDAO() {
		productos = new ArrayList<Producto>();
		try {			

			productos.add(new Producto(0,"ron",18,0,"images/ron.jpg","ron muuu rico","18€/L"));
			productos.add(new Producto(1,"gin barata",10,50,"images/gin.jpg","gin muuu rico","20€/L"));
			productos.add(new Producto(2,"vodka",23,8,"images/vodka.jpg","vozka muuu rico","16€/L"));
			productos.add(new Producto(0,"ron",17,0,"images/ron.jpg","ron muuu rico","18€/L"));
			productos.add(new Producto(1,"gin",20,20,"images/gin.jpg","gin muuu rico","20€/L"));
			
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
		if ( id != null ) { 
			for (int i = 0; i < productos.size(); i++) {
				p = productos.get(i); 
				if (id.equals(p.getId()) ) { 
					resul = productos.remove(p);
					break;
				}
			}
		}	
		return resul;
	}

}
