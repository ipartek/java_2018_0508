package com.ipartek.formacion.ejercicios;

public class Excepciones {

	public static void main(String[] args) {

		
		System.out.println("Comenzamos ejecucion");
		
		try {
			/*
			Object o = null;
			o.toString();
			*/
			
			//TODO capturar y conseguir que entre en en un catch de ArrayIndexOfBoundsException
			
			int [] numeros = {1,2};
			System.out.println(numeros[-1]);
			
			//TODO Crea nueva clase Excepciones2 con un metodo main, metodoA, metodoB y metodoC
			// metodoA llama al B, el B al C y el C al main
			
			
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No existe el elemento o index es negativo");
		} catch (NullPointerException e) {
			System.out.println("NULL Exception");
		} catch (Exception e) {
			// e.printStackTrace
			System.out.println("USER=> ha surgido un problema.");
			System.out.println("LOG=>" + e.getMessage() + " " + e.getCause() );
		}finally {
			System.out.println("Terminamos ejecucion. Siempre se debe ejecutar");
		}
		
		
	}

}
