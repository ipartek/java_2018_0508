package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.CrudAble;
import com.ipartek.formacion.pojo.Video;

public class VideoArrayListDao implements CrudAble<Video> {
	private static VideoArrayListDao INSTANCE = null;
	private static ArrayList<Video> videos = null;
	private static boolean cargaVideos = false;

	private VideoArrayListDao() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		videos = new ArrayList<Video>();
		try {
			videos.add(new Video("AwsoXKP2HWE", "El momo - sol de marzo"));
			videos.add(new Video("rC1KcJLRFDE", "Shintoma - Somos de lo malo lo peor"));
			videos.add(new Video("wWrXkBz74SU", "Nach - Éxodo"));
		} catch (Exception e) {
			System.out.println("Error en VideoArrayListDao");
		}
	}
	
	public static synchronized VideoArrayListDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoArrayListDao();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) {
		boolean result = false;

		if (pojo != null) {
			videos.add(pojo);
			result = true;
		}

		return result;
	}

	@Override
	public List<Video> getAll() {

		return videos;
	}

	@Override
	public Video getById(String id) {
		Video videoCoincidencia = null;
		if (id != null) {
			for (Video v : videos) {
				if (v.getId().equals(id)) {
					videoCoincidencia = v;
				}
			}
		}
		return videoCoincidencia;
	}

	@Override
	public boolean update(Video pojo) {
		boolean flag = false;

		if (pojo != null) {
			for (int i = 0; i < videos.size(); i++) {
				if (videos.get(i).getId() == pojo.getId()) {
					videos.set(i, pojo);
					flag = true;
				}
			}
		}

		return flag;
	}

	@Override
	public boolean delete(String id) {
		boolean flag = false;
		if (id != null) {
			for (Video v : videos) {
				if (v.getId().equals(id)) {
					videos.remove(v);
					flag = true;
				}
			}
		}
		return flag;
	}

}
