package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;

public class JugandoPadreHijo extends LibroElectronico {

		public static void main(String[] args) throws Exception {
			
			LibroElectronico le = new LibroElectornico();
			
			le.setTitulo("Lorem Ipsum");
			
			System.out.println(le.toString());
			
			Libro l = new Libro(1, "iiii55", "Libro de la Selva", "Amazonas", true);
			
			// No se pueden instanciar obejto de Clases Abstractas
			// ObjetoGrafico o = new ObjetoGrafico();
			
			ObjetoGrafico o = new ObjetoGrafico() {
				
				@Override
				void dibujar() {
					
					
				}
			};
			
			Circulo circulo = new Circulo();
			circulo.dibujar();
			System.out.println(circulo);
			
			
			//array con todos los ibros mezaclados
			ArrayList<Libro> stock = new ArrayList<Libro>();
			
			Libro libro = new Libro();
			libro.setTitulo("La historia interminable");
			
			Ebook ebook = new Ebook();
			ebook.setTitulo("Estolda jolasak");
			
			
			stock.add(libro);
			stock.add(ebook);
			
			for( Libro libroIteracion : stock ) {
				
				if ( libroIteracion instanceof Ebook ) {
					
					Ebook ebook2 = (Ebook)libroIteracion;
					ebook2.encenderLuz();
					System.out.println( "Soy un Ebook -> " + ebook2.getTitulo()  );
					
				}else {
					System.out.println( libroIteracion.getTitulo() );
				}	
				
			}
			
			
			
		}

	}

}
