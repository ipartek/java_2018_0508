package com.ipartek.formacion.prestamos_libros.service;

import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Usuario;

public interface IServiceUsuario {
	boolean crear(Usuario u) throws Exception;

	boolean modificar(Usuario u) throws Exception;

	boolean eliminar(long id) throws Exception;

	List<Usuario> listar() throws Exception;

	Usuario buscarId(long id) throws Exception;

}
