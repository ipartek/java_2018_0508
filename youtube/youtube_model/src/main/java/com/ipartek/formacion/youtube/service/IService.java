package com.ipartek.formacion.youtube.service;

import java.util.List;

public interface IService<P> {

	boolean crear(P pojo)throws Exception;
	
	boolean modificar(P pojo)throws Exception;
	
	boolean eliminar(long id) throws Exception;
	
	P buscar(long id) throws Exception;
	
	List<P> listar() throws Exception;
}
