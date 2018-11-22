package com.ipartek.formacion.youtube.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.youtube.dao.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.ipartek.formacion.youtube.service.IServiceUsuario;
import com.ipartek.formacion.youtube.service.IServiceVideo;

public class ServiceVideo implements IServiceVideo {

	private static ServiceVideo INSTANCE = null;
	private static VideoDAO daoVideo = null;

	private final static Logger LOG = Logger.getLogger(ServiceVideo.class);

	static ValidatorFactory factory = null;
	static Validator validator = null;

	public static synchronized IServiceVideo getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServiceVideo();
		}

		return INSTANCE;
	}

	public ServiceVideo() {
		daoVideo = VideoDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();
	}

	@Override
	public Video buscarPorId(long idUsuario) throws Exception {

		Video v = null;
		if (idUsuario > 0) {
			v = daoVideo.getById(idUsuario);
		}
		return v;
	}

	@Override
	public List<Video> listar() {

		ArrayList<Video> videos = new ArrayList<Video>();
		try {
			videos = (ArrayList<Video>) daoVideo.getAll();
		}
			
		 catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return videos;
	}

	@Override
	public boolean crear(Video v) throws Exception {
		boolean resul = false;
		


		Set<ConstraintViolation<Video>> violations = validator.validate(v);
		String[] errores = new String[violations.size()];

		if (violations.size() > 0) {

			int contador = 0;

			// No tenemos ningun fallo, la Validacion es correcta
			for (ConstraintViolation<Video> violation : violations) {

				errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
				contador++;
			}

		} else {
			if (daoVideo.insert(v)) {
				resul = true;
			}
		}

		return resul;
	}

	@Override
	public boolean modificarVideo(Video v) throws Exception {
		boolean resul = false;

		/*Set<ConstraintViolation<Video>> violations = validator.validate(v);
		String[] errores = new String[violations.size()];

		// preguntamos por el campo rol
		// viene sin el campo rol y hay que completarlo
		if (u.getRol().getId() < 0) {
			Usuario usuarioOrig = daoVideo.getById(String.valueOf(u.getId()));
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
*/
		return resul;
	}

	@Override
	public boolean eliminarVideo(long id) throws Exception {
		boolean resul = false;
		/*if (daoUsuario.delete(String.valueOf(id))) {
			resul = true;
		}*/
		return resul;
	}

	@Override
	public List<Usuario> listarPublicos() {
		// TODO Auto-generated method stub
		return null;
	}
}
