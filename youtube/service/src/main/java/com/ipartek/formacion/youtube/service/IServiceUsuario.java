package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.UsuarioPublico;

public interface IServiceUsuario {
	
	/**
	 * Login para iniciar sesión.
	 * @param nombre
	 * @param password
	 * @return Usuario si existe, null en caso contrario.
	 */
	Usuario login(String nombre, String password);
	
	/**
	 * Busca un usuario por su id, no recuperamos sus videos.
	 * @param idUsuario
	 * @return Usuario si existe, null en caso contrario.
	 */
	Usuario buscarPorId(long idUsuario);
	
	/**
	 * Colección de usuarios (ADMINISTRADORES Y USUARIOS) limitados a 1000 y orden desc por id.
	 * @return
	 */
	List<Usuario> listar();
	
	/**
	 * Colección de usuarios públicos, no se muestra password.
	 * @return
	 */
	List<UsuarioPublico> listarPublicos();
	
	/**
	 * Crea un nuevo usuario, por defecto ROL = 'usuario', no es 'administrador'.
	 * @param usuario
	 * @return true si crea, false en caso contrario.
	 * @throws Exception si no tenemos todos los atributos necesarios o el nombre del usuario existe en la BBDD.
	 */
	boolean crear(Usuario usuario) throws Exception;
	
	/**
	 * Modificar todos los atributos de un usuario, podemos modificar el ROL.
	 * @param usuario
	 * @return true si modifica, false en caso contrario.
	 * @throws Excption si no tenemos todos los atributos necesarios o el nombre del usuario existe en la BBDD.
	 */
	boolean modificar(Usuario usuario) throws Exception;
	
	/**
	 * Elimnina fisicamente un usuario.
	 * @param idUsuario
	 * @return true si elimina, false si no encuentra el usuario.
	 * @throws Exception si el usuario a eliminar tiene videos asociados.
	 */
	boolean eliminar(long idUsuario) throws Exception;
	
}
