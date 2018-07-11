package com.ipartek.formacion.ejercicios.basicos.iniciales;
/**
 * 
 * @author Curso
 *5. Programa Java que declare una variable A de tipo entero y asígnale un valor. A continuación muestra un mensaje indicando si A es par o impar. Utiliza el operador condicional ( ? : ) dentro del println para resolverlo. 
 */
public class Ejercicio5 {
	public static void main(String[] args) {
		 int a = 6;
	        //condicion ? retorno si es verdadero : retorno que es falso
	        System.out.println(a + (a%2==0 ? " es par " : " es impar "));
	}
}
