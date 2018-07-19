package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;;

public class JugandoPadreHijo {

	public static void main(String[] args) throws Exception {

		LibroElectronico le = new LibroElectronico();
		
		le.setTitulo("Lorem Ipsum");
		
		System.out.println(le.toString());
		
		Libro l = new Libro (1, "iiii555", "Libro de la selva", "Amazonas", false);
		
		// No se puede instanciar un objeto de una Clase Abstracta
		//ObjetoGrafico o = new ObjetoGrafico()
				
		ObjetoGrafico o = new ObjetoGrafico() {
			
			@Override
			void dibujar() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		Circulo circulo = new Circulo();
		circulo.dibujar();
		System.out.println(circulo);
		
		System.out.println();
		
		// array con todos los libros mezclados
		ArrayList<Libro> stock = new ArrayList<Libro>();	// getters and setters

		Libro libro = new Libro();
		libro.setTitulo("La historia interminable");
		
		Ebook ebook = new Ebook();
		ebook.setTitulo("Estolda jolasak");
		
		stock.add(libro);
		stock.add(ebook);
		
		for (Libro libroIteracion : stock) {
			if (libroIteracion instanceof Ebook) {
				Ebook ebook2 = (Ebook)libroIteracion;
				ebook2.encenderLuz();
				System.out.println("Soy un ebook -> " + ebook2.getTitulo());
			} else {
				System.out.println(libroIteracion.getTitulo());
			}
		}
		
		
		
	}

}
