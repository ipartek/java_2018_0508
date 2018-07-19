package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.libreria.Libro;
import com.ipartek.formacion.libreria.LibroElectronico;

public class JugandoPadreHijo {

	public static void main(String[] args) throws Exception {

		LibroElectronico le = new LibroElectronico();

		le.setTitulo("Lorem ipsum");

		System.out.println(le.toString());

		Libro l = new Libro(1, "iiiiii", "Libro de la selva", "Amazonas", true);
		System.out.println(l);
		// ObjetoGrafico o = new ObjetoGrafico() {}
		// NO se pueden instanciar objetos de clases abstractas
		ObjetoGrafico o = new ObjetoGrafico() {

			@Override
			void dibujar() {
				// TODO Auto-generated method stub

			}

		};

		Circulo circulo = new Circulo();
		circulo.dibujar();

		// array con todos los libros mezclados
		ArrayList<Libro> stock = new ArrayList<Libro>();

		Libro libro = new Libro();
		libro.setTitulo("La historia interminable");

		Ebook ebook = new Ebook();
		ebook.setTitulo("Estolda jolasak");

		stock.add(libro);
		stock.add(ebook);

		// recorrer array
		for (Libro libroIteracion : stock) {

			if (libroIteracion instanceof Ebook) {
				Ebook ebook2 = (Ebook) libroIteracion;
				ebook2.encenderLuz();
				System.out.println("Soy un ebook ->" + ebook2.getTitulo());
			} else {

				System.out.println(libroIteracion.getTitulo());
			}

		}

	}

}
