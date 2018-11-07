package com.ipartek.formacion.prestamolibros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.pojo.Prestamo;

public class PrestamoDAO {
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

	public List<Prestamo> getPrestados() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		Prestamo prestamo = null;
		String sql = "{CALL `prestamoGetPrestados`()}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					prestamo = new Prestamo();

					Libro libro = new Libro();
					libro.setId(rs.getLong("id_libro"));
					libro.setTitulo(rs.getString("titulo"));

					Alumno alumno = new Alumno();
					alumno.setId(rs.getLong("id_alumno"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setApellidos(rs.getString("apellidos"));

					prestamo.setAlumno(alumno);
					prestamo.setLibro(libro);
					prestamo.setFechaInicio(rs.getDate("fecha_inicio"));
					prestamo.setFechaFin(rs.getDate("fecha_final"));
					prestamo.setDiasRestantes();

					prestamos.add(prestamo);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return prestamos;
	}

	public List<Prestamo> getHistorico() throws Exception {

		ArrayList<Prestamo> historico = new ArrayList<Prestamo>();
		Prestamo prestamo = null;
		String sql = "{CALL `prestamoGetHistorico`()}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					prestamo = new Prestamo();

					Libro libro = new Libro();
					libro.setId(rs.getLong("id_libro"));
					libro.setTitulo(rs.getString("titulo"));

					Alumno alumno = new Alumno();
					alumno.setId(rs.getLong("id_alumno"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setApellidos(rs.getString("apellidos"));

					prestamo.setAlumno(alumno);
					prestamo.setLibro(libro);
					prestamo.setFechaInicio(rs.getDate("fecha_inicio"));
					prestamo.setFechaFin(rs.getDate("fecha_final"));
					prestamo.setDevuelto(rs.getDate("fecha_devuelto"));

					historico.add(prestamo);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return historico;
	}

	public List<Alumno> getAlumnosDisponibles() throws Exception {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno alumno = null;
		String sql = "{CALL `prestamoGetAlumnosDisponibles`()}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {

					alumno = new Alumno();
					alumno.setId(rs.getLong("id"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setApellidos(rs.getString("apellidos"));

					alumnos.add(alumno);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return alumnos;
	}

	public List<Libro> getLibrosDisponibles() throws Exception {

		ArrayList<Libro> libros = new ArrayList<Libro>();
		Libro libro = null;
		String sql = "{CALL `prestamoGetLibrosDisponibles`()}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {

					libro = new Libro();
					libro.setId(rs.getLong("id"));
					libro.setTitulo(rs.getString("titulo"));

					Editorial editorial = new Editorial();
					editorial.setId(rs.getLong("id_tipo_editorial"));
					editorial.setEditorial(rs.getString("editorial"));

					libro.setEditorial(editorial);

					libros.add(libro);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return libros;
	}

	public boolean prestar(long idLibro, long idAlumno, Date fechaInicio) throws Exception {
		boolean resul = false;

		String sql = "{CALL `prestamoPrestar`(?,?,?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, idLibro);
			cs.setLong(2, idAlumno);
			cs.setDate(3, fechaInicio);

			cs.execute();
			resul = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;
	}

	public boolean devolver(long idAlumno, long idLibro, Date fechaInicio, Date fechaDevolucion) throws Exception {

		boolean resul = false;
		String sql = "{CALL `prestamoDevolver` (?,?,?,?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, idAlumno);
			cs.setLong(2, idLibro);
			cs.setDate(3, fechaInicio);
			cs.setDate(4, fechaDevolucion);

			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}

		return resul;
	}

	public boolean modificarPrestamo(long idLibro, long idAlumno, Date fechaInicio, Date fechaFin, long oldIdLibro, long oldIdAlumno,
			Date oldFechaInicio) throws Exception {

		boolean resul = false;
		String sql = "{CALL `prestamoUpdate` (?, ?, ?, ?, ?, ?, ?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, idLibro);
			cs.setLong(2, idAlumno);
			cs.setDate(3, fechaInicio);
			cs.setDate(4, fechaFin);
			cs.setLong(5, oldIdLibro);
			cs.setLong(6, oldIdAlumno);
			cs.setDate(7, oldFechaInicio);

			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}

		return resul;

	}

	public boolean modificarHistorico(long idLibro, long idAlumno, Date fechaInicio, Date fechaFin, Date fechaDevolucion, long oldIdLibro, long oldIdAlumno,
			Date oldFechaInicio) throws Exception {

		boolean resul = false;
		String sql = "{CALL `prestamoModificarHistorico` (?, ?, ?, ?, ?, ?, ?, ?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, idLibro);
			cs.setLong(2, idAlumno);
			cs.setDate(3, fechaInicio);
			cs.setDate(4, fechaFin);
			cs.setDate(5, fechaDevolucion);
			cs.setLong(6, oldIdLibro);
			cs.setLong(7, oldIdAlumno);
			cs.setDate(8, oldFechaInicio);

			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}

		return resul;

	}
	
	

}
