package com.ipartek.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa Java que lea por teclado 10 números enteros y los guarde en un array. 
 * A continuación calcula y muestra por separado la media de los valores positivos 
 * y la de los valores negativos
 * @author Curso
 *
 */

public class Ejercicio1 {
		
		private static Scanner sc;

		public static void main(String[] args) {
			
			sc = new Scanner(System.in);
			
			int i;
			int pos= 0; //contador numeros positivos
			int neg= 0; //contador numeros negativos
			
			int numeros[]= new int[10];
			
			double sumarPos= 0; //acumulador suma positivos
			double sumarNeg= 0; //acumulador suma negativos
			
			System.out.println("Los elementos del array son: ");
			
			for (i = 0; i < 10; i++) {
	            System.out.print("numeros[" + i + "]: ");
	            numeros[i]= sc.nextInt();
			
			}
			
			for (i = 0; i < 10; i++) { //recorremos el array y sumamos los numeros pos y neg
				if(numeros[i]>0) {
					sumarPos+= numeros[i];
					pos++;
				}
				else if(numeros[i]<0) {
						sumarNeg+= numeros[i];
						neg++;
					}
					
				}
			
			if (pos!= 0) {
	            System.out.println("Media valores positivos: " + sumarPos / pos);
	        } 
			
			else {
	            System.out.println("No se han introducido numeros positivos");
	        }
	        if (neg!= 0) {
	            System.out.println("Media valores negativos: " + sumarNeg / neg);
	        } 
	        
	        else {
	            System.out.println("No se han introducido numeros negativos");
	        }
				
			}	
	}


