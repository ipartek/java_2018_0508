package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

public interface IServiceUsuario extends Singleton<IServiceUsuario> {
	
	/**
	 * Login para iniciar session
	 * @param nombre
	 * @param password
	 * @return Usuario si existe, null en caso contrario
	 */
	Usuario login( String nombre, String password);
	
	/** 
	 * No recuperamos sus videos
	 * @param idUsuario
	 * @return
	 */
	
	Usuario buscarPorId(long idUsuario);
	
	/**
	 * Coleccion de usuarios limitado a 1000 y orden desc por id
	 * @return
	 */
	List<Usuario> listar();
	/**
	 * Creammos un nuevo usuario, por defecto ROL == 'usuario', no es 'administrador'
	 * @param usuario
	 * @return true si crea, false en caso contrario
	 * @throws Exception si no tenemos todos los estributos necesarios o el nombre del usuario existe
	 */
	boolean crear (Usuario usuario) throws Exception;
	
	/**
	 * Modificar todos los atributos de un Usuario y  podemos modificar el ROL
	 * @param usuario
	 * @return true si modifica, false en caso contrario, false si no se encuentra 
	 * @throws Exception
	 */
	boolean modificar (Usuario usuario ) throws Exception;
	/**
	 * Eliminar fisicamente un usuario
	 * @param uModificar
	 * @return true si eliminar 
	 * @throws Exception si tiene videos asociados
	 */
	boolean eliminar (Usuario idUsuario) throws Exception;

}
