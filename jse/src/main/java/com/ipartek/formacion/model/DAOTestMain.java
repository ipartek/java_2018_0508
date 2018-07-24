package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

public class DAOTestMain {
	
	public static void main(String[] args) {
		
		List<String> canciones= new ArrayList<String>();
		
		canciones.add("Sultans of Swing");
		canciones.add("Thunderstorm");
		canciones.add("Yellow submarine");
		
		for (int i = 0; i < canciones.size(); i++) {
			System.out.println(canciones.get(i));
				
		}
		
		canciones.get(0);
		
		canciones.remove(1); //borramos Thunderstorm
		
		canciones.set(1, "Adventure of a life"); //Yellow submarine pasa a 1 y la modificamos
		
		System.out.println(canciones);
		
		
	}

}
