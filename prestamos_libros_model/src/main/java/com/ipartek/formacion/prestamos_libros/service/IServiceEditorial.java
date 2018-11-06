package com.ipartek.formacion.prestamos_libros.service;

import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;

public interface IServiceEditorial {
	boolean crear(Editorial e) throws Exception;

	boolean modificar(Editorial e) throws Exception;

	boolean eliminar(long id) throws Exception;

	List<Editorial> listar() throws Exception;

	Editorial buscarId(long id) throws Exception;

}
