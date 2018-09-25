package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.supermercado.model.pojo.Producto;


public class ProductoArrayListDAO implements CrudAble<Producto> {

	private static ProductoArrayListDAO INSTANCE = null;
	private static List<Producto> productos = null;

	private ProductoArrayListDAO() {
		productos = new ArrayList<Producto>();
		try {
			productos.add(new Producto(2,"Botella whisky",10.50f,0,"Whisky barato barato","images/whisky.jpg",10.0f));
			productos.add(new Producto(3,"Botella Jagermeister",10f,0,"Bebida asquerosa","images/jager.jpg",7.0f));
			productos.add(new Producto(4,"Botella Brugal",6.50f,10,"Bebida de pobres","images/brugal.jpg",5.0f));
			productos.add(new Producto(5,"Botella ginebra",9.50f,20," Bebida mata ratas","images/ginebra.jpg",9.0f));
			productos.add(new Producto(6,"Botella Coca-Cola",2.89f,0,"Azúcar puro","images/cocaCola.jpg",1.44f));
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
			for (Producto v : productos) {
				if (id.equals(v.getId())) {
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
