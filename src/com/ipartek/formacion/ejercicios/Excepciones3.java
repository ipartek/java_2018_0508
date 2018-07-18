package com.ipartek.formacion.ejercicios;

public class Excepciones3 {
	public static void main(String[] args) {

	}
	
	//metodo get excepiones 3 en el ejericio 3 copiamos en 2 y indicar que le metodo 2 puede sacar una excepcion 
	//y el ejercicio 3 se va a lanzar para arriba 
	//hacer un ejercicio 4 y en el ejercicio 4 capturar excepciones para que se ejecuten todos los metodos como si no hubiera excepcion 
	

	static void metodoA() throws Exception {
		System.out.println("    Metodo A entro ");
		metodoB();
		System.out.println("    Salgo A salgo ");
	}

	static void metodoB() throws Exception{
		System.out.println("         Metodo B entro ");
		
		Object o = null;
		o.toString();
		
		System.out.println("         Salgo B salgo ");
	}


}
