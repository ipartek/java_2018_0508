package com.ipartek.formacion.ejercicios;

public class Excepciones2 {

	public static void main(String[] args) {
		
		System.out.println("metodoMain() entro");		
		metodoA();
		System.out.println("metodoMain() salgo");
		
	}
	
	public static void metodoA(){
		System.out.println("metodoA() entro");
		metodoB();
		System.out.println("metodoA() salgo");
	}
	
	public static void metodoB(){
		System.out.println("metodoB() entro");
		metodoC();
		System.out.println("metodoB() salgo");
	}
	
	public static void metodoC() {

		System.out.println("metodoC() entro");
		try {
			int numeros[] = {1, 5, 7, 3};
			System.out.println(numeros[4]);
		} catch (Exception e) {
			System.out.println("Lo sentimos, pero ha ocurrido un problema");
		}
		System.out.println("metodoC() salgo");
		
	}

}
