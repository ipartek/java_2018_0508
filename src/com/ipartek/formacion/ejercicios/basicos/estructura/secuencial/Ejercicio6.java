package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 6. Programa que pase una velocidad en Km/h a m/s. La velocidad se
 * lee por teclado.
 */

public class Ejercicio6 {
public static void main(String[] args) {
	Scanner m=new Scanner(System.in);
	double velocidad;
	System.out.println("Ingrese la velocidad en km/h = ");
	velocidad = m.nextDouble();
	System.out.println("La velocidad en km/m a m/s = " + (velocidad * 1000/3600));
	
}
}
