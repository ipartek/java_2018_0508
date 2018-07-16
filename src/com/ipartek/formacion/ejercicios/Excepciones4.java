package com.ipartek.formacion.ejercicios;

//TODO
/*Capturar excepciones para que se ejecuten todos los metodos como si no hubiera 
 * excepcion*/

public class Excepciones4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main empezamos");
		MetodoA();
		System.out.println("Main terminamos");
	}

	static void MetodoA() {
		System.out.println("	MetodoA entro");		
		MetodoB();
		System.out.println("	MetodoA salgo");
	}

	@SuppressWarnings("null")
	static void MetodoB() {
		System.out.println("		MetodoB entro");		
		try {
			Object o = null;
			o.toString();
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Error. Excepcion detectada");
		}
		finally {
			System.out.println("		MetodoB salgo");
		}
	}

}