package com.ipartek.formacion.ejercicios.basicos.iniciales;

public class Ejercicio1 {

	public static void main(String[] args) {

		
		/**
		 * Escribe un programa Java que realice lo siguiente: declarar una variable <b>n</b><br/> 
		 * de tipo int, una variable <b>a</b> de tipo double y una variable <b>c</b><br/> 
		 * de tipo char y asigna a cada una un valor.<br/> 
		 * A continuación muestra por pantalla:<br/>
		 * El valor de cada variable.<br/>
		 * La suma de N + A<br/>
		 * La diferencia de A - N<br/>
		 * El valor numérico correspondiente al carácter que contiene la variable C.<br/>
		 * Si por ejemplo le hemos dado a N el valor 5, a A el valor 4.56 y a C el valor ‘a’,<br/> 
		 * se debe mostrar por pantalla:<br/>
		 *<br/>
		 * Variable N = 5<br/>
		 * Variable A = 4.56<br/>
		 * Variable C = a<br/>
		 * 5 + 4.56 = 9.559999999999999<br/>
		 * 4.56 - 5 = -0.4400000000000004<br/>
		 * Valor numérico del carácter a = 97
		 */
		
		int n = 5;
		double a = 4.56;
		char c = 'a';
		
		System.out.println("Variable N = " + n);
		System.out.println("Variable A = " + a);	
		System.out.println("Variable C = '" + c + "'");	
		System.out.println("Suma de " + n + " + " + a + " = " + (n + a));
		System.out.println("Resta de " + a + " - " + n + " = " + (a - n));
		System.out.println("Valor númerico del carácter '" + c + "' = " + (int)c);
		
		
	}

}
