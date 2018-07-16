package com.ipartek.formacion.ejercicios;

public class Excepciones3 {

public static void main(String[] args){
		
		System.out.println("metodoMain() entro");		
		try {
			metodoA();
		} catch (Exception e) {
			System.out.println("Lo sentimos, ha habido un error");
		}
		System.out.println("metodoMain() salgo");
		
	}
	
	public static void metodoA() throws Exception{
		System.out.println("metodoA() entro");
		metodoB();
		System.out.println("metodoA() salgo");
	}
	
	public static void metodoB() throws Exception{
		System.out.println("metodoB() entro");
		metodoC();
		System.out.println("metodoB() salgo");
	}
	
	public static void metodoC() throws Exception{

		System.out.println("metodoC() entro");
		
		int numeros[] = {1, 5, 7, 3};
		System.out.println(numeros[4]);
		
		System.out.println("metodoC() salgo");
		
	}

}

