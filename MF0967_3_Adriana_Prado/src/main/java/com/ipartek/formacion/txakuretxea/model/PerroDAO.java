package com.ipartek.formacion.txakuretxea.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.txakuretxea.pojo.Chip;
import com.ipartek.formacion.txakuretxea.pojo.Perro;

public class PerroDAO implements Crudable<Perro>{
	
	private static PerroDAO INSTANCE = null;
	private static List<Perro> lista = null;
	
	private PerroDAO() {
		lista = new ArrayList<Perro>();
		/*DD-DDDD-AAAA ( D: numero del 0 al 9, AAAA año del chip )*/
		lista.add(new Perro("Spyke", 7, "Collie", 15.50, true, "Un pequeño Collie que se rescató de la calle.", "images/collie.jpg", new Chip("11-1111-2000", "45", "45")));
		lista.add(new Perro("Suri", 10, "Shi-tzu", 9.75, false, "Un adorable shi-tzu que busca una familia.", "images/shitzu.jpg", new Chip("22-2222-2003", "100", "20")));
		lista.add(new Perro("Canela", 3, "Labrador", 4.33, false, "Una joven labrador muy juguetona y fiel.", "images/labrador.jpg", new Chip("33-3333-2015", "180", "90")));
		lista.add(new Perro("Brownie", 8, "milraza", 20.05, true, "Una perrita de color chocolate.", "images/mezcla.jpg", new Chip("44-4444-2008", "15", "15")));
		lista.add(new Perro("Dama", 14, "Pitbull", 13.90, true, "Una encantadora pitbull.", "images/pitbull.jpg", new Chip("55-5555-1999", "150", "50")));
	}
	
	public static synchronized PerroDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PerroDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Perro perro) {
		boolean resul = false;
		if (perro != null) {
			resul = lista.add(perro);
		}
		return resul;
	}

	@Override
	public List<Perro> getAll() {
		return lista;
	}

	@Override
	public Perro getById(long id) {
		Perro resul = null;
		if (id != 0) {
			for (Perro paginaIteracion : lista) {
				if (id == paginaIteracion.getId()) {
					resul = paginaIteracion;
					break;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Perro perroUpdate) {
		boolean resul = false;
		Perro perroIteracion = null;
		int i = 0;
		if (perroUpdate != null) {
			// Iterator
			Iterator<Perro> it = lista.iterator();
			while (it.hasNext()) {
				perroIteracion = it.next();
				if (perroIteracion.getId() == perroUpdate.getId()) {
					lista.set(i, perroUpdate);
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
		Perro pIteracion = null;
		if (id != 0) {
			// buscar producto a eliminar
			for (int i = 0; i < lista.size(); i++) {
				pIteracion = lista.get(i); // perro sobre el que iteramos
				if (id == pIteracion.getId()) { // perro encontrado
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
	
	public List<Perro> busqueda(String busqueda){
		ArrayList<Perro> perrosEncontrados = new ArrayList<Perro>();
		if(busqueda != null) {
			for(Perro perro : lista) {
				String nombreYchip = perro.getNombre()+perro.getChip();
				if(nombreYchip.toLowerCase().contains(busqueda.toLowerCase())) {
					perrosEncontrados.add(perro);
				}
			}
		}
		return perrosEncontrados;
	}
}
