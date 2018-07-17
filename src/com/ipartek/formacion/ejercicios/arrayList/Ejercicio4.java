package com.ipartek.formacion.ejercicios.arrayList;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa Java para calcular el String de mayor longitud de todos los
 * contenidos en un ArrayList de String.
 * 
 * El programa utilizará los siguientes métodos además del método main:
 * 
 * Método leerArray(): este método recibe como parámetro el arrayList de Strings
 * vacío. El método pide por teclado cadenas de caracteres y las añade al
 * ArrayList. La lectura de cadenas termina cuando se introduce la palabra
 * “FIN”.
 * 
 * Método cadenaMasLarga():este método recibe como parámetro el ArrayList de
 * Strings con todas las cadenas leídas anteriormente y devuelve el String de
 * mayor longitud.
 * 
 * @author andreaPerez
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		try {
			ArrayList<String> aString = new ArrayList<>();

			leerArray(aString);

		} catch (Exception e) {
			System.out.println("Uppss...Algo falló inesperadamente...");
		}

	}

	static void leerArray(ArrayList<String> lista) {

		Scanner sc = new Scanner(System.in);
		String texto;
		boolean resul = false;

		do {
			System.out.println("Introduce palabras(Para terminar poner FIN):");
			texto = sc.next();

			if ("FIN".equalsIgnoreCase(texto)) {
				resul = false;
			} else {
				lista.add(texto);
			}
			sc.nextLine();
		} while (resul == false);

		cadenaMasLarga(lista);

	}

	static void cadenaMasLarga(ArrayList<String> lista) {

		String textoMax = lista.get(0);

		for (int i = 0; i < lista.size(); i++) {
//			if (textoMax < lista.get(i).length()) {
//
//			}

		}
	}

}
