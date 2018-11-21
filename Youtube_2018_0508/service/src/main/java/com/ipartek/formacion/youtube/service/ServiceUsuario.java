package com.ipartek.formacion.youtube.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

public class ServiceUsuario implements IServiceUsuario {
	
	private static ServiceUsuario INSTANCE = null;
	
	private UsuarioDAO daoUsuario = null;
	
	//Validaciones
	ValidatorFactory factory = null;
	Validator validator = null;
	
	// Logger
	private final static Logger LOG = Logger.getLogger(ServiceUsuario.class);
	
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
	public Usuario login(String nombre, String pswd) {
		Usuario u = null;
		try {
			u = daoUsuario.getByNombreAndPswd(nombre, pswd);
			LOG.debug("Credenciales correctas " + u);
		} catch (Exception e) {
			LOG.error(e);
		}
		return u;
	}

	@Override
	public Usuario buscarPorId(long id) {
		
		Usuario u = null;
		try {
			u = daoUsuario.getById(Long.toString(id));
		} catch (Exception e) {
			LOG.error(e);
		}
		return u;
	}

	@Override
	public List<Usuario> listar() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public boolean crear(Usuario u) throws Exception {
		boolean resul = false;
		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		if (violations.isEmpty()) {
			if(daoUsuario.insert(u)) {
				LOG.debug("Usuario creado");
				return true;
			}
		}else {
			for (ConstraintViolation<Usuario> violation : violations) {
				LOG.debug("Error de validacion al crear usuario: " + violation.getPropertyPath() + ": "
						+ violation.getMessage());
			}
		}
		
		return resul;
	}

	@Override
	public boolean modificar(Usuario u) throws Exception {
		boolean resul = false;
		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		if (violations.isEmpty()) {
			if(daoUsuario.update(u)) {
				LOG.debug("Usuario modificado");
				resul = true;
			}
		}else {
			for (ConstraintViolation<Usuario> violation : violations) {
				LOG.debug("Error de validacion al modificar usuario: " + violation.getPropertyPath() + ": "
						+ violation.getMessage());
			}
		}
		
		return resul;
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		boolean resul = false;
		if(daoUsuario.delete(Long.toString(id))) {
			LOG.debug("Usuario eliminado");
			resul = true;
		}
		return resul;
	}

}
