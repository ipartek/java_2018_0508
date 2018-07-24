package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Pasar de grados centígrados a grados kelvin.El proceso de leer grados
 * centígrados se debe repetir mientras que se responda ‘S’ a la pregunta:
 * Repetir proceso? (S/N)
 * 
 * Para hacer la conversión de grados Centígrados a grados Kelvin hay que
 * utilizar la fórmula:
 * 
 * ºK = ºC + 273
 * 
 * @author andreaperez
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		String respuesta = "n";
		double k = 0;
		double c = 0;
		Scanner sc = new Scanner(System.in);

		do {

			System.out.print("Escribe Grados ºC: ");
			c= sc.nextDouble();
			k=c+273;
			System.out.println(c + " ºC = " + k + " ºK ");
			System.out.println("¿Repetir proceso? (S/N)");
			respuesta = sc.next();

		} while (!"n".equalsIgnoreCase(respuesta));

		sc.close();

	}

}
