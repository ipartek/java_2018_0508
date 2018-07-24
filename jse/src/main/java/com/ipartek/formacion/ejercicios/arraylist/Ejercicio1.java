package com.ipartek.formacion.ejercicios.arraylist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Curso 1. Calcular la altura media de los alumnos de una clase.
 *
 */
public class Ejercicio1 {
	public static void main(String[] args) throws Exception {

		ArrayList<Double> alturaA = new ArrayList();
		double nAlturas;
		double alturaAlumno;
		double media = 0;
		int contadorMayor = 0;
		int contadorMenor = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el numero de alturas que calcularemos");
		nAlturas = Integer.parseInt(br.readLine());
		for (int x = 0; x < nAlturas; x++) {
			System.out.println("Introduce la altura del alumno nº: " + (x + 1));
			alturaAlumno = Double.parseDouble(br.readLine());
			alturaA.add(alturaAlumno);
			// alturaA.set(x, alturaAlumno);
		}
		for (int x = 0; x < nAlturas; x++) {
			media += alturaA.get(x).doubleValue();

		}
		media = media / nAlturas;
		System.out.println("La media de altura de la clase es: " + String.format("%.2f", media));
		for (int x = 0; x < nAlturas; x++) {
			if (alturaA.get(x).doubleValue() > media) {
				contadorMayor += 1;
			} else {
				if (alturaA.get(x).doubleValue() < media) {
					contadorMenor += 1;
				}
			}
		}
		System.out.println("Nº de alumnos por encima de la media: " + contadorMayor);
		System.out.println("Nº de alumnos por debajo de la media: " + contadorMenor);

	}
}
