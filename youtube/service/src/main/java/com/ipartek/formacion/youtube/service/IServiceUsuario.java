package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

public interface IServiceUsuario {
	
		
	/**
	 * Login para iniciar session
	 * @param nombre
	 * @param password
	 * @return Usuario si existe, null en caso contrario
	 */
	Usuario login( String nombre, String password);

	/**
	 * No recuperamos sus videos
	 * @param idUsurio
	 * @return
	 */
	Usuario buscarPorId( long idUsurio );
	
	/**
	 * Coleccion de usuarios limitado a 1000 y orden desc por id
	 * @return
	 */
	List<Usuario> listar();
	
	/**
	 * Coleccion de usuario publicos, no se muestra password
	 * @return
	 */
	List<Usuario> listarPublicos();
	
	/**
	 * Creamos un nuevo usuario, por defecto ROL == ' usuario', no es 'administrador'
	 * @param usuario
	 * @return true si crea, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre del usuario existe en la bbdd
	 */
	boolean crear(Usuario usuario) throws Exception;
	
	/**
	 * Modificar todos los atributos de un Usuario, podemos modificar el ROL
	 * @param usuario
	 * @return true si modificamos, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre del usuario existe en la bbdd
	 */
	boolean modificar(Usuario usuario) throws Exception;
	
	/**
	 * Elimina fisicamente un usuario
	 * @param idUsurio
	 * @return true si elimina, false si no encuentra el usuario
	 * @throws Exception si tiene videos asociados
	 */
	boolean eliminar(long idUsurio) throws Exception;

	
}