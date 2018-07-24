package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Ebook;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;

public class JugandoPadreEHijo {

	public static void main(String[] args) throws Exception {
		LibroElectronico le = new LibroElectronico();
		le.setTitulo("lorem Ipsum");
		System.out.println(le.toString());

		// Libro l = new Libro(1, "iiiwww", "El libro de la selva", "Amazonas", true);

		Circulo circulo = new Circulo();
		circulo.dibujar();

		// Arraycon todos los libros mezcaldo
		ArrayList<Libro> stock = new ArrayList<Libro>();

		Libro lib = new Libro();
		lib.setTitulo("La historia interminable");

		Ebook ebook = new Ebook();
		ebook.setTitulo("Estolda jolasak");

		stock.add(ebook);
		stock.add(lib);

		for (Libro libro : stock) {

			if (libro instanceof Ebook) {

				((Ebook) libro).encenderLuz();
				System.out.println("Soy un Ebook ->" + libro.getTitulo());

			} else {
				System.out.println(libro.getTitulo());
			}

		}

	}

}
