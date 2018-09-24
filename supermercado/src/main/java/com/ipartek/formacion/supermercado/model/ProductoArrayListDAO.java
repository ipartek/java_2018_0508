package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.List;

public class ProductoArrayListDAO implements CrudAble<Producto> {

	private static ProductoArrayListDAO INSTANCE = null;
	private static List<Producto> productos = null;

	private ProductoArrayListDAO() {
		productos = new ArrayList<Producto>();
		try {
			productos.add(new Producto(1783,"Vodka",11.40f,10,"images/vodka_product.jpg","Vodka importado de Rusia",12.50f));
			productos.add(new Producto(1785,"Whiskie",23.70f,0,"images/whiskie_producto.png","Whiskie de malta",12.50f));
			productos.add(new Producto(1786,"Tequila",56.70f,50,"images/tequila_product.jpg","Tequila de Mexico",4.60f));
			productos.add(new Producto(1788,"Baileis",14.70f,20,"images/baileis_product.jpg","Crema deliciosa",1.75f));
			productos.add(new Producto(1780,"Vino Tinto",6.30f,70,"images/tinto_product.jpg","Vodka importado de Rusia",8.40f));
		
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
