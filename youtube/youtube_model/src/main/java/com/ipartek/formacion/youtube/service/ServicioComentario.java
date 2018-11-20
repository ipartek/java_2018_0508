package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.pojo.Comentario;

public class ServicioComentario implements IService<Comentario> {

	private static ServicioComentario INSTANCE = null;

	private ComentarioDAO daoComentario;

	private ServicioComentario() {
		super();
		daoComentario = ComentarioDAO.getInstance();
	}

	public static synchronized ServicioComentario getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioComentario();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Comentario pojo) throws Exception {
		return daoComentario.insert(pojo);
	}

	@Override
	public boolean modificar(Comentario pojo) throws Exception {
		return daoComentario.update(pojo);
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		return daoComentario.delete(id);
	}

	@Override
	public Comentario buscar(long id) throws Exception {
		return daoComentario.getById(id);
	}

	@Override
	public List<Comentario> listar() throws Exception {
		return daoComentario.getAll();
	}

}
