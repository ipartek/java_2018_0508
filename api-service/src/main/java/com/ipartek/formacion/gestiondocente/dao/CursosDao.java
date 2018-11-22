package com.ipartek.formacion.gestiondocente.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.gestiondocente.conection.ConnectionManager;
import com.ipartek.formacion.gestiondocente.pojo.Alumno;
import com.ipartek.formacion.gestiondocente.pojo.Cliente;
import com.ipartek.formacion.gestiondocente.pojo.Curso;
import com.ipartek.formacion.gestiondocente.pojo.Profesor;




public class CursosDao  {
	
	
	private static CursosDao INSTANCE = null;
	private static List<Curso> cursos = null;

	// querys CRUD
	private final String SQL_GET_ALL_CURSOS = "SELECT codigo, nombre, identificador, fInicio,fFin,nHoras,temario,activo,cliente_codigo,precio,profesor_codigo\r\n" + 
			" FROM gestiondocente.curso\r\n" + 
			" order by codigo limit 100;";
	
	private final String SQL_GET_ALL_CURSOS_PROFESOR = "SELECT c.codigo  , c.nombre, identificador, c.fInicio, c.fFin, c.nHoras, c.temario, c.activo, c.cliente_codigo, c.precio, c.profesor_codigo, p.nombre as nombre_maestro\r\n" + 
			" FROM gestiondocente.curso as c , gestiondocente.profesor as p\r\n" + 
			" where profesor_codigo = p.codigo\r\n" + 
			" order by codigo limit 100;";
	

	private CursosDao() {

		cursos = new ArrayList<Curso>();
	}

	public static synchronized CursosDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursosDao();
		}
		return INSTANCE;
	}

	
	

	
	public List<Curso> getAllCursos() throws Exception {
		// donde guardaremos el numero de registros afectados
		ArrayList<Curso> usuariosArray = new ArrayList<Curso>();
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement ps = conexion.prepareStatement(SQL_GET_ALL_CURSOS);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				usuariosArray.add(rowMapper(rs));
			}
		} 
		return usuariosArray;
	}

	public List<Curso> getAllCursosProfesores() throws Exception {
		// donde guardaremos el numero de registros afectados
		ArrayList<Curso> usuariosArray = new ArrayList<Curso>();
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement ps = conexion.prepareStatement(SQL_GET_ALL_CURSOS_PROFESOR);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				usuariosArray.add(rowMapperConMaestros(rs));
			}
		} 
		return usuariosArray;
	}

	

	private Curso rowMapper(ResultSet rs) throws Exception {
		Curso curso = new Curso();
		if (rs != null) {
			// asi cojeriamos con la query normal los datos ahora debemos usar los
			// alias de la query
			
			curso.setCodigo(rs.getInt("codigo"));
			curso.setNombre(rs.getString("nombre"));
			curso.setIdentificador(rs.getString("identificador"));
			curso.setfFin(rs.getDate("fFin"));
			curso.setfInicio(rs.getDate("fInicio"));
			curso.setnHoras(rs.getInt("nHoras"));
			curso.setTemario(rs.getString("temario"));
			curso.setActivo(rs.getInt("activo"));
			curso.setPrecio(rs.getInt("precio"));


			
			

			//video.setUsuario(usuariosJDBC.getById(rs.getString("id_usuario")));// no es lo mas optimo


		}
		return curso;
	}
		
		private Curso rowMapperConMaestros(ResultSet rs) throws Exception {
			Curso curso = new Curso();
			Profesor profesor = new Profesor();
			Alumno alumno = new Alumno();
			Cliente cliente = new Cliente();
			if (rs != null) {
				// asi cojeriamos con la query normal los datos ahora debemos usar los
				// alias de la query
				
				curso.setCodigo(rs.getInt("codigo"));
				curso.setNombre(rs.getString("nombre"));
				curso.setIdentificador(rs.getString("identificador"));
				curso.setfInicio(rs.getDate("fInicio"));
				curso.setfFin(rs.getDate("fFin"));
				curso.setnHoras(rs.getInt("nHoras"));
				curso.setTemario(rs.getString("temario"));
				curso.setActivo(rs.getInt("activo"));
				curso.setPrecio(rs.getInt("precio"));
				profesor.setCodigo(rs.getInt("profesor_codigo"));
				curso.setProfesor(profesor);

				
				

				//video.setUsuario(usuariosJDBC.getById(rs.getString("id_usuario")));// no es lo mas optimo


			}
			return curso;
	}

	

	
}
