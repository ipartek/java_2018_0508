package com.ipartek.formacion.prestamos_libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Usuario;

public class UsuarioDAO implements CrudAble<Usuario>{

	private static UsuarioDAO INSTANCE = null;
	
	public UsuarioDAO() {
		
	}
	
	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}
	
	@Override
	public boolean insert(Usuario pojo) throws Exception {
		String sql = "{ CALL `usuariosInsert` (?) }";
		boolean result = false;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			cs.setString(1, pojo.getNombre_apellidos());
			result = cs.execute();
		}
		
		return result;
	}

	@Override
	public List<Usuario> getAll() throws Exception {
		String sql = "{ CALL `usuariosGetAll` () }";
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			//preparar parametros
			try ( ResultSet rs = cs.executeQuery()){
				while (rs.next()) {
					Usuario u = new Usuario();
					u.setId(rs.getLong("id"));
					u.setNombre_apellidos(rs.getString("nombre_apellidos"));
					
					usuarios.add(u);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return usuarios;
	}

	@Override
	public Usuario getById(String id) throws Exception {
		String sql = "{ CALL `usuariosGetById` (?) }";
		Usuario u = new Usuario();
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			cs.setInt(1, Integer.parseInt(id));
			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					u.setId(rs.getLong("id"));
					u.setNombre_apellidos(rs.getString("nombre_apellidos"));

				}
			}

		}
		
		return u;
	}

	@Override
	public boolean update(Usuario pojo) throws Exception {
		String sql = "{ CALL `usuariosUpdate` (?,?) }";
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs =  con.prepareCall(sql);
				){
			//parseInt para convertir de Long a INT
			cs.setInt(1, new Long(pojo.getId()).intValue());
			cs.setString(2, pojo.getNombre_apellidos());
			result = cs.execute();
		}
		return result;
	}

	@Override
	public boolean delete(String id) throws Exception {
		String sql = "{ CALL `usuariosDelete` (?) }";
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
