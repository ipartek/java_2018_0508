package com.ipartek.formacion.youtube.model;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

public class UsuariosDaoJDBC implements CrudAble<Usuario> {

	private static UsuariosDaoJDBC INSTANCE = null;
	private static List<Usuario> usuarios = null;
	// querys CRUD
	private final String SQL_INSERT = "INSERT INTO usuario(nombre,password) VALUES(?,?)";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre=?,email=?,password=? WHERE id=? ";
	private final String SQL_SELECT = "SELECT * FROM usuario ORDER BY id";
	private final String SQL_DELETE = "DELETE from usuario WHERE id=?";
	private final String SQL_SELECT_BY_NAMEPASS = "SELECT id,nombre, password, role FROM usuario WHERE nombre = ? and password = ? ";
	private final String SQL_SELECT_BY_NAME = "SELECT id,nombre, password, role FROM usuario WHERE nombre = ?";


	private UsuariosDaoJDBC() {

		usuarios = new ArrayList<Usuario>();
		/*
		 * usuarios.add(new Usuario(1,"admin","admin@gmail.com","admin"));
		 * usuarios.add(new Usuario(2,"pepep","pepe@gmail.com","pepep"));
		 * usuarios.add(new Usuario(3,"manoli","manoli@gmail.com","manoli"));
		 * usuarios.add(new Usuario(3,"josepo","josepo@gmail.com","josepo"));
		 */
	}

	public static synchronized UsuariosDaoJDBC getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuariosDaoJDBC();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) {
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
			ps.setString(index, pojo.getPass());// parametro 3
			System.out.println("INSERTANDO ");
			// nos devuelve un entero representado el numero de registros afectados por la
			// query
			rows = ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		System.out.println(rows + " registros afectados en la accion de insertar Usuario");
		return flag;
	}

	@Override
	public List<Usuario> getAll() {
		// donde guardaremos el numero de registros afectados
		ArrayList<Usuario> usuariosArray = new ArrayList<Usuario>();
		int rows = 0;
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement ps = conexion.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery();) {
			System.out.println("Pasando por getAll UsuariosDaoJDBC");
			while (rs.next()) {
				usuariosArray.add(rowMapper(rs));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuariosArray;
	}

	@Override
	public Usuario getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	private Usuario rowMapper(ResultSet rs) throws Exception {
		Usuario usuario = new Usuario();
		if (rs != null) {
			usuario.setId(rs.getLong("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPass(rs.getString("password"));
			
		}
		return usuario;
	}
	
	public Usuario checkByNamePass(String nombre, String pass) {
		Usuario usuario = new Usuario();
		PreparedStatement ps = null;
		boolean resul = false;
		int rows = 0;
		try (Connection conexion = ConnectionManager.getConnection();
				
				) {
			int index = 1;
			ps = conexion.prepareStatement(SQL_SELECT_BY_NAMEPASS);
			ps.setString(index++, nombre);// parametro 1
			ps.setString(index, pass);	
			
			System.out.println("Pasando por checkByNamePass UsuariosDaoJDBC");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				while (rs.next()) {
					usuario = (rowMapper(rs));
					
				}
			}else {
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
			System.out.println("Pasando por checkByNamePass UsuariosDaoJDBC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usuario = (rowMapper(rs));
				if(usuario!= null) {
					resul = true;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resul;
	}
}
