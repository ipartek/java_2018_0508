package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		double radio;
		double volumen;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cual es el radio de tu esfera? ");
		radio = sc.nextDouble();
		volumen = (4/3)*Math.PI* Math.pow(radio, 3);
		
		System.out.println("Tu esfera de " + radio + " centimetros, tiene un volumen de "
				+ volumen + " centimetros cubicos");

	}

}
