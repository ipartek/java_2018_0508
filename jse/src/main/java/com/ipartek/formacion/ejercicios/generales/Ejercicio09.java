package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 9. Pasar de decimal a binario
 * 
 * @author Curso
 *
 */
public class Ejercicio09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int nEntero;
		int auxNEntero;
		String nBinario = "";

		System.out.println("Introduce un numero:");
		nEntero = sc.nextInt();

		auxNEntero = nEntero;

		while (auxNEntero / 2 != 0) {
			nBinario += auxNEntero % 2;
			auxNEntero = auxNEntero / 2;
		}

		nBinario += auxNEntero % 2;
		
		// TODO dar la vuelta al numero
		System.out.println(nBinario);
		sc.close();
	}

}
