package com.ipartek.formacion.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.gestion.connection.ConnectionManager;
import com.ipartek.formacion.gestion.pojo.Curso;
import com.ipartek.formacion.gestion.pojo.Profesor;

public class CursoDAO implements CrudAble<Curso> {
	private static CursoDAO INSTANCE = null;

	private static final String SQL_GET_ALL_CURSO_PROFESOR = "SELECT c.codigo as cursoCod, c.nombre as cursoNom, c.identificador, c.nHoras, p.codigo, p.nombre, p.apellidos\r\n"
			+ "FROM curso as c, profesor as p\r\n" + "WHERE c.profesor_codigo = p.codigo;";

	private CursoDAO() {
		super();
	}

	public static synchronized CursoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Curso pojo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Curso> getAll() throws Exception {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_CURSO_PROFESOR);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Curso c = new Curso();
				c.setCodigo(rs.getLong("cursoCod"));
				c.setNombre(rs.getString("cursoNom"));
				c.setIdentificador(rs.getString("identificador"));
				c.setnHoras(rs.getInt("nHoras"));

				Profesor p = new Profesor();
				p.setCodigo(rs.getLong("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setApellidos(rs.getString("apellidos"));
				

				c.setProfesor(p);

				cursos.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

	@Override
	public Curso getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
