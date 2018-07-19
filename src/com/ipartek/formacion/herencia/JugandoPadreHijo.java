package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.EBook;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;


public class JugandoPadreHijo {

	public static void main(String[] args) throws Exception {

		LibroElectronico le = new LibroElectronico();
		System.out.println(le);

		Libro l = new Libro(1, "asdfsdfg", "Libro de la selva", "Amazonas", true);
		System.out.println(l);
		// No se puede instanciar objetos de clases abstractas
		// ObjetoGrafico ob = new ObjetoGrafico();

		Circulo c = new Circulo();
		System.out.println(c);

		// Array con todos los libros mezclados

		//array con todos los ibros mezaclados
		ArrayList<Libro> stock = new ArrayList<Libro>();
		
		Libro libro = new Libro();
		libro.setTitulo("La historia interminable");
		
		EBook ebook = new EBook();
		ebook.setTitulo("Estolda jolasak");
		
		
		stock.add(libro);
		stock.add(ebook);
		
		for( Libro libroIteracion : stock ) {
			
			if ( libroIteracion instanceof EBook ) {
				
				EBook ebook2 = (EBook)libroIteracion;
				ebook2.encenderLuz();
				System.out.println( "Soy un Ebook -> " + ebook2.getTitulo()  );
				
			}else {
				System.out.println( libroIteracion.getTitulo() );
			}	
			
		}

	}

}
