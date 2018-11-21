package com.ipartek.formacion.youtube.service;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

public interface IServiceVideo extends Singleton<IServiceVideo> {

	/**
	 * Creamos un nuevo video
	 * @param video
	 * @return true si el video se crea, false en caso contrario.
	 * @throws Exception si el código del video ya existe.
	 */
	boolean crear(Video video) throws Exception;
	
	
	/**
	 * Eliminamos un video por si id
	 * @param idVideo
	 * @return true si el video se elimina, false en caso contrario.
	 * @throws Exception
	 */
	boolean eliminar(long idVideo)throws Exception;
	
	
	/**
	 * Colección de videos registrados en la app.
	 * @return listado de los videos registrados en la app.
	 */
	List<Video> listar();
	
	/**
	 * Recuperamos un video por su id.
	 * @param idVideo
	 * @return Video si existe, null en caso contrario.
	 */
	Video buscarPorId(long idVideo);
}
