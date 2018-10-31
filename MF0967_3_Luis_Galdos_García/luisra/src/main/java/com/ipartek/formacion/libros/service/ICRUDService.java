package com.ipartek.formacion.libros.service;

import java.util.List;

public interface ICRUDService<P> {
	
	List<P> listar() throws Exception;
	
	P obtener(long id) throws Exception;
	
	boolean crear(P pojo) throws Exception;	// INSERT
	
	boolean modificar(P pojo) throws Exception;	//	UPDATE
	
	boolean eliminar(String id) throws Exception;	//	DELETE
	
	

}
