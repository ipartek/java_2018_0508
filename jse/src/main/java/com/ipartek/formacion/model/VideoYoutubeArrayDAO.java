package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los videos de youtube con ArrayList
 * Usamos el patró singleton
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 * @author Curso
 *
 */

public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube> {
	
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
		
		VideoYoutube resul=null;
		
		for(VideoYoutube videoIteracion : Lista) { //esto es un foreach
			
			if(id==videoIteracion.getId()) {
				resul= videoIteracion;
				break;
			}
			
			
		}
		return resul;
	}

	@Override
	public boolean update(VideoYoutube videoUpdate) {
		
		boolean resul= false;
		VideoYoutube videoIteracion= null;
		int i=0;
		
		if(videoUpdate != null) { //si el video no es null hacemos la busqueda
			//iterator
			Iterator<VideoYoutube> it = Lista.iterator();
			while (it.hasNext()) {
				videoIteracion= it.next();
				if(videoIteracion.getId()== videoUpdate.getId()) {
					Lista.set(i, videoUpdate);
					resul= true;
					break;
		}
			
			}
			i++;
		}
		
		return resul;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		boolean resul=false;
		
		VideoYoutube vIteracion= null;
		
		//buscar video a eliminar
		for (int i = 0; i < Lista.size(); i++) {
			vIteracion= Lista.get(i);
			
			if (id==vIteracion.getId()){
				resul= Lista.remove(vIteracion);
				break;
				
			}
			
		}
		return false;
	}

}
