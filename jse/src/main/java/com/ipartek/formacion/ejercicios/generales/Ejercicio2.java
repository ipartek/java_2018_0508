package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que pide un número entero por teclado y calcula y muestra el
 * número de cifras que tiene.
 * 
 * Por ejemplo si se introduce el número 54391 el programa mostrará el mensaje:
 * 
 * El número tiene 5 cifras
 * 
 * Si se introduce el número 101 se mostrará el mensaje:
 * 
 * El número tiene 3 cifras
 * 
 * El proceso leer un número y contar sus cifras se repetirá hasta que se
 * conteste ‘N’ a la pregunta Continuar? (S/N) Si se responde 'S' se volverá a
 * pedir otro número.
 * 
 * Para saber cuántas cifras tiene un número entero haremos lo siguiente:
 * 
 * Dividiremos el número sucesivamente entre 10. En cada división tomaremos la
 * parte entera y volvemos a dividir. Este proceso se repite hasta que se
 * obtenga un cero como cociente en la división.
 * 
 * Por ejemplo, si el número leído es 1234 haremos las siguientes operaciones:
 * 
 * 1234 / 10 = 123 123 / 10 = 12 12 / 10 = 1 1 / 10 = 0
 * 
 * hemos realizado 4 divisiones hasta obtener un cero como cociente, por lo
 * tanto el número tiene 4 cifras.
 * 
 * @author valen
 *
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		int numero;
		int variable;
		System.out.println(" Ingresa el  numero ");
		numero = r.nextInt();

		char respuesta = 'n';
		do {

			variable = 0;
			numero = numero / 10;
			variable++;
			
			System.out.println("El numero tiene las siguientes cifras " + variable);

			/**
			 * TODO Contar las cifraS
			 */

			System.out.println("¿Quieres continuar?");
			String s = r.nextLine();
			respuesta = s.charAt(0);
		} while (respuesta == 's');

	}

}
