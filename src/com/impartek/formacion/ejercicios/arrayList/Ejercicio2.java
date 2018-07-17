package com.impartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 2. Leer números por teclado hasta introducir -99. Calcular la suma, la media
 * y cuántos son mayores que la media.
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		int n = 0;
		List<Integer> numeros = new ArrayList<Integer>();
		int media = 0;
		int suma = 0;
		int sMedia = 0;
		Scanner sc = new Scanner(System.in);

		while (n != -99) {

			System.out.println("Introduce un numero:");
			n = sc.nextInt();
			if (n == -99) {
				numeros.add(n);
				media += n;
			}

		}

		suma = media;
		media = media / numeros.size();

		for (Integer nActual : numeros) {
			if (nActual >= media) {
				sMedia++;
			}
		}

		System.out.println("La suma de los numeros es " + suma);
		System.out.println("La media es de " + media + " y hay " + sMedia + " numeros que superan la media.");

		sc.close();

	}

}
