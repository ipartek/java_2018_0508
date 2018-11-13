package com.ipartek.formacion.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;

public class PrestamoDAO implements Crudable<Prestamo> {

	private static PrestamoDAO INSTANCE = null;

	private PrestamoDAO() {
		super();
	}

	public static synchronized PrestamoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PrestamoDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Prestamo pojo) throws Exception {

		boolean resul = false;

		String sql = "{call `prestamoInsert`(?,?,?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, pojo.getAlumno().getId());
			cs.setLong(2, pojo.getLibro().getId());
			cs.setDate(3, (Date) pojo.getFecha_prestado());

			int affectedRows = cs.executeUpdate();

			if (affectedRows == 1) {

				resul = true;

			}
		}
		return resul;
	}

	@Override
	public List<Prestamo> getAll() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		String sql = "{call `prestamogetAll` ()}";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {

			while (rs.next()) {
				Prestamo p = new Prestamo();

				p.setFecha_prestado((rs.getDate("fecha_prestado")));

				Alumno a = new Alumno();
				a.setId(rs.getLong("id_alumno"));
				a.setNombre(rs.getString("nombre_apellidos"));
				p.setAlumno(a);

				Libro l = new Libro();
				l.setId(rs.getLong("id_libro"));
				l.setTitulo(rs.getString("titulo"));	
				p.setLibro(l);
				

				prestamos.add(p);
			}
		}
		return prestamos;
	}

	public List<Prestamo> getHistorico() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		String sql = "{call `prestamogetAllHistorico` ()}";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {

			while (rs.next()) {
				Prestamo p = new Prestamo();
				p.setFecha_prestado((rs.getDate("fecha_prestado")));
				p.setFecha_fin(rs.getDate("fecha_final"));
				p.setFecha_retorno(rs.getDate("fecha_retorno"));

				Alumno a = new Alumno();
				a.setId(rs.getLong("id_alumno"));
				a.setNombre(rs.getString("nombre_apellidos"));
				p.setAlumno(a);

				Libro l = new Libro();
				l.setId(rs.getLong("id_libro"));
				l.setTitulo(rs.getString("titulo"));
				l.setIsbn(rs.getString("isbn"));
				
				Editorial e =new Editorial();
				e.setId(rs.getLong("id_editorial"));
				e.setNombre(rs.getString("nombre_editorial"));
				
				l.setEditorial(e);	
				p.setLibro(l);

				prestamos.add(p);
			}
		}
		return prestamos;
	}

	public List<Prestamo> getAllPrestados() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		String sql = "{call `prestamoGetALLPrestado` ()}";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {

			while (rs.next()) {
				Prestamo p = new Prestamo();
				p.setFecha_prestado((rs.getDate("fecha_prestado")));
				p.setFecha_fin((rs.getDate("fecha_final")));

				Alumno a = new Alumno();
				a.setId(rs.getLong("id_alumno"));
				a.setNombre(rs.getString("nombre_apellidos"));
				p.setAlumno(a);

				Libro l = new Libro();
				l.setId(rs.getLong("id_libro"));
				l.setTitulo(rs.getString("titulo"));
				l.setIsbn(rs.getString("isbn"));
				
				Editorial e =new Editorial();
				e.setId(rs.getLong("id_editorial"));
				e.setNombre(rs.getString("nombre_editorial"));
				
				l.setEditorial(e);
				p.setLibro(l);

				prestamos.add(p);
			}
		}
		return prestamos;
	}

	public List<Libro> librosDisponibles() throws Exception {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		String sql = "{call `prestamoLibrosDisponibles` ()}";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {

			while (rs.next()) {
				Libro l = new Libro();
				l.setId(rs.getLong("id"));
				l.setTitulo(rs.getString("titulo"));

				libros.add(l);
			}
		}
		return libros;
	}

	public List<Alumno> alumnosDisponibles() throws Exception {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		String sql = "{call `prestamoAlumnoDisponibles` ()}";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {

			while (rs.next()) {

				Alumno a = new Alumno();
				a.setId(rs.getLong("id"));
				a.setNombre(rs.getString("nombre_apellidos"));

				alumnos.add(a);
			}
		}
		return alumnos;
	}

	@Override
	public Prestamo getById(String id) throws Exception {
		return null;
	}

	public Prestamo buscarPorId(long idLibro, long idAlumno, Date fecha_prestado) throws Exception {
		Prestamo prestamo = new Prestamo();
		String sql = "{call `prestamoGetById` (?,?,?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, idLibro);
			cs.setLong(2, idAlumno);
			cs.setDate(3, fecha_prestado);

			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {

					prestamo.setFecha_prestado(rs.getDate("fecha_prestado"));
					prestamo.setFecha_fin(rs.getDate("fecha_final"));
					prestamo.setFecha_retorno(rs.getDate("fecha_retorno"));

					Alumno a = new Alumno();
					a.setId(rs.getLong("id_alumno"));
					a.setNombre(rs.getString("nombre_apellidos"));

					prestamo.setAlumno(a);

					Libro l = new Libro();
					l.setId(rs.getLong("id_libro"));
					l.setTitulo(rs.getString("titulo"));

					prestamo.setLibro(l);

				}
			}

		}
		return prestamo;
	}
	
	public boolean modifyAll(long idAlumno, long idLibro, Date fechaPrestado, long idAlumnoNEW, long idLibroNEW, Date fechaPrestadoNEW, Date fechaFinal, Date fechaRetorno) throws SQLException {
		boolean resul = false;

		String sql = "{call prestamoUpdate(?,?,?,?,?,?,?,?)}";
		
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, idAlumno);
			cs.setLong(2, idLibro);
			cs.setDate(3, fechaPrestado);
			
			cs.setLong(4, idAlumnoNEW);
			cs.setLong(5, idLibroNEW);
			cs.setDate(6, fechaPrestadoNEW);
			
			cs.setDate(7, fechaFinal);
			cs.setDate(8, fechaRetorno);

			int affectedRows = cs.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean update(Prestamo pojo) throws Exception {
		boolean resul = false;

		String sql = "{call prestamoDevolver(?,?,?,?)}";
		
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, pojo.getAlumno().getId());
			cs.setLong(2, pojo.getLibro().getId());
			cs.setDate(3, pojo.getFecha_prestado());
			cs.setDate(4, pojo.getFecha_retorno());

			int affectedRows = cs.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception {
		return false;
	}

}
