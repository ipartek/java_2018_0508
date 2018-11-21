package com.ipartek.formacion.youtube.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;

public class ServiceUsuario implements IServiceUsuario {

	private static ServiceUsuario INSTANCE = null;
	private static UsuarioDAO daoUsuario = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	private final static Logger LOG = Logger.getLogger(ServiceUsuario.class);

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
		Usuario resultado = null;

		try {

			Usuario usuario = new Usuario(nombre, password);
			resultado = daoUsuario.login(usuario);
			LOG.debug("usuario logueado: " + resultado);

		} catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}

	@Override
	public Usuario buscarPorId(long idUsuario) {
		Usuario usuario = null;

		try {

			usuario = daoUsuario.getById(idUsuario);
			LOG.debug("usuario encontrado: " + usuario);

		} catch (Exception e) {
			LOG.error(e);
		}
		return usuario;
	}

	@Override
	public List<Usuario> listar() {
		ArrayList<Usuario> usuarios = null;
		try {

			usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
			LOG.debug("Usuarios encontrados: " + usuarios);

		} catch (Exception e) {
			LOG.error(e);
		}
		return usuarios;
	}

	@Override
	public boolean crear(Usuario usuario) throws Exception {
		boolean resultado = false;

		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		if (violations.isEmpty()) {
			if (daoUsuario.insert(usuario)) {
				resultado = true;
				LOG.debug("Usuario creado: " + usuario);
			}

		}else {
			LOG.debug("Validación incorrecta");
		}

		return resultado;
	}

	@Override
	public boolean modificar(Usuario usuario) throws Exception {
		boolean resultado = false;

		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		if (violations.isEmpty()) {
			if (daoUsuario.update(usuario)) {
				resultado = true;
				LOG.debug("Usuarios modificado: " + usuario);
			}
		}else {
			LOG.debug("Validación incorrecta");
		}

		return resultado;
	}

	@Override
	public boolean eliminar(long idUsuario) throws Exception {
		boolean resultado = false;
		if (daoUsuario.delete(idUsuario)) {
			resultado = true;
			LOG.debug("Usuario eliminado:");
		}
		return resultado;
	}

}
