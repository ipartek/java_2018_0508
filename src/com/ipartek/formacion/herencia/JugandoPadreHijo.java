package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Ebook;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;

public class JugandoPadreHijo {

	public static void main(String[] args) throws Exception {

		LibroElectronico le = new LibroElectronico();
		
		le.setTitulo("La novela mas larga del mundo.");
		
		System.out.println(le);
		
		Libro l = new Libro(1, "Libro de la Selva", "123456789", "Amazonas", true);
		
		ArrayList<Libro> stock = new ArrayList<Libro>();

		Ebook e = new Ebook();
		e.setTitulo("Estolda jolasak");
		
		stock.add(l);
		stock.add(e);
		
		for (Libro libroIteracion : stock) {
			
			if (libroIteracion instanceof Ebook) {
				((Ebook)libroIteracion).encenderLuz();
			}else {
				System.out.println(libroIteracion.getTitulo());
			}
			
		}
		
		//TODO Hacer jerarquia, libro, libroelectronico, ebook, libropapel
		
		//TODO interfaces: serializable, imprimible, interfaz1, interfaz2
		
		//TODO todas vacias excepto imprimible imprimir
		
	}

}
