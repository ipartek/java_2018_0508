package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Leer números por teclado hasta introducir -99. Calcular la suma, la media<br>
 * y cuántos son mayores que la media.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		ArrayList<Integer> array = leerValores();
		double suma = calcularSuma(array);
		double media = suma / array.size();
		mostrarResultados(array, suma, media);
	}

	public static ArrayList<Integer> leerValores() {
		ArrayList<Integer> valores = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("Introduce un número entero.");
			System.out.println("Si deseas terminar introduce -99");
			n = sc.nextInt();
			valores.add(n);
		} while (n != -99);

		sc.close();
		return valores;
	}

	public static double calcularSuma(ArrayList<Integer> valores) {
		double suma = 0;
		for (Integer numero : valores) {
			suma += numero;
		}
		return suma;
	}

	public static void mostrarResultados(ArrayList<Integer> valores, double suma, double media) {
		int cont = 0;
		System.out.println("Valores introducidos: ");
		System.out.println(valores);
		System.out.println("Suma: " + suma);
		System.out.println(media);
		for (Integer i : valores) {
			if (i > media) {
				cont++;
			}
		}
		System.out.println(cont + " valores superiores a la media");
	}
}
