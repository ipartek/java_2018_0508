package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.text.DecimalFormat;

/**
 * Programa lea la longitud de los catetos de un triángulo rectángulo y calcule
 * la longitud de la hipotenusa según el teorema de Pitágoras.
 * 
 * @author andreaPerez
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		double lado1 = 3;
		double lado2 = 3;
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("La hipotenusa del triangulo con lado1 " + lado1 + "y  lado2 " + lado2 + " = "
				+ df.format(Math.hypot(lado1, lado2)));

	}

}
