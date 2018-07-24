package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/*
 * Ejercicio 7.
 *  Programa lea la longitud de los catetos de un triángulo rectángulo 
 *  y calcule la longitud de la hipotenusa según el teorema de Pitágoras.*/

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		
		//Variables
		double cateto1,cateto2,hipote;
		
		System.out.println("Cateto1:");
		cateto1=sc.nextDouble();
		System.out.println("Cateto2:");
		cateto2=sc.nextDouble();
		
		//calculamos hipotenusa
		hipote=Math.sqrt(Math.pow(cateto1,2)+ Math.pow(cateto2, 2));
		//Math.sqrt(x) --> La raiz cuadrada de 1
		//Math.pow(base,exponente);2^4
		
		System.out.println("El triangulo cuadrado su hipotenusa es:"+hipote);
	}

}
