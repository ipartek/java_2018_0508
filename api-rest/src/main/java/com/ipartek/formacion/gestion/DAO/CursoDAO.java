package com.ipartek.formacion.gestion.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.gestion.conection.ConnectionManager;
import com.ipartek.formacion.gestion.pojo.Curso;
import com.ipartek.formacion.gestion.pojo.Profesor;

public class CursoDAO {

	private static CursoDAO INSTANCE = null;

	private static final String SQL_GET_CURSO = " select nombre as 'curso',identificador as 'identificadorCurso',nhoras as 'horas' from curso  LIMIT 1000;";
	private static final String SQL_GET_CURSO_PROFESOR = " select c.nombre as 'curso',c.identificador as 'identificadorCurso',nhoras as 'horas' ,p.nombre as 'nombreprofesor',p.apellidos as 'apellidos' FROM curso c,profesor p WHERE c.profesor_codigo=p.codigo LIMIT 1000;";
	private static final String SQL_GET_CURSO_ALUMNO = "select c.nombre as 'curso',	c.identificador as 'identificadorCurso',nhoras as 'horas' ,	p.nombre as 'nombreprofesor',p.apellidos as 'apellidosProfesor',a.nombre as 'nombrealumno',a.apellidos as 'apellidosalumno' FROM curso c,profesor p, alumno a,imparticion i WHERE c.profesor_codigo=p.codigo AND i.curso_codigo=c.codigo AND i.alumno_codigo=a.codigo LIMIT 1000;";

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
	 * Metodo que lista los cursos 
	 * @return List<Curso> 
	 * @throws Exception
	 */
	public List<Curso> listarCurso() throws Exception {
		List<Curso> cursos = new ArrayList<Curso>();
		Curso c = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_CURSO);
				ResultSet rs = ps.executeQuery();) {

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				c = new Curso();
				c.setNombre(rs.getString("curso"));
				c.setIdentificador(rs.getString("identificadorCurso"));
				c.setnHoras(rs.getInt("horas"));
				cursos.add(c);
			}

		}

		return cursos;
	}

	/**
	 * Metodo que lista los cursos con los profesor
	 * @return List<Curso> 
	 * @throws Exception
	 */
	public List<Curso> listarCursoProfesor() throws Exception {
		List<Curso> cursos = new ArrayList<Curso>();
		Curso c = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_CURSO_PROFESOR);
				ResultSet rs = ps.executeQuery();) {

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				c = new Curso();
				c.setNombre(rs.getString("curso"));
				c.setIdentificador(rs.getString("identificadorCurso"));
				c.setnHoras(rs.getInt("horas"));

				Profesor p = new Profesor();
				p.setNombre(rs.getString("nombreprofesor"));
				p.setApellidos("apellidosprofesor");
				c.setProfesor(p);

				cursos.add(c);
			}

		}

		return cursos;
	}

	/**
	 * Metodo que lista los cursos con los alumnos y profesor
	 * @return List<Curso> 
	 * @throws Exception
	 */
	public List<Curso> listarCursoAlumno() throws Exception {
		List<Curso> cursos = new ArrayList<Curso>();
		Curso c = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_CURSO_ALUMNO);
				ResultSet rs = ps.executeQuery();) {

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				c = new Curso();
				c.setNombre(rs.getString("curso"));
				c.setIdentificador(rs.getString("identificadorCurso"));
				c.setnHoras(rs.getInt("horas"));

				Profesor p = new Profesor();
				p.setNombre(rs.getString("nombreprofesor"));
				p.setApellidos("apellidosprofesor");
				c.setProfesor(p);

				Alumno a = new Alumno();
				a.setNombre(rs.getString("nombrealumno"));
				a.setApellidos("apellidosalumno");
				c.setAlumno(a);
				
				cursos.add(c);
			}
		}

		return cursos;
	}

}
