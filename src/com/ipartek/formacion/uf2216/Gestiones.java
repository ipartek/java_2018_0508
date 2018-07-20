package com.ipartek.formacion.uf2216;

import java.util.List;

/**
 * Interfaz que declara los metodos para gestionar revistas
 * <ul>
 * <li>Listar<li>
 * <li>Anadir<li>
 * <li><Buscar por IDli>
 * @author Curso
 *
 * @param <P>
 */
public interface Gestiones<P> {
	
	List<P> GetAll();
	
	P getById(long id);
	
	boolean insert(P pojo);	

}
