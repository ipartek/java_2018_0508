package com.ipartek.ejercicios.estructura.secuencial;
import java.util.*;
/**
 * Programa que tome como dato de entrada un número que corresponde a la longitud del radio una esfera y nos calcula y escribe el volumen de la esfera que se corresponden con dicho radio.

La fórmula para calcular el volumen de la esfera es 
v = (4/3)*PI*r^3
 * @author Curso
 *
 */

public class Ejercicio8 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		double radio, volumen;
        System.out.print("Introduce radio de la esfera: ");
        radio = sc.nextDouble();
        System.out.println("Volumen de la esfera del radio " + radio + "= " + (4.0/3)* Math.PI * Math.pow(radio, 3));
	}

}
