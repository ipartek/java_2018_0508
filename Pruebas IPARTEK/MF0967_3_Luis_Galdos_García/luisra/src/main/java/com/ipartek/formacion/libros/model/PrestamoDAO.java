package com.ipartek.formacion.libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;

public class PrestamoDAO implements CrudAble<Prestamo> {

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

	/* GETTERS */
	@Override
	public List<Prestamo> getAll() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try (Connection con = ConnectionManager.getConnection();) {

			CallableStatement sp = con.prepareCall("{CALL prestamoGetAll}");
			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					prestamos.add(rowMapper(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prestamos;
	}

	@Override
	public Prestamo getById(long id) throws Exception {
		Prestamo p = null;
		try (Connection con = ConnectionManager.getConnection();) {

			CallableStatement sp = con.prepareCall("{CALL prestamoGetById(?)}");

			// se cargan los parametros de entrada
			sp.setLong("p_id", id);// Tipo String

			// Se ejecuta el procedimiento almacenado

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					p = rowMapper(rs);

				}
			}
		}
		return p;
	}

	/* SETTERS */

	@Override
	public boolean insert(Prestamo pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection()) {

			CallableStatement sp = con.prepareCall("{CALL prestamoInsert(?, ?)}");

			// se cargan los parametros de entrada
			sp.setLong("id_libro", pojo.getLibro().getId());
			sp.setLong("id_alumno", pojo.getLibro().getId());

			// parametros de salida
			sp.registerOutParameter("o_id", Types.INTEGER);

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();

			//int id = sp.getInt("o_id");

			if (resultado == 1) {

				resul = true;

			}
		}
		return resul;
	}

	@Override
	public boolean update(Prestamo pojo) throws Exception {
		
		boolean resul;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL prestamoUpdate(?)}");) {

			// se cargan los parametros de entrada
			sp.setLong("p_alumno", pojo.getAlumno().getId());
			sp.setLong("p_libro", pojo.getLibro().getId());

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();
			if (resultado == 1) {

				resul = true;

			} else {

				resul = false;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception {
		boolean resul;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL libroDelete(?)}");) {

			// se cargan los parametros de entrada

			sp.setString("p_id", id);

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();
			
			if (resultado == 1) {
				
				resul = true;

			} else {
				
				resul = false;
			}
		}
		return resul;

	}

	private Prestamo rowMapper(ResultSet rs) throws SQLException {
		Prestamo p = new Prestamo();
		
		p.setFechaInicio(rs.getDate("fecha_inicio"));
		p.setFechaFin(rs.getDate("fecha_fin"));
		
		Alumno a = new Alumno();
		a.setId(rs.getInt("id_alumno"));
		
		Libro l = new Libro();
		l.setId(rs.getInt("id_libro"));
		
		p.setAlumno(a);
		p.setLibro(l);

		return p;
	}
}
