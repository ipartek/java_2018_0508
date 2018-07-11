package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa que calcula el volumen de una esfera.
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		double radio = 2.0;
		double volumen = 0.0;
		volumen = (4 * Math.PI * Math.pow(radio, 3)) / 3;
		System.out.println("El volumen de la esfera es:" + volumen + " metros cúbicos");

	}

}
