package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.model.EditorialDAO;
import com.ipartek.formacion.pojo.Editorial;

public class ServiceEditorial implements IServiceEditorial {

	EditorialDAO daoEditorial;

	private static ServiceEditorial INSTANCE = null;

	private ServiceEditorial() {
		super();
		daoEditorial = EditorialDAO.getInstance();
	}

	public static synchronized ServiceEditorial getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceEditorial();
		}
		return INSTANCE;
	}
	
	
	@Override
	public ArrayList<Editorial> listar() throws Exception {
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		editoriales = (ArrayList<Editorial>) daoEditorial.getAll();
		return editoriales;
	}

	@Override
	public boolean crear(Editorial editorial) throws Exception {
		boolean resul = false;
		resul = daoEditorial.insert(editorial);
		return resul;
	}

	@Override
	public boolean modificar(Editorial editorial) throws Exception {
		boolean resul = false;
		resul = daoEditorial.update(editorial);
		return resul;
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		boolean resul = false;
		resul = daoEditorial.delete(id);
		return resul;
	}

	@Override
	public Editorial buscar(long id) throws Exception {
		Editorial e = null;
		e = daoEditorial.getById(id);
		return e;
	}

}
