package com.andrea.perez.youtube.service;

import java.util.List;

import com.andrea.perez.youtube.pojo.Usuario;

public interface IServiceUsuario{
	
	/**
	 * Login para iniciar sesión
	 * 
	 * @param nombre
	 * @param password
	 * @return Usuario si existe, null en caso contrario
	 */
	Usuario login(String nombre, String password);

	/**
	 * No se recupera sus videos
	 * 
	 * @param idUsuario
	 * @return
	 */
	Usuario buscarPorId(long idUsuario);

	/**
	 * Coleccion de usuarios limitado a 1000 y ordenado por id DESC.
	 * 
	 * @return
	 */
	List<Usuario> listar();

	/**
	 * Creamos un nuevo usuario con Rol por defecto 'usuario' que no es administrador.
	 * @param usuario
	 * @return true si crea, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre del usuario existe.
	 */
	boolean crear(Usuario usuario) throws Exception;

	/**
	 * Modifica todos los atributos de un usuario, podemos modificar el Rol.
	 * @param usuario
	 * @return si modifica, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre del usuario existe
	 */
	boolean modificar(Usuario usuario) throws Exception;
	
	
	/**
	 * Elimina un usuario por su id
	 * @param usuario
	 * @return true si elimina, false si no lo encuentra
	 * @throws Exception si tiene video asociados.
	 */
	boolean eliminar(long idUsuario)throws Exception;
}
