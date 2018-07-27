package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;


import com.ipartek.formacion.model.CrudAble;
import com.ipartek.formacion.pojo.Video;

public class VideoArrayListDao implements CrudAble<Video> {
	private static VideoArrayListDao INSTANCE = null;
	private static ArrayList<Video> lista;
	
	public static synchronized VideoArrayListDao getInstance() {
		return (INSTANCE == null ? new VideoArrayListDao() : INSTANCE);
	}

	@Override
	public boolean insert(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Video> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video getById(String id) {
		if(id != null) {
			for (Video v: lista) {
				if(id.equals("")) {
					
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
