package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/***
 * Pasar de grados cent�grados a grados kelvin.El proceso de leer grados
 * cent�grados se debe repetir mientras que se responda �S� a la pregunta:
 * Repetir proceso? (S/N)
 * 
 * @author user
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		double tempG;
		char opc;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduzca los grados centigrados: ");
			tempG = sc.nextDouble();

			sc.nextLine();
			System.out.println(tempG + "�C equivalen a " + tempG + 273 + " Kelvin");
			System.out.println("Repetir proceso? (S/N)");
			opc = sc.nextLine().charAt(0);
		} while (opc == 's' || opc == 'S');

		sc.close();
	}

}
