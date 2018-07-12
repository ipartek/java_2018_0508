package com.ipartek.formacion.ejercicios.basicos;

/**
 * Escribe un programa java que declare una variable <b>c</b> de tipo entero y
 * asígnale un valor. A continuación muestra un <br>
 * mensaje indicando si el valor de <b>c</b> es positivo o negativo, si es par o
 * impar, si es múltiplo de 5, si es múltiplo de<br>
 * 10 y si es mayor o menor que 100. Consideraremos el 0 como positivo. Utiliza
 * el operador condicional ( ? : ) dentro del <br>
 * println para resolverlo.<br>
 * Si por ejemplo C = 55 la salida será:<br>
 * 55 es positivo<br>
 * 55 es impar<br>
 * 55 es múltiplo de 5<br>
 * 55 no es múltiplo de 10<br>
 * 55 es menor que 100<br>
 * 
 * @author Curso
 *
 */

public class Ejercicio7 {

	public static void main(String[] args) {
		
		int c = 55;
		
		String PAR = (c % 2 == 0) ? "PAR" : "IMPAR";
		
		String NEG = (c >= 0) ? "POSITIVO" : "NEGATIVO";
		
		String MULTI = (c % 5 == 0) ? "ES MULTIPLO DE 5" : "NO ES MULTIPLO DE 5";
		
		String MULTEN = (c % 10 == 0) ? "ES MULTIPLO DE 10" : "NO ES MULTIPLO DE 10";
		
		String MENOR = (c < 100) ? "ES MENOR QUE 100" : "ES MAYOR QUE 100";

		System.out.println(c + " es " + PAR);
		
		System.out.println(c + " es " + NEG);
		
		System.out.println(c + " es " + MULTI);
		
		System.out.println(c + " es " + MULTEN);
		
		System.out.println(c + " es " + MENOR);
	}

}
