package com.ipartek.formacion.ejercicios;

/**
 * TODO capturar y conseguir que entre en un catch de ArrayIndexOfBounException
 * @author Curso
 *
 */

public class Excepciones {

	public static void main(String[] args) {

		System.out.println("Comenzamos ejecución");
		try {
			int [] aEnteros=new int[5];
			int a=aEnteros[5];
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error con el Array");
		}
			
		/*} catch (Exception e) {
			System.out.println("Usuario=> Lo sentimos pero ha surgido un problema.");
			System.out.println("LOG=> " + e);
			
		} finally {
			System.out.println("Terminamos ejecución (Siempre se ejecute)");
		}*/

	}

}
