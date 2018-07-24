package com.ipartek.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa Java que llene un array con 10 números enteros que se leen por teclado. 
 * A continuación calcula y muestra la media de los valores positivos y la de los 
 * valores negativos del array
 * @author Curso
 *
 */

public class Ejercicio6 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int numeros[]= new int[10];
        int pos= 0; 
        int neg= 0;  
        
        double sumaPos= 0, sumaNeg = 0;  
       
        System.out.println("Lectura de los elementos del array: ");
        for (int i= 0; i < numeros.length; i++) {
            System.out.print("numeros[" + i + "]= ");
            numeros[i]=sc.nextInt();
        }
        
        for (int i= 0; i < numeros.length; i++) {
            if (numeros[i] > 0){ 
                sumaPos += numeros[i];
                pos++;
            } else if (numeros[i] < 0){ 
                sumaNeg+= numeros[i];
                neg++;
            }
        }
        
        if (pos!= 0) {
            System.out.println("Media valores positivos: " + sumaPos / pos);
        } else {
            System.out.println("No ha introducido números positivos");
        }
        if (neg!= 0) {
            System.out.println("Media negativos: " + sumaNeg / neg);
        } else {
            System.out.println("No ha introducido números negativos");
        }

}
	
}
