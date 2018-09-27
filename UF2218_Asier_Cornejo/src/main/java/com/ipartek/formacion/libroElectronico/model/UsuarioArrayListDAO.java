package com.ipartek.formacion.libroElectronico.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.libroElectronico.model.pojo.Pagina;
import com.ipartek.formacion.libroElectronico.model.pojo.Usuario;

public class UsuarioArrayListDAO implements CrudAble<Usuario> {

	private static UsuarioArrayListDAO INSTANCE = null;
	private static List<Usuario> usuarios = null;

	private UsuarioArrayListDAO() {
		usuarios = new ArrayList<Usuario>();
		try {
			usuarios.add(new Usuario(1,"William", "Shakespeare"));
			usuarios.add(new Usuario(2,"Cervantes", "Saavedra"));
			usuarios.add(new Usuario(3,"Pablo", "Neruda"));
			usuarios.add(new Usuario(4,"Pablo", "Cohelo"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized UsuarioArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioArrayListDAO();
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
	public Usuario getById(int id) {
		Usuario resul = null;
		if (id>=0) {
			for (Usuario v : usuarios) {
				if (id==v.getId()) {
					resul = v;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		Usuario p = null;
		if (id >=0) {
			for (int i = 0; i < usuarios.size(); i++) {
				p = usuarios.get(i);
				if (id ==p.getId()) {
					resul = usuarios.remove(p);
					break;
				}
			}
		}
		return resul;
	}

}
