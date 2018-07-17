package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;

/**
 * Implementar CrudAble
 * 
 * @author Ainara
 *
 */

public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;
	private static List<Usuario> lista = null;
	
	public static void main(String[] args) {
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
		boolean resul = false;
		if (pojo != null) {
			resul = lista.add(pojo);
		}
		return resul;
	}

	@Override
	public List<Usuario> getAll() {
		return lista;
	}

	@Override
	public Usuario getById(long id) {
		Usuario resul = null;
		// foreach
		for (Usuario usuarioIteracion : lista) {
			if (id == usuarioIteracion.getId()) {
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
		if (pojo != null) {
			// Iterator
			Iterator<Usuario> it = lista.iterator();
			while (it.hasNext()) {
				usuarioIteracion = it.next();
				if (usuarioIteracion.getId() == pojo.getId()) {
					lista.set(i, pojo);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;

		Usuario vUsuario = null;

		// buscar video a eliminar
		for (int i = 0; i < lista.size(); i++) {

			vUsuario = lista.get(i); // usuario sobre el que iteramos

			if (id == vUsuario.getId()) { // usuario encontrado
				resul = lista.remove(vUsuario);
				break;
			}
		}

		return resul;
	}

}
