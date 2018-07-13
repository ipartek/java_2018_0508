package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los videos de youtube con ArrayList
 * Usamos el patró singleton
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 * @author Curso
 *
 */

public class VideoYoutubeArrayDAO implements CrudAble {
	
	private static VideoYoutubeArrayDAO INSTANCE=null;
	private static List<VideoYoutube> Lista=null;
	
	private VideoYoutubeArrayDAO(){
		
		Lista= new ArrayList<VideoYoutube>();
			
	}
	
	public static synchronized VideoYoutubeArrayDAO getInstance() {
		
		if(INSTANCE==null) {
			
			INSTANCE= new VideoYoutubeArrayDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(VideoYoutube video) {
		// TODO Auto-generated method stub
		
		boolean resul=false;
		
		if(video!=null) {
			
			Lista.add(video); //si es diferente de null me lo metes en la lista
			resul=true;
			
		}
		
		return resul;
	}

	@Override
	public List<VideoYoutube> getAll() {
		// TODO Auto-generated method stub
		return Lista;
	}

	@Override
	public VideoYoutube getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(VideoYoutube video) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
