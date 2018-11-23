package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * 
 * @author Curso
 *
 */
public interface IServiceComentario  {
	
	//No olvidarse del patron singleton
	
	//Iniciar sesion

	Comentario buscarPorId(long idComentario);
	
	/**
	 * Listado de usuarios limitado a 1000 ordenado de forma ascendente por id
	 * @return Listado de usuarios 
	 */
	List<Comentario> listar();
	
	/**Coleccion de listados publicos no se muestra password 
	 * 
	 */
	List<Comentario> listarPublicos();
	
	/**
	 * Creamos un nuevo usuario rol por defecto ROL == 'usuario' no es 'administrador'
	 * @param usuario u
	 * @return true, si crea, false si no crea
	 * @throws Exception Si no tenemos todos los atributos necesarios o el nombre de usuario existe
	 */
	boolean crear(Comentario u) throws Exception ;
	
	/**
	 * Se permite modificar todo
	 * @param usuario u
	 * @return true si modifica , false si no lo hace
	 * @throws Exception si no tenemos todos los atributos necesarios 
	 */
	boolean modificarComentario(Comentario u) throws Exception;
	
	
	/**
	 * 
	 * @param id
	 * @return true si elminar correctamente, false si no encuentra el usuario
	 * @throws Exception si tiene videos asociados 
	 */
	boolean eliminarUsuario(long id) throws Exception;
}
