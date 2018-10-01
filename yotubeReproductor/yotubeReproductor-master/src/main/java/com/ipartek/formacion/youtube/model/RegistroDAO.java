package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Usuario;

public class RegistroDAO implements CrudAble<Usuario> {

	private static RegistroDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT id, nombre, password FROM usuario ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT  id, nombre, password FROM usuario WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre= ? , password= ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO usuario (nombre, password) VALUES (?,?);";

	private RegistroDAO() {
		super();
	}

	public static synchronized RegistroDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RegistroDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			if (pojo != null) {
				ps.setString(1, pojo.getNombre());
				ps.setString(2, pojo.getPass());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {

					resul = true;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return resul;
	}

	@Override
	public List<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				usuarios.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;

	}

	private Usuario rowMapper(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		if (rs != null) {
			usuario.setId(rs.getLong("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPass(rs.getString("password"));
		}
		return null;
	}

	@Override
	public Usuario getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
