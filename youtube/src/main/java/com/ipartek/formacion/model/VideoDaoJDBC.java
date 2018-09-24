package com.ipartek.formacion.model;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.pojo.Video;
import com.mysql.jdbc.PreparedStatement;

public class VideoDaoJDBC implements CrudAble<Video> {
	
	private static VideoDaoJDBC INSTANCE = null;
	private static List<Video> videos = null;
	//querys CRUD
    private final String SQL_INSERT = "INSERT INTO videos(video_id,nombre_cancion) VALUES(?,?)";
    private final String SQL_UPDATE ="UPDATE videos SET video_id=?,nombre_cancion=? WHERE video_id=? ";
    private final String SQL_SELECT ="SELECT * FROM videos ORDER BY id";
    private final String SQL_DELETE ="DELETE from videos WHERE video_id=?";

	private VideoDaoJDBC() {
		videos = new ArrayList<Video>();
		try {
/*			videos.add(new Video("UKRLY9EptCY","Violin piano, Dubstep, Extended Edition, 20 Minutes,"));
			videos.add(new Video("OQcS-dZy1mg", "De tranquis"));
			videos.add(new Video("ninviq_cRbk", "Louder (Karate Kid)"));
			videos.add(new Video("YSAMOBVncSg", "Im a wanted man"));
			videos.add(new Video("OJxCcCEobNs","EPIC ROCK | ''Dead Man Walking'' by WAR*HALL"));*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized VideoDaoJDBC getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDaoJDBC();
		}

		return INSTANCE;
	}
	
	@Override
	public boolean insert(Video pojo) {
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
            estamento.setString(index++, pojo.getId());//parametro 1
            estamento.setString(index++, pojo.getNombreCancion());//parametro 2
            System.out.println("INSERTANDO ");
            //nos devuelve un entero representado el numero de registros afectados por la query
            rows = estamento.executeUpdate();
            System.out.println("Registros afectados: " + rows);
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Conexion.close(conexion);
        }
        return flag;
	}

	@Override
	public List<Video> getAll() {
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
            System.out.println("Pasando por getAll VideoDaoJDBC");
			//mapear resulSet al arrayList creando un objeto por cada registro del resulset
			Video v = null;
			while(resultado.next()) {
				v = new Video();
				v.setId(resultado.getString("video_id"));
				v.setNombreCancion(resultado.getString("nombre_cancion"));
				videos.add(v);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexion.close(resultado);
            Conexion.close(conexion);
		}
		
		return videos;
	}

	@Override
	public Video getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


}
