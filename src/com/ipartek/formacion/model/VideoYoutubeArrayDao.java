package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.videoYoutube;

/**
 * Clase DAO para gestionar los VideosYoutube con arrayList
 * usamos patron Singleton
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Curso
 *
 */

public class VideoYoutubeArrayDao implements CrudAble {
	
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
		if(video != null) {
			resul =lista.add(video);
		}

		return resul;
	}

	@Override
	public List<videoYoutube> getAll() {
		return lista;
	}

	@Override
	public videoYoutube getById(long id) {
		videoYoutube resul = null;
		videoYoutube videoIteracion = null;
		for (int i = 0; i < lista.size(); i++) {
			videoIteracion = lista.get(i);
			if(videoIteracion.getId()== id) {
				resul = videoIteracion;
				break;
			}
		}
		return resul;
		

	}

	@Override
	public boolean update(videoYoutube video) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
