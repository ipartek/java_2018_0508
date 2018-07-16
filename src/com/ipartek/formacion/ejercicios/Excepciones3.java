package com.ipartek.formacion.ejercicios;

public class Excepciones3 {

	public static void main(String[] args) {
		// TODO Ejercicio3 de excepciones, el metodoB() puede lanzar una excepcion con la palabra throws
		int numero = 0;
		try {
			numero = metodoA();
		}
		catch (NullPointerException e) {
			System.out.println("Esto lanza una excepcion nullpointer -  NullPointerException");
		}
	}
	
	private static int metodoA(){
		System.out.println("Entramos al metodoA ");
		return metodoB();
	}
	
	private static int metodoB() throws NullPointerException{
		System.out.println("Entramos al metodoB");
		throw new NullPointerException();
		//return (Integer) null;
	}
	
	private static int metodoC(){
		System.out.println("Entramos al metodoC");
		return (Integer) null;
	}

}
