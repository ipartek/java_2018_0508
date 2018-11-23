package com.ipartek.formacion.repaso.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.conection.ConnectionManager;
import com.ipartek.formacion.repaso.pojo.Juego;

public class JuegoDAO {

	private static JuegoDAO INSTANCE = null;
	private static final String SQL_LISTADO = "SELECT id,titulo,fecha_lanzamiento FROM juego ORDER BY id DESC LIMIT 500;";
	private static final String SQL_INSERT="INSERT INTO juego (`titulo`, `fecha_lanzamiento`) VALUES (?,?);";
	private final static Logger LOG = Logger.getLogger(JuegoDAO.class);

	// TODO patron singleton
	private JuegoDAO() {
		super();
	}

	public static synchronized JuegoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new JuegoDAO();
		}

		return INSTANCE;
	}

	public List<Juego> getAll() throws SQLException, Exception {
		ArrayList<Juego> juegos = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_LISTADO);
				ResultSet rs = ps.executeQuery();) {

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				juegos.add(rowMapper(rs));
			}

		} catch (Exception e) {
			LOG.equals(e);
		}
		return juegos;
	}
	
	public boolean insert(Juego pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (pojo != null) {

				ps.setString(1, pojo.getTitulo().trim());
				ps.setDate(2, pojo.getFecha_lanzamiento());
				
				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					try (ResultSet rs = ps.getGeneratedKeys()) {
						while (rs.next()) {
							pojo.setId(rs.getLong(1));// devuelve el valor de la primera columna "id" de la bbdd
							resul = true;
						}
					}

				}
			}
		}
		return resul;
	}

	private Juego rowMapper(ResultSet rs) throws Exception {
		Juego u = new Juego();

		if (rs != null) {
			u.setId(rs.getLong("id"));
			u.setTitulo(rs.getString("titulo"));
			u.setFecha_lanzamiento(rs.getDate("fecha_lanzamiento"));

		}
		return u;
	}

}
