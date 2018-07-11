package com.ipartek.formacion.ejercicios.basicos;

/**
 * 
 * Escribe un programa java que declare una variable <b>b</b> de tipo entero y asígnale un valor. A continuación muestra un <br>
 * mensaje indicando si el valor de B es positivo o negativo. Consideraremos el 0 como positivo. Utiliza el operador <br>
 * condicional ( ? : ) dentro del println para resolverlo.<br>
 * Si por ejemplo B = 1 la salida será:<br>
 * 1 es positivo<br>
 * Si fuese por ejemplo B = -1 la salida será:<br>
 * -1 es negativo<br>
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {
	public static void main(String[] args) {
		int b=-1;
		String neg=(b >= 0 ? " es positivo " : " es negativo ");
		System.out.println(b +" es " + neg );
	}
}
