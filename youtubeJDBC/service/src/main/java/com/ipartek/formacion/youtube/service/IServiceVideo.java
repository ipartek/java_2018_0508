package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

/**
 * 
 * @author Curso
 *
 */
public interface IServiceVideo  {
	
	//No olvidarse del patron singleton
	
	//Iniciar sesion
	
	
	/**
	 * Recuperamos videos por id
	 * @param idVideo
	 * @return Video si existe, null en caso contrario
	 */
	Video buscarPorId(long idVideo) throws Exception;
	
	/**
	 * Listado de usuarios limitado a 1000 ordenado de forma ascendente por id
	 * @return Listado de usuarios 
	 */
	List<Video> listar();
	
	/**Coleccion de listados publicos no se muestra password 
	 * 
	 */
	List<Usuario> listarPublicos();
	
	/**
	 * Creamos un nuevo usuario rol por defecto ROL == 'usuario' no es 'administrador'
	 * @param usuario u
	 * @return true, si crea, false si no crea
	 * @throws Exception Si no tenemos todos los atributos necesarios o el nombre de usuario existe
	 */
	boolean crear(Video u) throws Exception ;
	
	/**
	 * Se permite modificar todo
	 * @param usuario u
	 * @return true si modifica , false si no lo hace
	 * @throws Exception si no tenemos todos los atributos necesarios 
	 */
	boolean modificarVideo(Video u) throws Exception;
	
	
	/**
	 * 
	 * @param id
	 * @return true si elminar correctamente, false si no encuentra el usuario
	 * @throws Exception si tiene videos asociados 
	 */
	boolean eliminarVideo(long id) throws Exception;
}
