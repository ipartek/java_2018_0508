package com.ipartek.formacion.uf2216;

import java.util.List;

public interface CrudAble<P> {
	
	boolean insert(P pojo);
	

	List<P> getAll();
	
	
	P getById(long id);
	
	boolean update(P pojo);
	
	boolean delete(long id);


}
