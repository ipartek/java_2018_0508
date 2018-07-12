package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase DAO para gestionar los videos de youtube con ArrayList<> Usamos patron
 * Singleton
 * 
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Curso
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
		if (video != null) {
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

		VideoYoutube video = null;
		if (id != -1) {
			int contador = 0;
			int tamano = this.getAll().size();
			boolean encontrado = false;

			while (contador < tamano || encontrado == false) {

				video = this.getAll().get(contador);

				if (video.getId() == id) {
					encontrado = true;
				}

				contador++;
			}
		}

		return video;
	}

	@Override
	public boolean update(VideoYoutube video) {

		boolean resul = false;
		if (video != null) {
			resul = lista.add(video);
		}

		return resul;
		
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
