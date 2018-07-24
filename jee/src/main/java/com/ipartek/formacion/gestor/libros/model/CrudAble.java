package com.ipartek.formacion.gestor.libros.model;

import java.util.List;

public interface CrudAble<P> {

	boolean insert(P pojo);

	/**
	 * recupera todos los videos de Youtube
	 * 
	 * @return si no existe resultados retorna una lista vacua , no null
	 */

	List<P> getAll();

	/**
	 * Buscamos un Youtube por su identificador
	 * 
	 * @param id long identificador
	 * @return si lo encuentra null si no esta
	 */

	P getByID(long id);

	boolean update(P pojo);

	boolean delete(long id);

}
