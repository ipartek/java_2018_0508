package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. Calcular la altura media de los alumnos de una clase.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int n;
		List<Integer> alturas = new ArrayList<Integer>();
		int media = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {

			System.out.println("Introduce la altura");
			n = sc.nextInt();
			alturas.add(n);
			media += n;

		}

		System.out.println("La media es de " + (media / alturas.size()));

		sc.close();

	}

}
