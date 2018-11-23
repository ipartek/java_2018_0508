package com.ipartek.formacion.repaso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.pojo.Juego;
import com.ipartek.formacion.youtube.conection.ConnectionManager;

public class JuegoDAO {

	private static JuegoDAO INSTANCE = null;

	private final static Logger LOG = Logger.getLogger(JuegoDAO.class);

	private static final String SQL_LISTA_JUEGOS = "SELECT id, titulo, fecha_lanzamiento\r\n" + "FROM game.juego\r\n"
			+ "limit 500;";
	private static final String SQL_CREAR_JUEGO = "INSERT INTO `game`.`juego` (`titulo`, `fecha_lanzamiento`) VALUES (?, ?);";

	public static synchronized JuegoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new JuegoDAO();
		}
		return INSTANCE;
	}

	public JuegoDAO() {

		super();
	}

	public List<Juego> getall() throws Exception {
		ArrayList<Juego> juegos = new ArrayList<Juego>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(SQL_LISTA_JUEGOS);
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
			e.printStackTrace();
		}

		return juegos;
	}

	public boolean crear(Juego j) throws Exception {

		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_CREAR_JUEGO, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, j.getTitulo());
			pst.setDate(2, j.getFechaLanzamiento());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
				try (ResultSet rs = pst.getGeneratedKeys();) {

					while (rs.next()) {
						j.setId(rs.getLong(1));
					}

				}
			}

		} catch (Exception e) {

		}
		return resul;
	}

}
