package com.ipartek.formacion.supermercado.model.pojo;

import java.util.ArrayList;
import java.util.List;





public class UsuarioArrayListDAO implements CrudAble<Usuario> {

	private static UsuarioArrayListDAO INSTANCE = null;
	private static List<Usuario> usuarios = null;

	private UsuarioArrayListDAO() {
		usuarios = new ArrayList<Usuario>();
		try {
			usuarios.add(new Usuario(1,"admin","admin@gmail.com","admin"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized UsuarioArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) {
		return usuarios.add(pojo);
	}

	@Override
	public List<Usuario> getAll() {
		return usuarios;
	}

	@Override
	public Usuario getById(String id) {
		Usuario resul = null;
		if (id != null) {
			for (Usuario p : usuarios) {
				if (id.equals(p.getId())) {
					resul = p;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Usuario p = null;
		if ( id != null ) { 
			for (int i = 0; i < usuarios.size(); i++) {
				p = usuarios.get(i); 
				if (id.equals(p.getId()) ) { 
					resul = usuarios.remove(p);
					break;
				}
			}
		}	
		return resul;
	}

	
}