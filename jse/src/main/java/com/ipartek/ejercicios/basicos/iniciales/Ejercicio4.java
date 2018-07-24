package com.ipartek.ejercicios.basicos.iniciales;

/**
 * Programa java que declare cuatro variables enteras A, B, C y D y asígnale un valor a cada una. A continuación realiza las instrucciones necesarias para que:
B tome el valor de C
C tome el valor de A
A tome el valor de D
D tome el valor de B
Si por ejemplo A = 1, B = 2, C = 3 y D = 4 el programa debe mostrar:
Valores iniciales
A = 1
B = 2
C = 3
D = 4
Valores finales
B toma el valor de C -> B = 3
C toma el valor de A -> C = 1
A toma el valor de D -> A = 4
D toma el valor de B -> D = 2
 * @author Curso
 *
 */

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		int a=1;
		int b=2;
		int c=3;
		int d=4;
		int aux;
		
		System.out.println("Valores iniciales:");
		System.out.println("A: "+a);
		System.out.println("B: "+b);
		System.out.println("C: "+c);
		System.out.println("D: "+d);
		System.out.println();
		
		aux=b;
		b=c;
		c=a;
		a=d;
		d=aux;
		
		System.out.println("Valores finales:");
		System.out.println("B toma el valor de C -> B = " + b);
        System.out.println("C toma el valor de A -> C = " + c);
        System.out.println("A toma el valor de D -> A = " + a);
        System.out.println("D toma el valor de B -> D = " + d);
		
		
	}

}
