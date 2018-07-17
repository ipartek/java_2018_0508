package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

import com.sun.corba.se.impl.interceptors.PICurrent;

/*Ejercicio 5. Programa que lee por teclado el valor del radio de una circunferencia y calcula y muestra por pantalla la longitud y el área de la circunferencia. 

Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia = PI*Radio^2
*/
public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		
		//Variables
		double radio,longitud,area;
	
		
		System.out.println("Introduce los radios de la circunferencia:");
		radio=sc.nextDouble();
		
		longitud=2*Math.PI*radio;
		area= Math.PI * Math.pow(radio, 2);
		
		System.out.println("La longitud de la circunferencia:"+longitud);
		System.out.println("El area de la circunferencia:"+area);
		

	}

}
