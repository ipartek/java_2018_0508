package com.ipartek.ejercicios.estructura.secuencial;
import java.util.Scanner;
/**
 * Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit. 
La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
F = 32 + ( 9 * C / 5)
 * @author Curso
 *
 */
public class Ejercicio4 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		double gradosC;
		double gradosF;
		System.out.println("Introduce los grados centigrados: ");
		gradosC= sc.nextDouble();
		gradosF=32+(9*gradosC/5);
		System.out.println(gradosC +" ºC = " + gradosF + " ºF");
	}

}
