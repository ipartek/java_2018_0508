package com.ipartek.formacion.ejercicios;

/*main llama a metodoA, metodoA a metodoB, B a C, C casca*/
public class Excepciones2 {

	public static void main(String[] args) {
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
		Object o = null;
		o.toString();
		System.out.println("		MetodoB salgo");
	}
}