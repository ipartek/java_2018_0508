package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ejemplo de uso de un ArrayList: Calcular la altura media de los alumnos de
 * una clase.
 * 
 * Programa Java que pida por teclado las alturas de N alumnos de una clase y
 * las guarde en un ArrayList de tipo Double. A continuación el programa
 * calculará la altura media de todos los alumnos, cuantos alumnos hay más altos
 * que la media y cuantos más bajos.
 * 
 * Para resolverlo vamos a utilizar 4 métodos además del método main:
 * 
 * Método numeroAlumnos(): este método pide por teclado el número de alumnos de
 * la clase y devuelve dicho número al programa principal.
 * 
 * Método leerAlturas(): pide por teclado las alturas de los N alumnos y las
 * almacena en el ArrayList. Este método recibe como parámetros el ArrayList
 * inicialmente vacío y el número de alumnos a leer.
 * 
 * Método calcularMedias(): calcula y devuelve la media de los alumnos de la
 * clase. Este método recibe como parámetro el ArrayList con las alturas de
 * todos los alumnos.
 * 
 * Método mostrarResultados(): muestra por pantalla todas las alturas y calcula
 * y muestra el número de alumnos con altura superior e inferior a la media.
 * Recibe como parámetros el ArrayList con las alturas de todos los alumnos y la
 * media calculada anteriormente.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio1 {

	static Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Double> alumnos = new ArrayList<Double>();

		int n = numeroAlumnos();

		leerAlturas(alumnos, n);
	}

	static int numeroAlumnos() {

		int n = 0;

		System.out.println("Numero total de alumnos:");
		n = SC.nextInt();

		return n;

	}

	static void leerAlturas(ArrayList<Double> aList, int n) {

		for (int i = 0; i < n; i++) {
			System.out.println("Altura del alumno " + i + ": ");
			aList.add(SC.nextDouble());
		}

		double media = calcularMedias(aList);
		mostrarResultados(aList, media);

	}

	static double calcularMedias(ArrayList<Double> aList) {

		int cont = 0;
		double suma = 0;
		double media = 0;
		for (Double altura : aList) {
			cont++;
			suma += altura;
		}

		media = suma / cont;

		return media;

	}

	static void mostrarResultados(ArrayList<Double> aList, double media) {

		int altSuperior = 0;
		int altInferior = 0;

		System.out.println("altura media de los alumnos: " + media);

		for (Double altura : aList) {
			System.out.println("Altura: " + altura);
			if (altura > media) {
				altSuperior++;
			} else {
				altInferior++;
			}
		}
		System.out.println(altSuperior + " total alumnos con la altura mayor que la media");
		System.out.println(altInferior + " total alumnos con la altura menor que la media");

		SC.close();

	}
}
