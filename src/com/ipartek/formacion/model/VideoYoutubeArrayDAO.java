package com.ipartek.formacion.model;

/**
 * Clase DAO para gestionar los VideoYoutube con ArrayList.
 * Usamos patron Singleton
 */
import java.util.ArrayList;
import java.util.List;

public class VideoYoutubeArrayDAO implements CrudAble {

	private static VideoYoutubeArrayDAO INSTANCE = null;
	private static List<VideoYoutube> lista = null;

	private VideoYoutubeArrayDAO() {
		lista = new ArrayList<VideoYoutube>();
	}

	public static synchronized VideoYoutubeArrayDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoYoutubeArrayDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(VideoYoutube video) {
		boolean resul = false;
		if (video != null) {
			lista.add(video);
			resul = true;
		}
		return resul;
	}

	@Override
	public List<VideoYoutube> getAll() {
		return lista;
	}

	@Override
	public VideoYoutube getById(long id) {
		return null;
	}

	@Override
	public boolean update(VideoYoutube video) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		VideoYoutube vIteracion = null;
		// buscar video a eliminar
		for (int i = 0; i < lista.size(); i++) {
			vIteracion = lista.get(i); //video sobre el que iteramos
			if (id == vIteracion.getId()) { // video encontrado
				resul = lista.remove(vIteracion);
				break;
			}
		}
		return resul;
	}

}
