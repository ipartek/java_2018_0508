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
import com.ipartek.formacion.youtube.pojo.UsuarioPrivado;
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
		UsuarioPrivado resultado = null;

		try {

			UsuarioPrivado usuario = new UsuarioPrivado(nombre, password);
			resultado = daoUsuario.login(usuario);
			LOG.debug("usuario logueado: " + resultado);

		} catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}

	@Override
	public Usuario buscarPorIdPublico(long idUsuario) {
		Usuario resultado = null;
		try {

			resultado = daoUsuario.getByIdPublico(idUsuario);
			LOG.debug("usuario encontrado: " + resultado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error(e);
		}

		return resultado;
	}

	@Override
	public UsuarioPrivado buscarPorIdPrivado(long idUsuario) {
		UsuarioPrivado resultado = null;
		try {

			resultado = daoUsuario.getByIdPrivado(idUsuario);
			LOG.debug("usuario encontrado: " + resultado);
		} catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}

	@Override
	public List<Usuario> listarPublico() {
		ArrayList<Usuario> usuarios = null;

		try {

			usuarios = (ArrayList<Usuario>) daoUsuario.getAllPublico();
			LOG.debug("usuarios encontrados: " + usuarios);

		} catch (Exception e) {
			LOG.error(e);
		}

		return usuarios;
	}

	@Override
	public List<UsuarioPrivado> listarPrivado() {
		ArrayList<UsuarioPrivado> usuarios = null;

		try {

			usuarios = (ArrayList<UsuarioPrivado>) daoUsuario.getAllPrivado();
			LOG.debug("usuarios encontrados: " + usuarios);

		} catch (Exception e) {
			LOG.error(e);
		}

		return usuarios;
	}

	@Override
	public boolean crear(UsuarioPrivado usuario) throws Exception {
		boolean resultado = false;
		Set<ConstraintViolation<UsuarioPrivado>> violations = validator.validate(usuario);
		if (violations.isEmpty()) {

			resultado = daoUsuario.insert(usuario);
			resultado = true;
			LOG.debug("usuari@ cread@: " + usuario);

		} else {
			LOG.debug("Validación incorrecta");
		}
		return resultado;
	}

	@Override
	public boolean modificar(Usuario usuario) throws Exception {
		boolean resultado = false;

		if (usuario instanceof Usuario) {
			daoUsuario.update((UsuarioPrivado) usuario);
		} else if (usuario instanceof UsuarioPrivado) {
			daoUsuario.update(usuario);
		}
		return false;
	}

	@Override
	public boolean eliminar(long idUsuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @Override public List<Usuario> listar() { ArrayList<UsuarioPrivado> usuarios
	 * = null; try {
	 * 
	 * usuarios = (ArrayList<UsuarioPrivado>) daoUsuario.getAllPrivado();
	 * LOG.debug("Usuarios encontrados: " + usuarios);
	 * 
	 * } catch (Exception e) { LOG.error(e); } return usuarios; }
	 * 
	 * @Override public boolean crear(UsuarioPrivado usuario) throws Exception {
	 * boolean resultado = false;
	 * 
	 * Set<ConstraintViolation<UsuarioPrivado>> violations =
	 * validator.validate(usuario); if (violations.isEmpty()) { if
	 * (daoUsuario.insert(usuario)) { resultado = true; LOG.debug("Usuario creado: "
	 * + usuario); }
	 * 
	 * } else { LOG.debug("Validación incorrecta"); }
	 * 
	 * return resultado; }
	 * 
	 * @Override public boolean modificar(UsuarioPrivado usuario) throws Exception {
	 * boolean resultado = false;
	 * 
	 * Set<ConstraintViolation<UsuarioPrivado>> violations =
	 * validator.validate(usuario); if (violations.isEmpty()) { if
	 * (daoUsuario.update(usuario)) { resultado = true;
	 * LOG.debug("Usuarios modificado: " + usuario); } } else {
	 * LOG.debug("Validación incorrecta"); }
	 * 
	 * return resultado; }
	 * 
	 * @Override public boolean eliminar(long idUsuario) throws Exception { boolean
	 * resultado = false; if (daoUsuario.delete(idUsuario)) { resultado = true;
	 * LOG.debug("Usuario eliminado:"); } return resultado; }
	 * 
	 * @Override public Usuario login(String nombre, String password) { }
	 * 
	 * @Override public boolean crear(Usuario usuario) throws Exception { // TODO
	 * Auto-generated method stub return false; }
	 * 
	 * @Override public boolean modificar(Usuario usuario) throws Exception { //
	 * TODO Auto-generated method stub return false; }
	 * 
	 * @Override public boolean crear(Usuario usuario) throws Exception { // TODO
	 * Auto-generated method stub return false; }
	 * 
	 * @Override public boolean modificar(com.ipartek.formacion.youtube.pojo.Usuario
	 * usuario) throws Exception { // TODO Auto-generated method stub return false;
	 * }
	 * 
	 * // DETALLE
	 * 
	 * @Override public Usuario buscarPorIdPublico(long idUsuario) { Usuario usuario
	 * = null;
	 * 
	 * try {
	 * 
	 * usuario = daoUsuario.getById(idUsuario); LOG.debug("usuario encontrado: " +
	 * usuario);
	 * 
	 * } catch (Exception e) { LOG.error(e); } return usuario; }
	 * 
	 * @Override public UsuarioPrivado buscarPorIdPrivado(long idUsuario) {
	 * UsuarioPrivado usuario = null;
	 * 
	 * try {
	 * 
	 * usuario = daoUsuario.getById(idUsuario); LOG.debug("usuario encontrado: " +
	 * usuario);
	 * 
	 * } catch (Exception e) { LOG.error(e); } return usuario; }
	 * 
	 * @Override public List<UsuarioPrivado> listarPrivado() {
	 * ArrayList<UsuarioPrivado> usuarios = null; try {
	 * 
	 * usuarios = (ArrayList<UsuarioPrivado>) daoUsuario.getAllPrivado();
	 * LOG.debug("Usuarios encontrados: " + usuarios);
	 * 
	 * } catch (Exception e) { LOG.error(e); } return usuarios; }
	 */

}
