package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;
/**
 * Programa que tome como dato de entrada un número que corresponde a la longitud del radio de una esfera y nos calcula y escribe<br>
 *  el volumen de la esfera que se corresponden con dicho radio.<br>
 *  La fórmula para calcular el volumen de la esfera es: <br> 
 *  v = (4/3)*PI*r^3 <br>
 * @author Curso
 *
 */
public class Ejercicio8 {
	public static void main(String[] args){
		
		float radio;
		float volumen;
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la longitud del radio de una esfera: "); 
        radio = sc.nextFloat(); 
        volumen= (float) ((4/3) * Math.PI * Math.pow(radio, 3));
        System.out.println("La longitud de la hipotenusa es: " + volumen);
        sc.close();
	}
}
