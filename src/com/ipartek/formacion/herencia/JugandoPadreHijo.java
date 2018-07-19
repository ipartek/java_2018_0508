package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;

public class JugandoPadreHijo {

	public static void main(String[] args) throws Exception {
		
		LibroElectronico le= new LibroElectronico();
		
		le.setTitulo("Lorem ipsum");
		
		System.out.println(le.toString());
		
		Libro l= new Libro(1,"iiii55","Libro de la selva","Amazonas",true);
		
		//no se pueden instanciar objetos de clases abstractas
		//ObjetoGrafico o= new ObjetoGrafico();
		
		/**
		 * ObjetoGrafico o= new ObjetoGrafico() {
			
			void dibujar() {
				
			}
			
		};
		
		Circulo circulo= new Circulo();
		circulo.dibujar();
		 */
		
		//array con todos los libros mezclados
		ArrayList<Libro> stock= new ArrayList<Libro>();
		
		Libro libro= new Libro();
		libro.setTitulo("La historia interminable");
		
		Ebook ebook= new Ebook();
		ebook.setTitulo("Estolda jolasak");
		
		//ahora añadimos estos 2 libros al array
		
		stock.add(libro);
		stock.add(ebook);
		
		for(Libro libroiteracion : stock) {
			
			if(libroiteracion instanceof Ebook) {
				
				Ebook ebook2= (Ebook)libroiteracion;
				ebook2.encenderLuz();
				System.out.println("Soy un Ebook "+ebook2.getTitulo());
			}
			else {
			System.out.println(libroiteracion.getTitulo());
			}
		}

	}

}

/**
 * ETT, vamos a manejar personas, de todas las personas posibles tiene que haber un metodo
 * que sea calcularSalario(), y tengo que saber su nombre y su DNI. Personas tenemos al
 * contratado, del contratado tmb queremos saber le numero de la seguridad social. Queremos
 * otra persona que sea secretaria y queremos saber la edad. 
 * Socios fundadores: nombre y dni.
 * Salario secretaria: atributo salario*0.8
 * Socio fundador: salario*3
 * Contratado: salario/2
 * 
 * Jerarquia de clases y test para ver que todo funciona
 * Contratado: 600
 * Secretaria: 1000
 * Socio fundador: 5000
 */

