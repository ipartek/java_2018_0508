package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Video;

public interface IServiceVideo extends Singleton<IServiceVideo> {
	
	/**
	 * Coleccion de videos limitad a 1000 y en orden descendente
	 * @return List<Video> listado de todos los videos existentes
	 */
	List<Video> listar();
	
	/**
	 * Busca el detalle de un video a partir de un id
	 * @param id long identificador del Video
	 * @return pojo Video si existe, null en caso contrario
	 */
	Video buscarPorId(long id);
	
	/**
	 * Crea un nuevo video
	 * @param v Pojo video
	 * @return true si se ha creado, false si ha ocurrido algun error
	 * @throws Exception si no se pasan todos los atributos necesarios o si el codigo ya existe
	 */
	boolean crear(Video v) throws Exception;
	
	/**
	 * Modifica los valores de un Video en concreto
	 * @param v pojo Video a modificar
	 * @return true si se ha modificado, false si ha ocurrido algun error
	 * @throws Exception si el codigo ya existe
	 */
	boolean modificar(Video v) throws Exception;
	
	/**
	 * Elimina un video de la bbdd
	 * @param id long identificador del video a eliminar
	 * @return true si se ha eliminado, false si no lo ha encontrado
	 */
	boolean eliminar(long id);
	
}
