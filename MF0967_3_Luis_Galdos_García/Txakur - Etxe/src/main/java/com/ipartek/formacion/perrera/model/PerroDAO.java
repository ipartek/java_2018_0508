package com.ipartek.formacion.perrera.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.perrera.pojo.Chip;
import com.ipartek.formacion.perrera.pojo.Perro;

/**
 * Clase DAO para gestionar la clase Perro con ArrayList. Usamos el Patrón
 * Singleton.
 * 
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 * @author Curso
 *
 */
public class PerroDAO implements CrudAble<Perro> {

	private static PerroDAO INSTANCE = null;
	private static ArrayList<Perro> lista;
	
	//---------- CONSTRUCTOR ----------------//
	private PerroDAO() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		lista = new ArrayList<Perro>();
	}

	public static synchronized PerroDAO getInstance() {
		return (INSTANCE == null ? new PerroDAO() : INSTANCE);
	}
	
	
	public void cargarPerros() {
		
		Chip chip = new Chip("3000102010", 43.0, 43.00);
		Perro perro = new Perro(1, "Snoopy", "Labrador", 8, 24.5f, true, chip);
		perro.setImg("data:image/png;base64,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");
		lista.add(perro);
		
		chip = new Chip("200202015", 41.0, 243.00); 
		perro = new Perro(1, "Rocky", "Pastor Belga", 10, 36.5f, true, chip);
		perro.setImg("https://banner2.kisspng.com/20180327/ise/kisspng-german-shepherd-golden-retriever-puppy-clip-art-dogs-5aba18668bc441.0115280115221453825725.jpg");
		lista.add(perro);
		
		chip = new Chip("100302014", 123.0, 83.00); 
		perro = new Perro(1, "Scobby", "Milrazas", 10, 36.5f, false, chip);
		perro.setImg("http://www.stickpng.com/assets/images/59f87a353cec115efb3623a4.png");
		lista.add(perro);
		
		chip = new Chip("2210872015", 123.0, 83.00); 
		perro = new Perro(1, "Bethoveen", "San Bernardo", 3, 46.5f, false, chip);
		perro.setImg("https://banner2.kisspng.com/20180601/rkc/kisspng-german-pinscher-miniature-pinscher-puppy-st-berna-droopy-dog-5b10de50a0d494.9447176715278321446588.jpg");
		lista.add(perro);
				
	}


	//---------- GETTERS ----------------//
	@Override
	public List<Perro> getAll() {
		return lista;
	}

	public List<Perro> getAllAdoptados(boolean isApadrinado) {

		ArrayList<Perro> perrosAdoptados = new ArrayList<Perro>();
		if (lista.size() > 0) {

			for (Perro perro : lista) {
				if (perro.isEsApadrinado() == isApadrinado) {
					perrosAdoptados.add(perro);
				}
			}
		}
		return perrosAdoptados;
	}

	@Override
	public Perro getById(long id) {
		Perro Perro = null;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				Perro = lista.get(i);
				break;
			}
		}
		return Perro;
	}

	/**
	 * Busca  perros que coincida por nombre o por número de chip. Es ignoreCase y nos sirve cualquier
	 * coincidencia.
	 * 
	 * @param texto
	 * @return
	 */
	public ArrayList<Perro> busqueda(String texto) {
		ArrayList<Perro> perrosEncontrados = new ArrayList<Perro>();
		
		if (texto != null) {
			for (Perro perro : lista) {
				if (perro.getNombre().toLowerCase().contains(texto.toLowerCase().trim())) { // Coincide el nombre
					perrosEncontrados.add(perro);
				
				} else if (perro.getChip().getNumero().toLowerCase().contains(texto.toLowerCase().trim())) { // Coincide número de chip

					perrosEncontrados.add(perro);
				}
			}
		}
		return perrosEncontrados;

	}
	
	
	//---------- SETTERS ----------------//
	@Override
	public boolean insert(Perro pojo) {
		boolean result = false;

		if (pojo != null) {
			result = lista.add(pojo);
		}

		return result;
	}

	@Override
	public boolean update(Perro pojo) {
		boolean result = false;

		if (pojo != null) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == pojo.getId()) {
					lista.set(i, pojo);
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;

		for (Perro lIteracion : lista) {
			if (id == lIteracion.getId()) { // Perro encontrado
				result = lista.remove(lIteracion); // Eliminamos Perro y comprobamos
				break;
			}
		}

		return result;
	}

}
