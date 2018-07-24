package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calcular la altura media de los alumnos de una clase.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Double> alturas = new ArrayList<Double>();
		int n;
		double media;

		n = numeroAlumnos();

		leerAlturas(alturas, n);

		media = calcularMedia(alturas);

		mostrarResultados(alturas, media);
		sc.close();

	}

	public static int numeroAlumnos() {

		int n;
		do {
			System.out.print("Introduce número de alumnos: ");
			n = sc.nextInt();
		} while (n < 1);

		return n;
	}

	public static void leerAlturas(ArrayList<Double> a, int n) {

		int i;
		double alto;
		for (i = 1; i <= n; i++) {
			do {
				System.out.print("Alumno " + i + " altura: ");
				alto = sc.nextDouble();
			} while (alto <= 0);
			a.add(alto);
		}

	}

	public static double calcularMedia(ArrayList<Double> a) {
		double media = 0;
		for (Double d : a) {
			media = media + d;
		}
		return media / a.size();
	}

	public static void mostrarResultados(ArrayList<Double> a, double media) {
		int superior = 0;
		int inferior = 0;
		System.out.println("alturas introducidas: ");
		System.out.println(a);
		for (Double d : a) {
			if (d > media)
				superior++;
			else if (d < media)
				inferior++;
		}
		System.out.println(media);
		System.out.println("Hay " + superior + " alumnos m�s altos que la media");
		System.out.println("Hay " + inferior + " alumnos m�s bajos que la media");
	}

}
