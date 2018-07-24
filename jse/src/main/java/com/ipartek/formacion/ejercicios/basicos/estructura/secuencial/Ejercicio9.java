package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 9. Programa que calcula el área de un triángulo a partir de la
 *         longitud de sus lados. Primero hayamos el semiperimetro sumando los
 *         lados y dividiendolo entre 2 Con este dato el area se calcula de la
 *         siguiente manera area = raiz cuadrada de semiperimetro * la resta del
 *         semiperimetro y el lado
 *
 *
 */

public class Ejercicio9 {
	public static void main(String[] args) throws Exception {
		double semipermitro;
		double area;
		System.out.println("Introduce la longitud del primer lado :");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double lado1 = Double.parseDouble(br.readLine());
		System.out.println("Introduce la longitud del segundo lado :");

		double lado2 = Double.parseDouble(br.readLine());
		System.out.println("Introduce la longitud del tercer lado :");

		double lado3 = Double.parseDouble(br.readLine());
		semipermitro = (lado1 + lado2 + lado3) / 2;
		area = Math.sqrt(semipermitro * (semipermitro - lado1) * (semipermitro - lado2) * (semipermitro - lado3));

		System.out.println(area);

	}

}
