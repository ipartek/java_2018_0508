package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
 */

import java.util.Scanner;

public class Ejercicio1 {

	   public static void main(String[] args){

	        int n1, n2;
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Introduce un número entero: "); 
	        n1 = sc.nextInt();      
	        System.out.println("Introduce otro número entero: "); 
	        n2 = sc.nextInt();  
	        System.out.println("Ha introducido los números: " + n1 + " y " + n2);

	        sc.close();
	    }

}
