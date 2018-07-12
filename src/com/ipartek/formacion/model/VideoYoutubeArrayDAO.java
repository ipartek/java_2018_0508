package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los VideoYoutube con arraylist
 * Usamos patron Singleton
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 * @author Curso
 *
 */
public class VideoYoutubeArrayDAO implements CrudAble{
	
	private static VideoYoutubeArrayDAO INSTANCE = null;
	
	private static List<VideoYoutube> lista = null;
	
	private VideoYoutubeArrayDAO() {
		lista = new ArrayList<VideoYoutube>();
	}
	
	public static synchronized VideoYoutubeArrayDAO getInstance(long mock1Id, String mock1Codigo, String mock1Nombre) {
		if(INSTANCE == null) {
			INSTANCE = new VideoYoutubeArrayDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(VideoYoutube video) {
		boolean resul = false;
		if(video != null) {
			resul = lista.add(video);
		}
		return resul;
	}

	@Override
	public List<VideoYoutube> getAll() {
		return lista;
	}

	@Override
	public VideoYoutube getById(long id) {
		if(id > 0) {
			lista.get((int) id);
		}
		
		return null;
	}

	@Override
	public boolean update(VideoYoutube video) {
		boolean resul = false;
		if(video != null) {
			
			resul = true;
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		return false;
	}

}
