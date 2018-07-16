package com.ipartek.formacion.ejercicios;

/**
 * /TODO crear una nueva clase expeciones2 con un metodo main metodo a y
 * metodo<br>
 * b,el main llama al a el metodo a llama al b y el metodo b, llama al c y
 * este<br>
 * saca una excepcion de nullpointer<br>
 * 
 * @author Curso
 *
 */
public class Excepciones2 {

	public static void main(String[] args) {
		 metodoA();
		
	}
	private static void metodoA() {
		System.out.println("Metodo A");
		metodoB();
		System.out.println("Salgo de metodo b");
	}
	 
	 private static void metodoB() {
			System.out.println("entro Metodo B");
			Object o = null;
			o.toString();
			System.out.println("Salgo del metodo b");
					
			metodoC();
			System.out.println("salgo Metodo B");
		}
	 private static void metodoC()  {
			System.out.println("Metodo C");
			try {
				System.out.println("Comienza ejecucion");
				Object o = null;
				o.toString();
			} catch (NullPointerException e) {
				System.out.println(e);
			} 
			
		}
}
