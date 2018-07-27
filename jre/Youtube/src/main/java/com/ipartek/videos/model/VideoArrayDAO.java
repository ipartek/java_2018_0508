package com.ipartek.videos.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.videos.pojo.Video;

public class VideoArrayDAO implements CrudAble<Video> {
	private static VideoArrayDAO INSTANCE = null;
	private static List<Video> lista = null;

	private VideoArrayDAO() {
		try {
			lista = new ArrayList<Video>();
			lista.add(new Video("v2AC41dglnM", "AC/DC - Thunderstruck (Official Video)"));
			lista.add(new Video("o1tj2zJ2Wvg", "Guns N' Roses - Welcome To The Jungle"));
			lista.add(new Video("fp47VcTlwWQ", "FALSALARMA - PARA LOS MIOS (CANAL BOA)"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized VideoArrayDAO getInstance() {
		if (INSTANCE == null) {

			INSTANCE = new VideoArrayDAO();

		}

		return INSTANCE;

	}

	@Override
	public boolean insert(Video pojo) {
		boolean result = false;
		if (pojo != null) {
			result = true;
			lista.add(pojo);
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public List<Video> getAll() {

		return lista;
	}

	@Override
	public Video getById(String id) {
		Video result = null;
		if (id != null) {
			for (Video video : lista) {
				if (id.equals(video.getId())) {
					result = video;
				}
			}
		} else {

		}
		return result;
	}

	@Override
	public boolean update(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean result = false;
		return result;
	}

	@Override
	public boolean deleteAll(List<Video> list) {
		// TODO Auto-generated method stub
		return false;
	}

}
