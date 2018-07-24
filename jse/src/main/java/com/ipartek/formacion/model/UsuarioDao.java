package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;

public class UsuarioDao implements CrudAble<Usuario> {
	private static UsuarioDao INSTANCE = null;
	private static List<Usuario> usuario = null;

	private UsuarioDao() {
		usuario = new ArrayList<Usuario>();

	}

	public static synchronized UsuarioDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDao();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) {
		boolean resul = false;
		if (pojo != null) {
			resul = usuario.add(pojo);
		}
		return resul;
	}

	@Override
	public List<Usuario> getAll() {

		return usuario;
	}

	@Override
	public Usuario getById(long id) {
		Usuario usuarioIteracion = null;
		Usuario resul = null;
		for (int i = 0; i < usuario.size(); i++) {
			usuarioIteracion = usuario.get(i);
			if (usuarioIteracion.getId() == id) {
				resul = usuarioIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Usuario pojo) {
		boolean resul = false;
		Usuario usuarioIteracion = null;
		int i = 0;
		// comprobamos si es null hacer comprobacion
		if (pojo != null) {
			// iterator
			Iterator<Usuario> it = usuario.iterator();
			while (it.hasNext()) {
				usuarioIteracion = it.next();
				if (usuarioIteracion.getId() == pojo.getId()) {
					usuario.set(i, pojo);
					resul = true;
					break;
				}

			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {

		boolean resul = false;
		Usuario usuarioIteracion = null;
		for (int x = 0; x < usuario.size(); x++) {
			usuarioIteracion = usuario.get(x);
			if (id == usuarioIteracion.getId()) {
				resul = usuario.remove(usuarioIteracion);
			}
		}

		return resul;
	}

	
}
