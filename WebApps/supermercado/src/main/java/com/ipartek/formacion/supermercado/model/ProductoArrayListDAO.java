package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.List;


public class ProductoArrayListDAO implements CrudAble<Producto> {

	private static ProductoArrayListDAO INSTANCE = null;
	private static List<Producto> productos = null;

	private ProductoArrayListDAO() {
		productos = new ArrayList<Producto>();
		
		try {
			cargarProductos();
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
				if (id.equals(p.getId())) { 
					resul = productos.remove(p);
					break;
				}
			}
		}	
		return resul;
	}
	
	private void cargarProductos() {
		
		ArrayList<Producto> mocks = new ArrayList<Producto>();
		int id = 1;
		for (int i = 0; i < 10; i ++) {
			
			float precio = (float) (1.1 * (i+10.10));
			
			
			Producto p = new Producto();
			
			p.setId(id);
			p.setPrecio(precio);
			if (i%2 == 0) {
				int descuento = 5 * (i+1);
				p.setDescuento(descuento);
			}
			
			p.setNombre("Producto " + (i+1));
			p.setDescripcion("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
		
			productos.add(p);
		}
		
	}

}
