package com.ipartek.formacion.youtube.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.youtube.dao.UsuariosDAO;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;

public class ServiceUsuario implements IServiceUsuario {

	private static ServiceUsuario INSTANCE = null;
	private static UsuariosDAO daoUsuario = null;
	
	private final static Logger LOG = Logger.getLogger(ServiceUsuario.class);

	static ValidatorFactory factory = null;
	static Validator validator = null;

	public static synchronized IServiceUsuario getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServiceUsuario();
		}

		return INSTANCE;
	}

	public ServiceUsuario() {
		daoUsuario = UsuariosDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();
	}

	@Override
	public Usuario login(String nombre, String password) {

		Usuario resul = new Usuario(nombre, password);

		Set<ConstraintViolation<Usuario>> violations = validator.validate(resul);
		String[] errores = new String[violations.size()];

		try {
			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Usuario> violation : violations) {

					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

			}

			resul = daoUsuario.checkByNamePass(nombre, password);
			// LOG.debug()

		} catch (Exception e) {
			// LOG.debug()

			LOG.error(errores);
		}
		return resul;
	}

	@Override
	public Usuario buscarPorId(long idUsuario) {

		Usuario u = null;

		try {

			if (idUsuario > 0) {
				u = daoUsuario.getById(idUsuario);
			}

		} catch (Exception e) {

			LOG.error(e.getMessage());
		}

		return u;
	}

	@Override
	public List<Usuario> listar() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return usuarios;
	}

	@Override
	public boolean crear(Usuario u) throws Exception {
		boolean resul = false;


			Rol rol = new Rol();
			rol.setId(Rol.ROL_USER);
			rol.setNombre("usuario");
			u.setRol(rol);

			Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Usuario> violation : violations) {

					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

			} else {
				if (daoUsuario.insert(u)) {
					
					Usuario usuarioId = daoUsuario.checkByName(u.getNombre());
					u.setId(usuarioId.getId());
					resul = true;
				}
			}
		

		return resul;
	}

	@Override
	public boolean modificarUsuario(Usuario u) throws Exception {
		boolean resul = false;

		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		String[] errores = new String[violations.size()];
		
		//preguntamos por el campo rol
		//viene sin el campo rol y hay que completarlo
		if(u.getRol().getId() < 0) {
			Usuario usuarioOrig = daoUsuario.getById(u.getId());
			u.setRol(usuarioOrig.getRol());
		}

		if (violations.size() > 0) {

			int contador = 0;

			// No tenemos ningun fallo, la Validacion es correcta
			for (ConstraintViolation<Usuario> violation : violations) {

				errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
				contador++;
			}

		} else {
			if (daoUsuario.update(u)) {
				resul = true;
			}
		}

		return resul;
	}

	@Override
	public boolean eliminarUsuario(long id) throws Exception {
		boolean resul = false;
		if(daoUsuario.getById(id).getNombre().contains("admin")) {
			throw new Exception("Imposible eliminar el usuario");
		}
		if (daoUsuario.delete(String.valueOf(id))) {
			resul = true;
		}
		return resul;
	}

	@Override
	public List<Usuario> listarPublicos() {
		// TODO Auto-generated method stub
		return null;
	}

}
