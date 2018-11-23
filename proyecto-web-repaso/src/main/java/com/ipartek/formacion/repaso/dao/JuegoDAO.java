package com.ipartek.formacion.repaso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.conection.ConnectionManager;
import com.ipartek.formacion.repaso.pojo.Juego;

public class JuegoDAO {

	private static final Logger LOG = Logger.getLogger(JuegoDAO.class);

	// TODO patron singleton

	private static final String SQL_LISTADO = "SELECT id, titulo, fecha_lanzamiento FROM juego ORDER BY id DESC LIMIT 500;";

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

}
