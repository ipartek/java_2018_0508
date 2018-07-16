package com.ipartek.formacion.ejercicios;

public class Excepciones2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
