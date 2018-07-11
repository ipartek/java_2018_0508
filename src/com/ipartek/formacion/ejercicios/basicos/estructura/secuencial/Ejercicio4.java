package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit. 
La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
F = 32 + ( 9 * C / 5)
 * @author Curso
 *
 */

public class Ejercicio4 {
	public static void main(String[] args){
		
		float c;
		float f;
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce Grados Centigrados: "); 
        c = sc.nextFloat();   
        f = 32 + ( 9 * c / 5);
        System.out.println("Los grados introducidos son: " + c);
        System.out.println("Los grados Fahrenheit son: " + f);
	}
}
