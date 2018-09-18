package com.ipartek.formacion.youtube.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Video;

public class VideoArrayListDAO implements CrudAble<Video>{
	
	private static VideoArrayListDAO INSTANCE = null;
	private static List<Video> videos = null;
	
	private VideoArrayListDAO() {
		videos = new ArrayList<Video>();
		
		try {
			videos.add(new Video("Rbm6GXllBiw" ,"Guns N' Roses - Paradise City"));
			videos.add(new Video("LnegxdAKNvk", "The Locos - Resistire"));
			videos.add(new Video("iywaBOMvYLI", "System Of A Down - Toxicity"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized VideoArrayListDAO getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new VideoArrayListDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(Video video) {
		
		boolean resultado = false;
		
		if(video != null) {
			resultado = videos.add(video);
		}
		return resultado;
		
	}

	@Override
	public List<Video> getAll() {

		return videos;
	}

	@Override
	public Video getById(String id) {
		Video resultado = null;
		
		if(id != null && !"".equals(id)) {
			for(Video video : videos) {
				if(id.equals(video.getId())) {
					resultado = video;
					break;
				}
			}
		}
		
		return resultado;
	}

	@Override
	public boolean update(Video video) {

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
