package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Comentarios;
import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.pojo.Video;

public class ComentariosDao implements CrudAble<Comentarios> {

	private static ComentariosDao INSTANCE = null;
	private static List<Comentarios> comentarios = null;

	private ComentariosDao() {
		comentarios = new ArrayList<Comentarios>();
		
	}

	public static synchronized ComentariosDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentariosDao();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Comentarios pojo) {
		return comentarios.add(pojo);
	}

	@Override
	public List<Comentarios> getAll() {
		return comentarios;
	}

	@Override
	public Comentarios getById(String id) {
		Comentarios resul = null;
		if (id != null) {
			for (Comentarios c : comentarios) {
				if (id.equals(c.getVideoId())) {
					resul = c;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Comentarios pojo) {
		Comentarios comentarioActualizar = null;
		boolean flag = false;
		if(pojo != null) {
			for(Comentarios c : comentarios) {
				if(pojo.getVideoId() == c.getVideoId()) {
					c = pojo;
					flag = true;
				}
			}
			
		}
		return flag;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Comentarios c = null;
		if ( id != null ) { 
			for (int i = 0; i < comentarios.size(); i++) {
				c = comentarios.get(i); 
				if (id.equals(c.getVideoId()) ) { 
					resul = comentarios.remove(c);
					break;
				}
			}
		}	
		return resul;
	}



}