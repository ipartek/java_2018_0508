package com.ipartek.formacion.prestamos_libros.service;

import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Libro;

public interface IServiceLibro {
	boolean crear(Libro l) throws Exception;

	boolean modificar(Libro l) throws Exception;

	boolean eliminar(long id) throws Exception;

	List<Libro> listar() throws Exception;

	Libro buscarId(long id) throws Exception;

}
