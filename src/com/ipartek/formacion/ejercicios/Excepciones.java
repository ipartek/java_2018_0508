package com.ipartek.formacion.ejercicios;

public class Excepciones {
	// TODO capturar y conseguir que entre un catch de arrayindexofBoundexception
	// TODO crear una nueva clase expeciones2 con un metodo main metodo a y metodo
	// b,el main llama al a el metodo a llama al b y el metodo b, llama al c y este
	// saca una excepcion de nullpointer
	public static void main(String[] args) {
		try {
			System.out.println("Comienza ejecucion");
			Object o = null;
			o.toString();
		} catch (NullPointerException e) {
			System.out.println("Lo sentimos pero se ha producido un problema");
		} catch (Exception e) {
			System.out.println("Lo sentimos pero se ha producido un problema");
			System.out.println("LOG, " + e.getMessage());
		} finally {
			System.out.println("termina ejecucion");
		}
		Arrayerror();

	}

	private static void Arrayerror() {
		int[] rarray = new int[5];
		try {
			for (int x = 0; x < 12; x++) {
				System.out.println(rarray[x]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
