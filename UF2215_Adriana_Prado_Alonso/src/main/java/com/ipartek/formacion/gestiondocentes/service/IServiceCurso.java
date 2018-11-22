package com.ipartek.formacion.gestiondocentes.service;

import java.util.List;

import com.ipartek.formacion.gestiondocentes.pojo.Curso;

public interface IServiceCurso {
	/**
	 * Coleccion de cursos limitado a 1000 y orden descendente
	 * por codigo de curso
	 * @return List<Curso>
	 */
	List<Curso> listadoCursos();
	
	/**
	 * Coleccion de cursos mas los profesores que impartieron cada uno
	 * limitado a 1000 y orden descendente por codigo de curso
	 * @return List<Curso>
	 */
	List<Curso> listadoCursosProfesores();
	
	/**
	 * Coleccion de cursos mas los profesores que impartieron cada uno y
	 * los alumnos que se matricularon en cada uno de ellos
	 * limitado a 1000 y orden descendente por codigo de curso
	 * @return List<Curso>
	 */
	List<Curso> listadoCursosProfesoresAlumnos();
}
