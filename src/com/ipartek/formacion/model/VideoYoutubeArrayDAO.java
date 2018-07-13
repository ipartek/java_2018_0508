package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los VideoYoutube con ArrayList. Usamos el Patrón
 * Singleton
 * 
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 * @author Curso
 *
 */
public class VideoYoutubeArrayDAO implements CrudAble {

	private static VideoYoutubeArrayDAO INSTANCE = null;
	private static ArrayList<VideoYoutube> lista;

	private VideoYoutubeArrayDAO() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		lista = new ArrayList<VideoYoutube>();
	}

	public static synchronized VideoYoutubeArrayDAO getInstance() {
		return (INSTANCE == null ? new VideoYoutubeArrayDAO() : INSTANCE);
	}

	@Override
	public boolean insert(VideoYoutube video) {
		boolean result = false;

		if (video != null) {
			result = lista.add(video);
		}

		return result;
	}

	@Override
	public List<VideoYoutube> getAll() {
		return lista;
	}

	@Override
	public VideoYoutube getById(long id) {
		VideoYoutube v = null;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				v = lista.get(i);
				break;
			}
		}
		return v;
	}

	
	@Override
	public boolean update(VideoYoutube video) {
		boolean result = false;

		if (video != null) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == video.getId()) {
					lista.set(i, video);
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	public boolean delete(long id) {

		boolean result = false;

		for (VideoYoutube vIteracion : lista) {
			if (id == vIteracion.getId()) { // Video encontrado
				result = lista.remove(vIteracion); // Eliminamos video y comprobamos
				break;
			}
		}

		return result;
	}

}
