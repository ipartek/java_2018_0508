package com.ipartek.formacion.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.pojo.Video;
import com.mysql.jdbc.PreparedStatement;

public class UsuariosDaoJDBC implements CrudAble<Usuario> {
	
	private static UsuariosDaoJDBC INSTANCE = null;
	private static List<Usuario> usuarios = null;
	//querys CRUD
    private final String SQL_INSERT = "INSERT INTO usuarios(nombre,email,password) VALUES(?,?,?)";
    private final String SQL_UPDATE ="UPDATE usuarios SET nombre=?,email=?,password=? WHERE id=? ";
    private final String SQL_SELECT ="SELECT * FROM usuarios ORDER BY id";
    private final String SQL_DELETE ="DELETE from usuarios WHERE id=?";

	private UsuariosDaoJDBC() {
		
		usuarios = new ArrayList<Usuario>();
/*		usuarios.add(new Usuario(1,"admin","admin@gmail.com","admin"));
		usuarios.add(new Usuario(2,"pepep","pepe@gmail.com","pepep"));
		usuarios.add(new Usuario(3,"manoli","manoli@gmail.com","manoli"));
		usuarios.add(new Usuario(3,"josepo","josepo@gmail.com","josepo"));*/	
	}

	public static synchronized UsuariosDaoJDBC getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuariosDaoJDBC();
		}

		return INSTANCE;
	}
	
	@Override
	public boolean insert(Usuario pojo) {
		boolean flag = false;
		//Creamos los objetos de conexion, statement para ejecutar las querys
        //y resulset para el retorno
        Connection conexion = null;
        //PreparedStatement estamento = null;
        PreparedStatement estamento = null;  
        ResultSet resultado = null;
        //donde guardaremos el numero de registros afectados
        int rows = 0 ;
        try {
            conexion = Conexion.getConnection();
            estamento = (PreparedStatement) conexion.prepareStatement(SQL_INSERT);
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            int index = 1;
            estamento.setString(index++, pojo.getNombre());//parametro 1
            estamento.setString(index++, pojo.getEmail());//parametro 2
            estamento.setString(index, pojo.getPassword());//parametro 3
            System.out.println("INSERTANDO ");
            //nos devuelve un entero representado el numero de registros afectados por la query
            rows = estamento.executeUpdate();
            flag = true;
        } catch (SQLException e) {
        	flag = false;
            e.printStackTrace();
        }finally{
            Conexion.close(conexion);
        }
        System.out.println(rows + " registros afectados en la accion de insertar Usuario");
        return flag;
	}

	@Override
	public List<Usuario> getAll() {
		//Creamos los objetos de conexion, statement para ejecutar las querys
        //y resulset para el retorno
        Connection conexion = null;
        //PreparedStatement estamento = null;
        PreparedStatement estamento = null;  
        ResultSet resultado = null;
        //donde guardaremos el numero de registros afectados
        ArrayList<Usuario> usuariosArray = new ArrayList<>();
        int rows = 0;
            try {
            conexion = Conexion.getConnection();
            estamento = (PreparedStatement) conexion.prepareStatement(SQL_SELECT);
            resultado = estamento.executeQuery();
            System.out.println("Pasando por getAll UsuariosDaoJDBC");
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            while(resultado.next()){
                //System.out.println("Id -> "+resultado.getInt(1));
                //resultado.getString("Nombre -> "+resultado.getString(2));
                //resultado.getString("Apellido -> "+resultado.getString(3));
                usuariosArray.add(new Usuario(resultado.getInt(1),resultado.getString(2),resultado.getString(3),resultado.getString(4)));
            }
            
                
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                Conexion.close(resultado);
                Conexion.close(conexion);
            }
        return usuariosArray;
	}

	@Override
	public Usuario getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}


}
