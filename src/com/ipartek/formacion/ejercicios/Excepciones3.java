package com.ipartek.formacion.ejercicios;

//TODO
/*Excepciones3 copiar el Excepciones2. El metodoB puede lanzar una excepcion con
 * throws
 * El throws se va a lanzar siempre para arriba*/

public class Excepciones3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main empezamos");
		try {
			MetodoA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("Main terminamos");
		}
	}

	static void MetodoA() throws Exception {
		System.out.println("	MetodoA entro");	
		MetodoB();

		System.out.println("Error en el metodo B");

		System.out.println("	MetodoA salgo");

	}

	@SuppressWarnings("null")
	static void MetodoB() throws Exception{
		System.out.println("		MetodoB entro");		
		Object o = null;
		o.toString();
		System.out.println("		MetodoB salgo");
	}
}
