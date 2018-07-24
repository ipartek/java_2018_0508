package com.ipartek.formacion.generales;

import java.util.Scanner;

/**
 * CONVERTIR UN NÚMERO DE BINARIO A DECIMAL EN JAVA El programa para pasar un
 * número expresado en binario a decimal se basa en la forma tradicional de
 * hacerlo. Los dígitos del número binario ocupan una posición que se numera de
 * derecha a izquierda empezando por cero. La posición del dígito más a la
 * derecha es la 0.
 * 
 * Numero Binario: 1 1 0 1 0 1 Posición que ocupa cada dígito 5 4 3 2 1 0
 * 
 * Para pasar el número a decimal se multiplica cada dígito binario por 2
 * elevado a la posición que ocupa. La suma de todos los productos es el
 * equivalente en decimal.
 * 
 * @author Ainara
 *
 */

public class Ejercicio10 {

	public static void main(String[] args) {
		
		float num;
		float aux;
		float digito;
		float decimal;
		int exponente;
		boolean esBinario;
		
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Introduce un numero binario: ");
			num = sc.nextLong();
			
			esBinario = true;
			aux = num;
			
			while (aux != 0) {
				digito = aux % 10; 
				if (digito != 0 && digito != 1) { 
					esBinario = false; 
				}
				aux = aux / 10; 
			}
		} while (!esBinario); 

		
		exponente = 0;
		decimal = 0; 
		
		while (num != 0) {
			
			digito = num % 10;
			
			decimal = decimal + digito * (int) Math.pow(2, exponente);
			
			exponente++;
			
			num = num / 10;
		}
		System.out.println("Decimal: " + decimal);
		
		sc.close();
	}

}
