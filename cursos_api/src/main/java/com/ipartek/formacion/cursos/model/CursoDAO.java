package com.ipartek.formacion.cursos.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.cursos.cnx.ConnectionManager;
import com.ipartek.formacion.cursos.interfaces.CrudAble;
import com.ipartek.formacion.cursos.pojo.Alumno;
import com.ipartek.formacion.cursos.pojo.Curso;
import com.ipartek.formacion.cursos.pojo.Profesor;

public class CursoDAO implements CrudAble<Curso> {

	private static CursoDAO INSTANCE = null;

	private CursoDAO() {
		super();
	}

	public static synchronized CursoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CursoDAO();
		}

		return INSTANCE;
	}

	// --------------------------GETTERS------------------------ //
	// ---------------------------------------------------------//

	@Override
	public List<Curso> getAll() throws Exception {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL cursoGetAll}");) {

			try (ResultSet rs = sp.executeQuery();) {

				while (rs.next()) {

					cursos.add(rowMapper(rs));
				}
			}
		}

		return cursos;
	}

	@Override
	public Curso getById(long id) throws Exception {

		Curso curso = null;

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall(" CALL cursoGetById(?)");) {

			// Se cargan los parametros de entrada
			sp.setLong("p_id", id);// Tipo String

			// Se ejecuta el procedimiento almacenado

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {

					curso = rowMapper(rs);

				}
			}
		}
		return curso;
	}

	
	private Curso rowMapper(ResultSet rs) throws SQLException {

		Curso curso = new Curso();
		
		long codigo = rs.getLong("codigo_curso");

		curso.setCodigo(codigo);
		curso.setNombre(rs.getString("nombre_curso"));
		curso.setIdentificador(rs.getString("identificador"));
		curso.setNumHoras(rs.getInt("nHoras"));

		Profesor profesor = new Profesor();
		profesor.setCodigo(rs.getLong("codigo_profesor"));
		profesor.setNombre(rs.getString("nombre_profesor"));
		profesor.setApellidos(rs.getString("apellidos"));

		curso.setProfesor(profesor);

		return curso;
	}

	// --------------------------SETTERS------------------------ //
	// ---------------------------------------------------------//
	@Override
	public boolean insert(Curso pojo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Curso pojo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
