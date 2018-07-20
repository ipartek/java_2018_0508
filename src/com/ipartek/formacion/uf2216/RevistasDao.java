package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;

public class RevistasDao implements CrudAble<Revistas> {

	private static RevistasDao INSTANCE = null;
	private static List<Revistas> revista = null;

	public static synchronized RevistasDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RevistasDao();
		}
		return INSTANCE;
	}

	private RevistasDao() {
		revista = new ArrayList<Revistas>();

	}

	public boolean insert(Revistas pojo) {
		boolean resul = false;
		if (pojo != null) {
			resul = revista.add(pojo);
		}
		return resul;
	}

	public List<Revistas> getAll() {

		return revista;
	}

	public Revistas getById(long id) {
		Revistas RevistaIteracion = null;
		Revistas resul = null;
		for (int i = 0; i < revista.size(); i++) {
			RevistaIteracion = revista.get(i);
			if (RevistaIteracion.getId() == id) {
				resul = RevistaIteracion;
				break;
			}
		}
		return resul;
	}

	public boolean update(Revistas pojo) {
		boolean resul = false;
		Revistas RevistaIteracion = null;
		int i = 0;
		// comprobamos si es null hacer comprobacion
		if (pojo != null) {
			// iterator
			Iterator<Revistas> it = revista.iterator();
			while (it.hasNext()) {
				RevistaIteracion = it.next();
				if (RevistaIteracion.getId() == pojo.getId()) {
					revista.set(i, pojo);
					resul = true;
					break;
				}

			}
		}
		return resul;
	}

	public boolean delete(long id) {

		boolean resul = false;
		Revistas RevistaIteracion = null;
		for (int x = 0; x < revista.size(); x++) {
			RevistaIteracion = revista.get(x);
			if (id == RevistaIteracion.getId()) {
				resul = revista.remove(RevistaIteracion);
			}
		}

		return resul;
	}

	public long calculeId() {
		/**
		 * Se llama desde la vista para calcular el id cuando insertamos en el arraylist
		 */
		long id;
		id = revista.size() + 1;
		return id;
		
		
	}

	public boolean resuelveFormato(int formato) {
		/**
		 * Input:Nos llega la eleccion del usuario en entero 1 para definir papel 2 para definir digital
		 * Output: sale false con 1 sale true con 2
		 */
		boolean formatoFix = false;
		if(formato == 1) {
			formatoFix = false;
		}else {
			if(formato == 2) {
				formatoFix = true;
			}
		}
		return formatoFix;
	}

	public List<Libro> listarRevistas() {
		
		for(Revistas rev : revista) {
			System.out.println(rev.toString());
		}
		System.out.println("llege");
		return null;
	}

	



}
