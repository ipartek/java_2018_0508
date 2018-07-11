package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int num1;
		int num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero: ");
		num1 = sc.nextInt();
		
		System.out.println("Otro numero por favor");
		num2 = sc.nextInt();
		
		System.out.println("Los numeros elegidos son: " + num1 + " y " + num2);
		
		sc.close();
	}

}
