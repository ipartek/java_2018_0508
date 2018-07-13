package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
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
		
		VideoYoutube resultado = null;
		
		//foreach
		for (VideoYoutube videoIteracion : lista) {
			if(id == videoIteracion.getId()) {
				resultado = videoIteracion;
				break;
			}
		}
		
		return resultado;
	}

	@Override
	public boolean update(VideoYoutube videoUpdate) {
		
		boolean resultado = false;
		VideoYoutube videoIteracion = null;
		int i = 0;
		if(videoUpdate != null) {
			
			//Iterator -> otra forma de iterar
			Iterator<VideoYoutube> it = lista.iterator();
			
			while(it.hasNext()) {
				videoIteracion = it.next();
				if(videoIteracion.getId() == videoUpdate.getId()) {
					lista.set(i, videoUpdate);
					resultado = true;
					break;
				}
				i++;
			}
		}
		
		
		return resultado;
	}

	@Override
	public boolean delete(long id) {
		
		boolean resultado = false;
		
		VideoYoutube vIteracion = null;
		
		//Buscar video a eliminar por su id.
		for (int i = 0; i < lista.size(); i++) {
			
			vIteracion = lista.get(i); //Video sobre el que iteramos
			
			if (id == vIteracion.getId()) { //Video encontrado.
				resultado = lista.remove(vIteracion);
				break;
			}
		}
		
		return resultado;
	}

}
