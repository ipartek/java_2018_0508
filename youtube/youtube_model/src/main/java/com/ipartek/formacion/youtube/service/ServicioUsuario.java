package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

public class ServicioUsuario implements IService<Usuario> {

	private static ServicioUsuario INSTANCE = null;

	private UsuarioDAO daoUsuario;

	private ServicioUsuario() {
		super();
		daoUsuario = UsuarioDAO.getInstance();
	}

	public static synchronized ServicioUsuario getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioUsuario();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Usuario pojo) throws Exception {
		return daoUsuario.insert(pojo);
	}

	@Override
	public boolean modificar(Usuario pojo) throws Exception {
		return daoUsuario.update(pojo);
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		return daoUsuario.delete(id);
	}

	@Override
	public Usuario buscar(long id) throws Exception {
		return daoUsuario.getById(id);
	}

	@Override
	public List<Usuario> listar() throws Exception {
		return daoUsuario.getAll();
	}

}
