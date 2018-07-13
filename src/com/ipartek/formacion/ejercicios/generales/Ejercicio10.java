package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Pasar de binario a decimal
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		  Scanner teclado = new Scanner(System.in);
	        System.out.print("Introduce un numero: ");
	        int num = teclado.nextInt();
	        int digit = 0;
	        int decimal= 0;
	        int i=0;
	        while(num>0) {
	        	digit = num % 10;            
	        	decimal += digit * Math.pow(2, i);   
	        	num/=10;
	        	i++;
	        	
	        }

	        System.out.print("El numero decimal es: "+decimal);
	        teclado.close();
	}

}
