package com.ipartek.formacion.ejercicios.basicos.iniciales;

/***
 * Programa Java que declare una variable C de tipo entero y asígnale un valor.
 * A continuación muestra un mensaje indicando si el valor de C es positivo o
 * negativo, si es par o impar, si es múltiplo de 5, si es múltiplo de 10 y si
 * es mayor o menor que 100. Consideraremos el 0 como positivo. Utiliza el
 * operador condicional ( ? : ) dentro del println para resolverlo.
 * 
 * @author user
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = 350;

		System.out.println("El numero " + c + " es " + ((c > 0) ? "positivo" : "negativo"));
		System.out.println("El numero " + c + " es " + ((c % 2 == 0) ? "par" : "impar"));
		System.out.println("El numero " + c + " es " + ((c % 5 == 0) ? "multiplo de 5" : "no es multiplo de 5"));
		System.out.println("El numero " + c + " es " + ((c % 10 == 0) ? "multiplo de 10" : "no es multiplo de 10"));
		System.out.println("El numero " + c + " es " + ((c >= 100) ? "mayor o igual que 100" : "menor que 100"));

	}

}
