package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Pasar de grados centígrados a grados kelvin.El proceso de leer grados
 * centígrados se debe repetir mientras que se responda ‘S’ a la pregunta:
 * Repetir proceso? (S/N)
 */
public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		char ch = 'S';
		Scanner teclado = new Scanner(System.in);
		
		while(ch == 'S' || ch == 's') {
			System.out.print("Introducir grados celsius: ");
			float degrees = teclado.nextFloat();
			System.out.println("Grados kelvin: "+(degrees + 273.15f));
			System.out.print("Repetir proceso? (S/N): ");
			ch = (char) System.in.read();
		}
		teclado.close();
	}

}
