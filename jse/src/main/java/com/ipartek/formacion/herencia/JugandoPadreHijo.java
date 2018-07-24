package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Libro;

public class JugandoPadreHijo {

	public static void main(String[] args) throws Exception {

		LibroElectronico libroE = new LibroElectronico();

		libroE.setTitulo("Lorem Ipsum");

		System.out.println(libroE.toString());

		Libro l = new Libro(1, "Libro de la Selva", "Anónimo", "Editorial", "123456", 80, false);

		System.out.println(l.toString());

		Circulo circulo = new Circulo();
		circulo.dibujar();

		ArrayList<Libro> stock = new ArrayList<Libro>(); // ArrayList con todos los libros mezclados

		Libro libro = new Libro();
		libro.setTitulo("La historia interminable");

		Ebook ebook = new Ebook();
		ebook.setTitulo("Estolda jolasak");

		stock.add(libro);
		stock.add(ebook);

		for (Libro libroIteracion : stock) {
			if (libroIteracion instanceof Ebook) {

				Ebook ebook2 = (Ebook) libroIteracion;
				ebook2.encenderLuz();
				ebook2.apagarLuz();
				System.out.println("Soy un ebook: " + ebook2.getTitulo());

			} else {
				System.out.println("Soy un libro: " + libroIteracion.getTitulo());
			}
		}

	}

}
