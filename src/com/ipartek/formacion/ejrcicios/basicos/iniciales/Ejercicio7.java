package com.ipartek.formacion.ejrcicios.basicos.iniciales;
/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa Java que declare una variable C de tipo entero y asígnale un
 *         valor. A continuación muestra un mensaje indicando si el valor de C
 *         es positivo o negativo, si es par o impar, si es múltiplo de 5, si es
 *         múltiplo de 10 y si es mayor o menor que 100. Consideraremos el 0
 *         como positivo. Utiliza el operador condicional ( ? : ) dentro del
 *         println para resolverlo.
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		int c = -23;
		System.out.println(c + (c < 0 ? " ES NEGATIVO" : " ES POSITIVO"));
		System.out.println(c + (c % 2 == 0 ? " ES PAR" : " ES IMPAR"));
		System.out.println(c + (c % 5 == 0 ? " ES MÚLTIPLO DE 5" : " NO ES MÚLTIPLO DE 5"));
		System.out.println(c + (c % 10 == 0 ? " ES MÚLTIPLO DE 10" : " NO ES MÚLTIPLO DE 10"));
		System.out.println(c + (c < 100 ? " ES MENOR QUE 100" : " ES MAYOR QUE CIEN"));
	}

}
