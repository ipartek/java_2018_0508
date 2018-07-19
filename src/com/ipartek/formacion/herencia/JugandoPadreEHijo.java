package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Libro;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class JugandoPadreEHijo {

	public static void main(String[] args) throws Exception {
		LibroElectronico le = new LibroElectronico();

		le.setTitulo("Lorem Ipsum");

		System.out.println(le.toString());

		Libro l = new Libro(1, "212345", "Libro de la selva", "amazonas", true);

		// No se puede instanciar porque la clase es abstracta
		// ObjetoGrafico og = new ObjetoGrafico();
		
		Circulo c = new Circulo();
		c.dibujar();
		
		/*Array con todos los libros mezclados*/
		ArrayList<Libro> stock = new ArrayList<Libro>();
		
		Libro lp = new Libro();
		lp.setTitulo("La historia interminable");
		
		EBook eb = new EBook();
		eb.setTitulo("Estolda jolasak");
		
		stock.add(lp);
		stock.add(eb);
		
		for(Libro libro : stock) {
			//Si libro es una instancia de Ebook
			if(libro instanceof EBook) {
				EBook ebook = (EBook) libro;
				ebook.encenderLuz();
			}else {
				System.out.println(libro.getTitulo());
			}
		}
	}
}


