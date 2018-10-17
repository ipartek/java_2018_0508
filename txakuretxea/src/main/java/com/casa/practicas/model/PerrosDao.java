package com.casa.practicas.model;



import java.util.ArrayList;
import java.util.List;

import com.casa.practicas.pojo.Chip;
import com.casa.practicas.pojo.Perro;
import com.casa.practicas.pojo.Usuario;





public class PerrosDao implements CrudAble<Perro> {

	private static PerrosDao INSTANCE = null;
	private static List<Perro> perros = null;
	private Perro perro;
	private PerrosDao() {
		perros = new ArrayList<Perro>();
		perros.add(new Perro(1,"scooby",3,"pequinas",2.5,new Chip(),false,"https://as01.epimg.net/epik/imagenes/2018/04/28/portada/1524913221_572475_1524913364_noticia_normal.jpg"));
		perros.add(new Perro(2,"perro2",3,"pequinas",2.5,new Chip(),false,"data:image/jpeg;base64,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"));
		perros.add(new Perro(3,"perro3",3,"pequinas",2.5,new Chip(),true,"https://www.nationalgeographic.com.es/medio/2018/02/27/dos-perros-puli-corren-en-la-nieve__800x800.jpg"));
		perros.add(new Perro(4,"perro4",3,"pequinas",2.5,new Chip(),true,"https://www.hogarmania.com/archivos/201710/perros-blancos-848x477x80xX.jpg"));
		perros.add(new Perro(5,"perro5",3,"pequinas",2.5,new Chip(),false,"https://media.telemundo51.com/images/652*426/AHORA-PARQUE-PERROS.JPG"));

		
	}

	public static synchronized PerrosDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PerrosDao();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Perro pojo) {
		return perros.add(pojo);
	}

	@Override
	public List<Perro> getAll() {
		return perros;
	}

	@Override
	public Perro getById(String id) {
		Perro resul = null;
		if (id != null) {
			for (Perro p : perros) {
				if (id.equals(p.getId())) {
					resul = p;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Perro pojo) {
		Perro perroActualizar = null;
		boolean flag = false;
		if(pojo != null) {
			for(Perro p : perros) {
				if(pojo.getId() == p.getId()) {
					p = pojo;
					flag = true;
				}
			}
			
		}
		return flag;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Perro p = null;
		if ( id != null ) { 
			for (int i = 0; i < perros.size(); i++) {
				p = perros.get(i); 
				if (id.equals(p.getId()) ) { 
					resul = perros.remove(p);
					break;
				}
			}
		}	
		return resul;
	}



}