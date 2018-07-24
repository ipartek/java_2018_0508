package com.ipartek.formacion.model;

import java.util.*;

import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.pojo.VideoYoutube;


/**
* Clase DAO para gestionar usuarios con ArrayList Usamos patron
* Singleton
* 
* @see https://es.wikipedia.org/wiki/Singleton#Java
* @author Curso
*
*/

public class UsuarioArrayDAO implements CrudAble<Usuario> {

	private static UsuarioArrayDAO INSTANCE = null;
	private static List<Usuario> lista = null;

	private UsuarioArrayDAO() {
		lista = new ArrayList<Usuario>();
	}

	
	@Override
	public boolean insert(Usuario usuario) {
		boolean resul = false;
		if (usuario != null) {
			resul = lista.add(usuario);
		}
		return resul;
	}

	@Override
	public List<Usuario> getAll() {
		return lista;
	}

	@Override
	public Usuario getById(long id) {
		Usuario resul = null;
		//foreach
		for (Usuario usuarioIteracion : lista) {
			if ( id == usuarioIteracion.getId() ) {
				resul = usuarioIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Usuario usuarioUpdate) {
		boolean resul = false;
		Usuario usuarioIteracion = null;
		int i = 0;
		if ( usuarioUpdate != null ) {
			//Iterator		
			Iterator<Usuario> it = lista.iterator();
			while( it.hasNext() ) {
				usuarioIteracion = it.next();
				if ( usuarioIteracion.getId() == usuarioUpdate.getId() ) {
					lista.set(i, usuarioUpdate);
					resul = true;
					break;					
				}	
				i++;
			}		
		}	
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		
		Usuario uIteracion = null;
		
		//buscar usuario a eliminar
		for (int i = 0; i < lista.size(); i++) {
			
			uIteracion = lista.get(i);   //usuario sobre el que iteramos
			
			if ( id == uIteracion.getId() ) {    // usuario encontrado
				resul = lista.remove(uIteracion);
				break;
			}
		}
		
		return resul;
	}

	
}
