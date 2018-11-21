package com.andrea.perez.youtube.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.andrea.perez.youtube.conection.ConnectionManager;
import com.andrea.perez.youtube.dao.UsuarioDAO;
import com.andrea.perez.youtube.pojo.Rol;
import com.andrea.perez.youtube.pojo.Usuario;
import com.andrea.perez.youtube.service.IServiceUsuario;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class ServicioUsuario implements IServiceUsuario {

	private final static Logger LOG = Logger.getLogger(ConnectionManager.class);
	private static ServicioUsuario INSTANCE = null;
	private static UsuarioDAO daoUsuario = null;

	ValidatorFactory factory = null;
	Validator validator = null;

	private ServicioUsuario() {
		super();
		daoUsuario = UsuarioDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public static synchronized ServicioUsuario getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioUsuario();
		}

		return INSTANCE;
	}

	@Override
	public Usuario login(String nombre, String password) {

		Usuario u = null;
		u = new Usuario(nombre, password);

		try {

			u = daoUsuario.getByNombre(nombre, password);
			LOG.debug("Usuario logueado");

		} catch (Exception e) {
			LOG.error(e);
		}
		return u;
	}

	@Override
	public Usuario buscarPorId(long idUsuario) {
		Usuario u = null;
		try {
			String id = Long.toString(idUsuario);
			if (id != null) {
				u = daoUsuario.getById(id);
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return u;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			usuarios = daoUsuario.getAll();
		} catch (Exception e) {
			LOG.error(e);
		}

		return usuarios;
	}

	@Override
	public boolean crear(Usuario usuario) throws Exception {

		boolean resul = false;

		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

		try {
			Rol rol = new Rol();
			rol.setId(Rol.ROL_USER);			
			usuario.setRol(rol);

			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Usuario> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				LOG.debug("Datos no validos");
				throw new Exception(violations.toString());
				
			} else {
				
				if (daoUsuario.insert(usuario)) {
					resul = true;
				}
			}
			
		}catch (MySQLIntegrityConstraintViolationException e) {

			LOG.error(e);
			throw new Exception(e);

		} catch (Exception e) {
			LOG.error(e);
			throw new Exception(e);
		}

		return resul;
	}

	@Override
	public boolean modificar(Usuario usuario) throws Exception {
		boolean resul = false;
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

		Rol rol = new Rol();
		rol.setId(Rol.ROL_USER);
		usuario.setRol(rol);
		
		try {
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Usuario> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				LOG.debug("Datos no validos");

			} else {
				if (daoUsuario.update(usuario)) {
					resul = true;
				}
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

		if (daoUsuario.delete(Long.toString(idUsuario))) {
			resul = true;
		}
		return resul;
	}

	@Override
	public List<Usuario> listarPublicos() {
		//TODO capar los passwords  y rol
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			usuarios = daoUsuario.getAll();
		} catch (Exception e) {
			LOG.error(e);
		}
		return usuarios;
	}

}
