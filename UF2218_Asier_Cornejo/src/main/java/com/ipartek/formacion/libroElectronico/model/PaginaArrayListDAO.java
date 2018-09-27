package com.ipartek.formacion.libroElectronico.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.libroElectronico.model.pojo.Pagina;

public class PaginaArrayListDAO implements CrudAble<Pagina> {

	private static PaginaArrayListDAO INSTANCE = null;
	private static List<Pagina> paginas = null;

	private PaginaArrayListDAO() {
		paginas = new ArrayList<Pagina>();
		try {
			
			paginas.add(new Pagina(1, "Erase una vez", "Anonimo"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized PaginaArrayListDAO getInstance() {
		if (INSTANCE == null) {
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
	public Pagina getById(int id) {
		Pagina resul = null;
		if (id>=0) {
			for (Pagina v : paginas) {
				if (id==v.getId()) {
					resul = v;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Pagina pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		Pagina p = null;
		if (id >=0) {
			for (int i = 0; i < paginas.size(); i++) {
				p = paginas.get(i);
				if (id==p.getId()) {
					resul = paginas.remove(p);
					break;
				}
			}
		}
		return resul;
	}

}
