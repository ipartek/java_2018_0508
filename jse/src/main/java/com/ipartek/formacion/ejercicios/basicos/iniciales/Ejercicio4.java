package com.ipartek.formacion.ejercicios.basicos.iniciales;
/*
 * Programa java que declare cuatro variables enteras A, B, C y D y asígnale un valor a cada una. A continuación realiza las instrucciones necesarias para que:
			B tome el valor de C
			C tome el valor de A
			A tome el valor de D
			D tome el valor de B
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		//Variables
		int a=1;
		int b=2;
		int c=3;
		int d=4;
		int aux;
		
		System.out.println("Valores inciales");
		System.out.println("variable a ="+a);
		System.out.println("variable b ="+b);
		System.out.println("variable c ="+c);
		System.out.println("variable d ="+d);
		
		//Para no perder el valor de b lo guardamos en una variables auxiliar
		 aux=b;
		 
		 b=c;
		 c=a;
		 a=d;
		 d=aux;
		 
			System.out.println("Valores modificados");
			System.out.println("variable a ="+a);
			System.out.println("variable b ="+b);
			System.out.println("variable c ="+c);
			System.out.println("variable d ="+d);
		 
		 
	}

}
