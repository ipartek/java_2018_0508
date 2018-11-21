package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

public interface IServiceUsuario extends Singleton<IServiceUsuario>{
	
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
	 * Coleccion de usuarios limitado a 1000 y order desc por id
	 * @return Lista de usuarios
	 */
	List<Usuario> listar();
	
	/**
	 * Creamos un nuevo usuario, por defecto ROL == 'usuario', no es 'administrador'
	 * @param usuario
	 * @return true si crea, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre del usuario existe en la bbdd
	 */
	boolean crear(Usuario usuario) throws Exception;
	
	/**
	 * Modificar todos los atributos de un Usuario y tambien podemos modificar el ROL
	 * @param usuario
	 * @return true si modifica, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre del usuario existe en la bbdd
	 */
	boolean modificar(Usuario usuario) throws Exception;
	
	/**
	 * Elimina fisicamente un usuario
	 * @param idUsuario
	 * @return true si elimina, false en caso contrario
	 * @throws Exception si tiene videos asociados
	 */
	boolean eliminar(long idUsuario) throws Exception;

}
