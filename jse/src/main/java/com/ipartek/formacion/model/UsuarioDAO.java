package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;

public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;
	private static List<Usuario> lista = null;

	private UsuarioDAO() {
		lista = new ArrayList<Usuario>();
	}

	public static synchronized UsuarioDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario user) {

		boolean correct = false;
		if (user != null) {
			lista.add(user);
			correct = true;
		}
		return correct;

	}

	@Override
	public List<Usuario> getAll() {
		return lista;
	}

	@Override
	public Usuario getById(long id) {

		Usuario newUser = null;
		for (Usuario user : lista) {
			if (user.getId() == id) {
				newUser = user;
				break;
			}
		}

		return newUser;
	}

	@Override
	public boolean update(Usuario userUpdate) {

		boolean found = false;
		if(userUpdate != null) {
			for (Usuario user : lista) {
				if (user.getId() == userUpdate.getId()) {
					user = userUpdate;
					found = true;
				}
			}
		}

		return found;
	}

	@Override
	public boolean delete(long id) {

		boolean eliminado = false;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				eliminado = lista.remove(lista.get(i));
				break;
			}
		}

		return eliminado;
	}
}
