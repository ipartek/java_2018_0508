package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;
import java.util.logging.Logger;

import com.ipartek.formacion.ejercicios.basicos.estructura.secuencial.Ejercicio1;

/**
 * 
 * 
 * @author Asier Cornejo
 *
 *         Programa que lea un número entero y muestre si el número es múltiplo
 *         de 10.
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		int num1 = 0;

		String msg = "";
		Scanner sc = new Scanner(System.in);
		Logger log = Logger.getLogger(Ejercicio1.class.getName());
		log.info("Por favor introduzca un numero por teclado");
		num1 = sc.nextInt();
		msg = (num1 % 10 == 0) ? "El número " + num1 + " 5ES MULTIPLO DE 10"
				: "El número " + num1 + " NO ES MULTIPLO DE 10";
		log.info(msg);
		sc.close();
	}

}
