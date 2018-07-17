package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
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
public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube> {

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

		for (VideoYoutube videoIteracion : lista) {
			if (id == videoIteracion.getId()) {
				result = videoIteracion;
				break;
			}
		}

		return result;
	}

	@Override
	public boolean update(VideoYoutube videoUpdate) {

		boolean result = false;
		VideoYoutube videoIteracion = null;
		int i = 0;

		if (videoUpdate != null) {
			Iterator<VideoYoutube> it = lista.iterator();
			while (it.hasNext()) {
				videoIteracion = it.next();
				if (videoIteracion.getId() == videoUpdate.getId()) {
					lista.set(i, videoUpdate);
					result = true;
					break;
				}
				i++;
			}
		}

		return result;
	}

	@Override
	public boolean delete(long id) {

		boolean result = false;
		VideoYoutube aux = null;

		if (id >= 0) {

			for (VideoYoutube video : lista) {
				aux = lista.get((int) video.getId());
				if (aux.getId() == id) {
					result = lista.remove(aux);
					break;
				}

			}
		}
		return result;
	}

	public boolean deleteAll(List<VideoYoutube> list) {
		boolean result = false;
		if (!list.isEmpty()) {
			list.clear();
			result = true;
		}

		return result;
	}

}
