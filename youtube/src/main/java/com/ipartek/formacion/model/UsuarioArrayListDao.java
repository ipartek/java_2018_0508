package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.pojo.Video;

public class UsuarioArrayListDao implements CrudAble<Video> {

	private static UsuarioArrayListDao INSTANCE = null;
	private static List<Usuario> usuarios = null;

	private UsuarioArrayListDao() {
		usuarios = new ArrayList<Usuario>();
		

	}

	public static synchronized UsuarioArrayListDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioArrayListDao();
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
			for (Usuario u : usuarios) {
				if (id.equals(u.getId())) {
					resul = u;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Usuario u = null;
		if ( id != null ) { 
			for (int i = 0; i < usuarios.size(); i++) {
				u = usuarios.get(i); 
				if (id.equals(u.getId()) ) { 
					resul = usuarios.remove(u);
					break;
				}
			}
		}	
		return resul;
	}

	@Override
	public boolean insert(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Video getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}