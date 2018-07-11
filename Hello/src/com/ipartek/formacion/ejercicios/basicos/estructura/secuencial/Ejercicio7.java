package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa lea la longitud de los catetos de un triángulo rectángulo y <br>
 * calcule la longitud de la hipotenusa según el teorema de Pitágoras.
 * @author Curso
 *
 */
public class Ejercicio7 {
	public static void main(String[] args){
		
		float cateto1;
		float cateto2;
		float hipotenusa;
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer cateto: "); 
        cateto1 = sc.nextFloat(); 
        System.out.println("Introduce el segundo cateto: "); 
        cateto2 = sc.nextFloat(); 
        hipotenusa= (float) Math.sqrt(Math.pow(cateto1,2)+ Math.pow(cateto2, 2));
        System.out.println("La longitud de la hipotenusa es: " + hipotenusa);
        sc.close();
	}
}
