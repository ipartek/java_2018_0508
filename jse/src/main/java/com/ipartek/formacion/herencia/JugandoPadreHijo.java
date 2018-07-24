package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.ipartek.formacion.pojo.Ebook;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;

public class JugandoPadreHijo {

	public static void main(String[] args) throws Exception {
		LibroElectronico le=new LibroElectronico();
		//Estamos llamando al padre realmente
		le.setTitulo("Lorem ipsum");
		System.out.println(le.toString());
		
		//LibroElectronico l=new Libro(1,"iiiiii","Libro de la selva","Amazonas",true);
		
		
		/**
		 * No se ppuede instanciar objetos de clases abstractas
		 */
		//ObjetoGrafico o=new ObjetoGrafico();
		
		ObjetoGrafico o=new ObjetoGrafico() {
			
			@Override
			void dibujar() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Circulo circulo=new Circulo();
		circulo.dibujar();
		System.out.println(circulo);
		
		
		//Array con todos los libros mezclados
		ArrayList<Libro>stock=new ArrayList<Libro>();
		
		
		System.out.println("----------------");
		Libro libro=new Libro();
		libro.setTitulo("La historia nterminable");
		
		Ebook ebook=new Ebook();
		ebook.setTitulo("Estolda jolasak");
		
		stock.add(libro);
		stock.add(ebook);
		
		for(Libro libroIteracion : stock) {
			if(libroIteracion instanceof Ebook) {
				Ebook ebook2=(Ebook)libroIteracion;//He cogido un libro y le he dicho que es de tipo 
				ebook2.encenderLuz();
				System.out.println("Soy un ebook ->"+ebook2.getTitulo());
			}
			System.out.println(libroIteracion.getTitulo());
			}
	}
	
	

}
