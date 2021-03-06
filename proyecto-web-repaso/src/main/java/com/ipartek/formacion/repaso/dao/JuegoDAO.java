package com.ipartek.formacion.repaso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.conection.ConnectionManager;
import com.ipartek.formacion.repaso.pojo.Juego;
import com.mysql.jdbc.Statement;

public class JuegoDAO {

	private static final Logger LOG = Logger.getLogger(JuegoDAO.class);

	// TODO patron singleton

	private static final String SQL_LISTADO = "SELECT id, titulo, fecha_lanzamiento FROM juego ORDER BY id DESC LIMIT 500;";
	private static final String SQL_INSERT = "INSERT INTO `juego` (`titulo`, `fecha_lanzamiento`) VALUES ( ?, ? );";

	public List<Juego> getAll() {
		ArrayList<Juego> juegos = new ArrayList<Juego>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_LISTADO);
				ResultSet rs = pst.executeQuery();) {

			Juego j = null;
			while (rs.next()) {

				j = new Juego();
				j.setId(rs.getLong("id"));
				j.setTitulo(rs.getString("titulo"));
				j.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
				juegos.add(j);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return juegos;
	}

	public boolean crear(Juego juego) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, juego.getTitulo());
			pst.setDate(2, juego.getFechaLanzamiento());

			int affetcedRows = pst.executeUpdate();
			if (affetcedRows == 1) {

				try (ResultSet rs = pst.getGeneratedKeys()) {

					while (rs.next()) {
						juego.setId(rs.getLong(1));
						resul = true;
					}

				}

			}

		}

		return resul;
	}

}
