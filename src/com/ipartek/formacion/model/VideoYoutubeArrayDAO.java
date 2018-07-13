package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los VideoYoutube con ArrayList.
 * Usamos patron Singleton
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author ur00
 * 
 */
public class VideoYoutubeArrayDAO implements CrudAble {

	private static VideoYoutubeArrayDAO INSTANCE = null;
	private static List<VideoYoutube> lista = null;

	private VideoYoutubeArrayDAO() {
		lista = new ArrayList<VideoYoutube>();
	}

	public static synchronized VideoYoutubeArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new VideoYoutubeArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(VideoYoutube video) {
		boolean resul = false;
		if ( video != null ) {
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
		VideoYoutube result = null;
		for (int i = 0; i < lista.size(); i++) {
			if (id==lista.get(i).getId()) {
				result = lista.get(i);
				break;
			}
		}
		//para recorrer como un foreach:
		/*
		for (VideoYoutube videoIteracion : lista) {
			result = videoIteracion;
			break;
		}
		*/
		return result;
	}

	@Override
	public boolean update(VideoYoutube video) {
		if (video == null) {
			return false;
		}
		else {
			VideoYoutube videoModificar = this.getById(video.getId());
			boolean result = false;
			if (videoModificar!=null) {
				//lista.remove(videoModificar);
				videoModificar.setCodigo(video.getCodigo());
				videoModificar.setTitulo(video.getTitulo());
				//lista.add(videoModificar);
				result = true;
			}
			return result;
		}
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		VideoYoutube video = null;
		//buscar video a eliminar
		for (int i = 0; i < lista.size(); i++) {
			video = lista.get(i);
			if (id==video.getId()) {  //video encontrado
				lista.remove(i);
				resul = true;
				break;
			}
		}
		
		return resul;
	}

}
