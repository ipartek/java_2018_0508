package com.ipartek.formacion.model;

import java.util.List;

import com.ipartek.formacion.pojo.Usuario;

public class UsuarioDAO implements CrudAble<Usuario> {

	@Override
	public boolean insert(Usuario pojo) {
		return false;
	}

	@Override
	public List<Usuario> getAll() {
		return null;
	}

	@Override
	public Usuario getById(long id) {
		return null;
	}

	@Override
	public boolean update(Usuario pojo) {
		return false;
	}

	@Override
	public boolean delete(long id) {
		return false;
	}

}
