package com.ipartek.formacion.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Video;
import com.mysql.jdbc.PreparedStatement;

public class VideoDao implements CrudAble<Video> {
	
	private static VideoDao INSTANCE = null;
	private static List<Video> videos = null;

	private VideoDao() {
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

	public static synchronized VideoDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDao();
		}

		return INSTANCE;
	}
	
	@Override
	public boolean insert(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Video> getAll() {
		ArrayList<Video> videos= new ArrayList<Video>();
		try {
			Connection con = ConnectionManager.getConnection();
			//obtener conexion bd
			//Ejecutar sql
			String sql = "select id,codigo,nombre from video order by id desc;";
			java.sql.PreparedStatement ps = con.prepareStatement(sql);
			
			//obtener resultado
			ResultSet rs =  ps.executeQuery();
			//mapear resulSet al arrayList creando un objeto por cada registro del resulset
			Video v = null;
			while(rs.next()) {
				v = new Video();
				v.setId(rs.getString("codigo"));
				v.setNombreCancion(rs.getString("nombre"));
				videos.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return videos;
	}

	@Override
	public Video getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


}
