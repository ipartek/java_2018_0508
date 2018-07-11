package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		String nombre;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un nombre: ");
		nombre = sc.nextLine();
		
		System.out.println("Buenos dias " + nombre);
		
		sc.close();
	}

}
