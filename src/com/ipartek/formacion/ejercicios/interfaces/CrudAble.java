package com.ipartek.formacion.ejercicios.interfaces;

import java.util.List;


import com.ipartek.formacion.pojo.Youtube;

public interface CrudAble {

<<<<<<< HEAD
	/**
	 * recupera todos los VideoYoutube
	 * 
	 * @return si no existen resultados retorna Lista vacia,no null
	 */
=======
	boolean insert(Youtube video);
>>>>>>> branch 'valeriaValencia' of https://github.com/ipartek/java_2018_0508.git

	/**
<<<<<<< HEAD
	 * Buscamos un VideoYoutube oir su identificador
	 * 
	 * @param id long identificador
	 * @return VideoYoutube si lo encuentra, null si no encuentra
=======
	 * recupera todos los videos de Youtube
	 * 
	 * @return si no existe resultados retorna una lista vacua , no null
>>>>>>> branch 'valeriaValencia' of https://github.com/ipartek/java_2018_0508.git
	 */

<<<<<<< HEAD
	boolean update(Youtube video);
=======
	List<Youtube> getAll();
>>>>>>> branch 'valeriaValencia' of https://github.com/ipartek/java_2018_0508.git

<<<<<<< HEAD
	boolean delete(long id);
=======
	/**
	 * Buscamos un Youtube por su identificador
	 * 
	 * @param id long identificador
	 * @return si lo encuentra null si no esta
	 */
>>>>>>> branch 'valeriaValencia' of https://github.com/ipartek/java_2018_0508.git

<<<<<<< HEAD
	boolean insert(Youtube video);

	List<Youtube> getAll();

	Youtube getByID(long id);
=======
	Youtube getByID(long id);

	boolean update(Youtube video);

	boolean delete(long id);
>>>>>>> branch 'valeriaValencia' of https://github.com/ipartek/java_2018_0508.git

}
