package com.ipartek.examen.model.dao;



import java.util.ArrayList;
import java.util.List;

import com.ipartek.examen.model.pojo.Paginas;




public class PaginasDao   {
	private static PaginasDao INSTANCE = null;
	private static ArrayList<Paginas> paginas = null;


	private PaginasDao() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		paginas = new ArrayList<Paginas>();
		try {
			paginas.add(new Paginas("Admin","Erase una vez"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*try {
			Productos.add(new Producto("Producto Demo", "prod-1", false, 10, "Lorem Lorem Lorem Lorem Lorem"));
			
		} catch (Exception e) {
			System.out.println("Error en ProductosDao");
		}*/
	}
	
	public static synchronized PaginasDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PaginasDao();
		}

		return INSTANCE;
	}

	
	public boolean insert(Paginas pojo) {
		boolean result = false;

		if (pojo != null) {
			paginas.add(pojo);
			result = true;
		}

		return result;
	}

	public List<Paginas> getAll() {

		return paginas;
	}

	
	/*public Paginas getById(long id) {
		Paginas PaginaCoincidencia = null;
		if (id > 0) {
			for (Paginas p : paginas) {
				if (p.getId() == id){
					PaginaCoincidencia = p;
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
	}*/
}
