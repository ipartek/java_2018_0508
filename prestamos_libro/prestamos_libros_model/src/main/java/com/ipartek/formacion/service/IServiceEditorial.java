package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Editorial;

public interface IServiceEditorial {
	
	/**
	 * Funcion que crear una nueva editorial
	 * @param Editorial e
	 * @return  long id, si id>0==correcto sino no se ha creado
	 * @throws Exception
	 */
	boolean crear(Editorial e) throws Exception;
	
	/**
	 * Funcion para modificar los datos de una editorial
	 * @param Editorial e
	 * @return true si se modifica correctamente la Editorial, false si no se ha conseguido modificar
	 * @throws Exception
	 */
	boolean modificar(Editorial e) throws Exception;
	
	/**
	 * Funcion para eliminar una editorial existente
	 * @param id long identificador de la editorial
	 * @return true si se elimina correctamente la Editorial, false si no se ha conseguido eliminar
	 * @throws Exception
	 */
	boolean eliminar(long id) throws Exception;
	
	/**
	 * Funcion que retorna un objeto Editorial si se encuentra
	 * @param id long identificador de la editorial
	 * @return Editorial e
	 * @throws Exception
	 */
	Editorial buscarPorId(long id) throws Exception;
	
	/**
	 * Funcion que devuelve todos las Editoriales que hay
	 * @return List<Editorial>
	 * @throws Exception
	 */
	List<Editorial> listar() throws Exception;
}
