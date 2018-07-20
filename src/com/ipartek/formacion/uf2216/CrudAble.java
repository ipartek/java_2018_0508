package com.ipartek.formacion.uf2216;



public interface CrudAble<P> {

	boolean insert(P pojo);

	P getByID(long id);

	boolean update(P pojo);

	boolean delete(long id);

}
