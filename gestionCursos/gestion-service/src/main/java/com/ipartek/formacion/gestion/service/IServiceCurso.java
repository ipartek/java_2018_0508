package com.ipartek.formacion.gestion.service;

import java.util.List;

import com.ipartek.formacion.gestion.pojo.Curso;

public interface IServiceCurso {
	
	/**
	 * Lista de cursos mas profesor  
	 * @return
	 */
	List<Curso> listar();

}
