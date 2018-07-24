package com.ipartek.formacion.ejercicios;

public class Excepciones {

	public static void main(String[] args) {

		System.out.println("Comenzamos ejecucion...");

		try {

			/*
			Object o = null;
			o.toString();
			*/
			
			int[] numeros = {1,2,3};
			
			System.out.println(numeros[3]);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("La posicion a la que accedes no existe.");
			
		} catch (NullPointerException e) {

			System.out.println("NULL exception");
			
		} catch (Exception e) {

			System.out.println("UPSSS, Lo sentimos pero ha surgido un problema.");

			System.out.println("LOG=> " + e.getMessage() + " " + e.getCause());

		} finally {
			System.out.println("Terminamos ejecucion (Siempre se ejecute)");
		}

	}

}
