package com.ipartek.formacion.youtube.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.youtube.dao.ComentariosDao;
import com.ipartek.formacion.youtube.dao.UsuariosDAO;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceComentario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;

public class ServiceComentario implements IServiceComentario {

	private static ServiceComentario INSTANCE = null;
	private static ComentariosDao daoComentario = null;
	
	private final static Logger LOG = Logger.getLogger(ServiceComentario.class);

	static ValidatorFactory factory = null;
	static Validator validator = null;

	public static synchronized IServiceComentario getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServiceComentario();
		}

		return INSTANCE;
	}

	public ServiceComentario() {
		daoComentario = ComentariosDao.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();
	}

	
	@Override
	public Comentario buscarPorId(long idComentario) {

		Comentario c = null;

		try {

			if (idComentario > 0) {
				c = daoComentario.getById(idComentario);
			}

		} catch (Exception e) {

			LOG.error(e.getMessage());
		}

		return c;
	}
	

	@Override
	public List<Comentario> listar() {

		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try {
			comentarios = (ArrayList<Comentario>) daoComentario.getAll();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return comentarios;
	}

	@Override
	public boolean crear(Comentario c) throws Exception {
		boolean resul = false;




			Set<ConstraintViolation<Comentario>> violations = validator.validate(c);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Comentario> violation : violations) {

					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

			} else {
				if (daoComentario.insert(c)) {
					
					
					
					resul = true;
				}
			}
		

		return resul;
	}
	
	@Override
	public boolean modificarComentario(Comentario c) throws Exception {
		boolean resul = false;

		Set<ConstraintViolation<Comentario>> violations = validator.validate(c);
		String[] errores = new String[violations.size()];
		


		if (violations.size() > 0) {

			int contador = 0;

			// No tenemos ningun fallo, la Validacion es correcta
			for (ConstraintViolation<Comentario> violation : violations) {

				errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
				contador++;
			}

		} else {
			if(c.getFecha() == null ) {
				Comentario comentarioFechaOrig = daoComentario.getById(c.getId());
				c.setFecha(comentarioFechaOrig.getFecha());
				
			}
			if (daoComentario.update(c)) {
				resul = true;
				
			}
		}

		return resul;
	}
/*
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

*/



	@Override
	public List<Comentario> listarPublicos() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean eliminarUsuario(long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
