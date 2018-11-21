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
			LOG.debug("Usuario recuperado: " + resul);
		}catch(Exception e) {
			LOG.error(e);
		}
		
		return resul;
	}

	@Override
	public Usuario buscarPorId(long idUsuario) {
		Usuario resul = null;
		
		try {
			resul = daoUsuario.getById(Long.toString(idUsuario));
		}catch(Exception e) {
			LOG.error(e);
		}
		
		return resul;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = null;
		
		try {
			usuarios = daoUsuario.getAll();
			LOG.debug("Usuarios recuperados: " + usuarios);
		}catch(Exception e) {
			LOG.error(e);
		}
		
		return usuarios;
	}

	@Override
	public boolean crear(Usuario usuario) throws Exception {
		boolean resul = false;
		
		try {
			if(daoUsuario.insert(usuario)) {
				resul = true;
				LOG.debug("Usuario insertado; " + usuario);
			}
			
		}catch(Exception e) {
			LOG.error(e);
		}
		
		return resul;
	}

	@Override
	public boolean modificar(Usuario usuario) throws Exception {
		boolean resul = false;
		
		try {
			if(daoUsuario.update(usuario)) {
				resul = true;
				LOG.debug("Usuario modificado: " + usuario);
			}
		}catch(Exception e) {
			LOG.error(e);
		}
		
		return resul;
	}

	@Override
	public boolean eliminar(long idUsuario) throws Exception {
		boolean resul = false;
		
		try {
			if(daoUsuario.delete(Long.toString(idUsuario))) {
				resul = true;
				LOG.debug("Usuario con ID " + idUsuario + " eliminado");
			}
		}catch(Exception e) {
			LOG.error(e);
		}
		
		return resul;
	}

}
