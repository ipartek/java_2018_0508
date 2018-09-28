package com.ipartek.formacion.libro.model;

import java.util.ArrayList;
import java.util.List;

public class PaginaArrayListDAO implements CrudAble<Pagina>{
	
	private static PaginaArrayListDAO INSTANCE = null;
	private static List<Pagina> paginas = null;
	
	private PaginaArrayListDAO() {
		paginas = new ArrayList<Pagina>();
		
	}
	
	public static synchronized PaginaArrayListDAO getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new PaginaArrayListDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(Pagina pagina) {
		
		boolean resultado = false;
		
		if(pagina != null) {
			resultado = paginas.add(pagina);
		}
		return resultado;
		
	}

	@Override
	public List<Pagina> getAll() {

		return paginas;
	}

	@Override
	public Pagina getById(String id) {
		Pagina resultado = null;
		
		if(id != null && !"".equals(id)) {
			
			for(Pagina p : paginas) {
				
				if(id.equals(p.getId())) {
					resultado = p;
					break;
					
				}
			}
		}
		
		return resultado;
	}

	@Override
	public boolean update(Pagina pagina) {

		return false;
	}

	@Override
	public boolean delete(String id) {
		
		boolean resul = false;
		Pagina p = null;
		if ( id != null ) { 
			
			for (int i = 0; i < paginas.size(); i++) {
				p = paginas.get(i); 
				
				if (id.equals(p.getId()) ) { 
					resul = paginas.remove(p);
					break;
				}
			}
		}	
		return resul;
		
	}

}
