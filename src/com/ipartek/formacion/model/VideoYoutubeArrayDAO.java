package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los VideoYoutube con ArrayList. Usamos patron
 * Singleton
 * 
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Curso
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

		VideoYoutube video = null;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				video = lista.get(i);
				break;
			}
		}

		return video;
	}

	@Override
	public boolean update(VideoYoutube video) {
		boolean correcto = false;
		if (video != null) {
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getId()==video.getId()) {
					lista.set(i, video);
					correcto = true;
					break;					
				}
			}
		}
		return correcto;
	}

	@Override
	public boolean delete(long id) {
		boolean eliminado = false;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getId()==id) {
				lista.remove(i);
				eliminado = true;
				break;					
			}
		}

		
		return eliminado;
	}

}
