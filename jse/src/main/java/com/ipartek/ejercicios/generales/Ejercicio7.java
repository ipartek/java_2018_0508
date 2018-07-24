package com.ipartek.ejercicios.generales;

import java.util.Scanner;

/**
 * programa que calcula si dos números son amigos
 * @author Curso
 *
 */

public class Ejercicio7 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int n1;
		int n2;
		int i;
		int suma=0;
		
		System.out.println("Introduce un numero");
		n1= sc.nextInt();
		
		System.out.println("Introduce otro numero");
		n2= sc.nextInt();
		
		for (i=1;i<n1;i++) { //sumamos los divisores de n1
			
			if (n1%i==0) {
				
				suma= suma+i;
			}
			
		}
		
		if(suma==n2) { //si la suma de los divisores es igual a n2
			
			suma= 0;
			
			for (i=1;i<n2;i++) { //sumamos los divisores de n2
				
				if (n2%i==0) {
					
					suma= suma+i;
				}
			}
			
			if (suma==n1) {
				
				System.out.println("Los numeros son amigos");
			}
			
			else {
				
				System.out.println("Los numeros no son amigos");
			}
		}
		
		else {
			
			System.out.println("Los numeros no son amigos");
		}
		

}

}