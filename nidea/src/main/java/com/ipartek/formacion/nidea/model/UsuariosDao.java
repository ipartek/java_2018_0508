package com.ipartek.formacion.nidea.model;

import java.util.ArrayList;
import java.util.List;


import com.ipartek.formacion.nidea.pojo.Usuario;




public class UsuariosDao implements CrudAble<Usuario> {
	private static UsuariosDao INSTANCE = null;
	private static ArrayList<Usuario> usuariosArray = null;
	private static boolean cargaProductos = false;

	private UsuariosDao() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		usuariosArray = new ArrayList<Usuario>();
		/*try {
			Productos.add(new Producto("Producto Demo", "prod-1", false, 10, "Lorem Lorem Lorem Lorem Lorem"));
			
		} catch (Exception e) {
			System.out.println("Error en ProductosDao");
		}*/
	}
	
	public static synchronized UsuariosDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuariosDao();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) {
		boolean result = false;

		if (pojo != null) {
			usuariosArray.add(pojo);
			result = true;
		}

		return result;
	}

	@Override
	public List<Usuario> getAll() {

		return usuariosArray;
	}

	@Override
	public Usuario getById(long id) {
		Usuario usuarioCoincidencia = null;
		if (id > 0) {
			for (Usuario u : usuariosArray) {
				if (u.getId() == id){
					usuarioCoincidencia = u;
				}
			}
		}
		return usuarioCoincidencia;
	}

	@Override
	public boolean update(Usuario pojo) {
		boolean flag = false;

		if (pojo != null) {
			for (int i = 0; i < usuariosArray.size(); i++) {
				if (usuariosArray.get(i).getId() == pojo.getId()) {
					usuariosArray.set(i, pojo);
					flag = true;
				}
			}
		}

		return flag;
	}

	@Override
	public boolean delete(long id) {
		boolean flag = false;
		if (id > 0) {
			for (Usuario u : usuariosArray) {
				if (u.getId() == id) {
					usuariosArray.remove(u);
					flag = true;
				}
			}
		}
		return flag;
	}
}
