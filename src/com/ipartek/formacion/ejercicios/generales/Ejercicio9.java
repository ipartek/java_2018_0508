package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * En esta entrada vamos a escribir el programa java para convertir un número de
 * decimal a binario.
 * 
 * Para escribir el programa nos vamos a basar en la forma clásica de pasar de
 * decimal a binario, o sea, dividir el número entre 2 y quedarnos con el resto
 * de la división. Esta cifra, que será un cero o un uno, es el dígito de menos
 * peso (más a la derecha) del número binario. A continuación volvemos a dividir
 * el cociente que hemos obtenido entre 2 y nos quedamos con el resto de la
 * división. Esta cifra será la segunda por la derecha del número binario. Esta
 * operación se repite hasta que obtengamos un cero como cociente.
 *
 */

public class Ejercicio9 {

	public static void main(String[] args) {
		int numero, exp, digito;
		double binario;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduce un numero entero >= 0 ");
			numero = sc.nextInt();
		} while (numero < 0);
		
		exp = 0;
		binario = 0;
		
		while (numero != 0) {
			digito = numero % 2;
			binario = binario + digito * Math.pow(10, exp);
			exp ++;
			numero = numero/2;
		}

		System.out.println("Binario : " +  binario);
		
		sc.close();
	}

}
