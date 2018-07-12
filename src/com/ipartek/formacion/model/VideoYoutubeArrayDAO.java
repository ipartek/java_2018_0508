package com.ipartek.formacion.model;
/**
 * Clase DAO para gestionar los VideoYoutube con ArrayList.
 * Usamos patron Singleton
 */
import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VideoYoutube> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoYoutube getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(VideoYoutube video) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
