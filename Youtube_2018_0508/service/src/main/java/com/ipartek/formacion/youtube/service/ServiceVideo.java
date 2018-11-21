package com.ipartek.formacion.youtube.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Video;

public class ServiceVideo implements IServiceVideo {

	private static ServiceVideo INSTANCE = null;

	private VideoDAO daoVideo = null;

	// Validaciones
	ValidatorFactory factory = null;
	Validator validator = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(ServiceUsuario.class);

	private ServiceVideo() {
		super();
		daoVideo = VideoDAO.getInstance();
	}

	@Override
	public IServiceVideo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceVideo();
		}

		return INSTANCE;
	}

	@Override
	public List<Video> listar() {
		ArrayList<Video> videos = new ArrayList<Video>();
		videos = (ArrayList<Video>) daoVideo.getAll();
		return videos;
	}

	@Override
	public Video buscarPorId(long id) {
		Video v = null;
		v = daoVideo.getById(Long.toString(id));
		return v;
	}

	@Override
	public boolean crear(Video v) throws Exception {
		boolean resul = false;
		Set<ConstraintViolation<Video>> violations = validator.validate(v);
		if (violations.isEmpty()) {
			if (daoVideo.insert(v)) {
				LOG.debug("Video creado");
				resul = true;
			}
		} else {
			for (ConstraintViolation<Video> violation : violations) {
				LOG.debug("Error de validacion al crear video: " + violation.getPropertyPath() + ": " + violation.getMessage());
			}
		}

		return resul;
	}

	@Override
	public boolean modificar(Video v) throws Exception {
		boolean resul = false;
		Set<ConstraintViolation<Video>> violations = validator.validate(v);
		if (violations.isEmpty()) {
			if (daoVideo.update(v)) {
				resul = true;
				LOG.debug("Video modificado");
			}
		} else {
			for (ConstraintViolation<Video> violation : violations) {
				LOG.debug("Error de validacion al modificar video: " + violation.getPropertyPath() + ": " + violation.getMessage());
			}
		}

		return resul;
	}

	@Override
	public boolean eliminar(long id) {
		boolean resul = false;

		if (daoVideo.delete(Long.toString(id))) {
			resul = true;
			LOG.debug("Video eliminado");
		}

		return resul;
	}

}
