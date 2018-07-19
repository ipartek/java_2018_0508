package com.ipartek.formacion.herencia;

import com.ipartek.formacion.pojo.LibroElectronico;

public class JugandePadreHijo {

	public static void main(String[] args) throws Exception {

		LibroElectronico le = new LibroElectronico();

		//Libro l = new Libro(1, "34564765432", "Libro de la selva", "Amazonas", true);

		le.setTitulo("La novela mayor");

		System.out.println(le.toString());

		// No se pueden instanciar objetos de clases abstractas
		// ObjetoGrafico o = new ObjetoGrafico();
		
		/*
		ObjetoGrafico o = new ObjetoGrafico() {

			@Override
			void dibujar() {

			}
		};
		*/
		
		Circulo circulo = new Circulo();
		circulo.dibujar();
		System.out.println(circulo);
		
		/*
		//Array con todos los libros mezclados
		ArrayList<Libro> stock = new ArrayList<Libro>();
		
		Libro libro = new Libro();
		libro.setTitulo("La historia interminable");
		
		Ebook ebook = new Ebook();
		ebook.setTitulo("Estolda jolasak");
		
		stock.add(libro);
		stock.add(ebook);
		
		for (Libro libroIteracion : stock) {
			
			if(libroIteracion instanceof Ebook) {
				
				Ebook ebook2 = (Ebook)libroIteracion;
				ebook2.encenderLuz();
				System.out.println("Soy un ebook " + ebook2.getTitulo());
				
			}else {
				System.out.println(libroIteracion.getTitulo());
			}
						
		}*/
		
	}
}
