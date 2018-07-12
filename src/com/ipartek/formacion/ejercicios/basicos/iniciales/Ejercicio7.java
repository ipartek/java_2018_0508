package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
* Escribe un programa java que declare una variable C de tipo entero y asígnale un valor. 
* A continuación muestra un mensaje indicando si el valor de C es positivo o negativo, 
* si es par o impar, si es múltiplo de 5, si es múltiplo de 10 y si es mayor o menor que 100.
* Consideraremos el 0 como positivo. Utiliza el operador condicional ( ? : ) 
* dentro del println para resolverlo.
* Si por ejemplo C = 55 la salida será
* 55 es positivo
* 55 es impar
* 55 es múltiplo de 5
* 55 no es múltiplo de 10
* 55 es menor que 100
*/
public class Ejercicio7 {

	public static void main(String[] args) {

		int c = 55;
		
		System.out.println((c >= 0)? c + " positivo" : c + " es negativo");
		System.out.println((c % 2 == 0)? c + " par" : c + " es impar");
		System.out.println((c % 5 == 0)? c + " múltiplo de 5" : c + " no es múltiplo de 5");
		System.out.println((c % 10 == 0)? c + " múltiplo de 10" : c + " no es múltiplo de 10");
		System.out.println((c < 100)? c + " es menor que 100" : c + " es mayor que 100");
		
	}

}
