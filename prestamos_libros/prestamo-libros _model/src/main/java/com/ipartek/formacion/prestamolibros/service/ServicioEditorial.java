package com.ipartek.formacion.prestamolibros.service;

import java.util.List;

import com.ipartek.formacion.prestamolibros.model.EditorialDAO;
import com.ipartek.formacion.prestamolibros.pojo.Editorial;

public class ServicioEditorial implements IService<Editorial> {

	private static ServicioEditorial INSTANCE = null;
	
	private EditorialDAO daoEditorial;
	
	private ServicioEditorial() {
		super();
		daoEditorial = EditorialDAO.getInstance();
	}

	public static synchronized ServicioEditorial getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioEditorial();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Editorial e) throws Exception {
		
		return daoEditorial.insert(e);
	}

	@Override
	public boolean modificar(Editorial e) throws Exception {
		
		return daoEditorial.update(e);
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		
		return daoEditorial.delete(id);
	}

	@Override
	public Editorial buscar(long idEditorial) throws Exception {
		
		return daoEditorial.getById(idEditorial);
	}

	@Override
	public List<Editorial> listar() throws Exception {
		
		return daoEditorial.getAll();
	}

}
