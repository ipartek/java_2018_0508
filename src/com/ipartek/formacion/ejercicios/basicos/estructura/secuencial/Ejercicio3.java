package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		int numero;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero: ");
		numero = sc.nextInt();
		
		System.out.println("tu numero es: " + numero + " , el doble es: " + (numero*2) + 
				" y el triple: " + (numero * 3));

		sc.close();
	}

}
