package com.ipartek.formacion.arrayList;

import java.util.ArrayList;

/**
 * Método para desplazar todos los componentes de un Array un lugar a la
 * derecha. El último elemento pasará a la primera posición.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		ArrayList<Integer> valores = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			valores.add(i);
		}

		System.out.println(valores);

		desplazarDerechaClasico(valores); // Solución 1

		System.out.println(valores);

		desplazarDerechaRapido(valores); // Solución 2

	}

	public static void desplazarDerechaClasico(ArrayList<Integer> valores) {
		int i;

		int aux = valores.get(valores.size() - 1); // Guardamos el último elemento

		for (i = valores.size() - 1; i > 0; i--) { // Desplazamos los demás elementos
			valores.set(i, valores.get(i - 1));
		}
		valores.set(0, aux); // El último elemento pasa a ser el primero
	}

	public static void desplazarDerechaRapido(ArrayList<Integer> valores) {

		valores.add(0, valores.get(valores.size() - 1)); // Insertamos al principio el último elemento
		valores.remove(valores.size() - 1); // Lo borramos del final.
	}

}
