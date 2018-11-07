package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.model.PrestamoDAO;
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;

public class ServicePrestamo implements IServicePrestamo {
	
	PrestamoDAO daoPrestamo;

	private static ServicePrestamo INSTANCE = null;

	private ServicePrestamo() {
		super();
		daoPrestamo = PrestamoDAO.getInstance();
	}

	public static synchronized ServicePrestamo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePrestamo();
		}
		return INSTANCE;
	}

	@Override
	public ArrayList<Prestamo> prestados() throws Exception {
		ArrayList<Prestamo> Prestamos = new ArrayList<Prestamo>();
		Prestamos = (ArrayList<Prestamo>) daoPrestamo.getByPrestados();
		return Prestamos;
	}

	@Override
	public ArrayList<Prestamo> historico() throws Exception {
		ArrayList<Prestamo> Prestamos = new ArrayList<Prestamo>();
		Prestamos = (ArrayList<Prestamo>) daoPrestamo.getByHistorico();
		return Prestamos;
	}

	@Override
	public ArrayList<Alumno> AlumnosDisponibles() throws Exception {
		ArrayList<Alumno> a = new ArrayList<Alumno>();
		a = (ArrayList<Alumno>) daoPrestamo.getByAlmunosLibres();
		return a;
	}

	@Override
	public ArrayList<Libro> LibrosDisponibles() throws Exception {
		ArrayList<Libro> l = new ArrayList<Libro>();
		l = (ArrayList<Libro>) daoPrestamo.getByLibrosLibres();
		return l;
	}
	
	@Override
	public boolean modificar(Prestamo p) throws Exception {
		boolean resul = false;
		resul = daoPrestamo.modificar(p);
		return resul;
	}

	@Override
	public boolean devolver(Prestamo p) throws Exception {
		boolean resul = false;
		resul = daoPrestamo.devolucion(p);
		return resul;
	}

	@Override
	public boolean prestar(Prestamo p) throws Exception {
			boolean resul = false;
			resul = daoPrestamo.insert(p);
			return resul;
	}
	
	@Override
	public Prestamo buscar(long id) throws Exception {
		Prestamo p = null;
		p = daoPrestamo.getById(id);
		return p;
	}
	

}
