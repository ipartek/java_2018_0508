package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.text.DecimalFormat;

/**
 * Programa que calcula el volumen de una esfera.
 * 
 * @author andreaPerez
 * @see formula a usar ==> volumen=(4.0/3)* Math.PI * Math.pow(radio, 3))
 *      Debemos tener cuidado con la división entre números enteros. Si hacemos
 *      4/3 nos da como resultado 1, por eso se debe escribir al menos uno de
 *      los dos números como double. En este caso se ha puesto el numerador como
 *      double simplemente escribiendo 4.0 y de esta forma el resultado de la
 *      división 4.0/3 será de tipo double.
 * 
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		double radio = 2;
		DecimalFormat df = new DecimalFormat("#.00");
		double volumen = (4.0 / 3) * Math.PI * Math.pow(radio, 3);
		System.out.println("El volumen de una esfera con radio " + radio + " es:" + df.format(volumen));
	}

}
