package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.EditorialDAO;
import com.ipartek.formacion.pojo.Editorial;

public class ServiceEditorial implements IServiceEditorial{
	
	private static ServiceEditorial INSTANCE = null;
	private static EditorialDAO daoEditorial = null;

	private  ServiceEditorial() {
		daoEditorial = EditorialDAO.getInstance();
	}

	public static synchronized ServiceEditorial getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceEditorial();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Editorial e) throws Exception {
		boolean resul=false;
		
		if(daoEditorial.insert(e)) {
			resul=true;
		};
		
			
			
		
		return resul;
	}

	@Override
	public boolean modificar(Editorial e) throws Exception {
		boolean resul = false;
		if(daoEditorial.update(e)) {
			resul = true;
		}
		return resul;
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		boolean resul = false;
		if(daoEditorial.delete(Long.toString(id))) {
			resul = true;
		}
		return resul;
	}

	@Override
	public Editorial buscarPorId(long id) throws Exception {
		Editorial editorial = daoEditorial.getById(Long.toString(id));
		return editorial;
	}

	@Override
	public List<Editorial> listar() throws Exception {
		ArrayList<Editorial> editoriales = null;
		editoriales = (ArrayList<Editorial>) daoEditorial.getAll();
		return editoriales;
	}
	
}
