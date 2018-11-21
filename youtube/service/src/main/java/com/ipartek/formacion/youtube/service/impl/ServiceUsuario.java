package com.ipartek.formacion.youtube.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.youtube.dao.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;

public class ServiceUsuario implements IServiceUsuario{
	
	private final static Logger LOG = Logger.getLogger(ServiceUsuario.class);
	
	private static ServiceUsuario INSTANCE = null;
	private static UsuarioDAO daoUsuario = null;
	
	private ServiceUsuario() {
		super();
		daoUsuario = UsuarioDAO.getInstance();
	}

	@Override
	public IServiceUsuario getInstance() {
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
			LOG.debug("Usuario recuperado " + resul);
		}catch(Exception e) {
			LOG.error(e);
		}
		
		return resul;
	}

	@Override
	public Usuario buscarPorId(long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crear(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(long idUsuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
