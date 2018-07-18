package com.ipartek.formacion.ejercicios;

public class Excepciones2 {

	public static void main(String[] args) {

	}
	
	//metodo get excepiones 3 en el ejericio 3 copiamos en 2 y indicar que le metodo 2 puede sacar una excepcion 
	//y el ejercicio 3 se va a lanzar para arriba 
	
	static void metodoA() {
		System.out.println("    Metodo A entro ");
		metodoB();
		System.out.println("    Salgo A salgo ");
	}

	static void metodoB() {
		System.out.println("         Metodo B entro ");
		
		Object o = null;
		o.toString();
		
		System.out.println("         Salgo B salgo ");
	}

}
