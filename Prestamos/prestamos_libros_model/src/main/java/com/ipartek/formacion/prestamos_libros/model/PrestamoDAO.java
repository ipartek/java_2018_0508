package com.ipartek.formacion.prestamos_libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.pojo.Usuario;

public class PrestamoDAO implements CrudAble<Prestamo> {

	private static PrestamoDAO INSTANCE = null;

	public PrestamoDAO() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized PrestamoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PrestamoDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Prestamo pojo) throws Exception {
		String sql = "CALL `prestamosInsert` (?,?,?) ";
		boolean result = false;

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, pojo.getLibro().getId());
			cs.setLong(2, pojo.getUsuario().getId());
			cs.setDate(3, pojo.getFech_inicio());

			result = cs.execute();
		}

		return result;
	}

	@Override
	public List<Prestamo> getAll() throws Exception {

		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		String sql = "{ CALL `prestamosGetAll` () }";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// preparar parametros
			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					Prestamo p = new Prestamo();
					p.setFech_inicio(rs.getDate("fecha_inicio"));
					p.setFech_fin(rs.getDate("fecha_fin"));
					Libro l = new Libro();
					l.setId(rs.getLong("id_libro"));
					l.setTitulo(rs.getString("titulo"));
					p.setLibro(l);
					Usuario u = new Usuario();
					u.setId(rs.getLong("id_usuario"));
					u.setNombreApellido(rs.getString("nombre_apellidos"));
					p.setUsuario(u);

					long diffInMillies = Math.abs(p.getFech_fin().getTime() - Calendar.getInstance().getTimeInMillis());
					long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

					p.setDiasRestantes(diff);

					prestamos.add(p);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return prestamos;
	}

	public List<Prestamo> getAllDevueltos() throws Exception {

		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		String sql = "{ CALL `prestamosDevueltosGetAll` () }";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// preparar parametros
			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					Prestamo p = new Prestamo();
					p.setFech_inicio(rs.getDate("fecha_inicio"));
					p.setFecha_devuelto(rs.getDate("fecha_devuelto"));
					Libro l = new Libro();
					l.setId(rs.getLong("id_libro"));
					l.setTitulo(rs.getString("titulo"));
					p.setLibro(l);
					Usuario u = new Usuario();
					u.setId(rs.getLong("id_usuario"));
					u.setNombreApellido(rs.getString("nombre_apellidos"));
					p.setUsuario(u);

					prestamos.add(p);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return prestamos;
	}

	@Override
	public Prestamo getById(String id) throws Exception {
		return null;
	}

	public Prestamo getByIds(long idLibro, long idUsuario, Date fInicio) throws Exception {
		Prestamo p = new Prestamo();
		String sql = "{ CALL `prestamosGetByIds` (?,?,?) }";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			//preparar parametros
			cs.setLong(1, idLibro);
			cs.setLong(2, idUsuario);
			cs.setDate(3, fInicio);
			try ( ResultSet rs = cs.executeQuery()){
				if(rs.next()) {
					p.setFech_inicio(rs.getDate("fecha_inicio"));
					p.setFech_fin(rs.getDate("fecha_fin"));
					Libro l = new Libro();
					l.setId(rs.getLong("id_libro"));
					l.setTitulo(rs.getString("titulo"));
					p.setLibro(l);
					Usuario u = new Usuario();
					u.setId(rs.getLong("id_usuario"));
					u.setNombreApellido(rs.getString("nombre_apellidos"));
					p.setUsuario(u);
				}
			}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		return p;
	}

	@Override
	public boolean update(Prestamo pojo) throws Exception {
		String sql = "{ CALL `prestamosDevueltosUpdate` (?,?,?,?) }";
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// parseInt para convertir de Long a INT

			cs.setLong(1, pojo.getLibro().getId());
			cs.setLong(2, pojo.getUsuario().getId());
			cs.setDate(3, pojo.getFech_inicio());
			cs.setDate(4, pojo.getFecha_devuelto());
			result = cs.execute();
		}
		return result;
	}
	
	public boolean updatePrestamo(Prestamo pojo, Prestamo prestamoAntiguo) throws Exception {
		String sql = "{ CALL `prestamosUpdate` (?,?,?,?,?,?,?) }";
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// parseInt para convertir de Long a INT

			cs.setLong(1, pojo.getLibro().getId());
			cs.setLong(2, pojo.getUsuario().getId());
			cs.setDate(3, pojo.getFech_inicio());
			cs.setDate(4, pojo.getFech_fin());
			cs.setLong(5, prestamoAntiguo.getLibro().getId());
			cs.setLong(6, prestamoAntiguo.getUsuario().getId());
			cs.setDate(7, prestamoAntiguo.getFech_inicio());
			result = cs.execute();
		}
		return result;
	}
	
	public Prestamo historicoGetByIds(long idLibro, long idUsuario, Date fInicio) throws Exception {
		Prestamo p = new Prestamo();
		String sql = "{ CALL `prestamosDevueltosGetByIds` (?,?,?) }";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			//preparar parametros
			cs.setLong(1, idLibro);
			cs.setLong(2, idUsuario);
			cs.setDate(3, fInicio);
			try ( ResultSet rs = cs.executeQuery()){
				if(rs.next()) {
					p.setFech_inicio(rs.getDate("fecha_inicio"));
					p.setFecha_devuelto(rs.getDate("fecha_devuelto"));
					Libro l = new Libro();
					l.setId(rs.getLong("id_libro"));
					l.setTitulo(rs.getString("titulo"));
					p.setLibro(l);
					Usuario u = new Usuario();
					u.setId(rs.getLong("id_usuario"));
					u.setNombreApellido(rs.getString("nombre_apellidos"));
					p.setUsuario(u);
				}
			}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		return p;
	}
	
	public boolean updateHistorico(Prestamo pojo, Prestamo prestamoAntiguo) throws Exception {
		String sql = "{ CALL `historicoUpdate` (?,?,?,?,?,?,?) }";
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// parseInt para convertir de Long a INT

			cs.setLong(1, pojo.getLibro().getId());
			cs.setLong(2, pojo.getUsuario().getId());
			cs.setDate(3, pojo.getFech_inicio());
			cs.setDate(4, pojo.getFecha_devuelto());
			cs.setLong(5, prestamoAntiguo.getLibro().getId());
			cs.setLong(6, prestamoAntiguo.getUsuario().getId());
			cs.setDate(7, prestamoAntiguo.getFech_inicio());
			result = cs.execute();
		}
		return result;
	}

	@Override
	public boolean delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Usuario> getUsuariosDisponibles() {
		ArrayList<Usuario> usuariosDisponibles = new ArrayList<Usuario>();
		String sql = "{ CALL `prestamosUsuariosDisponibles` () }";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// preparar parametros
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					Usuario u = new Usuario();
					u.setId(rs.getLong("id"));
					u.setNombreApellido(rs.getString("nombre_apellidos"));

					usuariosDisponibles.add(u);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return usuariosDisponibles;
	}

	public List<Libro> getLibrosDisponibles() {
		ArrayList<Libro> librosDisponibles = new ArrayList<Libro>();
		String sql = "{ CALL `prestamosLibrosDisponibles` () }";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// preparar parametros
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					Libro l = new Libro();
					l.setId(rs.getLong("id"));
					l.setTitulo(rs.getString("titulo"));

					librosDisponibles.add(l);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return librosDisponibles;
	}
}
