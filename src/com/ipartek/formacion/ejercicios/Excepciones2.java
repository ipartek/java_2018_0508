package com.ipartek.formacion.ejercicios;
/**
 * Crear una nueva clase Excepciones2 con un metodo main (llama a A),
 * metodo A (Llama a main y metodo B (llama a C) y metodo C lanza una excepcion
 * @author Curso
 *
 */

public class Excepciones2 {
	
	public static void main(String[] args) throws Exception {
		
		metodoA();
		System.out.println("Terminamos main");
		
		
	}
	
	private static void metodoA() throws Exception {
		
		System.out.println("Entro al metodo A");
		metodoB();
		System.out.println("Salgo del metodo A");
		
	}
	
	private static void metodoB() throws Exception{ //hay que poner throws tmb en los metodos de arriba si no da fallo
		System.out.println("Entro al metodo B");
		
		try {
		Object o= null; //esto lanzaria una excepcion
		o.toString();
		}
		catch(Exception e) {
			System.out.println("Excepcion capturada");
		}
		
		System.out.println("Salgo del metodo B");
	}
	
	private static void metodoC() {
		
		
	}
	
	//Ejer3: indicar que el metodo B puede lanzar una excepcion con el metodo throws, y el throws se va a lanzar siempre para arriba
    //Ejer4: capturar excepciones para que se ejecuten todos los metodos como si no hubiera excepcion
}
