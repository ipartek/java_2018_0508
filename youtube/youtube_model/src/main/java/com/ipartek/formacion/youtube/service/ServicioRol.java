package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.pojo.Rol;

public class ServicioRol implements IService<Rol> {

	private static ServicioRol INSTANCE = null;

	private RolDAO daoRol;

	private ServicioRol() {
		super();
		daoRol = RolDAO.getInstance();
	}

	public static synchronized ServicioRol getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioRol();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Rol pojo) throws Exception {
		return daoRol.insert(pojo);
	}

	@Override
	public boolean modificar(Rol pojo) throws Exception {
		return daoRol.update(pojo);
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		return daoRol.delete(id);
	}

	@Override
	public Rol buscar(long id) throws Exception {
		return daoRol.getById(id);
	}

	@Override
	public List<Rol> listar() throws Exception {
		return daoRol.getAll();
	}

}
