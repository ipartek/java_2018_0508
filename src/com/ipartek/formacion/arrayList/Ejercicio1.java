package com.ipartek.formacion.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa Java que pida por teclado las alturas de N alumnos de una clase y
 * las guarde en un ArrayList de tipo Double. A continuación el programa
 * calculará la altura media de todos los alumnos, cuantos alumnos hay más altos
 * que la media y cuantos más bajos.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	static Scanner sc = new Scanner(System.in);

	static ArrayList<Double> alumnos = new ArrayList<>();

	static double media;

	public static void main(String[] args) {

		int n = 0;

		n = numeroAlumnos(); // Pedimos y guardamos el número de alumnos
		leerAlturas(alumnos, n); // Pedimos y guardamos las alturas
		media = calculaMedia(alumnos); // Calculamos la media

		mostrarResultados(alumnos, media); // Mostramos los resultados

	}

	/**
	 * Método que pide por teclado el número de alumnos de la clase y devuelve dicho
	 * número al programa principal.
	 * 
	 * @return n, con el número leido por consola.
	 */
	private static int numeroAlumnos() {
		int n;

		System.out.println("Introduce el número de alumnos: ");
		n = sc.nextInt();

		return n;

	}

	/**
	 * pide por teclado las alturas de los N alumnos y las almacena en el ArrayList.
	 * Este método recibe como parámetros el ArrayList inicialmente vacío y el
	 * número de alumnos a leer.
	 * 
	 * @param alturas, arraylist con las alturas de tipo double
	 * @param n, entero con el número de alturas de la lista
	 */
	private static void leerAlturas(ArrayList<Double> alturas, int n) {

		for (int i = 0; i < n; i++) {

			System.out.println("Introduce altura: ");
			alumnos.add(sc.nextDouble());
		}
	}

	private static double calculaMedia(ArrayList<Double> alturas) {
		double res = 0;

		for (Double altura : alturas) {
			res += altura;
		}

		res /= alturas.size();
		return res;
	}

	private static void mostrarResultados(ArrayList<Double> alturas, double media) {

		int i = 1;

		System.out.println("La media es: " + media);
		System.out.println("---------------------");

		for (Double tmp : alturas) {
			System.out.print("Altura " + i + ": " + tmp);
			System.out.print(tmp > media ? " es mayor que la media.\n" : " es menor que la media.\n");
		}
	}

}
