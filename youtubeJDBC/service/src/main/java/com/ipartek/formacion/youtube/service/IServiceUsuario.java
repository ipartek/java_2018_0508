package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * 
 * @author Curso
 *
 */
public interface IServiceUsuario  {
	
	//No olvidarse del patron singleton
	
	//Iniciar sesion
	
	/**
	 * Login para iniciar sesion
	 * @param nombre
	 * @param password
	 * @return Usuario si existe, null en caso contrario
	 */
	Usuario login(String nombre, String password);
	
	/**
	 * No recuperamos sus videos
	 * @param idUsuario
	 * @return Usuario si existe, null en caso contrario
	 */
	Usuario buscarPorId(long idUsuario);
	
	/**
	 * Listado de usuarios limitado a 1000 ordenado de forma ascendente por id
	 * @return Listado de usuarios 
	 */
	List<Usuario> listar();
	
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
	boolean crear(Usuario u) throws Exception ;
	
	/**
	 * Se permite modificar todo
	 * @param usuario u
	 * @return true si modifica , false si no lo hace
	 * @throws Exception si no tenemos todos los atributos necesarios 
	 */
	boolean modificarUsuario(Usuario u) throws Exception;
	
	
	/**
	 * 
	 * @param id
	 * @return true si elminar correctamente, false si no encuentra el usuario
	 * @throws Exception si tiene videos asociados 
	 */
	boolean eliminarUsuario(long id) throws Exception;
}
