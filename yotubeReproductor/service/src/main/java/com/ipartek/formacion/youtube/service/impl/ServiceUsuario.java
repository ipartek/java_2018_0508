package com.ipartek.formacion.youtube.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.youtube.dao.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;

public class ServiceUsuario implements IServiceUsuario {

	private final static Logger LOG = Logger.getLogger(ServiceUsuario.class);
	private static ServiceUsuario INSTANCE = null;
	private static UsuarioDAO daoUsuario = null;

	private ServiceUsuario() {
		super();
		daoUsuario = UsuarioDAO.getInstance();
	}


	public static synchronized IServiceUsuario getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceUsuario();
		}
		return INSTANCE;
	}

	@Override
	public Usuario login(String nombre, String password) {
		Usuario resul = null;
		try {

			Usuario u = new Usuario(nombre, password);
			resul = daoUsuario.login(u);
			LOG.debug("usuario recuperado" + resul);
		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;
	}

	@Override
	public Usuario buscarPorId(long idUsuario) {

		try {
			Usuario u = daoUsuario.getById(Long.toString(idUsuario));
			return u;

		} catch (Exception e) {
			LOG.error(e);
		}
		return null;
	}

	@Override
	public List<Usuario> listar() {

		List<Usuario> u = null;
		try {
			u = daoUsuario.getAll();
		} catch (Exception e) {
			LOG.error(e);
		}
		return u;
	}

	@Override
	public boolean crear(Usuario usuario) throws Exception {
		boolean resul = false;

		if (daoUsuario.insert(usuario)) {
			resul = true;
		}

		return resul;
	}

	@Override
	public boolean modificar(Usuario usuario) throws Exception {
		boolean resul = false;

		if (daoUsuario.update(usuario)) {
			resul = true;
		}

		return resul;
	}

	@Override
	public boolean eliminar(long idUsuario) {
		boolean resul = false;
		try {

			if (daoUsuario.delete(Long.toString(idUsuario))) {
				resul = true;
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;
	}


	@Override
	public List<Usuario> listarPublicos() {
		// TODO Auto-generated method stub
		return null;
	}

}
