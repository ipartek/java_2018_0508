package com.ipartek.ejercicios.estructura.secuencial;
import java.util.Scanner;
/**
 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.
 * @author Curso
 *
 */
public class Ejercicio6 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
        double velocidad;
        System.out.println("Introduce velocidad en Km/h: ");
        velocidad = sc.nextDouble();
        System.out.println(velocidad + " Km/h: " + velocidad*1000/3600 + " m/s");
	}

}
