package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;

public class JugandoPadreHijo {
	public static void main(String[] args) throws Exception {

		LibroElectronico le = new LibroElectronico();

		le.setTitulo("Lorem Ipsum");
		System.out.println(le.toString());

		Libro l = new Libro("iiii55", "Libro de la selva", "Amazonas", true);
		// No se pueden instancias objeto de clases abstractas
		// ObjetoGrafico o = new ObjetoGrafico ();
		ObjetoGrafico o = new ObjetoGrafico() {

			@Override
			void dibujar() {

			}
		};

		Circulo circulo = new Circulo();
		circulo.dibujar();
		System.out.println(circulo);
		// array con todos los libros mezclados
		ArrayList<Libro> stock = new ArrayList<Libro>();

		Libro libro = new Libro();
		libro.setTitulo("La historia interminable ");

		Ebook ebook = new Ebook();
		ebook.setTitulo("Etolda Joasak");

		stock.add(libro);
		stock.add(ebook);

		for (Libro libroIteracion : stock) {
			if (libroIteracion instanceof Ebook) {
				Ebook ebook2 = (Ebook) libroIteracion;
				ebook2.encenderLuz();
				System.out.println("Soy un Ebook " + ebook2.getTitulo());
			} else {
				System.out.println(libroIteracion.getTitulo());

			}

		}

	}
}
