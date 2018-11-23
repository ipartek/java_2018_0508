package com.formacion.ipartek.repaso.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.formacion.ipartek.repaso.connection.ConnectionManager;
import com.formacion.ipartek.repaso.pojo.Juego;
import com.mysql.jdbc.Statement;

public class JuegoDAO {
	private static JuegoDAO INSTANCE = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(JuegoDAO.class);

	private static final String SQL_LISTADO = "SELECT id, titulo, fecha_lanzamiento" + " FROM juego ORDER BY id DESC"
			+ " LIMIT 1000;";

	private static final String SQL_INSERT = "INSERT INTO juego (titulo, fecha_lanzamiento) VALUES(?,?);";

	private static final String SQL_UPDATE = "";

//	private static final String SQL_DELETE = "";

	private JuegoDAO() {
		super();
	}

	public static synchronized JuegoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new JuegoDAO();
		}

		return INSTANCE;
	}

	public List<Juego> getAll() {
		ArrayList<Juego> juegos = new ArrayList<Juego>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_LISTADO);) {
			ResultSet rs = ps.executeQuery();
			Juego juego = null;

			while (rs.next()) {
				juego = new Juego();
				juego.setId(rs.getLong("id"));
				juego.setTitulo(rs.getString("titulo"));
				juego.setFecha_lanzamiento(rs.getDate("fecha_lanzamiento"));

				juegos.add(juego);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return juegos;
	}

	public boolean insert(Juego j) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (j != null) {
				ps.setString(1, j.getTitulo().trim());
				ps.setDate(2, j.getFecha_lanzamiento());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					ResultSet rs = ps.getGeneratedKeys();
					while (rs.next()) {
						j.setId(rs.getLong(1));
						resul = true;
					}
					rs.close();
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;
	}

	public boolean update(Juego j) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {
			ps.setString(1, j.getTitulo());
			ps.setDate(2, j.getFecha_lanzamiento());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {

			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;
	}

	public boolean delete(long id) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;
	}
}
