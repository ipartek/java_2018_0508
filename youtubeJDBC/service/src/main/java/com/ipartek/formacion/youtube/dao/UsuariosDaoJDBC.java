package com.ipartek.formacion.youtube.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.conection.ConnectionManager;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuariosDaoJDBC implements CrudAble<Usuario> {

	private static UsuariosDaoJDBC INSTANCE = null;
	private static List<Usuario> usuarios = null;
	// querys CRUD
	private final String SQL_GET_ALL = "SELECT u.id as 'id_usuario',u.nombre as 'nombre_usuario', password, id_rol as 'id_rol',r.nombre as 'nombre_rol'"+
	"  FROM usuario as u , rol as r"+
	"  WHERE u.id_rol = r.id"+
	"  order by u.id ASC limit 1000;";
	private final String SQL_INSERT = "INSERT INTO usuario(nombre,password,id_rol) VALUES(?,?,?);";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre=?,password=?,id_rol = ?  WHERE id=? ;";
	private final String SQL_SELECT = "SELECT id,nombre, password, id_rol FROM usuario ORDER BY id DESC ;";
	private final String SQL_DELETE = "DELETE from usuario WHERE id=?;";
	private final String SQL_SELECT_BY_NAMEPASS = "SELECT u.id  as 'id_usuario',u.nombre as 'nombre_usuario', password, id_rol as 'id_rol'"+
			" FROM usuario as u, rol as r"+
			" WHERE u.nombre = ? and password = ? ;" ;
	private final String SQL_SELECT_BY_NAME = "SELECT id as 'id_usuario',nombre as 'nombre_usuario', password, id_rol FROM usuario WHERE nombre = ?;";
	private final String SQL_SELECT_BY_ID = "SELECT u.id as 'id_usuario',u.nombre as 'nombre_usuario', password, id_rol as 'id_rol', r.nombre as 'nombre_rol'"+
	" FROM usuario as u, rol as r"+
	" WHERE u.id = ?;";



	private UsuariosDaoJDBC() {

		usuarios = new ArrayList<Usuario>();
	}

	public static synchronized UsuariosDaoJDBC getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuariosDaoJDBC();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) throws Exception {
		boolean flag = false;

		// donde guardaremos el numero de registros afectados
		int rows = 0;
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement ps = conexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			// resultado = estamento.executeQuery(estamento);
			// Con esto nos apoyaremos para sustituir los ? de la query por los parametros
			// en ejecucion
			int index = 1;
			ps.setString(index++, pojo.getNombre());// parametro 1
			ps.setString(index++, pojo.getPass());// parametro 3
			ps.setInt(index, pojo.getRol().getId());// parametro 3
			System.out.println("INSERTANDO ");
			// nos devuelve un entero representado el numero de registros afectados por la
			// query
			rows = ps.executeUpdate();
			if(rows  > 0) {
				flag = true;
				System.out.println(rows + " registros afectados en la accion de insertar Usuario");
			}
			
		} 
		
		return flag;
	}

	@Override
	public List<Usuario> getAll() throws Exception {
		// donde guardaremos el numero de registros afectados
		ArrayList<Usuario> usuariosArray = new ArrayList<Usuario>();
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement ps = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {
			System.out.println("Pasando por getAll UsuariosDaoJDBC");
			while (rs.next()) {
				usuariosArray.add(rowMapper(rs));
			}
		} 
		return usuariosArray;
	}

	@Override
	public Usuario getById(String id) throws Exception{
		Usuario u = new Usuario();
		PreparedStatement ps = null;
		try (Connection conexion = ConnectionManager.getConnection();) {
			int index = 1;
			ps = conexion.prepareStatement(SQL_SELECT_BY_ID);
			ps.setString(index, id);// parametro 1


			System.out.println("Pasando por checkByNamePass UsuariosDaoJDBC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = (rowMapper(rs));
			}
			if(u.getNombre() == "" && u.getPass() == "") {
				u = null;
			}		
		}
			return u;
		}

	@Override
	public boolean delete(String id) throws Exception{
		String idString = String.valueOf(id);
		PreparedStatement ps = null;
		boolean resul = false;
		int rows;
		
		try(Connection conexion = ConnectionManager.getConnection();) {
			
			int index = 1;
			ps = conexion.prepareStatement(SQL_DELETE);
			ps.setString(index, idString);// parametro 1
			rows = ps.executeUpdate();
			if (rows == 1) {
				resul = true;
			}else {
				resul = false;
			}
			
		} 
		return resul;
	}

	@Override
	public boolean update(Usuario pojo) throws Exception {
		/**
		 * nombre=?,password=? WHERE id=? 
		 */
		PreparedStatement ps = null;
		boolean resul = false;
		int rows;
		
		try(Connection conexion = ConnectionManager.getConnection();) {
			
			int index = 1;
			ps = conexion.prepareStatement(SQL_UPDATE);
			
			ps.setString(index++, pojo.getNombre());// parametro 1
			ps.setString(index++, pojo.getPass());// parametro 1
			ps.setInt(index++, pojo.getRol().getId());// parametro 1
			ps.setLong(index, pojo.getId());// parametro 1
			rows = ps.executeUpdate();
			if (rows == 1) {
				resul = true;
			}else {
				resul = false;
			}
			
		} 
		return resul;
	}

	private Usuario rowMapper(ResultSet rs) throws Exception {
		Usuario usuario = new Usuario();
		if (rs != null) {
			usuario.setId(rs.getInt("id_usuario"));
			usuario.setNombre(rs.getString("nombre_usuario"));
			usuario.setPass(rs.getString("password"));
			//usuario.setId("id_usuario");
			Rol rol = new Rol();
			rol.setId((int) rs.getLong("id_rol"));
			rol.setNombre(rs.getString("nombre_rol"));
			usuario.setRol(rol);

		}
		return usuario;
	}

	public Usuario checkByNamePass(String nombre, String pass) {
		Usuario usuario = new Usuario();
		PreparedStatement ps = null;
		try (Connection conexion = ConnectionManager.getConnection();) {
			int index = 1;
			ps = conexion.prepareStatement(SQL_SELECT_BY_NAMEPASS);
			ps.setString(index++, nombre);// parametro 1
			ps.setString(index, pass);

			System.out.println("Pasando por checkByNamePass UsuariosDaoJDBC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usuario = (rowMapper(rs));
			}
			if(usuario.getNombre() == "" && usuario.getPass() == "") {
				usuario = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public boolean checkByName(String nombreUsuario) {
		boolean resul = false;
		Usuario usuario = new Usuario();
		int rows = 0;
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_BY_NAME);) {
			int index = 1;
			ps.setString(index, nombreUsuario);// parametro 1
			System.out.println("Pasando por checkByName UsuariosDaoJDBC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usuario = (rowMapper(rs));
				if (usuario != null) {
					resul = true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;
	}
}
