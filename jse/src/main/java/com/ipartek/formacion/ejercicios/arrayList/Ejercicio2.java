package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Leer números por teclado hasta introducir -99. Calcular la suma, la media y
 * cuántos son mayores que la media.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio2 {

	static final int SALIR = -99;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> numeros = new ArrayList<Integer>();

		int n = 0;
		int suma = 0;
		int mayorMedia = 0;
		int cont = 0;

		do {
			System.out.println("Inserte numero(Para salir introduzca el -99): ");
			n = sc.nextInt();
			numeros.add(n);
		} while (n != SALIR);

		for (Integer num : numeros) {
			suma += num;
			cont++;
		}

		for (Integer nume : numeros) {
			if (nume > suma / cont) {
				mayorMedia++;
			}
		}
		System.out.println("La suma de los numeros introducidos es: " + suma + "; la media: " + suma / cont
				+ " Cantidad de numeros que supera la media: " + mayorMedia);

		sc.close();

	}

}
