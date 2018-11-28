package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

public interface IServiceUsuario {
	

	/**
	 * Devuelve el Usuario con el nombre y la contraseña introducidos. Null en caso contrario.
	 * @param nombre, String
	 * @param password, String
	 * @return com.ipartek.formacion.Usuario
	 * @throws Exception 
	 */
	Usuario login( String nombre, String password ) throws Exception;
	
	/**
	 * Buscamos un Usuario por su ID.
	 * @param id, long
	 * @return com.ipartek.formacion.Usuario
	 * @throws Exception, si no encuentra el ID introducido.
	 */
	Usuario buscarPorId( long id ) throws Exception;
	
	/**
	 * Devuelve una colección de usuarios limitado a 1000, ordenados por su ID en orden DESC.
	 * @return List<Usuario>
	 * @throws Exception 
	 */
	List<Usuario> listar( ) throws Exception;
	
	/**
	 * Devuelve una colección de usuarios públicos (No se muestra Password) limitado a 1000, ordenados por su ID en orden DESC.
	 * @return List<Usuario>
	 * @throws Exception 
	 */
	List<Usuario> listarPublicos( ) throws Exception;
	
	/**
	 * Se crea un usuario con el nombre y la contraseña introducidos. Por defecto, se le asigna un rol
	 * de cliente en la BBDD.
	 * @param usuario, Usuario
	 * @return  <b>true</b> <==> Usuario correctamente creado
	 * 			<b>false</b> en caso contrario.
	 * @throws Exception, si ha ocurrido algún error
	 */
	boolean crear( Usuario usuario ) throws Exception;
	
	/**
	 * Se modifica un usuario con el nombre y la contraseña introducidos. Permitiremos modificar
	 * el ROL del Usuario.
	 * @param usuario, Usuario
	 * @return  <b>True</b> <==> Usuario correctamente modificado.
	 * 			<b>False</b> en caso contrario.
	 * @throws Exception, si ha ocurrido algún error
	 */
	boolean modificar( Usuario usuario ) throws Exception;
	
	
	/**
	 * Se elimina de la BBDD el usuario con el ID introducido.
	 * @param ID, Long
	 * @param password, String
	 * @return  <b>True</b> <==> Usuario correctamente eliminado.
	 * 			<b>False</b>, en caso contrario.
	 * @throws Exception, si el usuario tiene registros asociados.
	 */
	boolean eliminar( long id ) throws Exception;

}
