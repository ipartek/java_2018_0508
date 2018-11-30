package com.ipartek.formacion.repaso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.conecction.ConnectionManager;
import com.ipartek.formacion.repaso.pojo.Alumno;

public class AlumnoDAO {

	private static AlumnoDAO INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(AlumnoDAO.class);

	final String CREAR_ALUMNO = "INSERT INTO alumno(nombre, apellido1 ,apellido2,dni,email) VALUES (?, ? , ? , ? , ?) ;";
	final String LISTAR_ALUMNOS = "SELECT id, nombre, apellido1, apellido2, dni, email from alumno ORDER BY id desc limit 200  ;";
	final String ACTUALIZAR_ALUMNOS = "UPDATE `alumno` SET nombre = ? , apellido1= ?, apellido2= ?, dni = ? , email = ? WHERE id= ?;";
	final String BUSCAR_POR_DNI = "SELECT id, nombre, apellido1, apellido2, dni, email from alumno where dni = ?  ORDER BY id desc limit 200 ;";
	final String BUSCAR_POR_EMAIL = "SELECT id, nombre, apellido1, apellido2, dni, email from alumno where email = ?   ORDER BY id desc limit 200;";
	final String BUSCAR_POR_NOMBRE = "SELECT id, nombre, apellido1, apellido2, dni, email from alumno where nombre = ?   ORDER BY id desc limit 200;";
	final String BUSCAR_POR_APELLIDO1 = "SELECT id, nombre, apellido1, apellido2, dni, email from alumno where apellido1 = ?   ORDER BY id desc limit 200;";
	final String BUSCAR_POR_APELLIDO2 = "SELECT id, nombre, apellido1, apellido2, dni, email from alumno where apellido2 = ?   ORDER BY id desc limit 200;";
	final String ELIMINAR_ALUMNOS = "DELETE FROM `alumnos_examen`.`alumno` WHERE (1 = 1);";

	public static synchronized AlumnoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AlumnoDAO();
		}
		return INSTANCE;
	}

	public ArrayList<Alumno> listar() throws SQLException {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(LISTAR_ALUMNOS);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				alumnos.add(rowMapper(rs));
			}

		}

		return alumnos;
	}

	public ArrayList<Alumno> buscarPorDni(String dni) throws SQLException {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(BUSCAR_POR_DNI);) {
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				alumnos.add(rowMapper(rs));
			}

		}

		return alumnos;
	}

	public ArrayList<Alumno> buscarPorEmail(String email) throws SQLException {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(BUSCAR_POR_EMAIL);) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				alumnos.add(rowMapper(rs));
			}

		}

		return alumnos;
	}

	public ArrayList<Alumno> buscarPorNombre(String nombre) throws SQLException {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(BUSCAR_POR_NOMBRE);) {
			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				alumnos.add(rowMapper(rs));
			}

		}

		return alumnos;
	}

	public ArrayList<Alumno> buscarPorApellido1(String apellido1) throws SQLException {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(BUSCAR_POR_APELLIDO1);) {
			pst.setString(1, apellido1);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				alumnos.add(rowMapper(rs));
			}

		}

		return alumnos;
	}

	public ArrayList<Alumno> buscarPorApellido2(String apellido2) throws SQLException {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(BUSCAR_POR_APELLIDO2);) {
			pst.setString(1, apellido2);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				alumnos.add(rowMapper(rs));

			}

		}

		return alumnos;
	}

	public boolean crearAlumno(Alumno a) throws SQLException {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(CREAR_ALUMNO, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, a.getNombre());
			pst.setString(2, a.getApellido1());
			pst.setString(3, a.getApellido2());
			pst.setString(4, a.getDni());
			pst.setString(5, a.getEmail());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
				try (ResultSet rs = pst.getGeneratedKeys();) {

					while (rs.next()) {
						a.setId(rs.getLong(1));
					}

				}
			}

		}
		return resul;
	}

	public boolean actualziar(Alumno a) throws SQLException {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(ACTUALIZAR_ALUMNOS);) {
			pst.setString(1, a.getNombre());
			pst.setString(2, a.getApellido1());
			pst.setString(3, a.getApellido2());
			pst.setString(4, a.getDni());
			pst.setString(5, a.getEmail());
			pst.setLong(6, a.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;

			}

		}
		return resul;
	}

	private Alumno rowMapper(ResultSet rs) throws SQLException {
		Alumno a = new Alumno();

		a.setId(rs.getInt("id"));
		a.setNombre(rs.getString("nombre"));
		a.setApellido1(rs.getString("apellido1"));
		a.setApellido2(rs.getString("apellido2"));
		a.setDni(rs.getString("dni"));
		a.setEmail(rs.getString("email"));

		return a;
	}

	public int eliminarDB() throws SQLException {
		int affectedRows = 0;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(ELIMINAR_ALUMNOS);) {

			// ResultSet rs = pst.executeQuery();
			affectedRows = pst.executeUpdate();

		}
		return affectedRows;
	}

}
