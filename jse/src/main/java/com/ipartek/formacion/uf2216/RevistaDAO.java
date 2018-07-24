package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.CrudAble;

public class RevistaDAO implements CrudAble<Revista> {

	static private final int TITULO_MIN = 3;
	static private final int TITULO_MAX = 150;
	static private final int LONG_ISBN = 10;

	private static RevistaDAO INSTANCE = null;
	private static List<Revista> lista = null;

	/**
	 * inicializa el array
	 */
	private RevistaDAO() {

		lista = new ArrayList<Revista>();
	}

	/**
	 * metodo de acceso al DAO
	 * 
	 * @return INSTANCE
	 */
	public static synchronized RevistaDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RevistaDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Revista pojo) {
		boolean resul = false;
		if (pojo != null) {

			resul = lista.add(pojo);
		}

		return resul;
	}

	@Override
	public List<Revista> getALl() {

		return lista;
	}

	@Override
	public Revista getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Revista pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertTitulo(String texto) {

		boolean resul = false;

		if (texto != null) {
			if (texto.length() < TITULO_MIN || texto.length() > TITULO_MAX) {
				resul = false;
			} else {
				resul = true;
			}
		}
		return resul;

	}

	public boolean insertISBN(String texto) {

		boolean resul = false;

		if (texto != null) {
			if (texto.length() != LONG_ISBN) {
				resul = false;

			} else {
				resul = true;
			}
		}
		return resul;

	}

}
