package com.ipartek.formacion.arrayList.ejercicio5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * En esta entrada vamos a escribir un programa Java que crea un ArrayList de
 * <br>
 * Objetos de tipo Coche. El programa pide por teclado los datos de los coches y
 * <br>
 * los guarda en el array. A continuación utilizará el ArrayList para mostrar
 * <br>
 * por pantalla lo siguiente: <br>
 * <ul>
 * 
 * <li>- Todos los coches introducidos.</li>
 * <li>- Todos los coches de una marca determinada.</li>
 * <li>- Todos los coches con menos de un número determinado de Kilómetros.</li>
 * <li>- El coche con mayor número de Kilómetros.</li>
 * <li>- Todos los coches ordenados por número de kilómetros de menor a
 * mayor.</li>
 *
 * <ul>
 * 
 * @author Curso
 *
 */
public class Ejercicicio5 {

	static ArrayList<Coche> coches = new ArrayList<Coche>();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		leerCoches();
		mostrarCoches();
		System.out.println();

		mostrarPorMarca();
		System.out.println();

		mostrarPorKm();
		System.out.println();

		Coche mayorKm = mostrarPorMayorKm();
		System.out.println("El coche con mayor Km es:");
		System.out.println(mayorKm.toString());
		System.out.println();

		System.out.println("Coches ordenados por Km:");
		mostrarOrdenadosPorKm();

	} // FIN main

	/**
	 * Método que muestra los coches ordenados por número de Km de menor a mayor
	 */
	private static void mostrarOrdenadosPorKm() {

		coches.sort(new Comparator<Coche>() {

			@Override
			public int compare(Coche o1, Coche o2) {

				int cmp = 0; // Caso de que sean iguales

				if (o1.getKm() < o2.getKm()) { // o1 es menor que o2
					cmp = -1;
				} else if (o1.getKm() > o2.getKm()) { // o1 es mayor que o2
					cmp = 1;
				}

				return cmp;
			}
		}); // FIN compare(o1,o2);

		mostrarCoches();

	} // FIN mostrarOrdenadosPorKm();

	private static Coche mostrarPorMayorKm() {
		Coche res = coches.get(0);

		for (Coche coche : coches) {

			if (coche.getKm() > res.getKm()) {
				res = coche;
			}
		}
		return res;

	} // FIN mostrarPorMayorKm();

	/**
	 * Método para mostrar todos los coches con un número de Km inferior al número
	 * de Km que se pide por teclado
	 */
	private static void mostrarPorKm() {
		int km;

		System.out.println("Introduce Km: ");
		km = sc.nextInt();
		sc.nextLine(); // Debemos saltar el \n del scanner, ya que nextInt no lo hace.

		System.out.println("Coches con " + km + " kms:");

		for (Coche coche : coches) {
			if (coche.getKm() < km) {
				System.out.println(coche.toString());
			}

		}

	} // FIN mostrarPorKm();

	private static void mostrarPorMarca() {
		String marca;

		System.out.println("Introduce una marca: ");
		marca = sc.nextLine();

		System.out.println("Coches de la marca " + marca + ":");

		for (Coche coche : coches) {
			if (coche.getMarca().equals(marca)) {
				System.out.println(coche.toString());
			}

		}
	} // FIN mostrarPorMarca();

	private static void mostrarCoches() {

		for (Coche coche : coches) {
			System.out.println(coche.toString());
		}

	}

	private static void leerCoches() {

		String matricula;
		String marca;
		String modelo;
		int km;

		int n;

		Coche tmp; // En este objeto iremos creando cada coche con los datos leidos por consola

		do {

			System.out.print("Introduce el número de coches: ");
			n = sc.nextInt();

		} while (n < 0);

		sc.nextLine(); // Limpiar INTRO del Scanner

		for (int i = 0; i < n; i++) { // Leemos N coches

			System.out.println("Introduce la matrícula: ");
			matricula = sc.nextLine();

			System.out.println("Introduce la marca: ");
			marca = sc.nextLine();

			System.out.println("Introduce el modelo: ");
			modelo = sc.nextLine();

			System.out.println("Introduce los Km: ");
			km = sc.nextInt();
			sc.nextLine(); // Debemos saltar el \n del scanner, ya que nextInt no lo hace.

			tmp = new Coche(matricula, marca, modelo, km);
			coches.add(tmp);

		} // FIN for
	} // FIN leerCoches();
} // FIN Ejercicio5
