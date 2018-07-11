package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * 
 * @author Curso
 *Escribe un programa Java que realice lo siguiente: declarar una variable <b>n<b> 
 *de tipo int, una variable A de tipo double y una variable <b>c<b> de tipo char y 
 *asigna a cada una un valor. A continuación muestra por pantalla:
 *
 *El valor de cada variable.<br>
 *La suma de N + A<br>
 *La diferencia de A - N <br>
 *El valor numérico correspondiente al carácter que contiene la variable C. <br>
 *Si por ejemplo le hemos dado a N el valor 5, a A el valor 4.56 y a C el 
 *valor ‘a’, se debe mostrar por pantalla:<br>
 *Variable N = 5<br>
 *Variable A = 4.56<br>
 *Variable C = a<br>
 *5 + 4.56 = 9.559999999999999<br>
 *4.56 - 5 = -0.4400000000000004<br>
 *Valor numérico del carácter a = 97<br>
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		int n = 5;
		double a = 4.56;
		char c = 'a';
		
		System.out.println("Variable n = " + n);
		System.out.println("Variable a = " + a);
		System.out.println("Variable c = " + c);
		System.out.println(n+" + "+ a + " = " + (n+a));
		System.out.println("Valor numerico del caracter a = " + (int)c);
		
	}

}
