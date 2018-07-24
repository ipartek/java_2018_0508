package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * COMPROBAR SI DOS N�MEROS SON AMIGOS Dos n�meros enteros positivos A y B son
 * n�meros amigos si la suma de los divisores propios de A es igual a B y la
 * suma de los divisores propios de B es igual a A.
 * 
 * Los divisores propios de un n�mero incluyen la unidad pero no el propio
 * n�mero.
 * 
 * Un ejemplo de n�meros amigos son los n�meros 220 y 284. Los divisores propios
 * de 220 son 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 y 110. La suma de los divisores
 * propios de 220 da como resultado 284 Los divisores propios de 284 son 1, 2,
 * 4, 71 y 142. La suma de los divisores propios de 284 da como resultado 220.
 * Por lo tanto 220 y 284 son amigos.
 * 
 * Otras parejas de n�meros amigos son:
 * 
 * 1184, 1210 2620, 2924 5020, 5564 6232, 6368 10744, 10856 12285, 14595 17296,
 * 18416
 * 
 * @author Curso
 *
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		int num2;		
		int suma = 0;
		int suma2 = 0;
		
		System.out.print("Introduce numero 1: ");
		num = sc.nextInt();
		System.out.print("Introduce numero 2: ");
		num2 = sc.nextInt();
		
		for (int i = 1; i < num; i++) {
			if (num%i==0)
				suma = suma + i;
		}

		for (int i = 1; i < num2; i++) {
			if (num2%i==0)
				suma2 = suma2 + i;
		}
		
		if ( (num==suma2) && (num2==suma) )
			System.out.println(num + " (" + suma + ") <=> " + num2 + " (" + suma2 + ") -> Son amigos");
		else
			System.out.println(num + " (" + suma + ") <=> " + num2 + " (" + suma2 + ") -> No son amigos");

		sc.close();
		
	}

}
