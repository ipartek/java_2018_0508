package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por
 * teclado
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		float vel;

		System.out.print("Introduce velocidad en km/h: ");
		vel = sc.nextFloat();
		System.out.println("Son " + vel * 1000 / 3600 + " m/s");

		sc.close();
	}

}
