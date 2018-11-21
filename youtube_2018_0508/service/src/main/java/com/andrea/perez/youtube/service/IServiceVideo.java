package com.andrea.perez.youtube.service;

import java.util.List;

import com.andrea.perez.youtube.pojo.Usuario;
import com.andrea.perez.youtube.pojo.Video;

public interface IServiceVideo{
	
	/**
	 * Creamos un nuevo video
	 * @param video
	 * @return true si crea, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el codigo ya exista.
	 */
	boolean crear(Video video) throws Exception;

	/**
	 * recuperamos un video por su identificador
	 * 
	 * @param idUsuario
	 * @return
	 */
	Video buscarPorId(long idVideo);

	/**
	 * Coleccion de videos limitado a 1000 y ordenado por id DESC.
	 * 
	 * @return
	 */
	List<Video> listar();

	/**
	 * Modifica todos los atributos de un video.
	 * @param video
	 * @return si modifica, false en caso contrario
	 * @throws Exception si no tenemos todos los atributos necesarios o el codigo ya exista en la base de datos.
	 */
	boolean modificar(Video video) throws Exception;	
	
	/**
	 * Elimina un video por su id
	 * @param video
	 * @return true si elimina, false si no lo encuentra
	 * @throws Exception si tiene video asociados.
	 */
	boolean eliminar(long idVideo)throws Exception;
}
