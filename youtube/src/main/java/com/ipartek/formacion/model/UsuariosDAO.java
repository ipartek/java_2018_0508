package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.pojo.Video;

public class UsuariosDAO implements CrudAble<Usuario> {

	private static UsuariosDAO INSTANCE = null;
	private static List<Usuario> usuarios = null;
	private Usuario usuariosObj;
	private UsuariosDAO() {
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario(1,"admin","admin@gmail.com","admin"));
		usuarios.add(new Usuario(2,"pepep","pepe@gmail.com","pepep"));
		usuarios.add(new Usuario(3,"manoli","manoli@gmail.com","manoli"));
		usuarios.add(new Usuario(3,"josepo","josepo@gmail.com","josepo"));
		
	}

	public static synchronized UsuariosDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuariosDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) {
		return usuarios.add(pojo);
	}

	@Override
	public List<Usuario> getAll() {
		return usuarios;
	}

	@Override
	public Usuario getById(String id) {
		Usuario resul = null;
		if (id != null) {
			for (Usuario u : usuarios) {
				if (id.equals(u.getId())) {
					resul = u;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Usuario pojo) {
		Usuario usuarioActualizar = null;
		boolean flag = false;
		if(pojo != null) {
			for(Usuario u : usuarios) {
				if(pojo.getId() == u.getId()) {
					u = pojo;
					flag = true;
				}
			}
			
		}
		return flag;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Usuario v = null;
		if ( id != null ) { 
			for (int i = 0; i < usuarios.size(); i++) {
				v = usuarios.get(i); 
				if (id.equals(v.getId()) ) { 
					resul = usuarios.remove(v);
					break;
				}
			}
		}	
		return resul;
	}



}