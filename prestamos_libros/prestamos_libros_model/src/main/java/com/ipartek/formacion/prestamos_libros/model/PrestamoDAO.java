package com.ipartek.formacion.prestamos_libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Alumno;
import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;

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

		String sql = "{call `prestamoInsert`(?,?,?,?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, pojo.getAlumno().getId());
			cs.setLong(2, pojo.getLibro().getId());
			cs.setDate(3, (Date) pojo.getFecha_prestado());
			cs.registerOutParameter(4, Types.DATE);

			int affectedRows = cs.executeUpdate();

			if (affectedRows == 1) {
				Date date = cs.getDate(4);
				pojo.setFecha_fin(date);
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

	/**
	 * Retorna una lista de todos los prestamos ya finalizados
	 * @return List<Prestamo> de prestamos finalizados
	 * @throws Exception
	 */
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
				l.setIsbn(rs.getString("isbn"));
				l.setTitulo(rs.getString("titulo"));
				
				Editorial e = new Editorial();
				e.setId(rs.getLong("id_editorial"));
				e.setNombre(rs.getString("nombre_editorial"));
				l.setEditorial(e);
				
				p.setLibro(l);
				
				prestamos.add(p);
			}
		}
		return prestamos;
	}

	/**
	 * Retorna una lista de todos los prestamos actualmente activos
	 * @return List<Prestamo> de activos
	 * @throws Exception
	 */
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
				l.setIsbn(rs.getString("isbn"));
				l.setTitulo(rs.getString("titulo"));
				
				Editorial e = new Editorial();
				e.setId(rs.getLong("id_editorial"));
				e.setNombre(rs.getString("nombre_editorial"));
				l.setEditorial(e);
				
				p.setLibro(l);

				prestamos.add(p);
			}
		}
		return prestamos;
	}

	/**
	 * Retorna una lista de los libros que no estan actualmente prestados
	 * @return List<Prestamo> disponibles
	 * @throws Exception
	 */
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

	/**
	 * Retorna una lista de los alumnos que no tienen prestamos activos
	 * @return List<Alumno> sin prestamos activos
	 * @throws Exception
	 */
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

	/**
	 * Busca un prestamo por su clave primaria
	 * @param idLibro Identificador del libro
	 * @param idAlumno Identificador del alumno
	 * @param fecha_prestado Fecha inicial del prestamo
	 * @return pojo Prestamo. Si lo ha encontrado tendra valores, sino sera un objeto Prestamo vacio
	 * @throws Exception
	 */
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
	
	/**
	 * Modifica cualquier valor de un prestamo
	 * @param idAlumno Identificador del alumno
	 * @param idLibro Identificador del libro
	 * @param fechaPrestado Fecha inicial original
	 * @param idAlumnoNEW Nuevo identificador del alumno
	 * @param idLibroNEW Nuevo identificador del libro
	 * @param fechaPrestadoNEW Nueva fecha de inicio de prestamo
	 * @param fechaFinal Nueva fecha final de prestamo
	 * @param fechaRetorno Fecha de retorno del libro
	 * @return true si se ha podido modificar, false si ha ocurrido algun error
	 * @throws SQLException
	 */
	public boolean updateAll(long idAlumno, long idLibro, Date fechaPrestado, long idAlumnoNEW, long idLibroNEW, Date fechaPrestadoNEW, Date fechaFinal, Date fechaRetorno) throws SQLException {
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
	
	/**
	 * Devuelve un libro e introduce la fecha de retorno en la bbdd
	 * @param Prestamo pojo
	 * @return true si se ha podido devolver, false si algo ha fallado
	 * @throws SQLException
	 */
	public boolean devolver(Prestamo pojo) throws SQLException {
		boolean resul = false;

		String sql = "{call prestamoDevolver(?,?,?,?,?)}";
		
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, pojo.getAlumno().getId());
			cs.setLong(2, pojo.getLibro().getId());
			cs.setDate(3, pojo.getFecha_prestado());
			cs.setDate(4, pojo.getFecha_retorno());
			cs.registerOutParameter(5, Types.DATE);

			int affectedRows = cs.executeUpdate();

			if (affectedRows == 1) {
				Date date = cs.getDate(5);
				pojo.setFecha_fin(date);
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean update(Prestamo pojo) throws Exception {
		return false;
	}

	@Override
	public boolean delete(String id) throws Exception {
		return false;
	}

}
