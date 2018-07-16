package com.ipartek.formacion.ejercicios.interfaces;

import java.util.List;


import com.ipartek.formacion.pojo.Youtube;

public interface CrudAble {

	/**
	 * recupera todos los VideoYoutube
	 * 
	 * @return si no existen resultados retorna Lista vacia,no null
	 */

	/**
	 * Buscamos un VideoYoutube oir su identificador
	 * 
	 * @param id long identificador
	 * @return VideoYoutube si lo encuentra, null si no encuentra
	 */

	boolean update(Youtube video);

	boolean delete(long id);

	boolean insert(Youtube video);

	List<Youtube> getAll();

	Youtube getByID(long id);

}
