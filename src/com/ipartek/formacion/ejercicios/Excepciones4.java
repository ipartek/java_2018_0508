package com.ipartek.formacion.ejercicios;

public class Excepciones4 {

	public static void main(String[] args) {
		// TODO Capturar excepciones para que se ejecuten todos los metodos como si no hubiera excepcion
		int numero = 0;
		try {
			numero = metodoA();
		}
		catch (NullPointerException e) {
			System.out.println("Esto lanza una excepcion nullpointer -  NullPointerException");
		}
	}
	
	private static int metodoA() throws NullPointerException{
		System.out.println("Entramos al metodoA");
		return metodoB();
	}
	
	private static int metodoB() throws NullPointerException{
		System.out.println("Entramos al metodoB");
		return metodoC();
	}
	
	private static int metodoC() throws NullPointerException{
		System.out.println("Entramos al metodoC");
		return (Integer) null;
	}

}
