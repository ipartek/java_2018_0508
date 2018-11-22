package com.ipartek.formacion.gestiondocentes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.gestiondocentes.pojo.Alumno;
import com.ipartek.formacion.gestiondocentes.pojo.Curso;
import com.ipartek.formacion.gestiondocentes.pojo.Profesor;

public class CursoDAO {
	private static CursoDAO INSTANCE = null;

	private static final String SQL_GET_CURSOS = "SELECT codigo, nombre, identificador, nHoras" + " FROM curso"
			+ " ORDER BY codigo DESC" + " LIMIT 1000;";

	private static final String SQL_GET_CURSOS_PROFESOR = "SELECT c.codigo as codigo_curso,"
			+ " c.nombre as curso_nombre," + " c.identificador, c.nHoras, p.codigo as codigo_profesor,"
			+ " p.nombre as nombre_profesor," + " p.apellidos" + " FROM curso c, profesor p"
			+ " WHERE c.profesor_codigo = p.codigo" + " ORDER BY c.codigo DESC" + " LIMIT 1000;";

	private static final String SQL_GET_CURSOS_PROFESOR_ALUMNOS = "SELECT c.codigo as codigo_curso, c.nombre as curso_nombre,"
			+ " c.identificador, c.nHoras," + " p.codigo as codigo_profesor, p.nombre as nombre_profesor,"
			+ " p.apellidos as apellidos_profesor," + " a.codigo as codigo_alumno, a.nombre as nombre_alumno,"
			+ " a.apellidos as apellidos_alumno" + " FROM curso c, profesor p, imparticion i, alumno a"
			+ " WHERE c.profesor_codigo = p.codigo" + " AND i.curso_codigo = c.codigo"
			+ " AND i.alumno_codigo = a.codigo" + " ORDER BY c.codigo DESC" + " LIMIT 1000;";

	private CursoDAO() {
		super();
	}

	public static synchronized CursoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoDAO();
		}

		return INSTANCE;
	}
	
	/**
	 * Coleccion de cursos limitado a 1000 y orden descendente
	 * por codigo de curso
	 * @return List<Curso>
	 */
	public List<Curso> getAllCursos() throws Exception {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_CURSOS);) {
			ResultSet rs = ps.executeQuery();

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				Curso c = new Curso();
				if (rs != null) {
					c.setCodigo(rs.getLong("codigo"));
					c.setNombre(rs.getString("nombre"));
					c.setIdentificador(rs.getString("identificador"));
					c.setnHoras(rs.getInt("nHoras"));
				}
				cursos.add(c);
			}
		}
		return cursos;
	}

	/**
	 * Coleccion de cursos mas los profesores que impartieron cada uno
	 * limitado a 1000 y orden descendente por codigo de curso
	 * @return List<Curso>
	 */
	public List<Curso> getCursosProfesores() throws Exception {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_CURSOS_PROFESOR);) {
			ResultSet rs = ps.executeQuery();

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				Curso c = new Curso();
				if (rs != null) {
					c.setCodigo(rs.getLong("codigo_curso"));
					c.setNombre(rs.getString("curso_nombre"));
					c.setIdentificador(rs.getString("identificador"));
					c.setnHoras(rs.getInt("nHoras"));

					Profesor p = new Profesor();
					p.setCodigo(rs.getLong("codigo_profesor"));
					p.setNombre(rs.getString("nombre_profesor"));
					p.setApellidos(rs.getString("apellidos"));

					c.setProfesor(p);
				}
				cursos.add(c);
			}
		}
		return cursos;
	}

	/**
	 * Coleccion de cursos mas los profesores que impartieron cada uno y
	 * los alumnos que se matricularon en cada uno de ellos
	 * limitado a 1000 y orden descendente por codigo de curso
	 * @return List<Curso>
	 */
	public List<Curso> getCursosProfesoresAlumnos() throws Exception {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		List<Alumno> alumnos = null;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_CURSOS_PROFESOR_ALUMNOS);) {
			ResultSet rs = ps.executeQuery();

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				Curso c = new Curso();

				boolean cursoEncontrado = false;
				boolean alumnoEncontrado = false;

				if (rs != null) {

					c.setCodigo(rs.getLong("codigo_curso"));

					cursoEncontrado = false;

					// Busca en el array de cursos si ya existe el curso actual
					for (int i = 0; i < cursos.size(); i++) {
						if (cursos.get(i).getCodigo() == c.getCodigo()) {
							cursoEncontrado = true;
							c = cursos.get(i);
							break;
						}
					}

					// Si no lo encuentra lo crea y la lista de alumnos estara vacia
					// Asi que no es necesario comprobar si el alumno actual existe
					if (!cursoEncontrado) {
						c.setNombre(rs.getString("curso_nombre"));
						c.setIdentificador(rs.getString("identificador"));
						c.setnHoras(rs.getInt("nHoras"));

						Profesor p = new Profesor();
						p.setCodigo(rs.getLong("codigo_profesor"));
						p.setNombre(rs.getString("nombre_profesor"));
						p.setApellidos(rs.getString("apellidos_profesor"));

						c.setProfesor(p);

						alumnos = c.getAlumnos();

						Alumno a = new Alumno();
						a.setCodigo(rs.getLong("codigo_alumno"));
						a.setNombre(rs.getString("nombre_alumno"));
						a.setApellidos(rs.getString("apellidos_alumno"));

						alumnos.add(a);

						c.setAlumnos(alumnos);

					} else {
						// Si lo encuentra no se crea y habra un alumno minimo
						// por tanto se busca si el alumno actual ya existe en la lista
						alumnoEncontrado = false;
						alumnos = c.getAlumnos();

						Alumno a = new Alumno();

						a.setCodigo(rs.getLong("codigo_alumno"));

						for (int j = 0; j < alumnos.size(); j++) {
							if (alumnos.get(j).getCodigo() == a.getCodigo()) {
								alumnoEncontrado = true;
								break;
							}
						}

						//Si el alumno no existe se añade a la lista de alumnos del curso actual
						//Si existe, no se hace nada
						if (!alumnoEncontrado) {
							a.setNombre(rs.getString("nombre_alumno"));
							a.setApellidos(rs.getString("apellidos_alumno"));

							alumnos.add(a);
						}

						c.setAlumnos(alumnos);
					}

				}

				if (!cursoEncontrado) {
					cursos.add(c);
				}
			}
		}
		return cursos;
	}
	
}
