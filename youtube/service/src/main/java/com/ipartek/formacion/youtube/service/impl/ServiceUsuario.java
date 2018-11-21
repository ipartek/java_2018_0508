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
import com.ipartek.formacion.youtube.service.IServiceUsuario;

public class ServiceUsuario implements IServiceUsuario {
	
	private final static Logger LOG = Logger.getLogger(ServiceUsuario.class);

	private static ServiceUsuario INSTANCE = null;
	private static UsuarioDAO daoUsuario = null;
	
	
	private ValidatorFactory factory = null;
	private Validator validator = null;
	
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
			Usuario u = new Usuario(nombre, password);			
			resul = daoUsuario.login(u);
			LOG.debug("usaurio recuperado " + resul);
			
		}catch (Exception e) {
			LOG.error(e);
		}			
		return resul;
	}

	@Override
	public Usuario buscarPorId(long idUsurio) {
		Usuario resul = null;
		try {					
			resul = daoUsuario.getById(idUsurio);
			LOG.debug("usaurio recuperado " + resul);			
		}catch (Exception e) {
			LOG.error(e);
		}			
		return resul;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> resul = null;
		try {					
			resul = daoUsuario.getAll();
			if ( resul != null ) {
				LOG.debug("usuarios recuperados " + resul.size());
			}else {
				resul = new ArrayList<Usuario>();				
			}	
		}catch (Exception e) {
			LOG.error(e);
		}	
		return resul;
	}

	@Override
	public boolean crear(Usuario usuario) throws Exception {
		
		boolean resul = false;
		
		try {
			Rol rol = new Rol();
			rol.setId( Rol.ROL_USER);
			usuario.setRol(rol);
			
			//validar usuario
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if ( violations.isEmpty() ) {
				
				resul = daoUsuario.insert(usuario);
				LOG.debug("usuario creado " + usuario);
				
			}else {
				LOG.debug("Validacion no correcta " + violations);
				throw new Exception(violations.toString());
				
			}	
			
		}catch (Exception e) {
			LOG.error(e);
			throw new Exception(e);
		}	
		
		return resul;
	}

	@Override
	public boolean modificar(Usuario usuario) throws Exception {
		boolean resul = false;
		try {
			
			//validar usuario
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if ( violations.isEmpty() ) {
				
				resul = daoUsuario.update(usuario);
				LOG.debug("usuario modificado " + usuario);
				
			}else {
				LOG.debug("Validacion no correcta " + violations);
				
			}	
			
		}catch (Exception e) {
			LOG.error(e);
			throw new Exception(e);
		}	
		
		return resul;
	}

	@Override
	public boolean eliminar(long idUsurio) throws Exception {
		boolean resul = false;
		try {
			resul = daoUsuario.delete(idUsurio);
			if( resul ) {
				LOG.debug("usuario eliminado id " + idUsurio);
			}else {
				LOG.debug("usuario NO encontrado id " + idUsurio);
			}	
			
		}catch (Exception e) {
			LOG.error(e);
			throw new Exception(e);
		}	
		
		return resul;
	}

}
