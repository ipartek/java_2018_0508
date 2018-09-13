package com.ipartek.formacion.youtube.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.VideoYoutubePOJO;

public class VideoYoutubeArrayListDAO implements CrudAble<VideoYoutubePOJO> {

	private static VideoYoutubeArrayListDAO INSTANCE = null;
	private static ArrayList<VideoYoutubePOJO> lista;

	private VideoYoutubeArrayListDAO() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		
		lista = new ArrayList<VideoYoutubePOJO>();
		
		cargarVideosDePrueba();
		
	}
	
	private static void cargarVideosDePrueba() {
		
		VideoYoutubePOJO video = new VideoYoutubePOJO("7QU1nvuxaMA", "Audioslave - Like a Stone (Official Video)");
		lista.add(video);
		video = new VideoYoutubePOJO("WC5FdFlUcl0", "Audioslave - Be Yourself");
		lista.add(video);
		video = new VideoYoutubePOJO("vVXIK1xCRpY", "Audioslave - Show Me How to Live (Video)");
		lista.add(video);
		video = new VideoYoutubePOJO("dfF4t9-wpCM", "Audioslave - Shadow on the Sun [HQ]");
		lista.add(video);
		video = new VideoYoutubePOJO("hWlkmkZW2hk", "Audioslave - I Am The Highway (Lyrics)");
		lista.add(video);
	}

	public static synchronized VideoYoutubeArrayListDAO getInstance() {
		return (INSTANCE == null ? new VideoYoutubeArrayListDAO() : INSTANCE);
	}

	@Override
	public boolean insert(VideoYoutubePOJO pojo) {
		boolean result = false;

		if (pojo != null) {
			result = lista.add(pojo);
		}

		return result;
	}

	@Override
	public List<VideoYoutubePOJO> getAll() {
		return lista;
	}

	@Override
	public VideoYoutubePOJO getById(String id) {
		VideoYoutubePOJO video = null;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				video = lista.get(i);
				break;
			}
		}
		return video;
	}
	
	public VideoYoutubePOJO getByTitulo(String titulo) {
		VideoYoutubePOJO video = null;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(titulo)) {
				video = lista.get(i);
				break;
			}
		}
		return video;
	}

	@Override
	public boolean update(VideoYoutubePOJO pojo) {
		boolean result = false;

		if (pojo != null) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == pojo.getId()) {
					lista.set(i, pojo);
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	public boolean delete(String id) {
		boolean result = false;

		for (VideoYoutubePOJO vIteracion : lista) {
			if (id == vIteracion.getId()) { // Libro encontrado
				result = lista.remove(vIteracion); // Eliminamos Libro y comprobamos
				break;
			}
		}

		return result;
	}

}
