package com.ipartek.formacion.ejercicios;
/**
 * 
 * @author Curso
 *Escribe un programa Java que realice lo siguiente: declarar una variable <b>N</b> de tipo int, una variable <b>A</b> de tipo double y una variable <b>C</b> de tipo char y asigna a cada una un valor. A continuación muestra por pantalla:
El valor de cada variable.<br>
La suma de N + A<br>
La diferencia de A - N<br>
El valor numérico correspondiente al carácter que contiene la variable C.<br>
Si por ejemplo le hemos dado a N el valor 5, a A el valor 4.56 y a C el valor ‘a’, se debe mostrar por pantalla:
 */
public class Ejercicio1 {
	public static void main(String[] args) {
	    int n = 5;
        double a = 6.5;
        char c = 'p';
        int cConversion = (int) c;
        System.out.println(c);
        System.out.println(n+a);
        System.out.println(n-a);
        System.out.println( cConversion);
	}
}
