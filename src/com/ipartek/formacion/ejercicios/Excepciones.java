package com.ipartek.formacion.ejercicios;

public class Excepciones {

	public static void main(String[] args) {
		
		System.out.println("Comenzamos ejecución...");
		
		
		try{
		Object o= null;
		o.toString();
		
		//TO DO capturar y conseguir que entre en un catch de ArrayIndexOfBoundException()
		
		//int[] aEnteros= new int[5];
		//int excepcionArray= aEnteros[5];
		
		//catch(ArrayIndexOfBoundException e) {
			//System.out.println("Nos hemos salido del array");
		}
		
		//TO DO Crear una nueva clase Excepciones2 con un metodo main (llama a A, metodo A (Llama a main y metodo B (llama a C) y metodo C lanza una excepcion
		//}
		
		catch(Exception e) {
		//e.printStackTrace();
			System.out.println("Lo sentimos pero ha surgido un problema temporal");
			//tambien podemos usar e.getMessage() y e.getCause()
		}
		finally {
			System.out.println("Terminamos ejecución (siempre se debe ejecutar");
		}
		
		
		
		
		
		

	}

}
