package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa Java que lea dos números enteros por teclado y los muestre
 *         por pantalla.
 *
 */
public class Ejercicio1 {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 3;
		Scanner sc = new Scanner(System.in);
		Logger log = Logger.getLogger(Ejercicio1.class.getName());
		log.info("Por favor introduzca un numero por teclado");
		num1 = sc.nextInt();
		log.info("Por favor introduzca otro numero por teclado");
		num2 = sc.nextInt();

		log.info("Los numeros introducidos son: " + num1 + "," + num2);
		sc.close();
	}

}
