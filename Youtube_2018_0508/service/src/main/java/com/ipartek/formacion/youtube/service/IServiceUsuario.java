package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

public interface IServiceUsuario extends Singleton<IServiceUsuario>{

	/**
	 * Login para iniciar sesión
	 * @param nombre String nombre de usuario
	 * @param pswd String contraseña de usuario
	 * @return Usuario si existe, null en caso contrario
	 */
	Usuario login(String nombre, String pswd);
	
	/**
	 * Buscar el detalle de un usuario a partir de un id. No recupera sus videos
	 * @param id long identificador del usuario
	 * @return Usuario si existe, null en caso contrario
	 */
	Usuario buscarPorId(long id);
	
	/**
	 * Coleccion de usuarios limitado a 1000 y orden descendente
	 * @return List<Usuarios>
	 */
	List<Usuario> listar();
	
	/**
	 * Creacion de un nuevo usuario. Por defecto rol = usuario (id: 2), no administrador (id: 1)
	 * @param u pojo Usuario a insertar
	 * @return true si lo ha creado, false si ha ocurrido algun error
	 * @throws Exception si no se pasan todos los atributos necesarios o nombre de usuario ya existe en bbdd
	 */
	boolean crear(Usuario u) throws Exception;
	
	/**
	 * Modifica los atributos de un usuario. Podemos modificar el rol
	 * @param u pojo Usuario a modificar
	 * @return true si lo ha modificado, false si ha ocurrido algun error
	 * @throws Exception si no se pasan todos los atributos necesarios o nombre de usuario ya existe en bbdd
	 */
	boolean modificar(Usuario u) throws Exception;
	
	/**
	 * Eliminar un usuario
	 * @param id long identificador del Usuario a eliminar
	 * @return true si se ha podido eliminar, false si no lo encuentra
	 * @throws Exception si el Usuario a eliminar tiene videos asociados
	 */
	boolean eliminar(long id) throws Exception;
}
