package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los VideoYutube con ArrayList Usamos patron
 * Singlenton
 * 
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author andreaPerez
 *
 */
public class VideoYoutubeArrayDAO implements CrudAble {

	private static VideoYoutubeArrayDAO INSTANCE = null;
	private static List<VideoYoutube> lista = null;

	/**
	 * inicializa el array
	 */
	private VideoYoutubeArrayDAO() {

		lista = new ArrayList<VideoYoutube>();
	}

	/**
	 * metodo de acceso al DAO
	 * 
	 * @return INSTANCE
	 */
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

		}

		return resul;
	}

	@Override
	public List<VideoYoutube> getALl() {

		return lista;
	}

	@Override
	public VideoYoutube getById(long id) {

		VideoYoutube aux = new VideoYoutube();

		for (int i = 0; i < lista.size();) {
			for (VideoYoutube videoYt : lista) {
				if (videoYt.getId() == id) {
					aux = lista.get(i);
				}
			}
			break;
		}
		return aux;
	}

	@Override
	public boolean update(VideoYoutube video) {

		boolean resul = false;

		if (video != null) {

			for (int i = 0; i < lista.size();) {

				if (lista.get(i).getId() == video.getId()) {
					lista.set(i, video);

				}

				break;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {

		boolean resul = false;

		for (int i = 0; i < lista.size(); i++) {
			for (VideoYoutube videoYt : lista) {
				if (videoYt.getId() == id) {
					lista.remove(i);
					break;
				}
			}
		}
		return resul;
	}

}
