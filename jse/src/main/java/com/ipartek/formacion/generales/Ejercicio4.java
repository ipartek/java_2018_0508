package com.ipartek.formacion.generales;

/**
 * Programa Java que lea un número entero N y muestre la tabla de multiplicar de ese número. <br>
 * Por ejemplo, si se lee el valor 7 se mostrará por pantalla:<br>
 * Tabla del 7 <br>
 * --------------<br>
 * 7 * 1  =  7<br>
 * 7 * 2  = 14<br>
 * 7 * 3  = 21<br>
 * 7 * 4  = 28<br>
 * 7 * 5  = 35<br>
 * 7 * 6  = 42<br>
 * 7 * 7  = 49<br>
 * 7 * 8  = 56<br>
 * 7 * 9  = 63<br>
 * 7 * 10 = 70<br>
 * 
 *  @author Ainara
 */

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		int multi;

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce un número: \n");
		multi = sc.nextInt();

		System.out.print("Tabla del " + multi + "\n");
		System.out.print("---------------\n");

		for (int i = 1; i <= 10; i++) {

			System.out.println(multi + " * " + i + " = " + multi * i);
		}

		sc.close();
	}

}
