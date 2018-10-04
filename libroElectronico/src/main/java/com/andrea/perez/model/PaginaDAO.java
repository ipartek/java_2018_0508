package com.andrea.perez.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.andrea.perez.pojo.Pagina;

public class PaginaDAO implements Crudable<Pagina> {

	private static PaginaDAO INSTANCE = null;
	private static List<Pagina> paginas = null;

	private PaginaDAO() {
		
		paginas = new ArrayList<Pagina>();
		
		try {
			paginas.add(new Pagina(1,"Erasé una vez ....","yo" ));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized PaginaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PaginaDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Pagina pojo) {
		boolean resul = false;
		StringTokenizer longTexto = new StringTokenizer(pojo.getTexto());

		if (longTexto.countTokens() >= 25) {
			paginas.add(pojo);
			resul = true;
		}
		return resul;

	}

	@Override
	public List<Pagina> getAll() {
		return paginas;
	}

	@Override
	public Pagina getById(int numPag) {
		Pagina resul = null;
		if (numPag >0) {
			for (Pagina p : paginas) {
				if (numPag==p.getNumPag()) {
					resul = p;
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
	public boolean delete(int numPag) {
		// TODO Auto-generated method stub
		return false;
	}

}