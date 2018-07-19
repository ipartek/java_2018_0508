package com.ipartek.ejercicios.arrays;

/**
 * Programa que crea un array de 20 elementos llamado Pares y guarde los 20 primeros n�meros pares. 
 * Mostrar por pantalla el contenido del array creado
 * @author Curso
 *
 */

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		int cont= 2;
		int pares[]= new int[20];
		
		for (int i = 0; i < pares.length; i++) {
			pares[i]= cont;
			cont+=2;
		}
		
		for (int i = 0; i < pares.length; i++) {
			System.out.println(pares[i]);
			
		}

}
	
}
