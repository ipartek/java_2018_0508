package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Calcular el número de cifras de un número entero. Programa Java que pide un
 * número entero por teclado y calcula y muestra el número de cifras que tiene.
 * 
 * Por ejemplo si se introduce el número 54391 el programa mostrará el mensaje:
 * * El número tiene 5 cifras El proceso leer un número y contar sus cifras se
 * repetirá hasta que se conteste ‘N’ a la pregunta Continuar? (S/N) Si se
 * responde 'S' se volverá a pedir otro número.
 * 
 * Para saber cuántas cifras tiene un número entero haremos lo siguiente:
 * 
 * Dividiremos el número sucesivamente entre 10. En cada división tomaremos la
 * parte entera y volvemos a dividir. Este proceso se repite hasta que se
 * obtenga un cero como cociente en la división.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		String respuesta = "n";
		int num = 0;
		int cifras = 0;
		Scanner sc = new Scanner(System.in);

		do {
			
			System.out.print("Escribe nº: ");
			num = sc.nextInt();

			while (num != 0) { 								// mientras a n le queden cifras
				num = num / 10; 							// le quitamos el último dígito
				cifras++; 									// sumamos 1 al contador de cifras
			}
			System.out.println("El número tiene " + cifras+ " cifras");
			System.out.println("¿Continuar?\"S\"si y \"N\" no");
			respuesta = sc.next();

		} while (!"n".equalsIgnoreCase(respuesta));
		
		sc.close();
	}

}
