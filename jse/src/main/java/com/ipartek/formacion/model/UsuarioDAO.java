package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.ejercicios.interfaces.CrudAble;
import com.ipartek.formacion.pojo.Usuario;

public class UsuarioDAO implements CrudAble<Usuario> {
	
	private static UsuarioDAO INSTANCE = null;
	private static List<Usuario> Lista = null;
	private static long id = 1;
	
	private UsuarioDAO() {
		Lista = new ArrayList<Usuario>();
	}
	
	public static synchronized UsuarioDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
		
	}
	

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
	public Usuario getByID(long id) {
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
