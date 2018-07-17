package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;

/**
 * Clase DAO para gestionar la clase Usuario con ArrayList. Usamos el Patrón
 * Singleton
 * 
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 * @author Curso
 *
 */
public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	private static ArrayList<Usuario> lista;

	private UsuarioDAO() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		lista = new ArrayList<Usuario>();
	}

	public static synchronized UsuarioDAO getInstance() {
		return (INSTANCE == null ? new UsuarioDAO() : INSTANCE);
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
		Usuario u = null;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				u = lista.get(i);
				break;
			}
		}
		return u;
	}

	@Override
	public boolean update(Usuario pojo) {
		boolean result = false;

		if (pojo != null) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == pojo.getId()) {
					lista.set(i, pojo);
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;

		for (Usuario uIteracion : lista) {
			if (id == uIteracion.getId()) { // Usuario encontrado
				result = lista.remove(uIteracion); // Eliminamos Usuario y comprobamos
				break;
			}
		}

		return result;
	}

}
