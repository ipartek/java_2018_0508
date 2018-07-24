package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 3. Rotar los elementos de un ArrayList.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int totalNum = 0;
		ArrayList<Integer> aNum = new ArrayList<Integer>();

		System.out.println("Cantidad de numero a ingresar:");
		totalNum = sc.nextInt();

		for (int i = 0; i < totalNum; i++) {
			System.out.println("Introduce numero: ");
			aNum.add(sc.nextInt());

		}

		// guardamos el último elemento en un auxiliar,
		int aux = aNum.get(aNum.size() - 1);

		// desplazamos todos los elementos una posición a la derecha
		for (int i = aNum.size() - 1; i > 0; i--) {
			aNum.set(i, aNum.get(i - 1));
		}
		// finalmente guardamos en el primer elemento el valor guardado en el auxiliar
		aNum.set(0, aux);
		sc.close();

		System.out.println("Listado de numeros movido un espacio hacia a la derecha ");
		for (Integer n : aNum) {
			System.out.println( n);
		}

	}

}
