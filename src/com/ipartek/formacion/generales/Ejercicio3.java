package com.ipartek.formacion.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Programa Java que lee una temperatura expresada en grados centígrados y la
 * convierte a grados kelvin.<br>
 * El proceso de leer grados centígrados se debe repetir mientras que se
 * responda ‘S’ a la pregunta: <br>
 * Repetir proceso? (S/N)<br>
 * Para hacer la conversión de grados Centígrados a grados Kelvin hay que
 * utilizar la fórmula:<br>
 * ºK = ºC + 273 <br>
 * 
 * @author Ainara
 *
 */

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {

		double c;
		double k;
		char contestacion;

		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Introduce grados centigrados: ");
			c = sc.nextInt();

			k = c + 273;

			System.out.print(c + " grados centigrados son " + k + " Kelvin.");

			System.out.print("¿Quieres continuar? ");
			contestacion = (char) System.in.read();
		} while (contestacion == 'n' && contestacion == 'N');

		sc.close();

	}

}
