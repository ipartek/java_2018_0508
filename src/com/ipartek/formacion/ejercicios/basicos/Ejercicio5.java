package com.ipartek.formacion.ejercicios.basicos;

/**
 * Escribe un programa java que declare una variable <b>a</b> de tipo entero y asígnale un valor. A continuación muestra un <br>
 * mensaje indicando si <b>a</b> es par o impar. Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.<br>
 *  Si por ejemplo A = 14 la salida será<br>
 *  14 es par<br>
 *  Si fuese por ejemplo A = 15 la salida será:<br>
 *  15 es impar<br>
 * @author Curso
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) {
		int a=14;
		int b=15;
		
		String PAR=(a%2==0)?"PAR":"IMPAR";
		String PAR1=(b%2==0)?"PAR":"IMPAR";
		System.out.println(a + " es " + PAR);
		System.out.println(b + " es " + PAR1);

	}

}
