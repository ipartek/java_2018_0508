package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.List;

public class ProductoArrayListDAO implements CrudAble<Producto>{
	
	private static ProductoArrayListDAO INSTANCE = null;
	private static List<Producto> productos = null;
	
	private ProductoArrayListDAO() {
		productos = new ArrayList<Producto>();
		
		try {
			
			productos.add(new Producto(1, "Fanta", 1.35f, 10, "images/fanta.png", "0.67", "Lata de fanta naranja de 33cl"));
			productos.add(new Producto(2, "Lays", 2.65f, 30, "images/lays.png", "3.60", "Paquete de patatas Lays clásicas"));
			productos.add(new Producto(3, "Aceite", 4.75f, 0, "images/aceite.jpg", "3.99", "Botella de aceite de oliva virgen extra"));
			productos.add(new Producto(4, "Pan", 0.75f, 15, "images/pan.jpg", "1.45", "Barra baguette hecha con masa madre"));
			productos.add(new Producto(5, "Leche", 1.99f, 0, "images/leche.jpg", "1.50", "Tetrabrick de leche entera marca gaza"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ProductoArrayListDAO getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new ProductoArrayListDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(Producto producto) {
		
		boolean resultado = false;
		
		if(producto != null) {
			resultado = productos.add(producto);
		}
		return resultado;
		
	}

	@Override
	public List<Producto> getAll() {

		return productos;
	}

	@Override
	public Producto getById(String id) {
		Producto resultado = null;
		
		if(id != null && !"".equals(id)) {
			
			for(Producto p : productos) {
				
				if(id.equals(p.getId())) {
					resultado = p;
					break;
					
				}
			}
		}
		
		return resultado;
	}

	@Override
	public boolean update(Producto video) {

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
