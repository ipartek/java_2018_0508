package com.ipartek.formacion.ejrcicios.basicos.iniciales;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa java que realice lo siguiente: declarar una variable
 *         <b>n</b> de tipo int, una variable <b>a</b> de tipo double y una
 *         variable <b>c</b> de tipo char y asigna a cada una un valor. A
 *         continuación muestra por pantalla: El valor de cada variable, la suma
 *         de N + A, la diferencia de A - N, el valor numérico correspondiente
 *         al carácter que contiene la variable C.
 *
 * 
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		int n = 50;
		float a = 20.5f;
		char c = 'z';
		System.out.println("Los valores son:");
		System.out.println("n=" + n + " ," + "a=" + a + " ," + "c=" + c);
		System.out.println("a + n =" + (a + n) + ",a - n = " + (a - n) + ", c=" + Character.getNumericValue(c));
	}

}
