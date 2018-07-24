package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Rotar los elementos de un ArrayList.
 * @author Adrian Garcia
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		int cantidadNumeros;
		int n;
		int auxiliar;
		
		do {
			System.out.println("¿Cuántos números desea introducir?");
			cantidadNumeros = sc.nextInt();
		} while (cantidadNumeros <= 0);
		
		for (int i = 0; i < cantidadNumeros; i++) {
			System.out.println("Introduzca un número");
			n = sc.nextInt();
			numeros.add(n);
		}

        auxiliar = numeros.get(numeros.size() - 1);
        for (int i = numeros.size() - 1; i > 0; i--) {
        	numeros.set(i, numeros.get(i - 1)); 
        }
        numeros.set(0, auxiliar); 
		
        for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));
		}
        
		sc.close();
		
	}

}
