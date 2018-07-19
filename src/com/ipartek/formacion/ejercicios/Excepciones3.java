package com.ipartek.formacion.ejercicios;

public class Excepciones3 {
	public static void main(String[] args) {
		System.out.println("Main comenzamos");

		try {
			metodoA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Main Terminamos");
	}

	static void metodoA() throws Exception {
		System.out.println("    metodoA entro");
		metodoB();
		System.out.println("    metodoA salgo");
	}

	@SuppressWarnings("null")
	static void metodoB() throws Exception {
		System.out.println("        metodoB entro");

		Object o = null;
		o.toString();

		System.out.println("        metodoB salgo");
	}

}
