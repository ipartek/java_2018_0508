package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;

/**
 * Clase DAO para gestionar los Usuarios con ArrayList<> Usamos patron
 * Singleton
 * 
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Curso
 *
 */
public class UsuarioArrayDAO implements CrudAble<Usuario> {

	private static UsuarioArrayDAO INSTANCE = null;

	private static List<Usuario> lista = null;

	private UsuarioArrayDAO() {
		lista = new ArrayList<Usuario>();
	}

	public static synchronized UsuarioArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario video) {

		boolean resul = false;
		if (video != null) {
			resul = lista.add(video);
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
		for (Usuario uIteracion : lista) {

			if (id == uIteracion.getId()) {
				resul = uIteracion;
				break;
			}

		}
		return resul;
	}

	@Override
	public boolean update(Usuario usuarioUpdate) {

		boolean resul = false;
		Usuario uIteracion = null;
		int i = 0;

		if (usuarioUpdate != null) {
			// iterator
			Iterator<Usuario> it = lista.iterator();
			while (it.hasNext()) {

				uIteracion = it.next();
				if (uIteracion.getId() == usuarioUpdate.getId()) {
					lista.set(i, usuarioUpdate);
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

		Usuario uIteracion = null;

		for (int i = 0; i < lista.size(); i++) {

			uIteracion = lista.get(i);

			if (uIteracion.getId() == id) {
				resul = lista.remove(uIteracion);
				break;
			}
		}
		return resul;
	}

}
