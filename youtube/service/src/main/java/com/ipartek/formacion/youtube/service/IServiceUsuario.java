package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

public interface IServiceUsuario{

	/**
	 * Login para iniciar sesión
	 * @param nombre
	 * @param password
	 * @return Usuario si existe, null en caso contrario
	 */
	Usuario login( String nombre, String password);
	
	/**
	 * No recuperamos sus videos.
	 * @param idUsuario
	 * @return Usuario si existe, null en caso contrario
	 * @throws Exception 
	 */
	
	Usuario buscarPorId(long idUsuario) throws Exception;
	
	/**
	 * Colección de usuarios (ADMINISTRADORES Y NORMAL) limitado a 1000 y orden DESC por ID 
	 * @return
	 * @throws Exception 
	 */
	List<Usuario> listar() throws Exception;
	
	/**
	 * Colección de usuarios publicos. No se muestra password
	 * @return
	 * @throws Exception
	 */
	List<Usuario> listarPublicos() throws Exception;
	
	/**
	 * Creamos nuevo usuario por defecto rol ='Usuario', no es 'administrador'
	 * @param usuario
	 * @return true si crea, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre de usuario existe.
	 */
	boolean crear(Usuario usuario) throws Exception;
	
	/**
	 * Modificar todos los atributos de un usuario, podemos modificar el rol.
	 * @param usuario
	 * @return true si modifica, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre de usuario existe.
	 */
	boolean modificar(Usuario usuario) throws Exception;
	
	/**
	 * Eliminamos un usuario por ID
	 * @param idUsuario
	 * @return true si elimina, false si no encuentra el usuario.
	 * @throws Exception si el usuario tiene videos asociados.
	 */
	boolean eliminar(long idUsuario) throws Exception;
}
