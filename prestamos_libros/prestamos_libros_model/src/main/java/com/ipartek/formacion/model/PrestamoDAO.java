package com.ipartek.formacion.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;

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

	
	public ArrayList<Prestamo> getByPrestados() throws Exception {
		ArrayList<Prestamo> p = new ArrayList<Prestamo>();
		String sql = "{CALL prestamoByprestados}";

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {
			while (rs.next()) {
				p.add(rowMapper(rs));
			}

		}
		return p;
	}
	
	public ArrayList<Prestamo> getByHistorico() throws Exception {
		ArrayList<Prestamo> p = new ArrayList<Prestamo>();
		String sql = "{CALL prestamoByhistorico}";

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {
			while (rs.next()) {
				p.add(rowMapper(rs));
			}

		}
		return p;
	}
	
	public List<Libro> getByLibrosLibres() throws Exception {
		ArrayList<Libro> p = new ArrayList<Libro>();
		String sql = "{CALL prestamoByLibrosLibres}";

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {
			while (rs.next()) {
				p.add(rowMapperLibro(rs));
			}

		}
		return p;
	}
	
	
	
	public List<Alumno> getByAlmunosLibres() throws Exception {
		ArrayList<Alumno> a = new ArrayList<Alumno>();
		String sql = "{CALL prestamoByAlumnosLibres}";

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {
			while (rs.next()) {
				a.add(rowMapperAlumno(rs));
			}

		}
		return a;
	}

	@Override
	public Prestamo getById(long id) throws Exception {
		Prestamo resul = null;
		String sql = "{CALL prestamoGetById(?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			
			cs.setLong(1, id);

			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					resul = rowMapper(rs);
				}

			}

		}
		return resul;
	}
	
	public boolean modificar(Prestamo pojo) throws Exception {
		boolean resul = false;
		String sql = "{CALL prestamoModificar(?,?,?,?,?,?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			
			cs.setLong(1, pojo.getAlumno().getId());
			cs.setLong(2, pojo.getLibro().getId());
			cs.setDate(3, pojo.getFecha_inicio());
			cs.setDate(4, pojo.getFecha_fin());
			cs.setDate(5, pojo.getFecha_devuelto());
			cs.setLong(6, pojo.getId());
			
			

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	
	public boolean devolucion(Prestamo pojo) throws Exception {
		boolean resul = false;
		String sql = "{CALL prestamoDevolucion(?,?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			
			cs.setDate(1, pojo.getFecha_devuelto());
			cs.setLong(2, pojo.getId());
			
			

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private Prestamo rowMapper(ResultSet rs) throws Exception {
		Prestamo p = new Prestamo();
		p.setId(rs.getLong("id"));
		if (rs != null) {
			try {
				Alumno a =new Alumno();
				a.setId(rs.getLong("id_alumno"));
				a.setNombre(rs.getString("nombre"));
				a.setApellidos(rs.getString("apellidos"));
				p.setAlumno(a);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				Libro l=new Libro();
				l.setId(rs.getInt("id_libro"));
				l.setIsbn(rs.getString("isbn"));
				l.setTitulo(rs.getString("titulo"));
				
				Editorial e = new Editorial();
				e.setId(rs.getInt("id_editorial"));
				e.setNombre(rs.getString("e_nombre"));
				l.setEditorial(e);

				p.setLibro(l);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			p.setFecha_inicio(rs.getDate("fecha_inicio"));
			p.setFecha_fin(rs.getDate("fecha_fin"));
			p.setFecha_devuelto(rs.getDate("fecha_devuelto"));
			
			
		}
		return p;
	}
	
	private Alumno rowMapperAlumno(ResultSet rs) throws Exception {
		Alumno alumno = new Alumno();
		if (rs != null) {
			alumno.setId(rs.getLong("id"));
			alumno.setNombre(rs.getString("nombre"));
			alumno.setApellidos(rs.getString("apellidos"));
		}
		return alumno;
	}
	
	private Libro rowMapperLibro(ResultSet rs) throws Exception {
		Libro libro = new Libro();
		if (rs != null) {
			libro.setId(rs.getLong("id"));
			libro.setIsbn(rs.getString("isbn"));
			libro.setTitulo(rs.getString("titulo"));
		}
		return libro;
	}

	@Override
	public List<Prestamo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(Prestamo pojo) throws SQLException {
		boolean resul = false;
		String sql = "{CALL prestamoInsert(?,?,?,?,?,?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, pojo.getAlumno().getId());
			cs.setLong(2, pojo.getLibro().getId());
			cs.setDate(3, pojo.getFecha_inicio());
			
			cs.registerOutParameter(4, java.sql.Types.INTEGER);
			cs.registerOutParameter(5, java.sql.Types.DATE);
			cs.registerOutParameter(6, java.sql.Types.DATE);

			int affectedRows = cs.executeUpdate();
			
			pojo.setId(cs.getInt(4));
			pojo.setFecha_fin(cs.getDate(5));
			pojo.setFecha_devuelto(cs.getDate(6));
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Prestamo pojo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
