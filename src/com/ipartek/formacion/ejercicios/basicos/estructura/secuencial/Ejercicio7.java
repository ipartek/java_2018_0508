package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 7. Programa lea la longitud de los catetos de un triángulo rectángulo y<br>
 * calcule la longitud de la hipotenusa según el teorema de Pitágoras.
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {
	
	private static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
        double c1, c2;
        
        System.out.print("Introduce la longitud del primer cateto: ");
        c1 = scan.nextDouble();
        
        System.out.print("Introduce la longitud del segundo cateto: ");
        c2 = scan.nextDouble();
        
        System.out.println("La hipotenusa es " +  Math.sqrt(Math.pow(c1,2)+ Math.pow(c2, 2)));

	}

}
