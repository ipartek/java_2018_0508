package com.ipartek.formacion.gestiondocente.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.gestiondocente.conection.ConnectionManager;
import com.ipartek.formacion.gestiondocente.pojo.Alumno;
import com.ipartek.formacion.gestiondocente.pojo.Curso;
import com.ipartek.formacion.gestiondocente.pojo.Profesor;

public class CursoDAO {

	private static CursoDAO INSTANCE = null;

	private final String SQL_GET_CURSOS = "SELECT c.nombre as nombre_curso,c.identificador as identificador_curso,c.nHoras as horas,c.profesor_codigo as id_profesor,p.codigo as codigo_profesor,p.nombre as nombre_profesor,p.apellidos as apellidos_profesor,a.nombre as nombre_alumno,a.apellidos as apellidos_alumno FROM curso as c,profesor as p,alumno as a,imparticion as imp WHERE c.profesor_codigo=p.codigo AND a.codigo=imp.alumno_codigo AND c.codigo=imp.curso_codigo;";

	private CursoDAO() {
		super();
	}

	public static synchronized CursoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoDAO();
		}
		return INSTANCE;
	}

	public List<Curso> getAll() throws Exception {
		Curso usuario = null;

		List<Curso> cursos = new ArrayList<Curso>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_CURSOS);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				cursos.add(rowMapper(rs, usuario));
			}

		}

		return cursos;
	}

	private Curso rowMapper(ResultSet rs, Curso curso) throws Exception {
		if (curso == null) {
			curso = new Curso();
		} else {

		}

		if (rs != null) {

			curso.setNombre(rs.getString("nombre_curso"));
			curso.setIdentificador(rs.getString("identificador_curso"));
			curso.setHoras(rs.getInt("horas"));
			Alumno alumno = new Alumno(rs.getString("nombre_alumno"), rs.getString("apellidos_alumno"));
			curso.getAlumnos().add(alumno);
			Profesor profesor = new Profesor(rs.getString("nombre_profesor"), rs.getString("apellidos_profesor"));
			curso.setProfesor(profesor);
		}
		return curso;
	}

}
