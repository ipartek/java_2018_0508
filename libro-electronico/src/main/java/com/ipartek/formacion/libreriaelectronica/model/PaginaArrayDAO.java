package com.ipartek.formacion.libreriaelectronica.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaginaArrayDAO implements Crudable<Pagina>{
	private static PaginaArrayDAO INSTANCE = null;
	private static List<Pagina> lista = null;

	private PaginaArrayDAO() {
		lista = new ArrayList<Pagina>();
		try {
			lista.add(new Pagina(0, 
					"Érase una vez...", "Lorem ipsum dolor sit amet consectetur adipiscing, elit nisi leo ante praesent morbi, turpis tincidunt dapibus eu auctor. "
							+ "Bibendum est vestibulum orci neque hendrerit dictumst ligula arcu imperdiet, purus dis fermentum dui conubia cursus maecenas. "
							+ "Metus sodales montes interdum gravida nostra libero imperdiet a vestibulum, morbi non tristique volutpat leo integer eu rutrum, molestie placerat accumsan penatibus semper etiam sem suscipit.\r\n" 
							+ "Ornare tellus vehicula nibh sapien nostra fermentum, phasellus curae ac senectus tincidunt pharetra neque, in nam ligula porttitor habitasse. "
							+ "Natoque ultrices egestas euismod phasellus lacinia sollicitudin cubilia erat, integer commodo facilisis curabitur laoreet dapibus sagittis dictumst, auctor dui himenaeos interdum hendrerit platea sodales. "
							+ "Bibendum nullam laoreet pulvinar turpis tempus etiam, porta scelerisque morbi placerat suspendisse nascetur, sagittis tristique pharetra posuere vitae.", "Anónimo"));
			
			lista.add(new Pagina(1, 
					"Titulo pagina 1", "Lorem ipsum dolor sit amet consectetur adipiscing, elit nisi leo ante praesent morbi, turpis tincidunt dapibus eu auctor. "
							+ "Bibendum est vestibulum orci neque hendrerit dictumst ligula arcu imperdiet, purus dis fermentum dui conubia cursus maecenas. "
							+ "Metus sodales montes interdum gravida nostra libero imperdiet a vestibulum, morbi non tristique volutpat leo integer eu rutrum, molestie placerat accumsan penatibus semper etiam sem suscipit.\r\n" 
							+ "Ornare tellus vehicula nibh sapien nostra fermentum, phasellus curae ac senectus tincidunt pharetra neque, in nam ligula porttitor habitasse. "
							+ "Natoque ultrices egestas euismod phasellus lacinia sollicitudin cubilia erat, integer commodo facilisis curabitur laoreet dapibus sagittis dictumst, auctor dui himenaeos interdum hendrerit platea sodales. "
							+ "Bibendum nullam laoreet pulvinar turpis tempus etiam, porta scelerisque morbi placerat suspendisse nascetur, sagittis tristique pharetra posuere vitae.", "William"));
			lista.add(new Pagina(2, 
					"Titulo pagina 2", "Lorem ipsum dolor sit amet consectetur adipiscing, elit nisi leo ante praesent morbi, turpis tincidunt dapibus eu auctor. "
							+ "Bibendum est vestibulum orci neque hendrerit dictumst ligula arcu imperdiet, purus dis fermentum dui conubia cursus maecenas. "
							+ "Metus sodales montes interdum gravida nostra libero imperdiet a vestibulum, morbi non tristique volutpat leo integer eu rutrum, molestie placerat accumsan penatibus semper etiam sem suscipit.\r\n" 
							+ "Ornare tellus vehicula nibh sapien nostra fermentum, phasellus curae ac senectus tincidunt pharetra neque, in nam ligula porttitor habitasse. "
							+ "Natoque ultrices egestas euismod phasellus lacinia sollicitudin cubilia erat, integer commodo facilisis curabitur laoreet dapibus sagittis dictumst, auctor dui himenaeos interdum hendrerit platea sodales. "
							+ "Bibendum nullam laoreet pulvinar turpis tempus etiam, porta scelerisque morbi placerat suspendisse nascetur, sagittis tristique pharetra posuere vitae.", "Pablo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized PaginaArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new PaginaArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Pagina pagina) {
		boolean resul = false;
		if (pagina != null) {
			resul = lista.add(pagina);
		}
		return resul;
	}

	@Override
	public List<Pagina> getAll() {
		return lista;
	}

	@Override
	public Pagina getById(long id) {
		Pagina resul = null;
		if (id != 0) {
			for (Pagina paginaIteracion : lista) {
				if (id == paginaIteracion.getId()) {
					resul = paginaIteracion;
					break;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Pagina paginaUpdate) {
		boolean resul = false;
		Pagina paginaIteracion = null;
		int i = 0;
		if (paginaUpdate != null) {
			// Iterator
			Iterator<Pagina> it = lista.iterator();
			while (it.hasNext()) {
				paginaIteracion = it.next();
				if (paginaIteracion.getId() == paginaUpdate.getId()) {
					lista.set(i, paginaUpdate);
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
		Pagina pIteracion = null;
		if (id != 0) {
			// buscar producto a eliminar
			for (int i = 0; i < lista.size(); i++) {
				pIteracion = lista.get(i); // pagina sobre el que iteramos
				if (id == pIteracion.getId()) { // pagina encontrado
					resul = lista.remove(pIteracion);
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
