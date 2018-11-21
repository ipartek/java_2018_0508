package com.ipartek.formacion.youtube.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.youtube.dao.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.UsuarioPublico;
import com.ipartek.formacion.youtube.service.IServiceUsuario;

public class ServiceUsuario implements IServiceUsuario {

	private final static Logger LOG = Logger.getLogger(ServiceUsuario.class);
	private static ServiceUsuario INSTANCE = null;
	private static UsuarioDAO daoUsuario = null;
	ValidatorFactory factory = null;
	Validator validator = null; 
	
	private ServiceUsuario() {
		super();
		daoUsuario = UsuarioDAO.getInstance();
		
		//Crear Factoria y Validador
		 factory = Validation.buildDefaultValidatorFactory();
		 validator = factory.getValidator();
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
			Usuario usuario = new Usuario(nombre, password);
			resul = daoUsuario.login(usuario);
			LOG.debug("Usuario recuperado " + resul);
			
		} catch (Exception e) {
			LOG.error(e);			
		}
		
		return resul;
	}

	@Override
	public Usuario buscarPorId(long idUsuario) {
		
		Usuario resul = null;
		
		try {
			resul = daoUsuario.getById(idUsuario);
			LOG.debug("Usuario encontrado " + resul);
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return resul;
	}

	@Override
	public List<Usuario> listar() {
		
		ArrayList<Usuario> usuarios = null;
		
		try {
			usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
			LOG.debug("Recuperados todos los usuarios");
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return usuarios;
	}

	@Override
	public List<UsuarioPublico> listarPublicos() {
		
		ArrayList<UsuarioPublico> usuarios = null;
		
		try {
			
			usuarios = (ArrayList<UsuarioPublico>) daoUsuario.getAllPublic();
			LOG.debug("Recuperados todos los usuarios públicos");
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return usuarios;
	}

	@Override
	public boolean crear(Usuario usuario) throws Exception {
		
		boolean resul = false;
		
		try {
			Rol rol = new Rol();
			rol.setId(Rol.ROL_USER);
			usuario.setRol(rol);
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if(violations.isEmpty()) {
				
				resul = daoUsuario.insert(usuario);
				LOG.debug("Usuario creado: " + usuario);
			}else {
				LOG.debug("Validacion no correcta " + violations);
				throw new Exception(violations.toString());
			}
			
			
		} catch (Exception e) {
			LOG.error(e);
			throw new Exception(e);
		}
		
		return resul;
	}

	@Override
	public boolean modificar(Usuario usuario) throws Exception {
		
		boolean resul = false;		
		
		try {
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if(violations.isEmpty()) {
				resul = daoUsuario.update(usuario);
				LOG.debug("Usuario modificado: " + usuario);
			
			}else {
				LOG.debug("Validacion no correcta " + violations);
				throw new Exception(violations.toString());
			}
			
		} catch (Exception e) {
			LOG.error(e);
			throw new Exception(e);
		}
		
		return resul;
	}

	@Override
	public boolean eliminar(long idUsuario) throws Exception {
		
		boolean resul = false;
		
		if(daoUsuario.delete(idUsuario)) {
			resul = true;
			LOG.debug("Usuario eliminado");
		}
		
		return resul;
	}


}
