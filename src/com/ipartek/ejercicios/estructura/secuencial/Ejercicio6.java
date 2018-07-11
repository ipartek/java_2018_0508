package com.ipartek.ejercicios.estructura.secuencial;
import java.util.*;
/**
 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.
 * @author Curso
 *
 */
public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
        double velocidad;
        System.out.println("Introduce velocidad en Km/h: ");
        velocidad = sc.nextDouble();
        System.out.println(velocidad + " Km/h: " + velocidad*1000/3600 + " m/s");
	}

}
