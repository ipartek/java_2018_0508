package com.ipartek.formacion.game.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.game.connection.ConnectionManager;
import com.ipartek.formacion.game.pojo.Juego;

public class GameDAO {

	private static GameDAO INSTANCE = null;

	public static synchronized GameDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GameDAO();
		}
		return INSTANCE;
	}

	private GameDAO() {
		super();
	}

	/* GETTERS */

	public List<Juego> getAll() throws Exception {

		ArrayList<Juego> juegos = new ArrayList<Juego>();
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL juegoGetAll}");) {

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					juegos.add(rowMapper(rs));
				}
			}
		}

		return juegos;
	}

	public boolean insert(Juego pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL juegoInsert(?, ?, ?)}");) {

			// Se cargan los parametros de entrada
			sp.setString("p_titulo", pojo.getTitulo());
			sp.setDate("p_fecha_lanzamiento", pojo.getFechaLanzamiento());

			// parametros de salida
			sp.registerOutParameter("o_id", Types.INTEGER);

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();

			int id = sp.getInt("o_id");
			pojo.setId(id);

			if (resultado == 1) {

				resul = true;

			}

		}
		return resul;
	}

	public boolean insertMultiple(ArrayList<Juego> coleccion) throws Exception {
		boolean resul;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL juegoInsert(?, ?, ?)}");) {

			con.setAutoCommit(false);

			int i = 0;

			for (Juego pojo : coleccion) {

				i++;
				// Se cargan los parametros de entrada
				sp.setString("p_titulo", pojo.getTitulo());
				sp.setDate("p_fecha_lanzamiento", pojo.getFechaLanzamiento());

				// parametros de salida
				sp.registerOutParameter("o_id", Types.INTEGER);

				// Se ejecuta el procedimiento almacenado
				int resultado = sp.executeUpdate();

				if (i == 2) {

					con.rollback();
					throw new Exception("Forzar ROLLBACK");

				}

				if (resultado == 1) {

					int id = sp.getInt("o_id");
					pojo.setId(id);

				}
			}

			con.commit();
			resul = true;

		}

		return resul;
	}

	private Juego rowMapper(ResultSet rs) throws SQLException {

		Juego j = new Juego();

		j.setId(rs.getLong("idgame"));
		j.setTitulo(rs.getString("titulo"));
		j.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));

		return j;

	}

}
