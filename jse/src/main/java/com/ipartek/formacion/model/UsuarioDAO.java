package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.pojo.VideoYoutube;

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
	public boolean insert(Usuario pojo) {
		boolean result = false;
		if (pojo != null) {
			result = lista.add(pojo);
		}

		return result;
	}

	@Override
	public List<Usuario> getAll() {

		return lista;
	}

	@Override
	public Usuario getById(long id) {
		Usuario result = null;

		for (Usuario usuarioIteracion : lista) {
			if (id == usuarioIteracion.getId()) {
				result = usuarioIteracion;
				break;
			}
		}

		return result;
	}

	@Override
	public boolean update(Usuario pojo) {
		boolean result = false;
		Usuario usuarioIteracion = null;
		int i = 0;

		if (pojo != null) {
			Iterator<Usuario> it = lista.iterator();
			while (it.hasNext()) {
				usuarioIteracion = it.next();
				if (usuarioIteracion.getId() == pojo.getId()) {
					lista.set(i, pojo);
					result = true;
					break;
				}
				i++;
			}
		}

		return result;
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;
		Usuario aux = null;

		if (id >= 0) {

			for (int i = 0; i < lista.size(); i++) {
				aux = lista.get(i);
				if (aux.getId() == id) {
					result = lista.remove(aux);
					break;
				}

			}
		}
		return result;
	}

	@Override
	public boolean deleteAll(List<VideoYoutube> list) {
		boolean result = false;
		if (!list.isEmpty()) {
			list.clear();
			result = true;
		} else {

		}
		return result;
	}

}
