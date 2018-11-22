package com.ipartek.formacion.gestiondocente.service;

import java.util.List;

import com.ipartek.formacion.gestiondocente.pojo.Curso;

public interface IServiceCurso {

	/**
	 * Lista todos los cursos disponibles en Ipartek
	 * 
	 * @return Lista de los cursos indicando nombre y apellidos del profesor que lo
	 *         imparte y el nombre y apellidos de los alumnos que participan.
	 */
	List<Curso> listar();
}
