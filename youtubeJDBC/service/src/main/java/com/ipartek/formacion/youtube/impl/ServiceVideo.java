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
import com.ipartek.formacion.youtube.dao.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.ipartek.formacion.youtube.service.IServiceUsuario;
import com.ipartek.formacion.youtube.service.IServiceVideo;

public class ServiceVideo implements IServiceVideo {

	private static ServiceVideo INSTANCE = null;
	private static VideoDAO daoVideo = null;
	private static UsuariosDAO daoUsuario = null;

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
		daoUsuario = UsuariosDAO.getInstance();
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
				setUsuario(v);
			}
		}

		return resul;
	}

	@Override
	public boolean modificarVideo(Video vActu) throws Exception {
		boolean resul = false;

		Set<ConstraintViolation<Video>> violations = validator.validate(vActu);
		String[] errores = new String[violations.size()];

		if (violations.size() > 0) {

			int contador = 0;

			// No tenemos ningun fallo, la Validacion es correcta
			for (ConstraintViolation<Video> violation : violations) {

				errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
				contador++;
			}

		} else {

			if (daoVideo.update(vActu)) {

				resul = true;
				setUsuario(vActu);
			}

		}

		return resul;
	}

	@Override
	public boolean eliminarVideo(long id) throws Exception {
		boolean resul = false;
		return resul;
	}

	private void setUsuario(Video vActu) throws Exception {
		// completamos los campos del resultado
		Usuario u = daoUsuario.getById(vActu.getUsuario().getId());
		u.setPass("*****");
		vActu.setUsuario(u);

	}

	@Override
	public List<Usuario> listarPublicos() {
		// TODO Auto-generated method stub
		return null;
	}
}
