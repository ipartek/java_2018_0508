package com.ipartek.formacion.prestamos_libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;

public class LibroDAO implements CrudAble<Libro>{
	private static LibroDAO INSTANCE = null;
	
	public LibroDAO() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized LibroDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Libro pojo) throws Exception {
		String sql = "CALL `librosInsert` (?,?,?) ";
		boolean result = false;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			cs.setString(1, pojo.getTitulo());
			cs.setString(2, pojo.getIsbn());
			cs.setLong(3, pojo.getEditorial().getId());
			result = cs.execute();
		}
		
		return result;
	}

	@Override
	public List<Libro> getAll() throws Exception {

		ArrayList<Libro> libros = new ArrayList<Libro>();
		String sql = "{ CALL `librosGetAll` () }";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			//preparar parametros
			try ( ResultSet rs = cs.executeQuery()){
				
				while (rs.next()) {
					Libro l = new Libro();
					l.setId(rs.getLong("id"));
					l.setTitulo(rs.getString("titulo"));
					l.setIsbn(rs.getString("isbn"));
					Editorial e = new Editorial();
					e.setId(rs.getLong("id_editorial"));
					e.setNombre(rs.getString("nombre"));
					l.setEditorial(e);
					
					libros.add(l);
					
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return libros;
	}

	@Override
	public Libro getById(String id) throws Exception {
		String sql = "{ CALL `librosGetById` (?) }";
		Libro l = new Libro();
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			cs.setInt(1, Integer.parseInt(id));
			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					l.setId(rs.getLong("id_libro"));
					l.setTitulo(rs.getString("titulo"));
					l.setIsbn(rs.getString("isbn"));
					Editorial e = new Editorial();
					e.setId(rs.getLong("id_editorial"));
					e.setNombre(rs.getString("nombre"));
					l.setEditorial(e);
				}
			}

		}
		
		return l;
	}

	@Override
	public boolean update(Libro pojo) throws Exception {
		String sql = "{ CALL `librosUpdate` (?,?,?,?) }";
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			//parseInt para convertir de Long a INT
			cs.setInt(1, new Long(pojo.getId()).intValue());
			cs.setString(2, pojo.getTitulo());
			cs.setString(3, pojo.getIsbn());
			cs.setLong(4, pojo.getEditorial().getId());
			
			int affectedRows = cs.executeUpdate();
			if ( affectedRows == 1 ) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean delete(String id) throws Exception {
		String sql = "{ CALL `librosDelete` (?) }";
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			//parseInt para convertir de String a INT
			cs.setInt(1, Integer.parseInt(id));
			result = cs.execute();
		}
		return result;
	}

}
