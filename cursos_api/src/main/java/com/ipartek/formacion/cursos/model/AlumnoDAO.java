package com.ipartek.formacion.cursos.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.cursos.cnx.ConnectionManager;
import com.ipartek.formacion.cursos.pojo.Alumno;

public class AlumnoDAO {

	private static AlumnoDAO INSTANCE = null;

	private AlumnoDAO() {
		super();
	}

	public static synchronized AlumnoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new AlumnoDAO();
		}

		return INSTANCE;
	}
	
	public List<Alumno> getAlumnosPorCurso(long idCurso) throws SQLException {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL cursoGetAlumnos(?)}");) {

			// Se cargan los parametros de entrada
			sp.setLong("p_id_curso", idCurso);// Tipo String

			// Se ejecuta el procedimiento almacenado

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					alumnos.add(rowMapperAlumno(rs));

				}
			}

			return alumnos;
		}

	}

	private Alumno rowMapperAlumno(ResultSet rs) throws SQLException {

		Alumno alumno = new Alumno();

		alumno.setCodigo(rs.getLong("codigo"));
		alumno.setNombre(rs.getString("nombre"));
		alumno.setApellidos(rs.getString("apellidos"));

		return alumno;
	}


}
