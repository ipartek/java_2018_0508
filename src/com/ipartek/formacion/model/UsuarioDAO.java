package com.ipartek.formacion.model;

import java.util.List;

import com.ipartek.formacion.pojo.Usuario;

public class UsuarioDAO implements CrudAble<Usuario>{
	
	private static UsuarioDAO INSTANCE = null;
	private static List<Usuario> lista = null;

	@Override
	public boolean insert(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
