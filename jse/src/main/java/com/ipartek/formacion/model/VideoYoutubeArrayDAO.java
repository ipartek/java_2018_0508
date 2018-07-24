package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los VideoYoutube con arraylist
 * Usamos patron Singleton
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 * @author Curso
 *
 */
public class VideoYoutubeArrayDAO implements CrudAble<VideoYoutube>{
	
	private static VideoYoutubeArrayDAO INSTANCE = null;
	private static List<VideoYoutube> lista = null;
	
	private VideoYoutubeArrayDAO() {
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
		VideoYoutube resul = null;
		
		//Buscar video a modificar
		for (VideoYoutube videoIteracion : lista) {
			if(id == videoIteracion.getId()) { //Video encontrado
				resul = videoIteracion;
			}
		}
		return resul;
	}

	@Override
	public boolean update(VideoYoutube video) {
		boolean resul = false;
		VideoYoutube videoIteracion = null;
		int i = 0;
		
		if(video != null) {		
			//Iterator
			Iterator <VideoYoutube> it = lista.iterator();
			while (it.hasNext()) {
				videoIteracion = it.next();
				if(videoIteracion.getId() == video.getId()) {
					lista.set(i, video);
					resul = true;
					break;
				}
				i++;
			}
		}
		
		return resul;
	}
		

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		VideoYoutube vIteracion = null;
		
		//Buscar video a eliminar
		for (int i = 0; i < lista.size(); i++) {
			
			vIteracion = lista.get(i); //Video sobre el que iteramos
			
			if(id == vIteracion.getId()) { //Video encontrado
				resul = lista.remove(vIteracion);
				break;
			}
		}
		return resul;
	}

}
