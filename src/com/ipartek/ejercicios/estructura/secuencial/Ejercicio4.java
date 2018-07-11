package com.ipartek.ejercicios.estructura.secuencial;
import java.util.*;
/**
 * Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit. 
La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
F = 32 + ( 9 * C / 5)
 * @author Curso
 *
 */
public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		double gradosC, gradosF;
		System.out.println("Introduce los grados centigrados: ");
		gradosC= sc.nextDouble();
		gradosF=32+(9*gradosC/5);
		System.out.println(gradosC +" ºC = " + gradosF + " ºF");
	}

}
