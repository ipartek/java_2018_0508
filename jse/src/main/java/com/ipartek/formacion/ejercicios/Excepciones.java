package com.ipartek.formacion.ejercicios;

public class Excepciones {

	public static void main(String[] args) {
		
		System.out.println("Comenzamos ejecución");
		
		try {
			/*Object o = null;
			o.toString();*/
						
			int numeros[] = {1, 5, 7, 3};
			System.out.println(numeros[4]);
						
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Lo sentimos, ha habido un fallo en el sistema");
		}
				
		finally {
			System.out.println("Terminamos ejecución");
		}
		
		
	}

}