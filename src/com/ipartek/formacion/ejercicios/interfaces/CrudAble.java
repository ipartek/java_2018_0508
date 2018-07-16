package com.ipartek.formacion.ejercicios.interfaces;

import java.util.List;

import com.ipartek.formacion.pojo.Youtube;

public interface CrudAble {

	boolean insert(Youtube video);

	/**
	 * recupera todos los videos de Youtube
	 * 
	 * @return si no existe resultados retorna una lista vacua , no null
	 */

	List<Youtube> getAll();

	/**
	 * Buscamos un Youtube por su identificador
	 * 
	 * @param id long identificador
	 * @return si lo encuentra null si no esta
	 */

	Youtube getByID(long id);

	boolean update(Youtube video);

	boolean delete(long id);

}
