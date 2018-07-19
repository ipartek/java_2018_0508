package com.ipartek.formacion.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Ebock;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;

public class JugandoPadreHijo {

	public static void main(String[] args) throws Exception {

		LibroElectronico le = new LibroElectronico();
		le.setTitulo("La novela mas larga del mundo");
		System.out.println(le.toString());

		Libro l = new Libro(456457456, "9788467569957",
				"LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014 ", "EDICIONES SM", false);

		// No se puede instanciar objeto de clases Abstracta
		// ObjectoGrafico o=new ObjectoGrafico

		ObjectoGrafico o = new ObjectoGrafico() {

			@Override
			void dibujar() {

			}
		};

		Circulo circulo = new Circulo();
		circulo.dibujar();

		// array con todos los libros mezclados
		ArrayList<Libro> stock = new ArrayList<Libro>();
		Libro libro = new Libro();
		libro.setTitulo("Historia interminable");
		Ebock ebook = new Ebock();
		ebook.setTitulo("El abuelo picaó");

		stock.add(libro);
		stock.add(ebook);

		//recorrer el tuitulo, si es ebook  llamar el metodo de encender luz.+
		for (Libro li : stock) {
			if (li instanceof Ebock) { //si el libro es Eboock
			((Ebock) li).encenderLuz();
			System.out.println("Soy un ebook =>"+li.getTitulo());
			}else {
				System.out.println(li.getTitulo());
			}
		}
		
	}
	
	//Crear ett atrubuto, salario, nombre, dni......con metodo calcular salario.
	//personas atributos 
	//contratado atributo nº seguridad social salario=salario/2
		//Luis 600€ calculo sal=300
		//
	//secreataria atributo edad //salario=salario/0,8
		//Asier 1000€ salcalcu=1000-35
	
	//SocioFundadores atributo nombre dni salario=salario * 3
		//Eneko 5.000€ salCalcu=15000
	//Todas las personas con metodo calcular salario.
	
	
	//Hacer JUnit 

}
