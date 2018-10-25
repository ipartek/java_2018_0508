package com.ipartek.formacion.libros.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.libros.model.PrestamoDAO;
import com.ipartek.formacion.libros.pojo.Prestamo;

public class PrestamoService implements ICRUDService<Prestamo> {
	
	private static PrestamoService INSTANCE = null;

	private static PrestamoDAO prestamosDAO;

	private PrestamoService() {
		super();
		prestamosDAO = PrestamoDAO.getInstance();
	}

	public static synchronized PrestamoService getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new PrestamoService();
		}

		return INSTANCE;
	}

	@Override
	public List<Prestamo> listar() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		prestamos = (ArrayList<Prestamo>) prestamosDAO.getAll();
		
		return prestamos;
	}

	@Override
	public Prestamo obtener(long id) throws Exception {
		
		Prestamo p = new Prestamo();
		p = prestamosDAO.getById(id);

		return p;
	}

	@Override
	public boolean crear(Prestamo pojo) throws Exception {
		boolean resul = false;
		resul = prestamosDAO.insert(pojo);
		if (resul) {
			resul = true;
		}
		return resul;
	}

	@Override
	public boolean modificar(Prestamo pojo) throws Exception {
		boolean resul = false;
		resul = prestamosDAO.update(pojo);
		if (resul) {
			resul = true;
		}
		return resul;
	}

	@Override
	public boolean eliminar(String id) throws Exception {

		boolean resul = false;

		resul = prestamosDAO.delete(id);
		if (resul) {
			resul = true;
		}

		return resul;
	}



	public void devolverPorParamentros(Prestamo p) {
		
		
	}



}
