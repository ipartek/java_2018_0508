package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.UsuarioPrivado;

public interface IServiceUsuario {

	/**
	 * Login para iniciar sesión en la app.
	 * 
	 * @param nombre
	 * @param password
	 * @return Usuario si existe, null en caso contrario.
	 */
	Usuario login(String nombre, String password);

	/**
	 * No recuperamos sus videos.
	 * 
	 * @param idUsuario
	 * @return Usuario si existe, null en caso contrario.
	 */
	Usuario buscarPorIdPublico(long idUsuario);

	UsuarioPrivado buscarPorIdPrivado(long idUsuario);

	/**
	 * Colección de usuarios registrados en la app.
	 * 
	 * @return Listado de usuarios orednados por Id y orden desc, limitados a 1000;
	 */
	List<Usuario> listarPublico();

	List<UsuarioPrivado> listarPrivado();

	/**
	 * Creamos un nuevo usuario, por defecto ROL=='usuario' no es administrador.
	 * 
	 * @param usuario.
	 * @return true si lo crea, false en caso contrario.
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre
	 *                   del usuario ya existe en la BBDD.
	 */

	boolean crear(UsuarioPrivado usuario) throws Exception;

	/**
	 * Modificamos los datos de un usuario existente en la BBDD incluido el ROL.
	 * 
	 * @param usuario
	 * @return true si se modifica con exito, false en caso contrario.
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre
	 *                   del usuario ya existe en la BBDD.
	 */
	boolean modificar(Usuario usuario) throws Exception;

	/**
	 * Eliminar un usuario por su id.
	 * 
	 * @param idUsuario
	 * @return true si el usuario se elimina, false si no existe el usuario.
	 * @throws Exception Si el usuario tiene videos asociados.
	 */
	boolean eliminar(long idUsuario) throws Exception;
}
