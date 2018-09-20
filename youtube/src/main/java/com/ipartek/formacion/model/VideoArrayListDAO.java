package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Video;

public class VideoArrayListDAO implements CrudAble<Video> {

	private static VideoArrayListDAO INSTANCE = null;
	private static List<Video> videos = null;

	private VideoArrayListDAO() {
		videos = new ArrayList<Video>();
		try {
			videos.add(new Video("UKRLY9EptCY","Violin piano, Dubstep, Extended Edition, 20 Minutes,"));
			videos.add(new Video("OQcS-dZy1mg", "De tranquis"));
			videos.add(new Video("ninviq_cRbk", "Louder (Karate Kid)"));
			videos.add(new Video("YSAMOBVncSg", "Im a wanted man"));
			videos.add(new Video("OJxCcCEobNs","EPIC ROCK | ''Dead Man Walking'' by WAR*HALL"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized VideoArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) {
		return videos.add(pojo);
	}

	@Override
	public List<Video> getAll() {
		return videos;
	}

	@Override
	public Video getById(String id) {
		Video resul = null;
		if (id != null) {
			for (Video v : videos) {
				if (id.equals(v.getId())) {
					resul = v;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Video v = null;
		if ( id != null ) { 
			for (int i = 0; i < videos.size(); i++) {
				v = videos.get(i); 
				if (id.equals(v.getId()) ) { 
					resul = videos.remove(v);
					break;
				}
			}
		}	
		return resul;
	}

}