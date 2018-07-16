package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Programa Java que lee una temperatura expresada en grados centígrados y la
 * convierte a grados kelvin.
 * 
 * El proceso de leer grados centígrados se debe repetir mientras que se
 * responda ‘S’ a la pregunta: Repetir proceso? (S/N)
 * 
 * Para hacer la conversión de grados Centígrados a grados Kelvin hay que
 * utilizar la fórmula:
 * 
 * ºK = ºC + 273
 * 
 * El programa java para realizar la conversión de temperaturas es el siguiente:
 * 
 * @author valen
 *
 */

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double temperatura;
		char respuesta = 'n';
		do {
			System.out.println(" Ingrese la temperatura : ");
			temperatura = s.nextDouble();
			System.out.println("Grados Kelvin es = " + (temperatura + 213));
			System.out.println("¿Quieres continuar?");
			String c = s.nextLine();
			c = s.nextLine();
			respuesta = c.charAt(0);
		} while (respuesta == 's');
	}

}
