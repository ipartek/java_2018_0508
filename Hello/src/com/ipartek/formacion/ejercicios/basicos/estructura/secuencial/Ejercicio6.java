package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 *  Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.
 * @author Curso
 *
 */

public class Ejercicio6 {
	public static void main(String[] args){
		
		float velocidad;
		float metros;
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la velocidad: "); 
        velocidad = sc.nextFloat();   
        metros=velocidad*1000/3600;
        System.out.println("Velocidad en km/h: " + velocidad);
        System.out.println("Velocidad en m/s: " + metros);
        sc.close();
	}
}
