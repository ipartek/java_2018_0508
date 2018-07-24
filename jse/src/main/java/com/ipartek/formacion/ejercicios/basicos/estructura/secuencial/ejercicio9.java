package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.text.DecimalFormat;

/**
 * Programa que calcula el área de un triángulo a partir de la longitud de sus
 * lados. según la siguiente fórmula: area=raiz2(p(p-a)(p-b)(p-c)) donde p =
 * (a+b+c)/2
 * 
 * @author andreaPerez
 *
 */
public class ejercicio9 {

	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("#.00");
		double lado1 = 3;
		double lado2 = 3;
		double lado3 = 3;

		double p = (lado1 + lado2 + lado3) / 2;

		System.out.println("el area del triangulo con lados " + lado1 + "; " + lado2 + ";" + lado3 + " es: "
				+ df.format(Math.sqrt(p * (p - lado1) * (p - lado2) * (p - lado3))));

	}

}
