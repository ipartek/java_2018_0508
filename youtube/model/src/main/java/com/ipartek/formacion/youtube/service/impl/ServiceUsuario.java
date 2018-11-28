package com.ipartek.formacion.youtube.service.impl;

import java.sql.SQLClientInfoException;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;

public class ServiceUsuario implements IServiceUsuario {

	private static ServiceUsuario INSTANCE;
	
	private static UsuarioDAO daoUsuario;
	
	private static ValidatorFactory factory;
	private static Validator validator;

	public ServiceUsuario() {
		
		daoUsuario = UsuarioDAO.getInstance();
		
		// Crear Factoria y Validador de hibernate
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	public static synchronized  ServiceUsuario getInstance() {

		if (INSTANCE == null) {
			
			INSTANCE = new ServiceUsuario();
		}

		return INSTANCE;
	}

	@Override
	public Usuario login(String nombre, String password) throws Exception {
		
		Usuario usuario = new Usuario ( nombre, password );		// Crear Objeto Usuario
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate( usuario );	// Comprobar campos de Usuario
		
		if (violations.size() == 0) {	// Campos correctos
			
			
			usuario = daoUsuario.login(new Usuario(nombre, password));	// Loguear Usuario
			
		}
		
		return usuario;
	}

	@Override
	public Usuario buscarPorId(long id) throws Exception {
		
		Usuario usuario = null;
		
		if (id > 0 ) {		// Comprobar ID
			
			usuario = daoUsuario.getById(id);
			
			if (usuario != null) {
				
				usuario.setPassword("");
				usuario.setRol(new Rol());
			}
			
			
		}
		
		return usuario;
	}

	@Override
	public List<Usuario> listar() throws Exception {
		
		return daoUsuario.getAll();
	}
	
	@Override
	public List<Usuario> listarPublicos() throws Exception {
	
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
		
		for (Usuario u: usuarios) {
			
			u.setPassword("");
			u.setRol(new Rol());
		}
		
		return usuarios;
		
	}


	@Override
	public boolean crear( Usuario usuario ) throws Exception {
		
		boolean resul = false;
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate( usuario );	// Comprobar campos de Usuario
		
		if (violations.size() == 0) {	// Campos correctos
			
			resul = daoUsuario.insert( usuario );	// Insertar POJO Usuario
			
		}
		
		return resul;
	}

	@Override
	public boolean modificar( Usuario usuario ) throws Exception {
		
		boolean resul = false;
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate( usuario );
		
		if (violations.size() == 0) {	// Campos correctos
			
			resul = daoUsuario.update( usuario );	// Modificar Usuario de la BBDD
			
		} 
		
		return resul;
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		
		boolean resul = false;
		
		if ( id > 0 ) {		// Comprobar ID 
			
			Usuario usuario = daoUsuario.getById(id);
			
			if ( usuario.getRol().getId() == Rol.ID_ROL_ADMIN ) {
				
				throw new SQLDataException("No se puede eliminar a un administrador.");
			
			} else {
			
				resul = daoUsuario.delete( id );	// Eliminar Usuario de la BBDD
				
			}
			
		}
		
		return resul;
	}


}
