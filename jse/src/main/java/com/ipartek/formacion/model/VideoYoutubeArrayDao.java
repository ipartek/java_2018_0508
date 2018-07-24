package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.videoYoutube;

/**
 * Clase DAO para gestionar los VideosYoutube con arrayList usamos patron
 * Singleton
 * 
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Curso
 *
 */

public class VideoYoutubeArrayDao implements CrudAble<videoYoutube> {

	private static VideoYoutubeArrayDao INSTANCE = null;
	private static List<videoYoutube> lista = null;

	private VideoYoutubeArrayDao() {
		lista = new ArrayList<videoYoutube>();

	}

	public static synchronized VideoYoutubeArrayDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoYoutubeArrayDao();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(videoYoutube video) {
		boolean resul = false;
		if (video != null) {
			resul = lista.add(video);
			// resul = lista.set(video.getId(), video)
		}

		return resul;
	}

	@Override
	public List<videoYoutube> getAll() {
		return lista;
	}

	@Override
	/**
	 * Entra un id y si encuentra es true y si es falso devuelve false
	 */
	public videoYoutube getById(long id) {
		videoYoutube videoIteracion = null;
		videoYoutube resul = null;
		for (int i = 0; i < lista.size(); i++) {
			videoIteracion = lista.get(i);
			if (videoIteracion.getId() == id) {
				resul = videoIteracion;
				break;
			}
		}
		return resul;
		// foreach
		/*
		 * for (videoYoutube videoIteracion : lista) { resul = true; }
		 */

	}

	@Override
	public boolean update(videoYoutube videoupdate) {
		/*
		 * boolean resul = false; videoYoutube videoIteracion = null; if (video != null)
		 * { for (int x = 0; x < lista.size(); x++) { videoIteracion = lista.get(x); if
		 * (video.getId() == videoIteracion.getId()) { lista.add(video); resul = true; }
		 * } } return resul;
		 */
		boolean resul = false;
		videoYoutube videoIteracion = null;
		int i = 0;
		// comprobamos si es null hacer comprobacion
		if (videoupdate != null) {
			// iterator
			Iterator<videoYoutube> it = lista.iterator();
			while (it.hasNext()) {
				videoIteracion = it.next();
				if (videoIteracion.getId() == videoupdate.getId()) {
					lista.set(i, videoupdate);
					resul = true;
					break;
				}

			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		boolean resul = false;
		videoYoutube videoIteracion = null;
		for (int x = 0; x < lista.size(); x++) {
			videoIteracion = lista.get(x);
			if (id == videoIteracion.getId()) {
				resul = lista.remove(videoIteracion);
			}
		}

		return resul;
	}

}
