package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa que lee un número de 3 cifras y muestra sus cifras por separado.
 * 
 * @author andreaPerez
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {

		int numero = 123;
		int unidades = numero % 10;
		int decenas = numero % 100 / 10;
		int centenas = numero % 1000 / 100;

		System.out.println(
				"Los numeros que componen el " + numero + " son: " + centenas + "; " + decenas + "; " + unidades);

	}

}
