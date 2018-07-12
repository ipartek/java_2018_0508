package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa para pasar un número expresado en binario a decimal
 * @author Curso
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		long binario;
		long aux;
		long digito;
		long decimal;
		int exp;
		boolean esBinario;
		
		do {
	          System.out.print("Introduce un numero binario: ");
	          binario = teclado.nextLong();
	          esBinario = true;
	          aux = binario;
	          while (aux != 0) {
	                     digito = aux % 10; //última cifra del números
	                     if (digito != 0 && digito != 1) {
	                          esBinario = false; //no es un número binario
	                     }
	                     aux = aux / 10; //quitamos la última cifra para repetir el proceso
	           }
	    } while (!esBinario);
		
		  exp = 0;
	      decimal = 0; //será el equivalente en base decimal
	      while (binario != 0) {
	                //se toma la última cifra
	                digito = binario % 10;
	                //se multiplica por la potencia de 2 correspondiente y se suma al número
	                decimal = decimal + digito * (int) Math.pow(2, exp);
	                //se aumenta el exponente
	                exp++;
	                //se quita la última cifra para repetir el proceso
	                binario = binario / 10;
	      }
	      System.out.println("En decimal: " + decimal);

	      teclado.close();
	}

}

