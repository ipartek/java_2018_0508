package com.adriana.prado.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.adriana.prado.pojo.Comentario;

public class ComentarioArrayDAO implements Crudable<Comentario>{
	
	private static ComentarioArrayDAO INSTANCE = null;
	private static List<Comentario> lista = null;
	
	private ComentarioArrayDAO() {
		lista = new ArrayList<Comentario>();
		try {
			lista.add(new Comentario("C1", "2018/09/01",
					"Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n" + 
					"							Omnis et enim aperiam inventore, similique necessitatibus neque\r\n" + 
					"							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.\r\n" + 
					"							Sequi mollitia, necessitatibus quae sint natus.", "xuoXkMZvD5Q", "pepe"));
			lista.add(new Comentario("C2", "2018/08/04", 
					"Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n" + 
					"							Omnis et enim aperiam inventore, similique necessitatibus neque\r\n" + 
					"							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.\r\n" + 
					"							Sequi mollitia, necessitatibus quae sint natus.", "xuoXkMZvD5Q", "pepe"));
			lista.add(new Comentario("C3", "2018/09/19",
					"Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n" + 
					"							Omnis et enim aperiam inventore, similique necessitatibus neque\r\n" + 
					"							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.\r\n" + 
					"							Sequi mollitia, necessitatibus quae sint natus.", "xuoXkMZvD5Q","manoli"));
			lista.add(new Comentario("C4", "2018/08/04", 
					"Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n" + 
					"							Omnis et enim aperiam inventore, similique necessitatibus neque\r\n" + 
					"							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.\r\n" + 
					"							Sequi mollitia, necessitatibus quae sint natus.", "xuoXkMZvD5Q", "pepe"));
			lista.add(new Comentario("C5", "2017/12/20",
					"Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n" + 
					"							Omnis et enim aperiam inventore, similique necessitatibus neque\r\n" + 
					"							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.\r\n" + 
					"							Sequi mollitia, necessitatibus quae sint natus.", "O71fetlkCZo","admin"));
			lista.add(new Comentario("C5", "2018/05/30",
					"Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n" + 
					"							Omnis et enim aperiam inventore, similique necessitatibus neque\r\n" + 
					"							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.\r\n" + 
					"							Sequi mollitia, necessitatibus quae sint natus.", "O71fetlkCZo","josepo"));
			lista.add(new Comentario("C6", "2018/05/30",
					"Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n" + 
					"							Omnis et enim aperiam inventore, similique necessitatibus neque\r\n" + 
					"							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.\r\n" + 
					"							Sequi mollitia, necessitatibus quae sint natus.", "EOKAnomhHRg","admin"));
			lista.add(new Comentario("C7", "2017/02/14",
					"Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n" + 
					"							Omnis et enim aperiam inventore, similique necessitatibus neque\r\n" + 
					"							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.\r\n" + 
					"							Sequi mollitia, necessitatibus quae sint natus.", "EOKAnomhHRg","pepe"));
			lista.add(new Comentario("C8", "2016/03/21",
					"Lorem ipsum dolor sit amet, consectetur adipisicing elit.\r\n" + 
					"							Omnis et enim aperiam inventore, similique necessitatibus neque\r\n" + 
					"							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.\r\n" + 
					"							Sequi mollitia, necessitatibus quae sint natus.", "EOKAnomhHRg","manoli"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ComentarioArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ComentarioArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario comentario) {
		boolean resul = false;
		if (comentario != null) {
			resul = lista.add(comentario);
		}
		return resul;
	}

	@Override
	public List<Comentario> getAll() {
		return lista;
	}

	@Override
	public Comentario getById(String id) {
		Comentario resul = null;
		if (id != null) {
			for (Comentario comentarioIteracion : lista) {
				if (id.equals(comentarioIteracion.getId())) {
					resul = comentarioIteracion;
					break;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Comentario comentarioUpdate) {
		boolean resul = false;
		Comentario comentarioIteracion = null;
		int i = 0;
		if (comentarioUpdate != null) {
			// Iterator
			Iterator<Comentario> it = lista.iterator();
			while (it.hasNext()) {
				comentarioIteracion = it.next();
				if (comentarioIteracion.getId() == comentarioUpdate.getId()) {
					lista.set(i, comentarioUpdate);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Comentario vIteracion = null;
		if (id != null) {
			// buscar comentario a eliminar
			for (int i = 0; i < lista.size(); i++) {
				vIteracion = lista.get(i);
				if (id.equals(vIteracion.getId())) {
					resul = lista.remove(vIteracion);
					break;
				}
			}
		}		
		return resul;
	}
	
	public int length() {
		return lista.size();
	}
}
