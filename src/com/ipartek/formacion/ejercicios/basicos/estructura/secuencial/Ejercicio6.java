package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		double velocidad, velocidadsegundo;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cual es tu velocidad? ");
		velocidad = sc.nextDouble();
		
		velocidadsegundo = velocidad * 1000/3600;
		System.out.println(velocidadsegundo);
		
		sc.close();
	}

}
