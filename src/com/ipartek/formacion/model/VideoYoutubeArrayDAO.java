package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los VideoYoutube con ArrayList.<br>
 * Usamos patron Singleton
 * 
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Curso
 *
 */
public class VideoYoutubeArrayDAO implements CrudAble {

	private static VideoYoutubeArrayDAO INSTANCE = null;
	private static List<VideoYoutube> lista = null;
	private static final int ID_MIN_VALUE = 1;
	private static int idCounter = ID_MIN_VALUE;

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

		boolean result = false;
		if (video != null) {
			video.setId(idCounter++);
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

		VideoYoutube video = null;
		for (VideoYoutube videoYoutube : lista) {
			if (videoYoutube.getId() == id) {
				video = videoYoutube;
				break;
			}
		}
		return video;
	}

	@Override
	public boolean update(VideoYoutube videoUpdate) {
		boolean correcto = false;
		if (videoUpdate != null) {
			VideoYoutube videoIteracion = null;
			Iterator<VideoYoutube> it = lista.iterator();
			int i = 0;
			while (it.hasNext()) {
				videoIteracion = it.next();
				if (videoIteracion.getId() == videoUpdate.getId()) {
					lista.set(i, videoUpdate);
					correcto = true;
					break;
				}
				i++;
			}
		}
		return correcto;
	}

	@Override
	public boolean delete(long id) {
		boolean eliminado = false;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				eliminado = lista.remove(lista.get(i));
				break;
			}
		}

		return eliminado;
	}
	
	

}
