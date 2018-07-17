package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/* Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.*/
public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		
		//Variables
		double kmh,ms;
		
		System.out.println("Introduce una velocidad en Km/h:");
		kmh=sc.nextDouble();
		
		ms=kmh*1000/3600;
		System.out.println("Velocidad:");
		System.out.println(kmh+" Km/h"+"= "+ms+ " m/s");
	}

}
