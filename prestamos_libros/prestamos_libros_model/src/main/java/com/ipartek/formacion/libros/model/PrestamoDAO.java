package com.ipartek.formacion.libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Editorial;
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
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL prestamoGetAll}");) {

			
			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					
					prestamos.add(rowMapper(rs));
				}
			}
		} 

		return prestamos;
	}
	
	public List<Prestamo> getAllActivos() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL prestamoGetAllActivo}");) {

			
			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					prestamos.add(rowMapper(rs));
				}
			}
		} 

		return prestamos;
	}
	
	public List<Prestamo> getAllHistorico() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL prestamoGetAllHistorico}");) {

			
			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					prestamos.add(rowMapper(rs));
				}
			}
		} 
		return prestamos;
	}

	public Prestamo getById(long alumno, long libro, Date fecha) throws Exception {

		Prestamo p = null;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL prestamoGetById(?, ?, ?)}");) {

			// Se cargan los parametros de entrada
			sp.setLong("p_alumno", alumno);
			sp.setLong("p_libro", libro);			
			sp.setDate("p_fecha", fecha);

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

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL prestamoInsert(?, ?, ?)}");) {

			// Se cargan los parametros de entrada
			sp.setLong("p_alumno", pojo.getAlumno().getId());
			sp.setLong("p_libro", pojo.getLibro().getId());			
			sp.setDate("p_fecha", pojo.getFechaInicio());

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();

			if (resultado == 1) {

				resul = true;

			}
		}
		return resul;
	}

	public boolean update(long idAlumno, long idlibro, Date fechaInicio, long nuevoAlumno, long nuevoLibro, Date nuevaFecha, Date fechaFin, Date fechaRetorno) throws Exception {
		
		boolean resul;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL prestamoUpdate(?, ?, ?, ?, ?, ?, ?, ?)}");) {

			// se cargan los parametros de entrada
			sp.setLong("p_alumno", idAlumno);
			sp.setLong("p_libro", idlibro);
			sp.setDate("p_inicio", fechaInicio);
			
			sp.setLong("p_nuevoAlumno", nuevoAlumno);
			sp.setLong("p_nuevoLibro", nuevoLibro);
			sp.setDate("p_nuevaFecha", nuevaFecha);
			sp.setDate("p_fin", fechaFin);
			sp.setDate("p_retorno", fechaRetorno);

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

	
	public boolean delete(Prestamo pojo) throws Exception {
		boolean resul;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL prestamoDevolver(?, ?, ?, ?)}");) {

			// se cargan los parametros de entrada
			sp.setLong("p_id_alumno", pojo.getAlumno().getId());
			sp.setLong("p_id_libro", pojo.getLibro().getId());
			sp.setDate("p_fecha_inicio", pojo.getFechaInicio());
			sp.setDate("p_fecha_retorno", pojo.getFechaRetorno());

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
		
		//p.setId(rs.getInt("idprestamo"));
		p.setFechaInicio(rs.getDate("fecha_inicio"));
		p.setFechaFin(rs.getDate("fecha_fin"));
		p.setFechaRetorno(rs.getDate("fecha_retorno"));
		
		Alumno a = new Alumno();
		a.setId(rs.getInt("id_alumno"));
		a.setNombre(rs.getString("nombre"));
		
		Libro l = new Libro();
		l.setId(rs.getInt("id_libro"));
		l.setTitulo(rs.getString("titulo"));
		l.setIsbn(rs.getString("isbn"));
		
		Editorial e = new Editorial();
		e.setId(rs.getInt("ideditorial"));
		e.setNombre(rs.getString("nombre_editorial"));
		
		l.setEditorial(e);
		
		p.setAlumno(a);
		p.setLibro(l);
		

		return p;
	}

	@Override
	public boolean delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Prestamo pojo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Prestamo getById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
