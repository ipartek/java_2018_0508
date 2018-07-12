package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los VideoYoutube con ArrayList
 * Usamos patrón singleton
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Adrian Garcia
 *
 */
public class VideoYoutubeArrayDAO implements CrudAble {
	
	private static VideoYoutubeArrayDAO INSTANCE = null;
	
	private static List<VideoYoutube> lista = null;
	
	private VideoYoutubeArrayDAO(){
		lista = new ArrayList<VideoYoutube>();
	}
	
	public static synchronized VideoYoutubeArrayDAO getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new VideoYoutubeArrayDAO();
		}
		
		return INSTANCE;
	}
	
	@Override
	public boolean insert(VideoYoutube video) {
		
		boolean resultado = false;
		
		if(video != null) {
			resultado = lista.add(video);
		}
		return resultado;
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
		return false;
	}

	@Override
	public boolean delete(long id) {
		return false;
	}

}
