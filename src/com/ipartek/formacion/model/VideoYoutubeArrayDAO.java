package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * 
 * Clase DAO para gestionar los VideosYoutube con ArrayList.
 * 
 * Usamos patrón Singleton
 * 
 * @author Asier Cornejo
 * 
 * @see https://es.wikipedia.org/wiki/Singleton
 *
 */
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

	// En java solo se pone un return
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
		VideoYoutube result = null;
		if (id <= lista.size()) {
			result = lista.get((int) id);
		}

		return result;
	}

	@Override
	public boolean update(VideoYoutube video) {

		boolean result = false;
		VideoYoutube aux = null;

		if (video != null) {
			if (video.getId() >= 0) {
				for (int i = 0; i < lista.size(); i++) {
					aux = lista.get(i);
					if (aux.getId() == video.getId()) {
						lista.set(i, video);
						result = true;
						break;
					}
				}

			}

		}

		return result;
	}

	@Override
	public boolean delete(long id) {

		boolean result = false;
		VideoYoutube aux = null;

		if (id >= 0) {

			for (int i = 0; i < lista.size(); i++) {
				aux = lista.get(i);
				if (aux.getId() == id) {
					lista.remove(i);
					result = true;
				}
				break;

			}
		}

		return result;
	}

}
