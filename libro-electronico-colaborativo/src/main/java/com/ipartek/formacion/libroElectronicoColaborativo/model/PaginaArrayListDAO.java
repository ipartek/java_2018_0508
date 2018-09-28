package com.ipartek.formacion.libroElectronicoColaborativo.model;

import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.libroElectronicoColaborativo.pojo.Pagina;

public class PaginaArrayListDAO implements CrudAble<Pagina>{

	private static PaginaArrayListDAO INSTANCE = null;
	private static List<Pagina> paginas = null;
	
	private PaginaArrayListDAO() {
		paginas = new ArrayList<Pagina>();
		try {
			paginas.add( new Pagina("Erase una vez", "Anonimo"));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	public static synchronized PaginaArrayListDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PaginaArrayListDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(Pagina pojo) {
		return paginas.add(pojo);
	}

	@Override
	public List<Pagina> getAll() {
		return paginas;
	}

	@Override
	public Pagina getById(String id) {
		return null;
	}

	@Override
	public boolean update(Pagina pojo) {
		return false;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

}
