package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
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
public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube> {

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

			resul = lista.add(video);
		}

		return resul;
	}

	@Override
	public List<VideoYoutube> getALl() {

		return lista;
	}

	@Override
	public VideoYoutube getById(long id) {

		VideoYoutube aux = null;

		for (VideoYoutube videoIteracion : lista) {
			if (id == videoIteracion.getId()) {
				aux = videoIteracion;
				break;
			}
		}
		return aux;
	}

	@Override
	public boolean update(VideoYoutube videoUpdate) {

		boolean resul = false;
		VideoYoutube vIteracion;
		
		if (videoUpdate != null) {

			Iterator<VideoYoutube> it = lista.iterator();
			while (it.hasNext()) {
				vIteracion = it.next();
				if (vIteracion.getId() == videoUpdate.getId()) {
					lista.set(0, videoUpdate);
					resul = true;
					break;
				}
				
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {

		boolean resul = false;

		VideoYoutube viTeracion = null;

		// buscar video a eliminar
		for (int i = 0; i < lista.size(); i++) {

			viTeracion = lista.get(i);

			if (id == viTeracion.getId()) {
				resul = lista.remove(viTeracion);
				break;
			}
		}
		return resul;
	}

}
