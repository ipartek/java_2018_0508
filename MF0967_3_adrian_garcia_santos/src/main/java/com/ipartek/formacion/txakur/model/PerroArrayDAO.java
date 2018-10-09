package com.ipartek.formacion.txakur.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.txakur.pojo.Chip;
import com.ipartek.formacion.txakur.pojo.Perro;

public class PerroArrayDAO implements CrudAble<Perro>{
	
	private static PerroArrayDAO INSTANCE = null;
	private static List<Perro> perros = null;
	
	private PerroArrayDAO() {
		perros = new ArrayList<Perro>();
		
		try {
			perros = new ArrayList<Perro>();
			perros.add(new Perro("Toby", 3, "Mastín", 7.3f, false, new Chip("08-7456-2015", 7.23456, 13.87654), "https://i.pinimg.com/originals/cc/59/5b/cc595b49d2a02b353f894f15304687ae.jpg"));
			perros.add(new Perro("Marley", 7, "Pastor", 15.8f, true, new Chip("91-6342-2011", 45.98765, -2.23456), "https://i.pinimg.com/originals/b8/da/05/b8da05ca3bf672d121719a0e9dd34089.jpg"));
			perros.add(new Perro("Nela", 14, "Beagle", 27.4f, true, new Chip("71-6021-2004", -45.09876543, 30.45678), "https://i.pinimg.com/236x/d6/dc/78/d6dc78febb72ce559a80a7707a874c2b--celiac-disease-setter-irland%C3%A9s.jpg"));
			perros.add(new Perro("Bimba", 1, "Labrador", 5.3f, false, new Chip("64-5291-2011", 7.23456, 13.87654), "https://i.pinimg.com/236x/f4/74/6d/f4746d8ce74d0c3dbbee548c3a811307--sheep-dogs-doggies.jpg"));
			perros.add(new Perro("Hannah", 5, "Caniche", 17.5f, false, new Chip("03-4108-2005", 45.98765, -2.23456), "https://empoweredbyknowledge.files.wordpress.com/2014/08/081514_1333_14.jpg?w=1200"));
			perros.add(new Perro("Coco", 9, "Beagle", 33.4f, true, new Chip("84-6201-2012", -45.09876543, 30.45678), "https://i.pinimg.com/originals/83/b2/ee/83b2ee2a440a910286df82e4a8b4aef3.jpg"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static synchronized PerroArrayDAO getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new PerroArrayDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(Perro perro) {
		
		boolean resultado = false;
		
		if(perro != null) {
			resultado = perros.add(perro);
		}
		return resultado;
		
	}

	@Override
	public List<Perro> getAll() {

		return perros;
	}

	@Override
	public Perro getById(String id) {
		Perro resultado = null;
		
		if(id != null && !"".equals(id)) {
			
			for(Perro p : perros) {
				
				if(id.equals(p.getChip().getId())) {
					resultado = p;
					break;
					
				}
			}
		}
		
		return resultado;
	}

	@Override
	public boolean update(Perro perro) {

		return false;
	}

	@Override
	public boolean delete(String id) {
		
		return false;
		
	}

}
