package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 * Calcular el mayor de tres números enteros en Java.
 * El programa lee por teclado tres números enteros y calcula y muestra el mayor 
 * de los tres.
 */

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		int num1, num2, num3;
		int maximo;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero");
		num1 = sc.nextInt();
		
		System.out.println("Introduce otro numero");
		num2 = sc.nextInt();
		
		System.out.println("Introduce otro numero");
		num3 = sc.nextInt();
		
		if(num1 > num2 && num1 > num3) {
			maximo = num1;
			System.out.println("El maximo es: " + maximo);
		}
		else if(num2 > num1 && num2 > num3){
			maximo = num2;
			System.out.println("El maximo es: " + maximo);
		}
		else {
			maximo = num3;
			System.out.println("El maximo es: " + maximo);
		}
		sc.close();
	}

}
