package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Video;

public class ServicioVideo implements IService<Video> {

	private static ServicioVideo INSTANCE = null;

	private VideoDAO daoVideo;

	private ServicioVideo() {
		super();
		daoVideo = VideoDAO.getInstance();
	}

	public static synchronized ServicioVideo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioVideo();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Video pojo) throws Exception {
		// TODO Auto-generated method stub
		return daoVideo.insert(pojo);
	}

	@Override
	public boolean modificar(Video pojo) throws Exception {

		return daoVideo.update(pojo);
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		return daoVideo.delete(id);
	}

	@Override
	public Video buscar(long id) throws Exception {
		return daoVideo.getById(id);
	}

	@Override
	public List<Video> listar() throws Exception {
		return daoVideo.getAll();
	}

}
