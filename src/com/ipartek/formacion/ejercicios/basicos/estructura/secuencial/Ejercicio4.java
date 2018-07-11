package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Programa que lea una cantidad de grados centígrados y la pase a grados
 * Fahrenheit. La fórmula correspondiente para pasar de grados centígrados a
 * fahrenheit es: F = 32 + ( 9 * C / 5)
 * 
 * @author Curso
 *
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		float g;
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce temperatura en ºC: ");
		g = sc.nextFloat();

		System.out.println(g + "º C --> " + (32 + (9 * g / 5)) + "º F");

		sc.close();
		
	}

}
